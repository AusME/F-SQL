package name.ben.shepley.fsql.framework;

import java.util.Map;

public interface Query {
    String toSql();
    Map<Integer, Object> getSqlParameters();
}
