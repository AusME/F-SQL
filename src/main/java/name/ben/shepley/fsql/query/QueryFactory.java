package name.ben.shepley.fsql.query;

import name.ben.shepley.fsql.query.sqlCommand.Select;

public class QueryFactory {

    public Select select(Object object) {
        Query<Select> selectQuery = new Query<>();
        selectQuery.setCommand(new Select(selectQuery));

        return selectQuery.getCommand();
    }
}
