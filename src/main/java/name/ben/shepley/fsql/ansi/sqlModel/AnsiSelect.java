package name.ben.shepley.fsql.ansi.sqlModel;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AnsiSelect implements SqlModel {
    /* Immutable */
    private final String SQL;

    /* Mutable */
    private final ConcurrentHashMap<Integer, Object> PARAMETERS;

    /* Constructor */
    private AnsiSelect(String sql, ConcurrentHashMap<Integer, Object> parameters) {
        this.SQL = sql;
        this.PARAMETERS = parameters;
    }

    @Override
    public String toSql() {
        return null;
    }

    @Override
    public ConcurrentHashMap<Integer, Object> getParameters() {
        return null;
    }

    public static class AnsiSelectBuilder  {
        /* Keywords */
        private static final String SELECT = "SELECT";
        private static final String FROM = "FROM";

        /* Data */
        private Set<String> columns;
        private Set<String> tables;

        /* Constructor */
        private AnsiSelectBuilder() { }

        /* Builder Methods */
        public static AnsiSelectBuilder builder() {
            return new AnsiSelectBuilder();
        }

        public SqlModel build() {
            return new AnsiSelect("", null);
        }

        /* Data Methods */

    }
}
