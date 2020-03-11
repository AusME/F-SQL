package name.ben.shepley.fsql._framework.wrapper;

import name.ben.shepley.fsql._framework.util.StringCaseUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class PojoDescription<T> {
    private final Class<T> pojoClass;

    public PojoDescription(Class<T> pojoClass) {
        this.pojoClass = pojoClass;
    }

    public String getName() {
        return this.pojoClass.getName();
    }

    public Map<String, Class<?>> getFields() {
        Map<String, Class<?>> fields = new LinkedHashMap<>();
        for (Field field : this.pojoClass.getFields()) {
            for (Method method : this.pojoClass.getMethods()) {
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

    public T build(Map<String, Object> fields) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        T pojo = pojoClass.getDeclaredConstructor().newInstance();
        for (String field : fields.keySet()) {
            String setterName = StringCaseUtil.CAMEL.prepend("set", field);
            Method method = pojo.getClass().getMethod(setterName, fields.get(field).getClass());
            method.invoke(pojo, fields.get(field));
        }
        return pojo;
    }

}