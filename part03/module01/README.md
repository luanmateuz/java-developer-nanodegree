# 📝 Notes

Explore the differences between web services, APIs, and microservices. Develop REST and GraphQL APIs, and learn how to secure, consume, document, and test those APIs and web services.

## Web Services

A web service is a way to share data between two disparete systems. The communication typically happens between a client and a server.

- Client - the client makes a request for data.
- Server - The server responds to the client's request.

#### Communication

The means of communication between the client and server is via s standard web protocol like HTTP (or HTTPS) on the world wide web, that uses a common language like JSON or XML.

A client invokes a web service by sending an XML (or JSON) message, then waits for a corrensponding XML (or JSON) response from the server.

#### How web services work

1. The web service provides (the person who created the web service) defines a standard format for requests and also for theresponses provided.

2. The client sends a request to the web service across the network.

3. The web service recevies the request and performs an action (like query a database or perform a calculation) and sends a response back to the calling client.

#### Benefits of web services

- Reusability
- Usability

## Web Services Vs APIs Vs Microservices

- **Evolution**
	- APIs and microservies are an evolution
	- API allows for data sharing
	- APIs are more dynamic

- **Web Services**
	- Starded in early 90's
	- SOAP complexities led to REST
	- Developing Restful APIs Using Spring Boot
	- SOAP (Simple Object Access Protocol)

- **Features**
	- Lightweight and sreamlined
	- Devices with limited bandwidth
	- SOAP protocol vs REST
	- Work required to package and unpackage data

- **Microservices**
	- Similar to APIs
	- Fully contained
	- Individual component
	- Specific Business domain


A list of publicly accessible APIs: https://github.com/public-apis/public-apis/blob/master/README.md.


## REST APIs

REST stands for REpresentational State Transfer. It’s a set of guidelines application developers use to design APIs.

There are four principles that APIs follow:

1. Data and functionality in the API are considered “resources” and identified through something called the URI, or Uniform Resource Identifier. These are accessed by web links.
2. Resources are manipulated using a fixed set of operations. GET retrieves a resource. POST creates one. Use PUT to update the resource, and of course, DELETE will remove it.
3. Resources can be represented in multiple formats, such as HTML, XML, plain text, and other formats defined by a media type.
4. Communication between the client and server (i.e. endpoint) is stateless. This means the server will not remember or store any state about the client that made the call.

## Case Study

#### Intro & Maven Dependecies

The case study is a REST API that retrieves a list of locations from a database. The code can be cloned from GitLab.

- spring-boot-starter-web - This starter pack is used for web application development and automatically adds libraries like Spring MVC, REST, Tomcat, and Jackson.
- com.h2database - This starter pack is used for the H2 in-memory database.
- spring-boot-starter-data-jpa - This starter pack includes JDBC, Hibernate, Transactions API, JPA, and Aspects.

#### Annotations I

Annotation | Description
-------|-----
@Entity| This marks a Java class as an entity, which means it will be persisted to the database. Typically, an entity maps to a database table and the table contains rows that represent that given entity.
@RestController | This marks a class as a REST API. @RestController is a convenience annotation that combines @Controller and @ResponseBody.
@GetMapping | This annotation handles HTTP GET requests and acts as a shortcut for @RequestMapping (method = RequestMethod.GET).

continued

The case study is a REST API that retrieves a list of locations from a database. 

The REST API has the following components:

- Controller - LocationController.java
- Service - LocationService.java and LocationServiceImpl.java
- CRUD Repository - LocationRepository.java
- Domain Entity/Model - Location.java
- H2 Database accessible via http://localhost:8080/h2/
- Tomcat Server accessible via http://localhost:8080

For use `data.sql` on run project, this file should be within the `resources` directory and you need add this propertie

```properties
spring.jpa.defer-datasource-initialization=true
```