ARG JDK_IMAGE="amazoncorretto:17.0.12"

FROM ${JDK_IMAGE}

WORKDIR /ingestion_service

COPY build/libs/*.jar ingestion_service.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","ingestion_service.jar"]