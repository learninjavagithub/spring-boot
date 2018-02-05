Build a client CLI app to use the access token from our custom server:
1. Create a project with Cloud Security and Cloud OAuth2
2. implements CommandLineRunne in Main class of CLI
3. Implement the run method and give all the details that we gave in the postman
additional details are setClientAuthenticationScheme and setScope
4. Run the CLI app and see that the access token is being retrieved from our custom authz server
and the price data is retrieved and shown with no redirects happening
This kind of grant is used exactly in such situations where redirects are not possible because its a client application