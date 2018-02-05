This is the Resource Server entity

The idea of this is to pass the token downstream

1. Add @RestController and Create PriceData Class in Main class and add the method to return the pricedata 
2. Navigate to locahost:9001/services/pricedata in postman
It fails to fetch with some error. Add Basic auth with the credentials user/<password-from-server-log>

Add Resource Server
1. Add @EnableResourceServer
2. Add Resource Server uri in application.properties
security.oauth2.resource.user-info-uri=https://api.github.com/user
3. Access localhost:9001/services/pricedata using postman and will see,
Full authentication is required to access this resource
because the we are not authorized as we are not sending any oauth2 security token

Steps to display oauth2 security token are in secureui README.txt

Authorize using Token:
1. Start SpringCludM4ServerUI and Get the Token displayed in the server console of SecureUI 
2. Go to Postman, disable Authorization - Select "No Auth" under Authorization tab
3. Add Header named "Authorization" and value = Bearer<space><Token>
4. Now you should be able to access

Add Method Access Rules:


