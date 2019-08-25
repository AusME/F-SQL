package name.ben.shepley.fsql.function.keyword;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

@FunctionalInterface
public interface SelectCriteria {
    public abstract String[] getColumns();

    public static class byClass implements SelectCriteria {
        private String[] columns;
        public byClass(Class clazz) {
            if (clazz != null) {
                this.columns = Arrays.stream(clazz.getDeclaredFields()).map(Field::getName).toArray(String[]::new);
            } else {
                this.columns = new String[0];
            }
        }

        public String[] getColumns() {
            return columns;
        }
    }

    public static class bySql implements SelectCriteria {
        private String[] columns;
        public bySql(String sql) {
            if (sql != null) {
                String[] splitResults = sql.split(",");
                this.columns = Stream.of(splitResults).map(String::trim).toArray(String[]::new);
            } else {
                this.columns = new String[0];
            }
        }

        public String[] getColumns() {
            return this.columns;
        }
    }

}