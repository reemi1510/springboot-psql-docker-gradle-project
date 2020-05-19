# springboot-psql-docker-gradle-project

## Purpose
A template for building RESTful apis without the setup faff, hopefully. 

Basic functional and integration test suites are set up with Testcontainers.

Similar to my other one, bt this one uses the gradle build tool, and I've opted for yaml files in lieu of application.properties

## Prerequisites
- Java 8
- Docker

For a full list of dependencies, see build.gradle

## Running the application
`docker-compose up --build`

The template uses a PostgreSQL database which runs in Docker and automatically applies database migrations using flyway. 

### To explore the database:
`docker exec -it postgres bash`

Then:
`psql -U postgres`

Then connect to **projectdb**.

