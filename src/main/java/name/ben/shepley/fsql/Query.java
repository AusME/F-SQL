package name.ben.shepley.fsql;

import java.util.Map;

public interface Query {
    public abstract String toSql();
    public abstract Map<Integer, Object> getParameters();
}