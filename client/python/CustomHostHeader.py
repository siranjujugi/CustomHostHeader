import requests

def main():
    # Define the URL of the sample REST service
    url = "http://localhost:3000/"

    # Define the custom value for the "Host" header
    custom_host = "custom.python.com"

    # Define the custom headers
    headers = {"Host": custom_host}

    try:
        # Make the HTTP GET request with custom headers
        response = requests.get(url, headers=headers)

        # Get the response code
        status_code = response.status_code
        print("Response Code:", status_code)

        # Get the response body
        response_body = response.text
        print("Response Body:")
        print(response_body)

    except requests.exceptions.RequestException as e:
        # Handle request exceptions
        print("Error:", e)

if __name__ == "__main__":
    main()
