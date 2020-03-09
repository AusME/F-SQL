package name.ben.shepley.fsql.util;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StringCaseUtilTest {
    private static final int TEST_MULTI_WORD_STRING_LENGTH = 9;

    private static final String TEST_CAMEL_STRING           = "theQuickBrownFoxJumpsOverTheLazyDog";
    private static final String TEST_PREPEND_CAMEL_STRING   = "andTheQuickBrownFoxJumpsOverTheLazyDog";
    private static final String TEST_APPEND_CAMEL_STRING    = "theQuickBrownFoxJumpsOverTheLazyDogEnd";

    private static final String TEST_PASCAL_STRING          = "TheQuickBrownFoxJumpsOverTheLazyDog";
    private static final String TEST_PREPEND_PASCAL_STRING  = "AndTheQuickBrownFoxJumpsOverTheLazyDog";
    private static final String TEST_APPEND_PASCAL_STRING   = "TheQuickBrownFoxJumpsOverTheLazyDogEnd";

    private static final String TEST_SNAKE_STRING           =  "the_quick_brown_fox_jumps_over_the_lazy_dog";
    private static final String TEST_PREPEND_SNAKE_STRING   =  "and_the_quick_brown_fox_jumps_over_the_lazy_dog";
    private static final String TEST_APPEND_SNAKE_STRING    =  "the_quick_brown_fox_jumps_over_the_lazy_dog_end";

    private static final String TEST_KEBAB_STRING           =  "the-quick-brown-fox-jumps-over-the-lazy-dog";
    private static final String TEST_PREPEND_KEBAB_STRING   =  "and-the-quick-brown-fox-jumps-over-the-lazy-dog";
    private static final String TEST_APPEND_KEBAB_STRING    =  "the-quick-brown-fox-jumps-over-the-lazy-dog-end";

    @Test
    public void testCamel() {
        assertThat(StringCaseUtil.CAMEL.transform(StringCaseUtil.CAMEL, TEST_CAMEL_STRING), equalTo(TEST_CAMEL_STRING));
        assertThat(StringCaseUtil.CAMEL.transform(StringCaseUtil.PASCAL, TEST_PASCAL_STRING), equalTo(TEST_CAMEL_STRING));
        assertThat(StringCaseUtil.CAMEL.transform(StringCaseUtil.SNAKE, TEST_SNAKE_STRING), equalTo(TEST_CAMEL_STRING));
        assertThat(StringCaseUtil.CAMEL.transform(StringCaseUtil.KEBAB, TEST_KEBAB_STRING), equalTo(TEST_CAMEL_STRING));

        assertThat(StringCaseUtil.CAMEL.prepend("and", TEST_CAMEL_STRING), equalTo(TEST_PREPEND_CAMEL_STRING));
        assertThat(StringCaseUtil.CAMEL.append(TEST_CAMEL_STRING, "end"), equalTo(TEST_APPEND_CAMEL_STRING));

        assertThat(StringCaseUtil.CAMEL.parse(TEST_CAMEL_STRING), arrayWithSize(TEST_MULTI_WORD_STRING_LENGTH));
        assertThat(StringCaseUtil.CAMEL.is(TEST_CAMEL_STRING), is(true));
    }

    @Test
    public void testPascal() {
        assertThat(StringCaseUtil.PASCAL.transform(StringCaseUtil.CAMEL, TEST_CAMEL_STRING), equalTo(TEST_PASCAL_STRING));
        assertThat(StringCaseUtil.PASCAL.transform(StringCaseUtil.PASCAL, TEST_PASCAL_STRING), equalTo(TEST_PASCAL_STRING));
        assertThat(StringCaseUtil.PASCAL.transform(StringCaseUtil.SNAKE, TEST_SNAKE_STRING), equalTo(TEST_PASCAL_STRING));
        assertThat(StringCaseUtil.PASCAL.transform(StringCaseUtil.KEBAB, TEST_KEBAB_STRING), equalTo(TEST_PASCAL_STRING));

        assertThat(StringCaseUtil.PASCAL.prepend("and", TEST_PASCAL_STRING), equalTo(TEST_PREPEND_PASCAL_STRING));
        assertThat(StringCaseUtil.PASCAL.append(TEST_PASCAL_STRING, "end"), equalTo(TEST_APPEND_PASCAL_STRING));

        assertThat(StringCaseUtil.PASCAL.parse(TEST_PASCAL_STRING), arrayWithSize(TEST_MULTI_WORD_STRING_LENGTH));
        assertThat(StringCaseUtil.PASCAL.is(TEST_PASCAL_STRING), is(true));
    }

    @Test
    public void testSnake() {
        assertThat(StringCaseUtil.SNAKE.transform(StringCaseUtil.CAMEL, TEST_CAMEL_STRING), equalTo(TEST_SNAKE_STRING));
        assertThat(StringCaseUtil.SNAKE.transform(StringCaseUtil.PASCAL, TEST_PASCAL_STRING), equalTo(TEST_SNAKE_STRING));
        assertThat(StringCaseUtil.SNAKE.transform(StringCaseUtil.SNAKE, TEST_SNAKE_STRING), equalTo(TEST_SNAKE_STRING));
        assertThat(StringCaseUtil.SNAKE.transform(StringCaseUtil.KEBAB, TEST_KEBAB_STRING), equalTo(TEST_SNAKE_STRING));

        assertThat(StringCaseUtil.SNAKE.prepend("and", TEST_SNAKE_STRING), equalTo(TEST_PREPEND_SNAKE_STRING));
        assertThat(StringCaseUtil.SNAKE.append(TEST_SNAKE_STRING, "end"), equalTo(TEST_APPEND_SNAKE_STRING));

        assertThat(StringCaseUtil.SNAKE.parse(TEST_SNAKE_STRING), arrayWithSize(TEST_MULTI_WORD_STRING_LENGTH));
        assertThat(StringCaseUtil.SNAKE.is(TEST_SNAKE_STRING), is(true));
    }

    @Test
    public void testKebab() {
        assertThat(StringCaseUtil.KEBAB.transform(StringCaseUtil.CAMEL, TEST_CAMEL_STRING), equalTo(TEST_KEBAB_STRING));
        assertThat(StringCaseUtil.KEBAB.transform(StringCaseUtil.PASCAL, TEST_PASCAL_STRING), equalTo(TEST_KEBAB_STRING));
        assertThat(StringCaseUtil.KEBAB.transform(StringCaseUtil.SNAKE, TEST_SNAKE_STRING), equalTo(TEST_KEBAB_STRING));
        assertThat(StringCaseUtil.KEBAB.transform(StringCaseUtil.KEBAB, TEST_KEBAB_STRING), equalTo(TEST_KEBAB_STRING));

        assertThat(StringCaseUtil.KEBAB.prepend("and", TEST_KEBAB_STRING), equalTo(TEST_PREPEND_KEBAB_STRING));
        assertThat(StringCaseUtil.KEBAB.append(TEST_KEBAB_STRING, "end"), equalTo(TEST_APPEND_KEBAB_STRING));

        assertThat(StringCaseUtil.KEBAB.parse(TEST_KEBAB_STRING), arrayWithSize(TEST_MULTI_WORD_STRING_LENGTH));
        assertThat(StringCaseUtil.KEBAB.is(TEST_KEBAB_STRING), is(true));
    }

    @Test
    public void testWhich() {
        assertThat(StringCaseUtil.which(TEST_CAMEL_STRING), equalTo(StringCaseUtil.CAMEL));
        assertThat(StringCaseUtil.which(TEST_PASCAL_STRING), equalTo(StringCaseUtil.PASCAL));
        assertThat(StringCaseUtil.which(TEST_SNAKE_STRING), equalTo(StringCaseUtil.SNAKE));
        assertThat(StringCaseUtil.which(TEST_KEBAB_STRING), equalTo(StringCaseUtil.KEBAB));
    }

    @Test
    public void testConvert() {
        assertThat(StringCaseUtil.convert(StringCaseUtil.CAMEL, TEST_PASCAL_STRING), equalTo(TEST_CAMEL_STRING));
        assertThat(StringCaseUtil.convert(StringCaseUtil.CAMEL, TEST_SNAKE_STRING), equalTo(TEST_CAMEL_STRING));
        assertThat(StringCaseUtil.convert(StringCaseUtil.CAMEL, TEST_KEBAB_STRING), equalTo(TEST_CAMEL_STRING));

        assertThat(StringCaseUtil.convert(StringCaseUtil.PASCAL, TEST_CAMEL_STRING), equalTo(TEST_PASCAL_STRING));
        assertThat(StringCaseUtil.convert(StringCaseUtil.PASCAL, TEST_SNAKE_STRING), equalTo(TEST_PASCAL_STRING));
        assertThat(StringCaseUtil.convert(StringCaseUtil.PASCAL, TEST_KEBAB_STRING), equalTo(TEST_PASCAL_STRING));

        assertThat(StringCaseUtil.convert(StringCaseUtil.SNAKE, TEST_CAMEL_STRING), equalTo(TEST_SNAKE_STRING));
        assertThat(StringCaseUtil.convert(StringCaseUtil.SNAKE, TEST_PASCAL_STRING), equalTo(TEST_SNAKE_STRING));
        assertThat(StringCaseUtil.convert(StringCaseUtil.SNAKE, TEST_KEBAB_STRING), equalTo(TEST_SNAKE_STRING));

        assertThat(StringCaseUtil.convert(StringCaseUtil.KEBAB, TEST_CAMEL_STRING), equalTo(TEST_KEBAB_STRING));
        assertThat(StringCaseUtil.convert(StringCaseUtil.KEBAB, TEST_PASCAL_STRING), equalTo(TEST_KEBAB_STRING));
        assertThat(StringCaseUtil.convert(StringCaseUtil.KEBAB, TEST_SNAKE_STRING), equalTo(TEST_KEBAB_STRING));
    }
}
