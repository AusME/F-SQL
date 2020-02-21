# F-SQL
Fluent SQL is an ORM designed to make writing custom type safe SQL easier.
F-SQL is intended to be fail safe and work around limitations in SQL, and in Java to provide a simple way of accessing your chosen DBMS directly and still be able to realize the features of your chosen DBMS.

### Description
F-SQL primarily consists of THREE parts:
1) The Model. A builder that builds SQL, and parameters designed around specific DBMS implementations.
2) The QueryEngine. A singleton whose purpose it is to manage execution of queries.
3) The QueryResponse. An object which stores the ResultSet making transformations on that data easier.

### Examples
Example Code for Querying by String:

    public void someServiceMethod() {
        SqlModel select =
            SelectBuilder.getBuilder()
                .select("column_one")
                .from("table")
                .build();

        ResultsObject results = this.queryEngine.execute(select);
        List<Entity> entities = results.collect(SqlCollector.toList());
        Stream<Entity> stream = results.collect(SqlCollector.toStream());
        Integer i = results.collect(SqlCollector.toInteger());
    }

Too wordy? Since nearly everything in the framework uses the builder pattern, feel free to minimize. Or better yet, create your own singleton to store common ways of getting data from the database.
