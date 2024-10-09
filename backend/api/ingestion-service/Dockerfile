ARG JDK_IMAGE="amazoncorretto:17.0.12"

FROM ${JDK_IMAGE}

WORKDIR /auth_service

COPY build/libs/*.jar auth_service.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","auth_service.jar"]