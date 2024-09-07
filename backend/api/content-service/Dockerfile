ARG DOTNET_IMAGE=mcr.microsoft.com/dotnet/sdk:8.0@sha256:35792ea4ad1db051981f62b313f1be3b46b1f45cadbaa3c288cd0d3056eefb83
ARG DOTNET_RUNTIME_IMAGE=mcr.microsoft.com/dotnet/aspnet:8.0@sha256:6c4df091e4e531bb93bdbfe7e7f0998e7ced344f54426b7e874116a3dc3233ff

FROM ${DOTNET_IMAGE} AS build-env

WORKDIR /app

COPY . ./

RUN dotnet restore

RUN dotnet publish -c Release -o out

FROM ${DOTNET_RUNTIME_IMAGE} AS runtime

WORKDIR /app
COPY --from=build-env /app/out .

EXPOSE 5017

ENTRYPOINT ["dotnet", "ContentAPI.dll"]