package name.ben.shepley.fsql.query;

public interface QueryAware<T> {
    public abstract Query<T> getQuery();
    public abstract T setQuery(Query<T> query);
}
