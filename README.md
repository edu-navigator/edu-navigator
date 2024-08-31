# EduNavigator

EduNavigator is a simple school information search tool for South Africa. This project serves as a learning initiative.

## Required Applications

- PostgreSQL
- pgAdmin
- Solr
- Keycloak

These applications can be installed using Docker. There’s no need to install them locally; you only need Docker by downloading Docker Desktop.

Once Docker has been installed, run the following command:
## Setup Instructions
Run the following command to startup containers. Make sure you are on the edu-navigator directory when running this command
```bash
docker-compose up -d
```

This will start up the containers needed.

For Solr, navigate to http://localhost:8983/solr/#/.

For pgAdmin, navigate to http://localhost:5000/. The password for pgAdmin is in the Dockerfile.

