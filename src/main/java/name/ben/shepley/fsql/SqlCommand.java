package name.ben.shepley.fsql;

import java.util.Map;

public interface SqlCommand {
    public abstract String getSql();
    public abstract Map<String, Object> getData();
}
