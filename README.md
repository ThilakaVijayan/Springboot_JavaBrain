This is build using RESTFul API to create an end to end flow.
Java 14 is used. Swagger version - 3.0

http://localhost:8080/api/topics

http://localhost:8080/api/topics/courses

Get, Post, Put and Delete API for these urls.

Springboot creates a Jar which can run in a standalone. The top cat server is inbuilt in it.
We can also export a war if we want to deploy in an exsiting server.

IDE used is Spring Tool Suite.
Create New -> Maven Project. `course-api`. Then mention all the configuations in the dialog box.
In `pom.xml` add `parent` - `spring-boot-starter-parent`
Add 'dependency' - `spring-boot-starter-web`

Create a class with main method. Add `@SpringBootApplication` to the class.
Add this line in the main method

```java
SpringApplication.run(CourseApiApp.class, args);
```

`HelloController.java` is added to test a simple RESTFul API - which displays 'Hi'.

`Topic` and `Course` are pojo. These are the resources. 
`TopicController.java` is added. `getAllTopics()` method will return a list of Topics.

|Type | URL | Description|
|---|---|---|
|GET |/topics | Gets all topics|
|GET | /topics/{id} | Gets the topic|
|POST |/topics | Create new topic|
|PUT | /topics/{id} | Updates the topic|
|DELETE | /topics/{id} | Deletes the topic|

`TopicService.java` is a service. `@Service` annotation is added to the class.

The `topicService` is `@Autowired` in the controller.

### Ways to create a spring boot application.
1. Spring Initializr - http://start.spring.io/
2. Spring Boot CLI - Command line tool, to run Groovy scripts.
3. Spring Tool Suite IDE
4 Configuration ( we used this for this project)

`application.properties` file is used to customize the spring project.

`course-api-data` - project is same concept but will include Java Persistence API (JPA).
Include `JPA` and `Apache derby` while creating Spring boot project.
`@Entity` is added to `Topic` class.
`@Id` is added to the id field in the topic class, to mark it as a primary key.

`TopicRepository.java` in an interface which extends `CrudRepository`. Now `TopicRepository` has all the basic methods we need to query the database.

`Course.java` is marked as `@Entity`. `Topic` field is maked as `@ManyToOne`.
`CourseRepository.java` has an interface named `findByTopicId`. This format of naming, will let us filter the course by topic id. No need to write method implementation.

### How to deploy:
Go to the location of the pom.xml in the terminal/ command line.
```
mvn clean install
java jar <jarname>
```

### Swagger & Docket:
add this in the `pom.xml` in the `dependency` - `springfox-boot-starter`

http://localhost:8080/swagger-ui/index.html#/

http://localhost:8080/v2/api-docs

Various configuations are done to show it in the swagger UI.

### Logging:
Spring boot includes the logging framework.
Loggers can be configured by - both are done in this project.
- Application property values
- XML file

