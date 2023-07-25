# Week 8 Day 2

Assorted topics today, will not be demonstrating in detail for most

## Functions

- Discussed yesterday, these take some input and produce a return value
- Syntax to define:

```sql
CREATE OR REPLACE FUNCTION function_name(
    parameters(ex. param1 int, param2 dec)
)
LANGUAGE lang(ex. plpgsql for postgres)
AS $$
DECLARE any_variables
BEGIN
sql_body
END;
$$;
```

## Triggers

- An event that causes other events
- These can be registered to cause some action to be performed
- Syntax is:
  
```sql
CREATE TRIGGER trigger_name
BEFORE|AFTER event_name(ex. UPDATE, INSERT, DELETE)
ON table_name
FOR EACH ROW|STATEMENT
EXECUTE FUNCTION|PROCEDURE name_of_function/procedure(parameters)
```

## Stored Procedures

- Similar to functions, but these have no return value
- equivalent to void methods in java, these 'do' something, rather than returning something
- Syntax to define:

```sql
CREATE OR REPLACE PROCEDURE procedure_name(
    parameters(ex. param1 int, param2 dec)
)
LANGUAGE lang(ex. plpgsql for postgres)
AS $$
BEGIN
sql_body
END;
$$;
```

## Sequences

- These are sets of integers
- We've already seen a common one - serial
- Syntax to define:
  
```sql
CREATE SEQUENCE sequence_name
START start_number
INCREMENT BY increment_by
MINVALUE max
MAXVALUE min
CYCLE or NO CYCLE
```

## Indexes

- These implement an algorithm to improve lookup time for rows in a table
  - Similar to how a hashmap is faster to find a particular entry than an arraylist
- different types are available, using different algorithms
- Slows down DML commands in favor of DQL
- Automatically created for PK and unique columns
