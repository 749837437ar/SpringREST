# Spring Boot "MusicDb" Example Project

This is a sample Java / Maven / Spring Boot/JPA/H2 application that can be used as a starter for creating a MusicDb application.

## How to Run 

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar -Dspring.profiles.active=test target/smusicdb-0.0.1-SNAPSHOT.war
or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```
* Check the stdout or boot_example.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2017-08-29 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8091 (http)
2017-08-29 17:31:23.097  INFO 19387 --- [           main] com.khoubyari.example.Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```

## About the Service

The service is just a simple MusicDb  REST service. It uses an in-memory database (H2) to store the data. You can also do with a relational database like MySQL or PostgreSQL. 

 
Here is what this little application demonstrates: 

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single war with embedded container (tomcat 8): No need to install a container separately on the host just run using the ``java -jar`` command
* Writing a RESTful service using annotation: supports both XML and JSON request / response; simply use desired ``Accept`` header in your request
* Exception mapping from application exceptions to the right HTTP response with exception details in the body
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations. 
* Automatic CRUD functionality against the data source using Spring *Repository* pattern
* Demonstrates MockMVC test framework with associated libraries
* All APIs are "self-documented" by Swagger2 using annotations 

Here are some endpoints you can call:

### Get information all songs with respect to album whos id maches with artst id.

```
http://localhost:8091/artist/1

{
    "id": 1,	
    "name": "Muse",
    "albumList": [
        {
            "id": 1,
            "artistId": 1,
            "name": "Drones",
            "relesed": 2015,
            "songSet": [
                {
                    "id": 8,
                    "albumId": 1,
                    "songName": "Defector",
                    "track": 8
                },
                {
                    "id": 9,
                    "albumId": 1,
                    "songName": "Revolt",
                    "track": 9
                },
                {
                    "id": 12,
                    "albumId": 1,
                    "songName": "Drones",
                    "track": 12
                },
                {
                    "id": 5,
                    "albumId": 1,
                    "songName": "Reapers",
                    "track": 5
                },
                {
                    "id": 7,
                    "albumId": 1,
                    "songName": "JFK",
                    "track": 7
                },
                {
                    "id": 10,
                    "albumId": 1,
                    "songName": "Aftermath",
                    "track": 10
                },
                {
                    "id": 1,
                    "albumId": 1,
                    "songName": "Dead Inside",
                    "track": 1
                },
                {
                    "id": 11,
                    "albumId": 1,
                    "songName": "The Globalist",
                    "track": 11
                },
                {
                    "id": 6,
                    "albumId": 1,
                    "songName": "The Handler",
                    "track": 6
                },
                {
                    "id": 2,
                    "albumId": 1,
                    "songName": "Drill Sargeant",
                    "track": 2
                },
                {
                    "id": 3,
                    "albumId": 1,
                    "songName": "Psycho",
                    "track": 3
                },
                {
                    "id": 4,
                    "albumId": 1,
                    "songName": "Mercy",
                    "track": 4
                }
            ]
        },
        {
            "id": 2,
            "artistId": 1,
            "name": "Origin of Symmetry",
            "relesed": 2001,
            "songSet": []
        }
    ]
}

### Create a MusicDb resource

```
POST /artist
Accept: application/json
Content-Type: application/json

http://localhost:8091/artist

{
         "id": 5,
    	"name": "Rom"
    }
	


RESPONSE: HTTP 204 (No Content)
```
### To view Swagger 2 API docs

Run the server and browse to localhost:8091/swagger-ui.html



