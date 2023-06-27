--Yesterday we discussed SQL in general, and a bit of DDL
--Today's topic: DML, DQL

--DML - Data Manipulation Language
		--These consist of CRUD operations
		--common commands:
			--INSERT - adds new records to a table
			--UPDATE - changes records already in a table *
			--DELETE - deletes information from a table *

--* - necessary to use WHERE clause in most use cases 

--DQL - Data Query Language
		--Some debate on whether this should be part of DML or not
		--Consists of:
			--SELECT   - reads information from a table

			--WHERE    - an additional clause we can add to some commands to specify a condition for the operation
			--GROUP BY - groups rows with the same information together based on similar values
			--ORDER BY - sets a sorting order for the resultset to display in, asc and desc can define direction

--Run the previous script before this one for the tables we are about to use
--I will bundle a version with today's code that has the definitions set to what we will use.

--Insert
INSERT INTO user_credentials VALUES(DEFAULT, 'testAccount', 'password');

--INSERT INTO table_name(columns) VALUES(values);

--columns are optional if inserting all columns
--default alows us to use the default value for the column. Serial has this built in, we can also define it with a constraint per-column
INSERT INTO user_profile(id, phone_number, email, first_name, last_name, credentials_id)
VALUES(DEFAULT, 115, 'exampleEmail2@yopmail.com', 'firstname3', 'lastname2', 1);

SELECT * FROM user_credentials;
SELECT * FROM user_profile;

--Update
UPDATE user_profile SET first_name  = 'Joe', last_name = 'some other value' WHERE id = 4;
--using the where clause here, what happens if we don't include it?

--Delete
DELETE FROM user_profile WHERE id = 3;
--once again, using where to identify the specific record, if we don't include it, all records will be affected

TRUNCATE user_credentials RESTART IDENTITY CASCADE;
