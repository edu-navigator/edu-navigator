# Authentication Service
 This the service responsible for authenticating users.
 
### How to start Authentication Service?
 1. You need the following environmental variables


    AUTH_SERVER_HOST=host;KEYCLOAK_REALM=<realm>;CLIENT_ID=<client-id>>;CLIENT_SECRET=<secret>

 2. Add these environment variables to the project's run configurations in IntelliJ. For instructions on how to do this, check this link https://www.baeldung.com/intellij-idea-environment-variables
 3. Run the gateway-service

 4. Run the app. The service will run at http://localhost:8083

To make requests to the service, use the API gateway.

For example, to register a user, make a POST request to:
    http://localhost:9000/api/auth/register

Note that we're using http://localhost:9000 instead of http://localhost:8083. This is because the gateway handles the request and routes it to the appropriate service.