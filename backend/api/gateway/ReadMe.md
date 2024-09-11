# Gateway Service
This is the API gateway responsible for routing requests to the appropriate services in the system. It acts as a reverse proxy, forwarding client requests to internal microservices based on the request path.
### How to start Gateway Service?
1. You need the following environmental variables


    INGESTION_SERVICE_HOST=<<INGESTION_SERVICE_HOST>>; SEARCH_SERVICE_HOST=<<SEARCH_SERVICE_HOST>>; CONTENT_SERVICE_HOST=<<CONTENT_SERVICE_HOST>>; AUTH_SERVICE_HOST=<<AUTH_SERVICE_HOST>>; INGESTION_SERVICE_PATH=<<INGESTION_SERVICE_PATH>>; SEARCH_SERVICE_PATH=<<SEARCH_SERVICE_PATH>>; CONTENT_SERVICE_PATH=<<CONTENT_SERVICE_PATH>>; AUTH_SERVICE_PATH=<<AUTH_SERVICE_PATH>>;


2. Add these environment variables to the project's run configurations in IntelliJ. For instructions on how to do this, check this link https://www.baeldung.com/intellij-idea-environment-variables

4. Run the app. The service will run at http://localhost:9000