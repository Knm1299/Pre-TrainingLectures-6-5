**Database**
 - Any structured store of data
 - Can be as simple as an excel sheet
 - can come in many formats, today we are discussing relational databases, and using sql to interact with them

 **Relational Database**
  - A database that stores information in tables
  - The tables generally represent datapoints about entities, with the columns being the fields/properties of those entities, and the rows representing the entities themselves.
  - RDBMS: Relational Database Management System - The particular implementation of your flavor/dialect of sql(PostgreSQl, MySQL)
  
  **For example:**
  
  If we were to create the following table in SQL:

  |id   |user_name   |user_pass | 
  |-----|------------|----------|
  |0    |exampleUser |password! |
  |1    |example2    |wordpass  |

  The column names would be our fields, each entry/row/entity/object has an id, a username, and a password.
  
  If we were working only with Java, the objects this table can store could be represented by a class:

  ```java
  class User{
    int id;
    String user_name;
    String user_pass;
  }

  //each entry in the table could then be represented by an object:
  User exampleUser = new User(0,"exampleUser", "password!");
  User example2 = new User(1,"example2", "wordpass");
  ```

These are both equivalent ways to represent the same data, but the more compact and well defined nature of a table lends itself to storing vastly larger quantities of data at a time.

We use SQL to interact with relational databases

 **SQL**
 - Structured query language
 - SQL refers to the core language, many different 'dialects' or 'flavors' of SQL exist, most extend the core language in some way. I will use Postgres for our course, but almost everything we use in PostgresQL can be used in other SQL dialects.
 - SQL is often broken down into **sublanguages**:
    - Separate from dialects, these represent the categories of actions we can take with SQL. The count varies based on who you ask, but for our purposes, I will discuss the 4 or 5 major ones:
    - **DDL** - Data Definition Language, used to define the 'schema'(structure) of the database
    - **DML** - Data Manipulation Language, used to add/remove/update information in the tables of the database
    - **DQL** - Data Query Language - this one is debated, some consider it a valid sublanguage, some consider it part of DML, it is essentially just retrieving information with the SELECT command
    - **DCL** - Data Control Language, used to change permissions -  what 'accounts' can access the database/where can they make changes
    - **TCL** - Transaction Control Language, used group operations together, ensuring that if we run a set of commands together, they will either all pass, or if one fails, they will all fail, and the database will not be altered at all.

- See the .sql script for today's example with DDL