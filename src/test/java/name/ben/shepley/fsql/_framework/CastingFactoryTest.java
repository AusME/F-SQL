package name.ben.shepley.fsql._framework;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CastingFactoryTest {
    @Test
    public void testString() {
        assertThat(CastingFactory.cast("YES", Character.class).get(), equalTo('Y'));
        assertThat(CastingFactory.cast("YES", char.class).get(), equalTo('Y'));
        assertThat(CastingFactory.cast("true", Boolean.class).get(), equalTo(Boolean.TRUE));
        assertThat(CastingFactory.cast("true", boolean.class).get(), equalTo(true));
        assertThat(CastingFactory.cast("Hello World", byte[].class).get(), equalTo("Hello World".getBytes()));
//        assertThat(CastingFactory.cast("Hello World", Byte[].class).get(), equalTo("Hello World".getBytes()));


    }
}
