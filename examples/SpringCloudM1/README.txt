Navigate to below in postman:
localhost:8080/greeting


The port number is specified in application.properties

STS plugins are not compatible with JAVA 9. So use latest spring version while creating a project

To add a REST service,
1. Create a class and add @RestController annotation
2. Add a method and add @RequestMapping with "value" and "method" attributes