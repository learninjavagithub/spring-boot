We are trying to create a Grant Type 2 : Password credential application

1. Open Main class and add @EnableAuthorizationServer
2. Add the properties as mentioned in application.properties
3. Access using portman : localhost:9000/services/oauth/token
	1. Add Basic auth and use client-id as username and client-secret as password
	2. Select POST request type and select Body tab and add the following properties:
		grant_type : password
		client_id  : security.oauth2.client.client-id
		username   : security.user.name
		password   : security.user.password
4. We will get the access token of type bearer and a refresh token
		
Create a n in-memory user credential store instead of hard coded username and passwords in application.properties:
1. comment the security.user.name and security.user.password and security.user.role
2. Add a new class, ServiceConfig of type @Configuration
2. Extend GlobalAuthenticationConfigurerAdapter
3. Add init method with AuthenticationManagerBuilder as param and add the in-memory credentials
3. Access using portman : localhost:9000/services/oauth/token
	Use the same steps as before except that use the user credentials from the in-memory store now
	
To user our custom authz server instead of github one:
1. Add @EnableResourceServer and @RestController to Main class
2. Add a method that takes and returns a Principal
3. Change the resource.user-info-uri in application.properties of our SecureService project
with the custom authz server uri that we build
4. Start both Authz server and SecureService and using postman : 
	1. Get Token - localhost:9000/services/oauth/token
		use access_token of any user, say peppa
	2. http://localhost:9001/services/pricedata 
		change Bearer token with the access_token from step 1

Build a client CLI app to use the access token from our custom server:
See CLI README.txt

Grant Type : Client Credentials
To Test, 
Using postmane access : localhost:9000/services/oauth/token
use grant_type : client_credentials




	
	 
 
		