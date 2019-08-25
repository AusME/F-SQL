package name.ben.shepley.fsql;

import name.ben.shepley.fsql.function.keyword.SelectCriteria;
import name.ben.shepley.fsql._harness.model.Employee;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class SqlBuilderTest {
    @Test
    public void testSelect() {
        SqlBuilder sqlBuilder = new SqlBuilder();
        sqlBuilder.select(
                new SelectCriteria.byClass(Employee.class),
                new SelectCriteria.bySql("x, y, z")
        );

        Stream.of(sqlBuilder.getSelectColumns()).forEach(System.out::println);
    }
}
