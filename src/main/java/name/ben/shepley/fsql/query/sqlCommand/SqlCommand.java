package name.ben.shepley.fsql.query.sqlCommand;

public interface SqlCommand {
    public enum SqlCommandEnum {
        SELECT("SELECT");

        private String command;

        private SqlCommandEnum(String command) {
            this.command = command;
        }

        public String getCommand() {
            return this.command;
        }
    }

    public abstract SqlCommandEnum getCommand();
}