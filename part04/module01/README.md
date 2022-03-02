# 📝 Notes

Learn about different data stores and how to build persistence for Java applications. Work with relational and non-relational databases, and use Java to read/write and build test cases for MySQL and MongoDB.

## RDBMS & JDBC

### Relational Database
A relational database is a collection of data items with pre-defined relationships between them. These items are organized as a set of tables with columns and rows. Each row in a table can have a unique identifier called a primary key, and rows among multiple tables can be made related using foreign keys. Foreign keys are also known as referential integrity keys.

**SQL**

Structured Query Language is the primary interface used to communicate with Relational Databases.

**Transactions**

A database transaction is one or more SQL statements that are executed as a sequence of operations that form a single logical unit of work. Transactions provide an "all-or-nothing" proposition, meaning that the entire transaction must complete as a single unit and be written to the database or none of the individual components of the transaction should go through.

**Atomicity**

Atomicity requires that either transaction as a whole be successfully executed or if a part of the transaction fails, then the entire transaction be invalidated.

**Consistency**

Consistency mandates the data written to the database as part of the transaction must adhere to all defined rules and referential integrity constraints.

**Isolation**

Transactions are often executed concurrently (e.g., reading and writing to multiple tables at the same time). Isolation ensures that concurrent execution of transactions leaves the database in the same state that would have been obtained if the transactions were executed sequentially. Isolation is the main goal of concurrency control, the effects of an incomplete transaction might not even be visible to other transactions.

**Durability**

Durability requires that all of the changes made to the database be permanent once a transaction is successfully completed.

### SQL
Structured Query Language is the primary interface used to communicate with Relational Databases.

SQL is a declarative domain specific language that is specifically designed for managing data held in a relational database management system. SQL is declarative since it only describes the desired results without explicitly listing commands or steps that must be performed.

SQL statements can be broadly classified into

- DDL
- DML

**DDL**

Data Description Language is used for defining database schemas. DDL statements create, modify, and remove database objects such as tables, indexes, and users. Common DDL statements are `CREATE`, `ALTER` and `DROP`.

**DML**

Data Manipulation Language is used for adding (inserting), deleting, and modifying (updating) data in a relational database. Common DML statements are `INSERT`, `UPDATE` and `DELETE`.

### MySQL

MySQL is an open-source relational database management system (RDBMS) commonly used by startups and enterprises alike.

#### Data types
Data types identify the type of data that a column holds. Since a relational database requires a schema to be pre-defined, the data types of a column are specified when a table is created.

Data types can be broadly classified as,
- NUMBER
- CHAR
- DATETIME

**Numeric Types**

Numeric types are the different types of numbers that a column can have. Those could be regular numbers like INTEGER, SMALLINT etc and floating point types like FLOAT and DOUBLE.

**String types (CHAR)**

MySQL supports several character types like VARCHAR, CHAR, TEXT, TINYTEXT etc. These types differ in the amount of characters they can hold and how they behave when a string with more characters is set on the column. An extensive discussion of string types can be found in MySQL documentation.

**Datetime Types**

These are types for representing temporal values, like DATE, TIME, DATETIME and TIMESTAMP. In MySQL, an invalid date time value can be specified using ‘0’.

In general, when learning any new database, it is best to consult the official documentation to understand the supported data types and their limitations.

#### Tables

A table is a collection of related data held in a table format within a database. It consists of columns, and rows.
In relational databases, a table is a set of data elements (values)using a model of vertical columns (identifiable by name) and horizontal rows. A cell is formed by the intersection of a row and column. A table in a relational database has a specified number of columns, but can have any number of rows. Each row is identified by one or more values appearing in a particular column subset. A specific choice of columns which uniquely identify rows is called the primary key.

The _AUTO_INCREMENT_ attribute can be used to generate a unique identity for new rows.

```sql
CREATE TABLE animals (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     name CHAR(30) NOT NULL,
     PRIMARY KEY (id)
);

INSERT INTO animals (name) VALUES
    ('dog'),('cat'),('penguin'),
    ('lax'),('whale'),('ostrich');

SELECT * FROM animals;
```
#### Rows

**SELECT**

The SELECT statement reads rows from a table.

```sql 
SELECT column-names FROM table-name
```

To select all columns, substitute column-names with *, like this

```sql
SELECT * FROM table-name
```

**SELECT with WHERE**

WHERE is used to limit the number of rows.
The WHERE clause filters for rows that meet certain criteria.
WHERE is followed by a condition that returns either true or false.

```sql
SELECT column-names FROM table-name WHERE condition
```

**ORDER BY**

SELECT returns records in no particular order, use ORDER BY to ensure a specific order.
ORDER BY allows sorting by one or more columns.
Rows can be returned in ascending or descending order.

```sql
SELECT column-names FROM table-name WHERE condition ORDER BY column-names
```

**JOIN**

A SQL JOIN combines records from two tables. A query can contain zero, one, or more JOIN operations.

**Different types of JOINs**

(INNER) JOIN: Select records that have matching values in both tables.

LEFT (OUTER) JOIN: Select records from the first (left-most) table with matching right table records.

RIGHT (OUTER) JOIN: Select records from the second (right-most) table with matching left table records.

FULL (OUTER) JOIN: Selects all records that match either left or right table records.

- INNER JOIN

    ```sql
    SELECT column-names FROM table-name1 INNER JOIN table-name2 ON column-name1 = column-name2 WHERE condition
    ```
    The INNER keyword is optional.

- _LEFT JOIN_

    LEFT JOIN performs a join starting with the first (left-most) table and then any matching second (right-most) table records.

    ```sql
    SELECT column-names FROM table-name1 LEFT JOIN table-name2 ON column-name1 = column-name2 WHERE condition
    ```
    
- _RIGHT JOIN_

    RIGHT JOIN performs a join starting with the second (right-most) table and then any matching first (left-most) table records.

    ```sql
    SELECT column-names FROM table-name1 RIGHT JOIN table-name2 ON column-name1 = column-name2 WHERE condition
    ```

- _FULL JOIN_

    FULL JOIN returns all matching records from both tables whether the other table matches or not. It can potentially return very large datasets.

    ```sql
    SELECT column-names FROM table-name1 FULL JOIN table-name2 ON column-name1 = column-name2 WHERE condition
    ```

### JDBC (Java Database Connectivity)

JDBC API provides 3 different interfaces to execute the different types of SQL queries. They are,

- Statement – Used to execute normal SQL queries.
- PreparedStatement – Used to execute parameterized SQL queries.
- CallableStatement – Used to execute stored procedures.

#### Statement
Statement is used to send non parameterized SQL statements to the database. Statement interface is preferred for executing DDL statements, since they are typically executed only once. This does not mean one should not use Statement for other SQL queries. If the statement is executed only once or very sparingly during the lifetime of an application, Statement is a good choice.

Here’s an example

```java
//Statement is created from the JDBC Connection object 
Statement stmt = con.createStatement();

//A sample DDL statement execution 
stmt.executeUpdate("CREATE TABLE EMPLOYEE (EMP_ID  NUMBER NOT NULL, EMP_NAME VARCHAR)");
```

#### PreparedStatement
PreparedStatement can be used to send parameterized SQL statements to the database, although parameters are not mandatory. Since a PreparedStatement is a pre-compiled by the database, it saves the database from regenerating the query plan for each execution of the PreparedStatement. PreparedStatement is the most common and preferred way of executing SQL statements in JDBC. Statement is typically frowned upon. PreparedStatement is used to execute dynamic or parameterized SQL queries. PreparedStatement extends Statement interface. You can pass the parameters to SQL query at run time using this interface. It is recommended to use PreparedStatement if you are executing a particular SQL query multiple times.

```java
// Use the prepareStatement method to create a PreparedStatement 
PreparedStatement pstmt = con.prepareStatement("update EMPLOYEE set EMP_NAME = ? where EMP_ID = ?");

//Setting values to place holders using setter methods of PreparedStatement object
pstmt.setString(1, "JaneDoe");   //Assigns "JaneDoe" to first place holder
pstmt.setInt(2, 111);     //Assigns "111" to second place holder

//Execute PreparedStatement
pstmt.executeUpdate();
```

Instead of indexed placeholders, named placeholders or more commonly **named parameters** can be used. Here’s an example,

```java
// Use the prepareStatement method to create a PreparedStatement
PreparedStatement pstmt = con.prepareStatement("update EMPLOYEE set EMP_NAME = :name where EMP_ID = :id");

//Setting values to place holders using setter methods of PreparedStatement object
pstmt.setString(“name”, "JaneDoe");   //Assigns "JaneDoe" to the name parameter
pstmt.setInt(“id”, 111);     //Assigns "111" to the id parameter

//Execute PreparedStatement
pstmt.executeUpdate();
```

#### CallableStatement

CallableStatement is used to execute stored procedures. A stored procedure is a group of one or more SQL statements stored in the database as a procedure or function. In SQL, stored procedures are invoked using the `CALL` statement, hence the name CallableStatement.

## Java Persistence API (JPA)

#### JPA Entities

Entities
An entity is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table. The primary programming artifact of an entity is the entity class, although entities can use helper classes.

The persistent state of an entity is represented through either persistent fields or persistent properties. These fields or properties use object/relational mapping annotations to map the entities and entity relationships to the relational data in the underlying data store.

#### Requirements for Entity Classes

An entity class must follow these requirements.

The class must be annotated with the javax.persistence.Entity annotation.

The class must have a public or protected, no-argument constructor. The class may have other constructors.

The class must not be declared final. No methods or persistent instance variables must be declared final.

Entities may extend both entity and non-entity classes, and non-entity classes may extend entity classes.

Persistent instance variables must be declared private, protected, or package-private and can be accessed directly only by the entity class’s methods. Clients must access the entity’s state through accessor or business methods.

#### Persistent Fields

If the entity class uses persistent fields, the Persistence runtime accesses entity-class instance variables directly. All fields not annotated javax.persistence.Transient or not marked as Java transient will be persisted to the data store. The object/relational mapping annotations must be applied to the instance variables.

#### Primary Keys in Entities

Each entity has a unique object identifier. A customer entity, for example, might be identified by a customer number. The unique identifier, or primary key, enables clients to locate a particular entity instance. Every entity must have a primary key. An entity may have either a simple or a composite primary key.
Simple primary keys use the javax.persistence.Id annotation to denote the primary key property or field.

The primary key, or the property or field of a composite primary key, must be one of the following Java language types:
Java primitive types
Java primitive wrapper types
java.lang.String
java.util.Date
java.sql.Date
java.math.BigDecimal
java.math.BigInteger

Floating-point types should never be used in primary keys.

#### Generated Identifiers

Primary key values can be automatically generated using the `@GeneratedValue` annotation.

It supports four generation strategies,
- AUTO
- IDENTITY
- SEQUENCE
- TABLE

If a value is not specified for the strategy field of the annotation, the default is AUTO.

## NoSQL and MongoDB

Relational databases use structured query language (SQL) for defining and manipulating data. On one hand, this is extremely powerful: SQL is one of the most versatile and widely-used options available, making it a safe choice and especially great for complex queries. On the other hand, it can be restrictive. SQL requires that you use predefined schemas to determine the structure of your data before you work with it. In addition, all of your data must follow the same structure. This can require significant up-front preparation and it can mean that a change in the structure would be both difficult and disruptive to your whole system.

A NoSQL database, is self-describing and has a dynamic schema for unstructured data, and data is stored in many ways: it can be column-oriented, document-oriented, graph-based or organized as a key-value store.

This flexibility means,
You can create documents without having to first define their structure
Each document can have its own unique structure
The syntax can vary from database to database, and
You can add fields as you go.


SQL Terms/Concepts| MongoDB Terms/Concepts
-----|------
database | database
tables | collections
rows | documents (BSON)
columns | fields

### MongoDB

In MongoDB, data is organized into documents. Documents are a collection of key and value pairs. The values can be scalar types like numbers, dates and strings. The values can also be arrays, other documents or arrays of documents.

Documents are organized into collections. A set of collections is organized into a database.

#### Documents

A record in MongoDB is a document, which is a data structure composed of field and value pairs. MongoDB documents are similar to JSON objects. The values of fields may include other documents, arrays, and arrays of documents.

The advantages of using documents are:

Documents (i.e. objects) correspond to native data types in many programming languages.
Embedded documents and arrays reduce need for expensive joins.

Additional Resources:
- [MongoDB](https://www.mongodb.com/what-is-mongodb)
- [JSON Spec](https://www.json.org/)
- [BSON](https://docs.mongodb.com/manual/reference/glossary/#term-bson)

#### Mongo Shell (mongosh)

To access mongo shell use the command:

```bash
# mongosh -u(user) name
mongosh -u root
```

To create user on mongodb:

```sh
db.createUser({"user": "course3", "pwd": "course3", "roles": ["readWrite", "dbAdmin"]});
```

To create database and use:

```sh
use 'name-database';
```

Document structure: 

```json
{
    "_id": “cjenkins”,
    "first_name": "Carl",
    "last_name": "Jenkins",
    "gender": "male",
    "age": 23,
    "address": {
        "street": "123 Main Street",
        "city": "Oakland",
        "state": "CA"
    },
    "interests": ["pilates","swim","crossfit"],
    "balance": 125.20
}
```

#### CRUD Operations
> [Docs](https://docs.mongodb.com/mongodb-shell/crud/)

In MongoDB have method with final name One (only one) or 'Many'.

- **Create**

    The MongoDB shell provides the following methods to insert documents into a collection:

    - To insert a single document, use `db.collection.insertOne()`.
    - To insert multiple documents, use `db.collection.insertMany()`.
    
    Insert a single (one) document:

    ```json
    use sample_mflix
    db.movies.insertOne(
    {
        title: "The Favourite",
        genres: [ "Drama", "History" ],
        runtime: 121,
        rated: "R",
        year: 2018,
        directors: [ "Yorgos Lanthimos" ],
        cast: [ "Olivia Colman", "Emma Stone", "Rachel Weisz" ],
        type: "movie"
    }
    )
    ```

    Insert a multiple (many) document: 

    ```json
    use sample_mflix
    db.movies.insertMany([
    {
        title: "Jurassic World: Fallen Kingdom",
        genres: [ "Action", "Sci-Fi" ],
        runtime: 130,
        rated: "PG-13",
        year: 2018,
        directors: [ "J. A. Bayona" ],
        cast: [ "Chris Pratt", "Bryce Dallas Howard", "Rafe Spall" ],
        type: "movie"
        },
        {
        title: "Tag",
        genres: [ "Comedy", "Action" ],
        runtime: 105,
        rated: "R",
        year: 2018,
        directors: [ "Jeff Tomsic" ],
        cast: [ "Annabelle Wallis", "Jeremy Renner", "Jon Hamm" ],
        type: "movie"
        }
    ])
    ```

- **Read**

    Use the `db.collection.find()` method in the MongoDB Shell to query documents in a collection.

    Read all document in a collection:

    ```sh
    use sample_mflix
    db.movies.find()
    ```

    This operation equivalent to the following SQL statment:

    ```sql
    SELECT * FROM movies;
    ```

    Specify Equality Condition

    ```sh
    use sample_mflix
    db.movies.find( { "title": "Titanic" } )
    ```
    This operation equivalent to the following SQL statment:

    ```sql
    SELECT * FROM movies WHERE title = "Titanic";
    ```

- **Update**

    The MongoDB shell provides the following methods to update documents in a collection:

    - To update a single document, use `db.collection.updateOne()`.
    - To update multiple documents, use `db.collection.updateMany()`.
    - To replace a document, use `db.collection.replaceOne()`.

    Update a Single Document

    ```sh
    use sample_mflix
    db.movies.updateOne( { title: "Tag" },
    {
        $set: {
            plot: "One month every year, five highly competitive friends
                hit the ground running for a no-holds-barred game of tag"
        }
        { $currentDate: { lastUpdated: true } }
    })
    ```
    The update operation:

    - Uses the `$set` operator to update the value of the _plot_ field for the movie _Tag_.
    - Uses the `$currentDate operator` to update the value of the _lastUpdated_ field to the current date. If _lastUpdated_ field does not exist, `$currentDate` will create the field. See `$currentDate` for details.

    Update Multiple Documents

    ```sh
    use sample_airbnb
    db.listingsAndReviews.updateMany(
        { security_deposit: { $lt: 100 } },
        {
            $set: { security_deposit: 100, minimum_nights: 1 }
        }
    )
    ```
    The update operation uses the `$set` operator to update the value of the `security_deposit` field to `100` and the value of the `minimum_nights` field to `1`.

    Replace a Document

    ```sh
    db.accounts.replaceOne(
        { account_id: 371138 },
        { account_id: 893421, limit: 5000, products: [ "Investment", "Brokerage" ] }
    )
    ```
    Run the following command to read your updated document:
    ```sql
    db.accounts.findOne( { account_id: 893421 } )
    ```

- **Delete**

    The MongoDB shell provides the following methods to delete documents from a collection:

    - To delete multiple documents, use `db.collection.deleteMany()`.
    - To delete a single document, use `db.collection.deleteOne()`.

    Delete All Documents: to delete all documents from a collection, pass an empty filter document {} to the `db.collection.deleteMany()` method.

    ```sh
    use sample_mflix
    db.movies.deleteMany({})
    ```

    Delete All Documents that Math a Condition: To specify equality conditions, use _`<field>:<value>`_ expressions in the query filter document.

    ```sh
    use sample_mflix
    db.movies.deleteMany( { title: "Titanic" } )
    ```

    Delete Only One Document that Matches a Condition

    ```sh
    use sample_mflix
    db.movies.deleteOne( { cast: "Brad Pitt" } )
    ```

#### Data Modeling

##### Patterns 

- **One-to-One with Embedded documents**

    Consider the following example that maps patient and address relationships. The example illustrates the advantage of embedding over referencing if you need to view one data entity in the context of the other. In this one-to-one relationship between patient and address data, the address belongs to the patient.
    In the normalized data model, the address document contains a reference to the patron document.

    ```json
    {
        _id: "lakshmi",
        name: "Lakshmi Natarajan"
    }

    {
        patient_id: "lakshmi",
        street: "149 Main St",
        city: "Birmingham",
        state: "AL"
    }
    ```

    If the address data is frequently retrieved with the patient information, then with referencing, your application needs to issue multiple queries to resolve the reference. The better data model would be to embed the address data in the patient data, like this,

    ```json
    {
        _id: "lakshmi",
        name: "Lakshmi Natarajan",
        address: {
                    street: "149 Main St",
                    city: "Birmingham",
                    state: "AL"
                }
    }
    ```

    With the embedded data model, your application can retrieve the complete patient information with one query.

- **One-to-Many with Embedded documents**

    Consider the following example that maps patient and multiple addresses. The example illustrates the advantage of embedding over referencing if you need to view many data entities in the context of another. In this one-to-many relationship between patient and address data, the patient has multiple address entities.

    In the normalized data model, the address documents contain a reference to the patient document.

    ```json
    {
        _id: "lakshmi",
        name: "Lakshmi Natarajan"
    }

    {
        patient_id: "lakshmi",
        street: "149 Main St",
        city: "Birmingham",
        state: "AL"
    }

    {
        patient_id: "lakshmi",
        street: "298 Second St",
        city: "Birmingham",
        state: "AL"
    }
    ```

    If your application frequently retrieves the address data with the patient information, then your application needs to issue as many queries as the number of linked addresses to resolve the references. A more optimal schema would be to embed the address data entities in the patient data, like this:

    ```json
    {
        _id: "lakshmi",
        name: "Lakshmi Natarajan"
        addresses: [{
            street: "149 Main St",
            city: "Birmingham",
            state: "AL"
        },
        {
            street: "298 Second St",
            city: "Birmingham",
            state: "AL"
        }]
    }
    ```

- **One-to-Many with Document references**

    Consider this example that maps movie and artist relationships. The example illustrates the advantage of referencing over embedding to avoid repetition of the artist information.

    Embedding the artist document inside the movie document would lead to repetition of the artist data, as the following documents show,

    ```json
    {
        "_id": "12345"
        "title": "Seven"
        "cast": [{
            "name": "Brad Pitt",
            "gender": "male",
            "age": 51
        },
        {
            "name": "Morgan Freeman",
            "gender": "male",
            "age": 70
        },
        {
            "name": "Gwyneth Paltrow",
            "gender": "female",
            "age": 46
        }]
    }

    {
        "_id": "12346"
        "title": "Fight Club"
        "cast": [{
            "name": "Brad Pitt",
            "gender": "male",
            "age": 51
        }]
    }
    ```

    Artist information is repeated across multiple movie documents. This leads to repetition of data and also makes it harder to update the details of the artist document. In order to update the age field of an actor, all the movie documents containing the artist document need to be updated.

    To avoid repetition of the artist data, use references and keep the artist information in a separate collection from the movie collection.

    > Artist Collection

    ```json
    {
        "_id": "abc123",
        "name": "Brad Pitt",
        "gender": "male",
        "age": 51
    }

    {
        "_id": "abc124",
        "name": "Morgan Freeman",
        "gender": "male",
        "age": 70
    }

    {
        "_id": "abc125",
        "name": "Gwyneth Paltrow",
        "gender": "female",
        "age": 46
    }
    ```

    > Movie Collection

    ```json
    {
        "_id": "12345"
        "title": "Seven"
        "cast": ["abc123", "abc124", "abc125"]
    }
    {
        "_id": "12346"
        "title": "Fight Club"
        "cast": ["abc123"]
    }
    ```

    When using references, the growth of the relationships determine where to store the reference. The number of artists in a movie doesn’t grow but an artist can keep acting in more movies. So in this case, storing the reference in the movie makes sense.