package xyz.zfdu.mall.api.util;

import org.springframework.beans.*;
import java.lang.reflect.Field;
import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * @author zfdu
 * @description 实体类工具，属性拷贝
 * @data 2021-04-21
 */
public abstract class BaseBeanUtil {
    public static Object copyProperties(Object source, Object target,String...ignoreProperties) {
        if (source == null) {
            return target;
        }
        BeanUtils.copyProperties(source, target, ignoreProperties);
        return target;
    }
    public static <T> List<T> copyList(List sources, Class<T> clazz) {
        return copyList(sources, clazz, null);
    }
    public static <T> List<T> copyList(List sources, Class<T> clazz, Callback<T> callback) {
        List<T> targetList = new ArrayList<>();
        if (sources != null) {
            try {
                for (Object source : sources) {
                    T target = clazz.newInstance();
                    copyProperties(source, target);
                    if (callback != null) {
                        callback.set(source, target);
                    }
                    targetList.add(target);
                }
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return targetList;
    }
    public static Map<String, Object> toMap(Object bean, String... ignoreProperties) {
        Map<String,Object> map = new LinkedHashMap<>();
        List<String> ignoreList = new ArrayList<>(Arrays.asList(ignoreProperties));
        ignoreList.add("class");
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(bean);
        for (PropertyDescriptor pd : beanWrapper.getPropertyDescriptors()) {
            if (!ignoreList.contains(pd.getName()) && beanWrapper.isWritableProperty(pd.getName())) {
                Object propertyValue = beanWrapper.getPropertyValue(pd.getName());
                map.put(pd.getName(), propertyValue);
            }
        }
        return map;
    }
    public static <T> T toBean(Map<String,Object> map,Class<T> beanType) {
        Object object;
        BeanWrapper beanWrapper = new BeanWrapperImpl(beanType);
        map.forEach((key, Value) -> {
            if (beanWrapper.isWritableProperty(key)) {
                beanWrapper.setPropertyValue(key,Value);
            }
        });
        return (T) beanWrapper.getWrappedInstance();
    }
    public static interface Callback<T> {
        void set (Object source, T target);
    }
    /**
     * 检查Pojo对象是否有null字段
     *
     * @param o   入参对象
     * @param clz 类型
     * @return boolean
     */
    public static boolean checkPojoNullField(Object o,Class<?> clz){
        try {
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                if(field.get(0) == null) {
                    return false;
                }
            }
            if (clz.getSuperclass() != Object.class) {
                return checkPojoNullField(o, clz.getSuperclass());
            }
            return true;
        } catch (IllegalAccessException e){
            return false;
        }
    }

}
