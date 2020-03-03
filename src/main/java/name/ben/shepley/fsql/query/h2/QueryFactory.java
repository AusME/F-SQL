package name.ben.shepley.fsql.query.h2;

import name.ben.shepley.fsql.query.h2.select.SelectQuery;

public class QueryFactory {

    public static SelectQuery selectFrom() {
        return new SelectQuery();
    }


}
