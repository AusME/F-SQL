package name.ben.shepley.fsql.h2;

import name.ben.shepley.fsql.Query;

import java.util.*;

public class H2Select implements Query {
    /* Immutable */
    private final String SQL;
    private final Map<Integer, Object> PARAMETERS;

    /* Constructor */
    private H2Select(String sql, Map<Integer, Object> parameters) {
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

    public static class H2SelectBuilder {
        /* Keywords */
        private static final String SELECT = "SELECT";
        private static final String FROM = "FROM";
        private static final String WHERE = "WHERE";

        /* Data */
        private Set<String> columns = new HashSet<>();
        private Set<String> tables = new HashSet<>();
        private String whereConditions = "";

        /* Constructor */
        private H2SelectBuilder() { }

        /* Builder Methods */
        public static H2SelectBuilder builder() {
            return new H2SelectBuilder();
        }

        public Query build() {
            String sql =
                    SELECT + " " + String.join(", ", this.columns) + "\n" +
                    FROM + " " + String.join(", ", this.tables) + "\n";
            return new H2Select(sql, Collections.EMPTY_MAP);
        }

        /* Data Methods */
        public H2SelectBuilder select(String... columns) {
            this.columns.addAll(Arrays.asList(columns));
            return this;
        }

        public H2SelectBuilder from(String... tables) {
            this.tables.addAll(Arrays.asList(tables));
            return this;
        }
    }
}