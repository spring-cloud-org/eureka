package cn.zd.bootproj.aop;

import com.sangame.adms.exception.BusinessException;
import com.sangame.adms.exception.GetAdException;
import com.sangame.adms.exception.PositionNoAdException;
import com.sangame.adms.support.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局错误配置处理
 *
 * @author wangfeng
 * @time 2017/07/11 09:54.
 */
@ControllerAdvice(basePackages = "com.sangame.adms")
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = PositionNoAdException.class)
    @ResponseBody
    public JsonResult<Integer> noAdErrorHandler(PositionNoAdException e) {
        return JsonResult.<Integer>builder()
                .flag(false)
                .code(e.getErrorCode().getCode())
                .msg(e.getErrorCode().getMessage())
                .data(e.getId())
                .build();
    }

    @ExceptionHandler(value = GetAdException.class)
    @ResponseBody
    public JsonResult adErrorHandler(GetAdException e) {
        return JsonResult.builder()
                .flag(false)
                .code(e.getErrorCode().getCode())
                .msg(e.getErrorCode().getMessage())
                .build();
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody()
    public JsonResult<String> businessErrorHandler(BusinessException e) {
        return JsonResult.<String>builder()
                .flag(false)
                .code(e.getCode())
                .msg(e.getMessage())
                .build();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult<String> businessErrorHandler(Exception e) {
        log.error(e.getMessage(), e);
        return JsonResult.<String>builder()
                .code(500)
                .msg("系统错误！")
                .flag(false)
                .data(e.getMessage())
                .build();
    }
}
