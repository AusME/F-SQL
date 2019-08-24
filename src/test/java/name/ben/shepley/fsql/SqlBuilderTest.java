package name.ben.shepley.fsql;

import name.ben.shepley.fsql.function.keyword.SelectCriteria;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class SqlBuilderTest {
    @Test
    public void testSelect() {
        SqlBuilder sqlBuilder = new SqlBuilder();
        sqlBuilder.select(
                new SelectCriteria.SelectCriteriaSql("a, b, c"),
                new SelectCriteria.SelectCriteriaSql("x, y, z")
        );

        Stream.of(sqlBuilder.getSelectColumns()).forEach(System.out::println);
    }
}
