ARG JDK_IMAGE="openjdk:17"

FROM ${JDK_IMAGE}

WORKDIR /gateway_app

COPY build/libs/*.jar gateway.jar

EXPOSE 9000

ENTRYPOINT ["java","-jar","gateway.jar"]