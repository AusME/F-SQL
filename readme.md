# F-SQL
Fluent SQL is an ORM designed to make writing custom type safe SQL easier.
F-SQL is intended to be fail safe and work around limitations in SQL, and in Java to provide a simple way of accessing your chosen DBMS directly and still be able to realize the features of your chosen DBMS.

### Description
F-SQL primarily consists of THREE parts:
1. Query: Stores SQL, and parameters. This is designed around specific DBMS implementations to support specific DBMS features.
2. QueryStream: Stores the resulting information from the query execution.
   - QueryCollector: Generic collector to collect database results into models or primitives.
3. QueryEngine: Singleton which stores Database details to assist in query execution management.

### Examples
Example Code for Querying by String:

    public void someServiceMethod() {
        Query select =
            SelectBuilder.getBuilder()
                .select("column_one")
                .from("table")
                .build();

        QueryStream result = this.queryEngine.execute(select);
        List<Entity> entities = result.collect(QueryCollector.toList());
        Stream<Entity> stream = result.collect(QueryCollector.toStream());
        Integer i = result.collect(QueryCollector.toInteger());
    }

Too wordy? Since nearly everything in the framework uses the builder pattern, feel free to minimize. Or better yet, create your own singleton to store common ways of getting data from the database.
