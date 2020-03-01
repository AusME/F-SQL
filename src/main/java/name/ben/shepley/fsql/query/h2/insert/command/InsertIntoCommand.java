package name.ben.shepley.fsql.query.h2.insert.command;

import name.ben.shepley.fsql.framework.dataStructure.NestedBuilder;
import name.ben.shepley.fsql.framework.model.Query;
import name.ben.shepley.fsql.query.h2.insert.InsertQuery;

import java.util.Collections;
import java.util.Map;

public class InsertIntoCommand extends NestedBuilder<InsertQuery> implements Query {

    public InsertIntoCommand(InsertQuery insertQuery) {
        super(insertQuery);
    }

    @Override
    public String toSql() {
        return "";
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return Collections.emptyMap();
    }
}
