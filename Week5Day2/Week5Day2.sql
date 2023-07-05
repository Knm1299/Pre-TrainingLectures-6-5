--Joins, set operators, Subqueries

--Joins: used to get information from more than one table at a time

--4 common types of joins:
--Inner - default kind of join, gets information that matches between two tables, no nulls

--Outer - all information from both tables, with matching results shown side by side

--Left  - also called left inner, gets info from the first table and matches with info from second table, doesn't show unmatched info from second table

--Right - also called right inner, reverse of left join


--cross join
--self join
--union

--setting up tables
DROP TABLE IF EXISTS pet_owners CASCADE;
DROP TABLE IF EXISTS pets CASCADE;
CREATE TABLE pet_owners(
	id serial PRIMARY KEY,
	first_name varchar(20),
	last_name varchar(20)
);

INSERT INTO pet_owners VALUES
(DEFAULT, 'Keven', 'Mitchell'),
(DEFAULT, 'Joseph', 'Highe'),
(DEFAULT, 'Cynthia', 'Enciso');

CREATE TABLE pets(
	id serial PRIMARY KEY,
	pet_name varchar(30),
	pet_age int,
	pet_owner int REFERENCES pet_owners(id)
);

INSERT INTO pets VALUES
(DEFAULT, 'Cooper', 2, 1),
(DEFAULT, 'Cooper', 2, 1),
(DEFAULT, 'PJ', 4, 1),
(DEFAULT, 'Scruffles', 4, 2),
(DEFAULT, 'Orphaned Pet', 2, NULL);

SELECT * FROM pets;
SELECT * FROM pet_owners;


--Inner Join - just similar information
SELECT * FROM pet_owners INNER JOIN pets ON pets.pet_owner = pet_owners.id;

--Outer/full join - all info, but matching results included
SELECT * FROM pets FULL OUTER JOIN pet_owners ON pets.pet_owner = pet_owners.id;

--Left Join - all info from one table, matching info from the other
SELECT * FROM pets LEFT JOIN pet_owners ON pets.pet_owner = pet_owners.id;

--Right Join - all info from second table, just matching info from first
SELECT * FROM pets RIGHT JOIN pet_owners ON pets.pet_owner = pet_owners.id;


--less common joins

--cross join - returns all possible combinations of rows from two tables (matches each row from one table with every row from the other)
SELECT * FROM pet_owners CROSS JOIN pets;

--self join - joins a table to itself, much rarer use cases
SELECT * FROM pet_owners AS p1, pet_owners AS p2;


CREATE VIEW all_pets AS SELECT * FROM pets;
SELECT * FROM all_pets;

--Subqueries, set operations
--SELECT statements return a 'view' which can be treated as a kind of virtual table.
--we can run other queries on the results of a select statement, and can combine these with 'set operators'

--set operators
--combine multiple views, views selected must have the same number of columns

--union
SELECT pet_name AS "Name" FROM pets
UNION 
SELECT first_name  FROM pet_owners;

--union all
SELECT pet_name AS "Name" FROM pets
UNION ALL 
SELECT first_name  FROM pet_owners;

--intersect
SELECT id FROM pets
INTERSECT 
SELECT id FROM pet_owners;

--except, minus
SELECT id FROM pets p 
EXCEPT 
SELECT id FROM pet_owners po ;


--EX 1. Create a query that returns the number of pets owned by each pet_owner
--return pet_owner first name, count of pets
SELECT po.first_name, (SELECT COUNT(pets.id) FROM pets WHERE pets.pet_owner = po.id) 
FROM pet_owners AS po;

--EX 2. Create a query that returns the average pet age of the pets owned by each owner
SELECT po.first_name, (SELECT AVG(p.pet_age) FROM pets AS p WHERE p.pet_owner = po.id) 
FROM pet_owners AS po;

