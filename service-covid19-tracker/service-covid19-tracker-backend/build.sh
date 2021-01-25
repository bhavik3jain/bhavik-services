#!/bin/sh
./gradlew clean build
docker build --build-arg JAR_FILE=build/libs/*.jar -t bhavik-services-covid19-backend .
docker tag bhavik-services-covid19-backend docker-registry:5000/bhavik-services-covid19-backend
docker push docker-registry:5000/bhavik-services-covid19-backend