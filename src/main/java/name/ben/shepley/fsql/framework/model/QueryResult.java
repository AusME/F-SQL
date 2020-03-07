package name.ben.shepley.fsql.framework.model;

import java.util.Collection;
import java.util.stream.Stream;

public final class QueryResult<T> {
    public final T t;

    public QueryResult(T t) {
        this.t = t;
    }

    public T get() {
        return this.t;
    }

    public Stream<T> toStream() {
        return Stream.of(this.t);
    }

    public <C> C as(Class<C> type) {
        if (type == String.class) {
            return (C) "Ben";
        }

        return null;
    }

    public <C> Collection<C> as(Collection<Class<C>> type) {
        return null;
    }

    public <C> C[] as(Class<C>[] type) {
        return null;
    }

}
