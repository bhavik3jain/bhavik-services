import requests
import json

json_fields_to_parse = [
    "date",
    "dataQualityGrade",
    "death",
    "deathConfirmed",
    "deathIncrease",
    "deathProbable",
    "fips",
    "hospitalizedCumulative",
    "hospitalizedCurrently",
    "hospitalizedIncrease",
    "inIcuCumulative",
    "inIcuCurrently",
    "negative",
    "negativeTestsAntibody",
    "negativeTestsPeopleAntibody",
    "negativeTestsViral",
    "onVentilatorCumulative",
    "onVentilatorCurrently",
    "pending",
    "positive",
    "positiveCasesViral",
    "positiveIncrease",
    "positiveTestsAntibody",
    "positiveTestsAntigen",
    "positiveTestsPeopleAntibody",
    "positiveTestsPeopleAntigen",
    "positiveTestsViral",
    "probableCases",
    "recovered",
    "state",
    "totalTestEncountersViral",
    "totalTestResults",
    "totalTestResultsIncrease",
    "totalTestsAntibody",
    "totalTestsAntigen",
    "totalTestsPeopleAntibody",
    "totalTestsPeopleAntigen",
    "totalTestsPeopleViral",
    "totalTestsViral"
]

# Get All States Metadata
state_metadata = requests.get("https://api.covidtracking.com/v1/states/info.json")

# Get All States to Process
states = []
for state in state_metadata.json():
    states.append({
        "state": state["state"],
        "name": state["name"]
    })

state_submission_json = json.dumps(states)
state_submission_json_headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
submit_covid_data_api_response = requests.post(
                                        url = "http://api.thebhavikjain.com/states",
                                        data = state_submission_json,
                                        headers = state_submission_json_headers)


# For each state, make API call to get historical data
for state in states:
    state_data_request_uri = "https://api.covidtracking.com/v1/states/{state:s}/daily.json"
    state_data_request_uri = state_data_request_uri.format(state = state["state"])
    state_data_response = requests.get(state_data_request_uri)

    state_data_response = state_data_response.json()

    state_data_submission = []

    for daily_state_data in state_data_response:
        new_row = {}
        for field in json_fields_to_parse:
            field_data = daily_state_data[field]
            if field:
                new_row[field] = field_data
        state_data_submission.append(new_row)

    data_submission_json = json.dumps(state_data_submission)
    headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}

    submit_covid_data_api_response = requests.post(
                                            url = "http://api.thebhavikjain.com/data/multi_create",
                                            data = data_submission_json,
                                            headers = headers)


# docker run -d --name covid19_data_extract covid19_data_extract
