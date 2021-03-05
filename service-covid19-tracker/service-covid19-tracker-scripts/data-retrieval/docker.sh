#!/bin/sh
docker build -t covid19_data_extract .
docker tag covid19_data_extract bhavik3jain/covid19_data_extract:1.0
docker push bhavik3jain/covid19_data_extract:1.0
