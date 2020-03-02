package name.ben.shepley.fsql.framework.model;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class DataStream<T> {
    private final T data;
    public DataStream(T data) {
        this.data = data;
    }

    public static <T> DataStream<T> of(T t) {
        return new DataStream<T>(t);
    }

    public static void main(String[] args) {
        System.out.println(Stream.of("Test", "Test2").findFirst());
    }



}
