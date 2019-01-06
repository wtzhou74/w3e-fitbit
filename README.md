# W3E-Fitbit
This is a simple demo application built on Spring Boot including functionalities - registration of W3E account, log in/out, authorize to fitbit account to view daily activity summary, revoke authorization and remove W3E account etc.
## Technology Stack
+ Java JDK 8
+ Spring Boot
+ Spring Framework
+ Spring Security
+ Apache Maven
+ Apache Tomcat
+ MySQL
+ OAuth2
+ JavaScript
+ JSTL
+ Fitbit SDK

## User Interfaces
+ Sign in
+ Sign up
+ Welcome, including Authorize to view daily activity summary, revoke authorization and delete W3E account, etc.
+ View Daily Activity Summary in JSON

## Prerequisite
Register an application to Fitbit (https://dev.fitbit.com/apps/new), then update application.yml

## Run
+ Running from IDE, e.g. Eclipse by importing Maven project
+ Running from command. Cd to root of project, then run "mvn package spring-boot:repackage", a jar package, e.g. fitbit-0.0.1-SNAPSHOT.jar will be generated and be placed in Target folder. Next, run "java -jar target/fitbit-0.0.1-SNAPSHOT.jar" to start the application. Then access http://localhost:8081

