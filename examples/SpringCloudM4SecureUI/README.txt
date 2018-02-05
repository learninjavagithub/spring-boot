This works only with spring-boot-starter-parent version 2.0.0.M7 and not with 2.0.0 SNAPSHOT

1. Disable spring-cloud-starter-oauth2 and spring-cloud-starter-security and see if localhost is accessible:
http://localhost:8080/
2. Enable spring-cloud-starter-oauth2 and spring-cloud-starter-security
and see that when localhost is accessed it asks for a username and password(enter pwd from server log)
3. Remove application.properties and create application.yml in root folder of the project
4. Access localhost, and see that the localhost is redirected to github. After Authorizing will redirect back to the localhost
5. Add WebSecurityConfigurerAdapter and override the configure method and get automatic authenticated underlying without the
redirects shown on the screen

Display OAuth2 Security Token:
1. Add clientContext variable
2. Add loadReports method to print the Token
3. Start the server and get the Token from the server logs
4. Navigate to http://localhost:8080/reports and observe the calls in Network Console

To Authorize using Token for UI :
1. Create ServiceConfig and add the contents
2. Add OAuth2RestTemplate and Price Class in ReportController
3. Add ResponseEntity line to RestController in loadReports method
4. Goto reports.html and uncomment the value display <table>
5. Access using browser : http://localhost:8080/reports
w