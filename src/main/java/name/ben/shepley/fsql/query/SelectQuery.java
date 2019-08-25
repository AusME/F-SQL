package name.ben.shepley.fsql.query;

public class SelectQuery implements Query {
    private String[] select;
    private String[] from;
    private String[] joins;
    private String where;
    private String[] groupBy;
    private String having;

    private SelectQuery(String[] select, String[] from, String[] joins, String where, String[] groupBy, String having) {
        this.select = select;
        this.from = from;
        this.joins = joins;
        this.where = where;
        this.groupBy = groupBy;
        this.having = having;
    }

    public String toSql() {
        if (select == null || select.length == 0) {
            throw new QueryException("SELECT string not given. Please specify a SELECT string before attempting to turn into SQL.");
        }

        StringBuilder sql = new StringBuilder();
        /* SELECT */
        sql.append("SELECT ");
        for (String column : this.select) {
            sql.append(column).append(", ");
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 2));
        sql.append("\n");

        /* FROM */
        if (this.from != null && this.from.length > 0) {
            sql.append(" FROM ");
            for (String table : this.from) {
                sql.append(table).append(", ");
            }
        }
        sql = new StringBuilder(sql.substring(0, sql.length() - 2));
        sql.append("\n");

        return sql.toString();
    }

    public static class SelectQueryBuilder {
        private String[] select;
        private String[] from;
        private String[] joins;
        private String where;
        private String[] groupBy;
        private String having;

        public SelectQuery build() {
            return new SelectQuery(this.select, this.from, this.joins, this.where, this.groupBy, this.having);
        }

        public SelectQueryBuilder setSelect(String[] select) {
            this.select = select;
            return this;
        }

        public SelectQueryBuilder setFrom(String[] from) {
            this.from = from;
            return this;
        }

        public SelectQueryBuilder setJoins(String[] joins) {
            this.joins = joins;
            return this;
        }

        public SelectQueryBuilder setWhere(String where) {
            this.where = where;
            return this;
        }

        public SelectQueryBuilder setGroupBy(String[] groupBy) {
            this.groupBy = groupBy;
            return this;
        }

        public SelectQueryBuilder setHaving(String having) {
            this.having = having;
            return this;
        }
    }

}
