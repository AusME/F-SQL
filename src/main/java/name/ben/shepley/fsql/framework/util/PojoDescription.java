package name.ben.shepley.fsql.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class PojoDescription<T> {
    private final Class<T> pojo;

    public PojoDescription(Class<T> pojo) {
        this.pojo = pojo;
    }

    public String getName() {
        return this.pojo.getName();
    }

    public Map<String, Class<?>> getFields() {
        Map<String, Class<?>> fields = new LinkedHashMap<>();
        for (Field field : this.pojo.getFields()) {
            for (Method method : this.pojo.getMethods()) {
                String getter = Optional.of(StringCaseUtil.CAMEL.prepend("get", field.getName())).orElse("");
                String setter = Optional.of(StringCaseUtil.CAMEL.prepend("set", field.getName())).orElse("");
                if (method.getName().equals(getter) && method.getName().equals(setter)) {
                    fields.put(field.getName(), field.getType());
                    break;
                }
            }
        }
        return Collections.unmodifiableMap(fields);
    }

    public Object build(Map<String, Object> fields) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object o = pojo.getDeclaredConstructor().newInstance();
        if (o instanceof String) {
            o = "Yay";
        }

        return o;
    }

}