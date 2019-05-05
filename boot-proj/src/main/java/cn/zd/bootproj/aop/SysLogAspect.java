package cn.zd.bootproj.aop;

import com.sangame.adms.dto.UserInfoDto;
import com.sangame.adms.service.base.UserInfoCache;
import com.sangame.sow.utils.IpUtils;
import com.wf2311.log.ExceptionLevel;
import com.wf2311.log.LogAspect;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static java.time.temporal.ChronoUnit.MILLIS;

/**
 * @author wangfeng
 * @time 2017/08/22 10:19.
 */
@Aspect
@Order(10)
@Component
public class SysLogAspect extends LogAspect {

    @Resource
    private UserInfoCache userInfoCache;

    /**
     * 修记录信息
     */
    @Override
    public void modifyLogInfo() {
        logInfo.setUrl(getUrl(request));
        //单位改为毫秒
        logInfo.setSpend(logInfo.getStartTime().until(logInfo.getEndTime(), MILLIS));
        logInfo.setIp(IpUtils.getClientIp(request));
        UserInfoDto userInfoDto = userInfoCache.getUserInfo();
        if (userInfoDto != null) {
            logInfo.setUserInfo(userInfoDto);
            logInfo.setCreator(userInfoDto.getRealName());
        }
        logInfo.setCreated(LocalDateTime.now());
        if (StringUtils.isEmpty(logInfo.getDescription())) {
            ApiOperation operation = method.getAnnotation(ApiOperation.class);
            if (operation != null) {
                logInfo.setDescription(operation.value());
            }
        }
    }

    /**
     * 要排除为异常类型的异常
     */
    @Override
    public List<ExceptionLevel> ignoreExceptions() {
        return Collections.emptyList();
    }

    /**
     * 要指定为特别等级的异常
     */
    @Override
    public List<ExceptionLevel> specifiedLevelExceptions() {
        return Collections.emptyList();
    }

    private String getUrl(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String query = request.getQueryString();
        return requestURL.toString() + ((query == null || query.isEmpty()) ? "" : "?" + query);
    }
}
