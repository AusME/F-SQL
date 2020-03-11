package name.ben.shepley.fsql.query.h2.select;

import name.ben.shepley.fsql._framework.model.Query;
import name.ben.shepley.fsql.query.h2.select.command.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SelectQuery implements Query {
    /* COMMANDS: */
    protected SelectCommand selectCommand = new SelectCommand(this);
    protected FromCommand fromCommand = new FromCommand(this);
    protected JoinCommand joinCommand = new JoinCommand(this);
    protected WhereCommand whereCommand = new WhereCommand(this);
    protected GroupByCommand groupByCommand = new GroupByCommand(this);
    protected HavingCommand havingCommand = new HavingCommand(this);
    protected OrderCommand orderCommand = new OrderCommand(this);
    protected LimitCommand limitCommand = new LimitCommand(this);

    @Override
    public String toSql() {
        StringBuilder sql = new StringBuilder();
        sql.append(this.selectCommand.toSql()).append("\n");
        sql.append(this.fromCommand.toSql()).append("\n");

        Query[] queries = {this.joinCommand, this.whereCommand, this.groupByCommand, this.havingCommand, this.orderCommand, this.limitCommand};
        for (Query query : queries) {
            if (!this.joinCommand.toSql().isEmpty()) {
                sql.append(query.toSql()).append("\n");
            }
        }

        return sql.toString();
    }

    @Override
    public Map<Integer, Object> getSqlParameters() {
        var keyStart = 0;
        var parameters = new HashMap<Integer, Object>();
        Query[] queries = {this.whereCommand, this.groupByCommand, this.havingCommand, this.orderCommand, this.limitCommand};

        for (Query query : queries) {
            for (Integer key : query.getSqlParameters().keySet()) {
                Object object = query.getSqlParameters().get(key);
                parameters.put(keyStart, object);
                keyStart++;
            }
        }

        return Collections.unmodifiableMap(parameters);
    }

    /* COMMANDS: */
    public SelectCommand select() {
        return this.selectCommand;
    }

    public FromCommand from() {
        return this.fromCommand;
    }

    public JoinCommand join() {return this.joinCommand;}

    public WhereCommand where() {return this.whereCommand;}

    public GroupByCommand groupBy() {return this.groupByCommand;}

    public HavingCommand having() {return this.havingCommand;}

    public OrderCommand orderCommand() {return this.orderCommand;}

    public LimitCommand limitCommand() {return this.limitCommand;}
}