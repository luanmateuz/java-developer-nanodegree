# Security and DevOps

Here are the main topics we'll explore:

- Authentication and authorization, and how to implement authentication on a Spring Boot application using a JSON Web token.
- Fundamental concepts of testing, including how to set, write, and run tests using Junit and Mockito.
- How to use logging utilities like SLF4J and Log4J to get better insights into your code and debug your applications more easily.

## Authentication and Authorization

### Whats is Authentication?

means confirming your own identity.

For example:

- In real world, Photo ID
- In the digital word, the most common is a username and password
- Other ways

Basically, authentication is all about proving that you are the person you say you are.

#### Authentication Considerations

- The data used for authentication must be protected
  - You wouldn't tell people your password
  
- The data must ve sufficiently random
  - Password length and complexity requirements

- Must not be easily forged
  - Needs to be deterministically generated
  
- The same data should be able to authenticate someone no matter the conditions.

[OWASP suggestions for authentication and authorization](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Authentication_Cheat_Sheet.md)

#### Authentication Protection

Good pratice for storing passwords:

- Hashing
- Salting
- Using a database

#### Hashing

A hash is a one-way function used to generate a string, or hash, from a given message.

_**Hashing example**_

Let's look at a simple example of hashing. Suppose that a user has the following password:
`passw0rd!`

If we directly store this text in the database, we will have a major security vulnerability.

`passw0rd!` → database
(⚠️ Bad idea! ⚠️)

So instead, we can first run the password through a one-way function that produces a jumbled up piece of text (which has no obviously discernible relationship to the original password). That jumbled up piece of text is the hash, and it might look something like this:

`passw0rd!` → hashing function → `@kdF3lkAWoLA`

So when the client interacts with the server, rather than directly sending the password, the client can instead send the hash:

`passw0rd!` → hashing function → `@kdF3lkAWoLA` → stored in database

This way, if someone gains access to the database, they will still not have access to the plain-text password.

#### Salting

We generate random, unique data called a salt for each user. Each user has a different sdalt, and this salt generally gets appended to the password transparently.

According to OWASP Guidelines, a salt is a fiexed-length cryptographically-strong random value that is added to the input of hash function to create unique hashes for every input regardless of the input not being unique.

**Salt example**

Let's consider a concrete example of what a salt might look like. First, suppose we have two users who have the same password: h3ll0. Here's what happens if we run those passwords through a hashing function:

- User 1: `h3ll0` → `hash(h3ll0)` → `qazx345y`
- User 2: `h3ll0` → `hash(h3ll0)` → `qazx345y`

As you can see, we end up with the same hashed value for both users. But if we first add a salt, the result is different:

- User 1: `h3ll0` → salt is `tyuikjg` → new password is `h3ll0tyuikjg` → hash is `juyhtrg54`
- User 2: `h3ll0` → salt is `htyhrt` → new password is `h3ll0htyhrt` → hash is `jyt5yu75s`

As you can see, even though both users have the same original password, the hashes are different after salting.

#### How to pick a good Hash Function?

- MD5 is no good
- SHA-1 also has some collision attacks shown against it
- Common password hashing functions include
- bcrypt
- scrypt
- PBKDF2

These functions are generally run thousands of times, eg. Most implementaions of bcrypt use 1024 rounds by default.

### What is Authorization?

- authorization concerns itself with permission and rights
- says what as authenticated user is allowed to access

#### RBAC

**Role-Based Access Control**, which is commonly abbreviated as **RBAC**. In **RBAC**, access is given based on a user's role—as a manager, engineer, customer service representative, etc.

Permissions can then be given (and limited) to users based on their roles. That way, each type of user only has limited access—they are able to access only the specific things they need for their particular job.

Basically, authorization is all about determinig what a user is allowed to access.

_Authentication and authorization are different, yet related. You can't grant a right to a user (i.e., authorize that user) without first knowing who that user is (i.e., by authenticating their identity)._

### JWTs

"what is JWT"

- ...is a means of representing claims to be transferred between two parties
- ...is a JSON-based open standard (RFC 7519) for creating access tokens that assert some number of claims.
- ...is a aJSON object that is defined in RFC 7519 as a safe way to represent a set of information between two parties
- ...is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object

_**JSON Web Token (JWT) is an acces token mechanism that asserts some sort of authorization claim**_

#### JSON Web Token structure

- Header
- Payload
- Signature

Typical structure is as follows:

**{header}.{payload}.{signature}**

- **Header**

  - type of the token
  - signing algorithm

    For example:

    ```json
    {
      "alg": "HS256",
      "typ": "JWT"
    }
    ```

- **Payload**

  - contains the claims

    ```json
    {
      "sub": "1234",
      "name": "Sareeta Panda",
      "admin": true
    }
    ```

- **Signature**

  - the encoded header
  - the encoded header
  - a secret the algorithm sprecified the header and sign that

    ```json
    HMACSHA256(
      base64UrlEncode(header)+"."+
      base64UrlEncode(payload),
      secret
    )
    ```

_A **JWT** can be used for Authorization and Authentication_