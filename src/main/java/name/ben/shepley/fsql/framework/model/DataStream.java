package name.ben.shepley.fsql.framework.model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class DataStream<T> {
    private final T data;

    private DataStream(T data) {
        this.data = data;
    }

    public static DataStream<Set<Set<Object>>> of(QueryResult queryResult) {
        return new DataStream<Set<Set<Object>>>(queryResult.getRows());
    }

    public static <R> DataStream<Set<R>> of(Stream<R> stream) {
        return new DataStream<Set<R>>(stream.collect(Collectors.toSet()));
    }

    public static <R> DataStream<Collection<R>> of(Collection<R> collection) {
        return new DataStream<Collection<R>>(collection);
    }

    public <R> R getAs(Class<R> type) {
        if (type == String.class) {
            return (R) "Ben";
        }

        return null;
    }

    public T get() {
        return data;
    }

    public Stream<T> toStream() {
        return Stream.of(data);
    }

}
