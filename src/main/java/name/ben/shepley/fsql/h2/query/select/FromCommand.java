package name.ben.shepley.fsql.h2.query.select;

import name.ben.shepley.fsql.framework.NestedBuilderAndCommand;
import name.ben.shepley.fsql.framework.SqlParameter;
import name.ben.shepley.fsql.h2.query.H2Select;
import org.apache.commons.collections.map.UnmodifiableMap;

public class FromCommand implements NestedBuilderAndCommand<FromCommand, H2Select>, SqlParameter {
    /* Parent */
    private H2Select h2Select;

    @Override
    public FromCommand getCommand() {
        return this;
    }

    @Override
    public FromCommand setParent(H2Select h2Select) {
        this.h2Select = h2Select;
        return this;
    }

    @Override
    public H2Select done() {
        return this.h2Select;
    }

    @Override
    public String toSql() {
        return null;
    }

    @Override
    public UnmodifiableMap getParameters() {
        return null;
    }
}
