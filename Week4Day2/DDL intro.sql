--SQL Intro
--Before doing anything else, we need to define where our data will go.
--We can do this with DDL:

--Common DDL commands:
	--create - create a table
	--alter  - alter a table, commonly used to change column definitions
 	--drop   - delete a table, including all info contained in it


--Two that I will not use today, but do exist in DDL: 	
	--truncate - delete all information from a table, but don't delete it
	--rename   - rename a table

--SQL is case insensitive, I've set this IDE for uppercase commands for readability's sake

--dropping tables if they already exist so that the rest of this script runs, cascade destroys the link between the two so that they can be dropped
DROP TABLE IF EXISTS user_credentials CASCADE;
DROP TABLE IF EXISTS user_profile CASCADE;

--our example table from the notes:
CREATE TABLE user_credentials(
	id serial PRIMARY KEY,
	user_name varchar(100),
	user_pass varchar(100) DEFAULT 'test'
);

--constraints: essentially restrictions we can place on a column
--primary key means that the data is unique and not null
--foreign key is another constraint we can use to create relationships between tables.

CREATE TABLE user_profile(
	phone_number int,
	email varchar(50),
	first_name varchar(30),
	last_name varchar(30),
	credentials_id int REFERENCES user_credentials(id)
);

ALTER TABLE user_profile ADD COLUMN id serial PRIMARY KEY;