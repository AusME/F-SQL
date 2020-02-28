package name.ben.shepley.fsql.framework.model;

import java.util.Map;

public interface Query {
    String toSql();
    Map<Integer, Object> getSqlParameters();
}
