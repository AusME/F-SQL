package name.ben.shepley.fsql.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public enum BeanUtils {
    SINGLETON;


    public static List<String> getBeanFieldNames(Class<?> bean) {
        var beanFieldsNames = new ArrayList<String>();
        Field[] fields = bean.getFields();
        boolean[] hasGetter = new boolean[fields.length];
        boolean[] hasSetter = new boolean[fields.length];

        fieldLoop:
        for (int i = 0; i < fields.length; i ++) {
            String field = fields[i].getName();
            for (Method method : bean.getMethods()) {
                if (method.getName().equals(StringCaseUtil.CAMEL.prepend("get", field))) {
                    hasGetter[i] = true;
                } else if (method.getName().equals(StringCaseUtil.CAMEL.prepend("set", field))) {
                    hasSetter[i] = true;
                }

                if (hasGetter[i] == true && hasSetter[i] == true) {
                    beanFieldsNames.add(field);
                    continue fieldLoop;
                }
            }
        }
        return beanFieldsNames;
    }

}
