#!/bin/sh
docker build -t bhavik-services-covid19-frontend .
docker tag bhavik-services-covid19-frontend docker-registry:5000/bhavik-services-covid19-frontend
docker push docker-registry:5000/bhavik-services-covid19-frontend
