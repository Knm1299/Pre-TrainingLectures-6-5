**Multiplicity AKA Cardinality**
- Describes the relationship between two tables. 
- Three different cardinalities 
	- One to Many / Many to One
	- Many to Many
	- One to One
	
<br>

- **1 : M (One to Many relationship)**
    - Each restaurant is located in exactly one region. Each region must have at least
    - one restaurant located in it, but it may have many restaurants located in it. 

        - An individual record in our table can be assoicated with many records in
        - another table. 
        - We can create this type of relationship with a Primary Key(PK), and unique Foreign Key. 

<br>

- **M : M (Many to Many)**
    - An employee may be assigned to a number of projects, but he or she can also be assigned to no projects. 
    - A project must have at least one employee assigned to it
    - but it may have many employees assigned to it. 
        - Records in both tables can be assicated with multiple
        - records in another table
        - This is best represented by what we call a join table. 
            - This is a table that holds our keys
            - The 'entity' that a join table holds is the relationship itself
        

<br>

- **1 : 1 (One to One)**
    - Each employee is allotted either one vehicle or no vehicles. Each vehicle is allotted only one employee. 
        - An individual record in a table is associated with a single record in anther table. 
            - We create this type of relationship using a PK and a Unique FK.
			

<br>

- **Normalization** 
    - The process of improving the design of the database tables. 

    - Each Normal Form (NF) contains a set of particular condtions that the table has to satisfy. 

    - To know which NF a table is in you have to evaluate each individual table. 

    - **1NF (1st Normal Form)**
        - states that each value in each column of a table is divided into single, meaningful units. This is also known a being atomic. 
        - i.e. all records have a primary key and, though that can be a composite key which uses multiple values to create a single larger unique key, each individual column holds the smallest meaningful amount of information

        - By definition every relational table is automatically in 1NF
        ```
        CREATE TABLE VET_CLINIC_CLIENT1NF(
            ClientID INT,
            ClientName VARCHAR(25),
            PetName VARCHAR(25) NOT NULL,
            PetBreed VARCHAR(25) NOT NULL,
            PetSpecies VARCHAR(25) NOT NULL,
            PRIMARY KEY(ClientID, PetName)
        );
        
        INSERT INTO VET_CLINIC_CLIENT1NF VALUES 
        (111, 'Revathi', 'CherryBomb', 'Chihuahua' 'Dog'),
        (222, 'Cynthia', 'Lulu', 'Tabby','Cat'),
        (222, 'Cynthia', 'Oreo', 'Shih Tzu', 'Dog'), 
        (222, 'Cynthia', 'Margarita', 'Parakeet', 'Bird'),
        (333, 'Dylan', 'Fluffy', 'Border Collie','Dog'),
        (333, 'Dylan', 'Rambo', 'Tabby', 'Cat');
            
        SELECT * FROM VET_CLINIC_CLIENT1NF;
        ```
        
        - In a composite key the whole set of elements must be unique
        - (111, 'CherryBomb'), (222, 'LuLu'), (222, 'Oreo') can exist but (111, 'CherryBomb') cannot exist again.
        
        <br>

    - **2NF (second normal form)**  
        - When a table meets the requirements of 1NF and  does not contain partial functional dependency
            - a partial dependency occurs when a portion of a composite keys functionality determines a column of a relation. 

        - This means that if a table has single PK, then there is no way for a partial dependency. 
        - Make sure that no column depends on part of a non-key column (Try to remove all composite keys) but you can have composite keys in 2NF.
        
        - Let's convert the previous table to 2NF
        ```
        CREATE TABLE VET_CLINIC_CLIENT2NF(
            ClientID INT PRIMARY KEY,
            ClientName VARCHAR(25)
        );
    
        CREATE TABLE VET_CLINIC_PET2NF(
            ClientID INT,
            PetName VARCHAR(25) NOT NULL,
            PetBreed VARCHAR(25) NOT NULL,
            PetSpecies VARCHAR(25) NOT NULL,
            PRIMARY KEY(ClientID, PetName),
            FOREIGN KEY(ClientID) REFERENCES VET_CLINIC_CLIENT(ClientID)
        );
        ```
        
        - By splitting the tables I eliminated partial dependency. 
        - This helps avoid data redundancy. 


        <br>

    - **3NF (third normal form)** 
        - When the table is 2NF and if it does not contain transitive functional dependencies.
        - In other words an indirect relationship between data. 
            - i.e my PetBreed and PetName and PetID have no real relationship
        - we can get rid of our transitive dependency by spliting our tables further. 

        - Same table, now in 3NF!
        ```
        CREATE TABLE VET_CLINIC_CLIENT3NF (
            ClientID INT PRIMARY KEY,
            ClientName VARCHAR(25)
        );
        
        CREATE TABLE VET_CLINIC_PET3NF (
            PetID INT PRIMARY KEY,
            ClientID INT,
            PetName VARCHAR(25) NOT NULL,
            PetBreed int REFERENCES PET_BREED3NF(PetBreedID),
            FOREIGN KEY(ClientID) REFERENCES VET_CLINIC_CLIENT3NF(ClientID)
        );
        
        CREATE TABLE PET_BREED3NF (
            PetBreedID INT PRIMARY KEY,
            PetBreed VARCHAR(25) NOT NULL,
            PetSpecies VARCHAR(40) REFERENCES PET_SPECIES3NF(PetSpeciesID)
        );

        CREATE TABLE PET_SPECIES3NF(
            PetSpeciesID serial,
            PetSpecies VARCHAR(40)
        )
        ```
		
		
		
	
	