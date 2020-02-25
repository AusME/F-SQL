package name.ben.shepley.fsql.h2.query;

import name.ben.shepley.fsql.framework.ExecutionContext;

public class H2QueryFactory {
    public H2Select select() {
        return new H2Select(new ExecutionContext());
    }
}
