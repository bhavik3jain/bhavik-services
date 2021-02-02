#!/bin/sh
./gradlew clean build
docker build --build-arg JAR_FILE=build/libs/*.jar -t bhavik-services-covid19-backend .
docker tag bhavik-services-covid19-backend bhavik3jain/bhavik-services-covid19-backend:1.4
docker push bhavik3jain/bhavik-services-covid19-backend:1.4