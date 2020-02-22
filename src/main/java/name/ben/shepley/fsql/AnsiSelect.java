package name.ben.shepley.fsql;

import java.util.*;

public class AnsiSelect implements Query {
    /* Immutable */
    private final String SQL;
    private final Map<Integer, Object> PARAMETERS;

    /* Constructor */
    private AnsiSelect(String sql, Map<Integer, Object> parameters) {
        this.SQL = sql;
        this.PARAMETERS = Collections.unmodifiableMap(parameters);
    }

    @Override
    public String toSql() {
        return this.SQL;
    }

    @Override
    public Map<Integer, Object> getParameters() {
        return this.PARAMETERS;
    }

    public static class AnsiSelectBuilder  {
        /* Keywords */
        private static final String SELECT = "SELECT";
        private static final String FROM = "FROM";
        private static final String WHERE = "WHERE";

        /* Data */
        private Set<String> columns = new HashSet<>();
        private Set<String> tables = new HashSet<>();
        private String whereConditions = "";

        /* Constructor */
        private AnsiSelectBuilder() { }

        /* Builder Methods */
        public static AnsiSelectBuilder builder() {
            return new AnsiSelectBuilder();
        }

        public Query build() {
            String sql =
                    SELECT + String.join(", ", this.columns) + "\n" +
                    FROM + String.join(", ", this.tables) + "\n";
            return new AnsiSelect(sql, Collections.EMPTY_MAP);
        }

        /* Data Methods */
        public AnsiSelectBuilder select(String... columns) {
            this.columns.addAll(Arrays.asList(columns));
            return this;
        }

        public AnsiSelectBuilder from(String... tables) {
            this.tables.addAll(Arrays.asList(tables));
            return this;
        }
    }
}