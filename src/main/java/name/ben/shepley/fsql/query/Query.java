package name.ben.shepley.fsql.query;

@FunctionalInterface
public interface Query {
    public abstract String toSql();
}
