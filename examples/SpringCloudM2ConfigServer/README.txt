If you are getting this exception when starting the Config Server: 

NoClassDefFoundError: org/eclipse/jgit/api/TransportConfigCallback


This means the jgit version is not compatible with the spring boot version. Look for the latest 
version in the maven repo and add it to POM. Update the Maven dependencies and run the application again

Infact you will see similar error with different class names whenever you see
 
Failed to introspect Class in the exception.
This is the indication

From command line:
mvn spring-boot:run
or
mvn clean install -DskipTests=true
cd target
java -jar <jar-file-name>.jar

access using browser/postman:
localhost:8888/app1/default
localhost:8888/app2/default
localhost:8888/app3/default

