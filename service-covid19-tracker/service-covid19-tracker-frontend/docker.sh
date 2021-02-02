#!/bin/sh
docker build -t bhavik-services-covid19-frontend .
docker tag bhavik-services-covid19-frontend bhavik3jain/bhavik-services-covid19-frontend:1.8
docker push bhavik3jain/bhavik-services-covid19-frontend:1.8
