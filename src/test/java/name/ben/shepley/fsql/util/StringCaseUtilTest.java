package name.ben.shepley.fsql.util;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StringCaseUtilTest {
    private static final int TEST_NO_RESULT = 0;
    private static final String TEST_NULL_STRING = null;
    private static final String TEST_EMPTY_STRING = "";

    private static final int TEST_SINGLE_WORD_LENGTH = 1;
    private static final String TEST_SINGLE_WORD_LOWER_CASE = "the";
    private static final String TEST_SINGLE_WORD_UPPER_CASE = "THE";

    private static final int TEST_MULTI_WORD_STRING_LENGTH = 9;
    private static final String TEST_CAMEL_STRING =  "theQuickBrownFoxJumpsOverTheLazyDog";
    private static final String TEST_PASCAL_STRING = "TheQuickBrownFoxJumpsOverTheLazyDog";
    private static final String TEST_SNAKE_STRING =  "the_quick_brown_fox_jumps_over_the_lazy_dog";
    private static final String TEST_KEBAB_STRING =  "the-quick-brown-fox-jumps-over-the-lazy-dog";

    @Test
    public void testCamel() {
        /* Test Convert */
        assertThat(StringCaseUtil.CAMEL.convert(StringCaseUtil.CAMEL, TEST_NULL_STRING), blankString());
        assertThat(StringCaseUtil.CAMEL.convert(StringCaseUtil.CAMEL, TEST_EMPTY_STRING), blankString());
        assertThat(StringCaseUtil.CAMEL.convert(StringCaseUtil.CAMEL, TEST_SINGLE_WORD_LOWER_CASE), equalTo(TEST_SINGLE_WORD_LOWER_CASE));
        assertThat(StringCaseUtil.CAMEL.convert(StringCaseUtil.CAMEL, TEST_SINGLE_WORD_UPPER_CASE), blankString());
        assertThat(StringCaseUtil.CAMEL.convert(StringCaseUtil.CAMEL, TEST_CAMEL_STRING), equalTo(TEST_CAMEL_STRING));
        //assertThat(StringFormatter.CAMEL.convert(StringFormatter.CAMEL, TEST_PASCAL_STRING), equalTo(TEST_CAMEL_STRING));
        //assertThat(StringFormatter.CAMEL.convert(StringFormatter.CAMEL, TEST_SNAKE_STRING), equalTo(TEST_CAMEL_STRING));
        //assertThat(StringFormatter.CAMEL.convert(StringFormatter.CAMEL, TEST_KEBAB_STRING), equalTo(TEST_CAMEL_STRING));

        /* Test Parse */
        assertThat(StringCaseUtil.CAMEL.parse(TEST_NULL_STRING), arrayWithSize(TEST_NO_RESULT));
        assertThat(StringCaseUtil.CAMEL.parse(TEST_EMPTY_STRING), arrayWithSize(TEST_NO_RESULT));
        assertThat(StringCaseUtil.CAMEL.parse(TEST_SINGLE_WORD_LOWER_CASE), arrayWithSize(TEST_SINGLE_WORD_LENGTH));
        assertThat(StringCaseUtil.CAMEL.parse(TEST_SINGLE_WORD_UPPER_CASE), arrayWithSize(TEST_NO_RESULT));
        assertThat(StringCaseUtil.CAMEL.parse(TEST_CAMEL_STRING), arrayWithSize(TEST_MULTI_WORD_STRING_LENGTH));
        assertThat(StringCaseUtil.CAMEL.parse(TEST_PASCAL_STRING), arrayWithSize(TEST_NO_RESULT));
        assertThat(StringCaseUtil.CAMEL.parse(TEST_SNAKE_STRING), arrayWithSize(TEST_NO_RESULT));
        assertThat(StringCaseUtil.CAMEL.parse(TEST_KEBAB_STRING), arrayWithSize(TEST_NO_RESULT));

        /* Test Is */
        assertThat(StringCaseUtil.CAMEL.is(TEST_NULL_STRING), is(false));
        assertThat(StringCaseUtil.CAMEL.is(TEST_EMPTY_STRING), is(false));
        assertThat(StringCaseUtil.CAMEL.is(TEST_SINGLE_WORD_LOWER_CASE), is(true));
        assertThat(StringCaseUtil.CAMEL.is(TEST_SINGLE_WORD_UPPER_CASE), is(false));
        assertThat(StringCaseUtil.CAMEL.is(TEST_CAMEL_STRING), is(true));
        assertThat(StringCaseUtil.CAMEL.is(TEST_PASCAL_STRING), is(false));
        assertThat(StringCaseUtil.CAMEL.is(TEST_SNAKE_STRING), is(false));
        assertThat(StringCaseUtil.CAMEL.is(TEST_KEBAB_STRING), is(false));
    }

    @Test
    public void testPascal() {

    }

    @Test
    public void testSnake() {

    }

    @Test
    public void testKebab() {

    }
}
