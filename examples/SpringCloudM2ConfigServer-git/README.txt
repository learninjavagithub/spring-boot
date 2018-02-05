http://localhost:8888/abc/master - picks from application.properties
or
http://localhost:8888/abc/default - picks from application.properties

http://localhost:8888/price/master
or
http://localhost:8888/price/default - picks from: 
price1/price.properties,
price2/price.properties,
application.properties

http://localhost:8888/price/dev - picks from:
price1/price-dev.properties,
price1/price.properties,
price2/price.properties,
application.properties

http://localhost:8888/price/uat - picks from: because there is no matching profile by name UAT so returned all default profiles
price1/price.properties,
price2/price.properties,
application.properties 

For different formats:
http://localhost:8888/price-default.properties
http://localhost:8888/price-dev.properties
http://localhost:8888/price-dev.json
http://localhost:8888/price-dev.yml - Not working


Security:
After adding spring-boot-starter-security, it adds HTTP basic auth with a default password shown
when server is started 

1. When security is enabled and accessed using POSTMAN or browser with the below URL, 
http://localhost:8888/price/default
You will see a login page asking to enter username and password

2. security:
  basic:
    enabled
    is deprecated so cannot disable using configuration. 
    Need to add a bean WebSecurityConfigurer - See example file
  
3.  Accessing 
http://localhost:8888/price/default

via postman shows the login page as html:
Add "Basic Auth"
enter the username : user
password : <password displayed in the server while startup>

Same for Browser, it redirect to http://localhost:8888/login

4. Client - See README.txt in client application



Encryption:

1. Download, Backup existing and copy the JCE jars to:
C:\Program Files\Java\jdk1.8.0_162\jre\lib\security\policy\unlimited

2. Postman ->
url : http://localhost:8888/encrypt
Add basic auth and enter username as user and password as pwd from server log
Use POST method
Add some string into body:
connectionstring=server123;user=root;password=passwd;

The response is an encrypted string. This can be decrypted similarly on another tab
using:
http://localhost:8888/decrypt

3. Add a variable as constring=(cipher)<encypted-value-from-step-2>
in application.properties and check-in to git

4. In Postman, navigate to
localhost:8888/price/default
Should see the newly added 

For Client, see client apps README,txt











IMP:
@SpringBootApplication is a convenience annotation that adds all of the following:

@Configuration tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.

@ComponentScan tells Spring to look for other components, configurations, and services in the hello package, allowing it to find the controllers.
    