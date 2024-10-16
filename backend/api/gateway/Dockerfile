ARG JDK_IMAGE="amazoncorretto:17.0.12"

FROM ${JDK_IMAGE}

WORKDIR /gateway_app

COPY build/libs/*.jar gateway.jar

EXPOSE 9000

ENTRYPOINT ["java","-jar","gateway.jar"]