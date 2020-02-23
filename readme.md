# F-SQL
Fluent SQL is an ORM designed to make writing custom type safe SQL easier.
F-SQL is intended to be fail safe and work around limitations in SQL, and in Java to provide a simple way of accessing your chosen DBMS directly and still be able to realize the features of your chosen DBMS.

### Description
F-SQL primarily consists of THREE parts:
1) Query: A built object which stores SQL, and parameters. This object is designed around specific DBMS implementations to support specific DBMS features.
2) QueryResult: A object which stores the resulting information from the query execution.
2) QueryEngine: A singleton which stores Database details to assist in query execution management.

### Examples
Example Code for Querying by String:

    public void someServiceMethod() {
        Query select =
            SelectBuilder.getBuilder()
                .select("column_one")
                .from("table")
                .build();

        QueryResult result = this.queryEngine.execute(select);
        List<Entity> entities = result.collect(SqlCollector.toList());
        Stream<Entity> stream = result.collect(SqlCollector.toStream());
        Integer i = result.collect(SqlCollector.toInteger());
    }

Too wordy? Since nearly everything in the framework uses the builder pattern, feel free to minimize. Or better yet, create your own singleton to store common ways of getting data from the database.
