package cn.zd.bootproj.aop;

import com.sangame.adms.service.base.UserInfoCache;
import com.sangame.adms.utils.ReflectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wangfeng
 * @time 2017/08/23 11:50.
 */
public abstract class SqlAspect {
    private static final Logger log = LoggerFactory.getLogger(SqlAspect.class);

    protected static final String CREATOR = "creator";
    protected static final String MODIFIER = "modifier";
    protected static final String CREATE_TIME = "createdAt";
    protected static final String MODIFIED_TIME = "updatedAt";

    @Resource
    protected UserInfoCache userInfoCache;

    public boolean existMethod(Object o, String name, Class<?> c) {
        try {
            Method method = o.getClass().getMethod(name, c);
            return method != null;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public boolean existMethod(Object o, String name) {
        try {
            Method method = o.getClass().getMethod(name);
            return method != null;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }


    private static boolean showSetValue(Object obj,Field field,String name){
        if (name.equals(field.getName())) {
            try {
                return ReflectUtils.getFiledValue(obj, field) == null;
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
            }
        }
        return false;
    }

    protected static boolean shouldSetCreator(Object obj, Field field) {
        return showSetValue(obj, field, CREATOR);
    }

    protected static boolean shouldSetCreatedTime(Object obj, Field field) {
        return showSetValue(obj, field, CREATE_TIME);
    }

    protected static boolean shouldSetModifier(Object obj, Field field) {
        return showSetValue(obj, field, MODIFIER);
    }

    protected static boolean shouldSetModifiedTime(Object obj, Field field) {
        return showSetValue(obj, field, MODIFIED_TIME);
    }
}
