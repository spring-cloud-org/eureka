//package cn.zd.bootproj.aop;
//
//import com.sangame.adms.annoation.Auth;
//import com.sangame.adms.constant.Constants;
//import com.sangame.adms.constant.ExceptionResponse;
//import com.sangame.adms.dto.PermissionDto;
//import com.sangame.adms.dto.UserInfoDto;
//import com.sangame.adms.exception.BusinessException;
//import com.sangame.adms.service.UserService;
//import com.sangame.adms.service.base.UserInfoCache;
//import com.sangame.adms.service.support.PageCache;
//import com.sangame.adms.utils.ArrayUtil;
//import com.sangame.sow.ssh.annotation.NotLogin;
//import org.apache.commons.lang.StringUtils;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Method;
//import java.util.List;
//
///**
// * @author wangfeng
// * @time 2017/07/11 17:19.
// */
//@Aspect
//@Order(1)
//@Component
//public class AuthAspect {
//
//    @Resource
//    private UserService userService;
//    @Resource
//    private UserInfoCache userInfoCache;
//    @Resource
//    private PageCache pageCache;
//
//    @Pointcut("execution(public * com.sangame.adms.web.api..*(..)) || execution(public * com.sangame.adms.web.api..*(..))")
//    public void aspect() {
//    }
//
//    @Before("aspect()")
//    public void before(JoinPoint joinPoint) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        cachePageParam(request);
//        NotLogin notLogin = method.getAnnotation(NotLogin.class);
//        if (notLogin != null) {
//            return;
//        }
//        Auth auth = method.getAnnotation(Auth.class);
//        boolean hasPermission = hasPermission(getAndCacheUserInfo(request), auth);
//        if (!hasPermission) {
//            throw new BusinessException(ExceptionResponse.NO_AUTH);
//        }
//    }
//
//    private String getUserToken(HttpServletRequest request) {
//        return request.getHeader(Constants.USER_TOKEN);
//    }
//
//    private boolean hasPermission(UserInfoDto userInfo, Auth auth) {
//        if (userInfo == null) {
//            return false;
//        }
//        if (auth == null || auth.value().getId() == null) {
//            return true;
//        }
//        List<PermissionDto> permissions = userInfo.getPermissions();
//        if (ArrayUtil.isEmpty(permissions)) {
//            return false;
//        }
//        return permissions.stream().anyMatch(p -> auth.value().getId().equals(p.getId()));
//    }
//
//    private UserInfoDto getAndCacheUserInfo(HttpServletRequest request) {
//        String userToken = getUserToken(request);
//        if (StringUtils.isEmpty(userToken)) {
//            userToken = request.getParameter(Constants.USER_TOKEN);
//            if (StringUtils.isEmpty(userToken)) {
//                throw new BusinessException(ExceptionResponse.NO_LOGIN);
//            }
//        }
//        UserInfoDto userInfo;
//        userInfo = userService.getUserByToken(userToken);
//        if (userInfo == null) {
//            throw new BusinessException(ExceptionResponse.NO_LOGIN);
//        }
//        request.getSession().setAttribute(Constants.USER_INFO, userInfo);
//        userInfoCache.setUserInfo(userInfo);
//        return userInfo;
//    }
//
//    private void cachePageParam(HttpServletRequest request) {
//        String webType = request.getHeader(PageCache.WEB_TYPE);
//        if (webType != null) {
//            pageCache.setWebType(Integer.valueOf(webType));
//        } else {
//            webType = request.getParameter(PageCache.WEB_TYPE);
//            if (webType != null) {
//                pageCache.setWebType(Integer.valueOf(webType));
//            }
//        }
//    }
//}
