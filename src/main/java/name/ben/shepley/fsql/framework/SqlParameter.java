package name.ben.shepley.fsql.framework;

import org.apache.commons.collections.map.UnmodifiableMap;

public interface SqlParameter {
    public abstract String toSql();
    public abstract UnmodifiableMap getSqlParameters();
}
