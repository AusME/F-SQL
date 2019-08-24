package name.ben.shepley.fsql;

import name.ben.shepley.fsql.function.keyword.Select;
import name.ben.shepley.fsql.function.keyword.SelectCriteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqlBuilder implements Select<SqlBuilder> {
    private String[] selectColumns;

    @Override
    public SqlBuilder select(SelectCriteria... selectCriteria) {
        List<String> columns = new ArrayList<>();
        Arrays.stream(selectCriteria)
                .forEach((e) ->
                        Arrays.stream(e.getColumns())
                            .forEach((s) -> columns.add(s)));

        this.selectColumns = columns.toArray(new String[]{});
        return this;
    }

    public String[] getSelectColumns() {
        return this.selectColumns;
    }
}