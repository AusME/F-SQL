package name.ben.shepley.fsql.h2.query.select.command;

import name.ben.shepley.fsql.framework.NestedBuilder;
import name.ben.shepley.fsql.framework.Query;
import name.ben.shepley.fsql.h2.query.select.SelectQuery;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WhereCommand extends NestedBuilder<SelectQuery> implements Query {
    /* Important Instance Variables */
    private Map<Integer, Object> parameters = new HashMap<>();
    private StringBuilder conditions = new StringBuilder("");
    private int parameterCount = 0;

    /* Operators */
    private static final String EQUALS = " = ";
    
    public WhereCommand(SelectQuery selectQuery) {
        super(selectQuery);
    }

    @Override
    public String toSql() {
        return conditions.toString();
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        return Collections.unmodifiableMap(this.parameters);
    }

    public WhereCommand beginStatement() {
        this.conditions.append("(");
        return this;
    }

    public WhereCommand endStatement() {
        this.conditions.append(")");
        return this;
    }

    public WhereCommand equals(String operandOne, Object operandTwo) {
        this.parameters.put(parameterCount, operandTwo);
        this.conditions.append(operandOne).append(EQUALS).append("?");
        this.parameterCount++;
        return this;
    }
}
