package name.ben.shepley.fsql.framework.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class QueryResult {
    private final List<String> columnNames;
    private final List<Class<?>> columnTypes;
    private final List<List<Object>> rows;

    public QueryResult(List<String> columnNames, List<Class<?>> columnTypes, List<List<Object>> rows) {
        this.columnNames = Collections.unmodifiableList(columnNames);
        this.columnTypes = Collections.unmodifiableList(columnTypes);
        this.rows = Collections.unmodifiableList(rows);
    }

    /* Getters */
    public <T> T as(Class<T> type) {
        if (type == String.class) {
            return (T) "Ben";
        }

        return null;
    }

    public <T> T as(Collection<Class<T>> type) {

        return null;
    }

    public <T> T as(Class<T>[] type) {
        return null;
    }

    public <T> Stream<T> toStream(Class<T> type) {
        return Stream.of(this.as(type));
    }

    /* Operations */
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
