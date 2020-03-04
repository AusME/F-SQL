package name.ben.shepley.fsql.framework.model;

import java.util.Collection;
import java.util.stream.Stream;

public final class QueryResult {
    public final TabularData tabularData;

    private QueryResult(TabularData tabularData) {
        this.tabularData = tabularData;
    }

    /* Factory Methods */
    public static QueryResult as(TabularData tabularData) {
        return new QueryResult(tabularData);
    }

    public <T> Stream<T> toStream(Class<T> type) {
        return Stream.of(this.as(type));
    }

    /* TODO: */
    public <T> T as(Class<T> type) {
        if (type == String.class) {
            return (T) "Ben";
        }

        return null;
    }

    public <T> Collection<T> as(Collection<Class<T>> type) {
        return null;
    }

    public <T> T[] as(Class<T>[] type) {
        return null;
    }

    /* Operations TODO: */
    public QueryResult intersection(QueryResult queryResult) {
        return queryResult;
    }

    public QueryResult add(QueryResult queryResult) {
        return queryResult;
    }

    public QueryResult subtract(QueryResult queryResult) {
        return queryResult;
    }

    public QueryResult xor(QueryResult queryResult) {
        return queryResult;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof QueryResult)) {
            return false;
        }

        QueryResult queryResult = (QueryResult) o;

        return true;
    }
}
