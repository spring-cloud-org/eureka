//package cn.zd.bootproj.aop;
//
//import com.sangame.adms.utils.ReflectUtils;
//import org.apache.commons.lang3.ArrayUtils;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Field;
//import java.time.LocalDateTime;
//
///**
// * @author wf2311
// */
//@Aspect
//@Order(20)
//@Component
//public class InsertSqlAspect extends SqlAspect {
//    private static final Logger log = LoggerFactory.getLogger(InsertSqlAspect.class);
//
//    @Pointcut("execution(public * com.sangame.adms.utils.BaseMapper.insert*(..))")
//    public void aspect() {
//    }
//
//
//    @Before("aspect()")
//    public void before(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            Field[] fields = arg.getClass().getDeclaredFields();
//            if (ArrayUtils.isNotEmpty(fields)) {
//                try {
//                    for (Field field : fields) {
//                        if (shouldSetCreator(arg, field)) {
//                            ReflectUtils.setFiledValue(arg, field, userInfoCache.getUserInfo().getRealName());
//                            continue;
//                        }
//                        if (shouldSetCreatedTime(arg, field)) {
//                            ReflectUtils.setFiledValue(arg, field, LocalDateTime.now());
//                            continue;
//                        }
//                    }
//                } catch (IllegalAccessException e) {
//                    log.error("自动注入属性失败", e);
//                }
//            }
//        }
//    }
//}
