package name.ben.shepley.fsql.ansi.sqlModel;

import java.util.Map;

public interface SqlModel {
    public abstract String toSql();
    public abstract Map<Integer, Object> getParameters();
}