Access using browser at:

http://localhost:8080/price

Change the profile to dev/qa/default in bootstrap.properties to use the appropriate profile 
(see the log to find which profile is being used)
spring.profiles.active=dev/qa/default

After adding spring-boot-starter-security,
The client fails to start,
Add the following to bootstrap.properties

spring.cloud.config.username=user
spring.cloud.config.password=839b208c-b3e8-4c5b-a77b-a5789809b099

Refresh:
1. Add @RefreshScope to the controller which needs to be refreshed
2. Add actuator dependency to the client
3. Change some value in price-dev.properties
4. Navigate to http://localhost:8888/price/dev in postman and see the value refreshed
5. Navigate to http://localhost:8080/price in browser which is the client, and refesh and see that it still shows the old value
6. Navigate to http://localhost:8080/refresh and do a POST request with Basic Auth details

Note : @RefreshScope works (technically) on an @Configuration class, but it might lead to surprising behaviour: e.g. 
it does not mean that all the @Beans defined in that class are themselves @RefreshScope. Specifically, anything that 
depends on those beans cannot rely on them being updated when a refresh is initiated, unless it is itself in @RefreshScope 
(in which it will be rebuilt on a refresh and its dependencies re-injected, at which point they will be re-initialized 
from the refreshed @Configuration).


