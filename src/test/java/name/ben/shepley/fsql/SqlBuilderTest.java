package name.ben.shepley.fsql;

import name.ben.shepley.fsql.function.keyword.SelectCriteria;
import name.ben.shepley.fsql._harness.model.Employee;
import name.ben.shepley.fsql.model.Select;
import name.ben.shepley.fsql.model.SelectBuilder;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class SqlBuilderTest {
    @Test
    public void testSelect() {
        Table t = new Table();
        Stream<Table> results =
                new QueryExecutor().execute(
                    new SelectBuilder()
                        .select("")
                        .from("")
                        .build()
                );

    }

    @Test
    public void testSelect1() {
        new Object().equals("");
    }
}
