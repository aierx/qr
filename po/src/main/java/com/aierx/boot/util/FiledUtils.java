package com.aierx.boot.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/4/20
 */
public class FiledUtils {
    public static HashMap<String, String> differentFields(Object newObject, Object oldObject, List<String> fields) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HashMap<String, String> res = new HashMap<>();
        Class<?> clazz = newObject.getClass();
        Class<?> oldClazz = oldObject.getClass();
        if (clazz != oldClazz) return res;
        if (fields==null || fields.isEmpty()) {
            fields = fields==null? new ArrayList<>():fields;
            for (Field field : clazz.getDeclaredFields()) {
                fields.add(field.getName());
            }
        }
        for (String fieldName : fields) {
            Method method = clazz.getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1));
            String newValue = method.invoke(newObject).toString();
            String oldValue = method.invoke(oldObject).toString();
            if (newValue.equals(oldValue)){
                continue;
            }
            res.put(fieldName, newValue);
        }
        return res;
    }
}
