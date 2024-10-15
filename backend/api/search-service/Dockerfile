ARG JDK_IMAGE="amazoncorretto:17.0.12"

FROM ${JDK_IMAGE}

WORKDIR /auth_service

COPY build/libs/*.jar search_service.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","search_service.jar"]

# docker push <dockerhub_username>/<image_name>:<tag>
#docker push norcodes/edunavigator-search-service:6046f6d4be5ab28cc1fbefea8e3d2b07f3f4bb5a