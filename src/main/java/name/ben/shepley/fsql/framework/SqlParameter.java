package name.ben.shepley.fsql.framework;

import java.util.Map;

public interface SqlParameter {
    public abstract String toSql();
    public abstract Map<Integer, Object> getSqlParameters();
}
