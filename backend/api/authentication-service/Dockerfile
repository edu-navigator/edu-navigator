ARG JDK_IMAGE="openjdk:17"

FROM ${JDK_IMAGE}

WORKDIR /auth_service

COPY build/libs/*.jar auth_service.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","auth_service.jar"]