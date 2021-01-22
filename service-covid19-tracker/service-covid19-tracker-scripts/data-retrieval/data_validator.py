import requests
import json


# Get All States Data
state_metadata = requests.get("https://api.covidtracking.com/v1/states/daily.json")

data = state_metadata.json()

print(len(data))
