# Week 8 Day 1

## DCL and TCL

These are two of the sublanguages that we haven't really talked about yet, but are actually already using.

### DCL

- Sublanguage that controls a user's access to the database
- Commands are GRANT, REVOKE
- Used to give or remove certain permissions to pre-existing users
  - oftentimes, this means that we create a user for each deployed application, so each app can only interact with the database using the commands it needs
- Permissions can be granted or revoked on a per-command basis
  - eg. ``GRANT SELECT ON employee TO postgres;`` would grant permission to select from the employee table in the DB to the user named postgres
  - The users I'm referring to here are set up within the RDBMS, and have no bearing on the actual tables or data within

### TCL

- This sublanguage is used to treat operations(commands executed together) similar to how git handles changes.
  - changes are not permanent unless they are 'committed'
  - everything we have done so far has automatically committed changes
- Commands in this sublanguage:
  - COMMIT
    - Saves all pending changes in the database, also referred to as 'persisting' the changes
  - ROLLBACK
    - Rolls changes back to the last commit run, and puts the database in a previous state
  - SAVEPOINT
    - Creates a named state you can roll back to, rather than rolling back to the last commit
- Transactions should follow the ACID properties

### ACID

1. Atomic
   - Transactions should pass or fail as a single unit
   - If one step of a transaction fails, the whole transaction fails and the DB is rolled back
2. Consistent
   - If transactions are atomic, the state of the database will be consistent
3. Isolated
   - Transactions that modify the same resource can't be executed simultaneously
   - Each transaction must run isolated from others
4. Durable
   - The results of transactions should be stored and logged if they are successful
     - This happens automatically
   - This results in the changes being saved even if the DB has a system failure

## Built-in Functions

Functions in SQL refer to a group of commands that take some input and return a value. These are categorized based on the type of input given.

### Aggregate

- These take a range of information as an input
- Examples:
  - COUNT() - returns count of rows
  - SUM()   - returns sum of values
  - AVG()   - returns average value
  - MIN()   - returns lowest value
  - MAX()   - returns highest value

### Scalar

- These take a single value as an input
- Examples:
  - upper()     - returns a string input as UPPERCASE
  - lower()     - upper, but returns lowercase
  - sqrt()      - returns square root of number
  - round()     - rounds a number to nearest int
  - round(a, b) -  rounds the number(a) to nearest b decimal places
    - eg. round(123.456, 2) becomes 123.46

- There are an enormous number of scalar functions built-in, docs recommended for more info

[Docs for postgres functions and operators](https://www.postgresql.org/docs/current/functions.html)
