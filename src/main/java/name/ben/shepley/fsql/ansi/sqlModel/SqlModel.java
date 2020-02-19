package name.ben.shepley.fsql.ansi.sqlModel;

import java.util.concurrent.ConcurrentHashMap;

public interface SqlModel {
    public abstract String toSql();
    public abstract ConcurrentHashMap<Integer, Object> getParameters();
}