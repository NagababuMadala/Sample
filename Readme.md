Employee Management System
=========================

Prerequisites
--------------

* Java 8
* Maven 3.x
* Spring Boot 2.x.x
* Mongo DB 4.x.x
* Swagger 2.x.x

Running the Application
-----------------------

Embedded Tomcat
---------------
**Step 1**: Compile the project with jar :

    mvn clean install

**Step 2**: Run following command

	  mvn spring-boot:run

**Step 3**: Open browser and verify Swagger

      http://localhost:8080/swagger-ui.html
Lombock
-------
Use javap -c Profile.class in target path to check the fields

Hit the EndPoints
----------------
http://localhost:8080/api/employee/
