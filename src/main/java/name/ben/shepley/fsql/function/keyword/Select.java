package name.ben.shepley.fsql.function.keyword;

import name.ben.shepley.fsql.function.SqlKeyword;

@FunctionalInterface
public interface Select<T> extends SqlKeyword<T> {
    public abstract T select(SelectCriteria... s);
}
