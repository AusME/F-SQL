package name.ben.shepley.fsql.framework.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

public class PojoDescriptionTest {
    @Test
    public void testIt() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PojoDescription<String> p = new PojoDescription<String>(String.class);

        String s = (String) p.build(Collections.emptyMap());

        System.out.println(s);
    }
}
