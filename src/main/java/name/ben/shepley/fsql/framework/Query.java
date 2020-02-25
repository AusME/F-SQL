package name.ben.shepley.fsql.framework;

public interface Query {
    public abstract QueryStream execute(Query query);
}