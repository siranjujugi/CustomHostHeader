using System;
using System.Net.Http;
using System.Threading.Tasks;

class Program
{
    static async Task Main(string[] args)
    {
        // Define the URL of the sample REST service
        string url = "http://localhost:3000/";

        // Define the custom value for the "Host" header
        string customHost = "custom.dotnet.com";

        // Create an instance of HttpClient
        using (HttpClient client = new HttpClient())
        {
            // Create an instance of HttpRequestMessage with the HTTP method and URL
            HttpRequestMessage request = new HttpRequestMessage(HttpMethod.Get, url);

            // Set the custom value for the "Host" header
            request.Headers.Host = customHost;

            // Send the request and get the response
            HttpResponseMessage response = await client.SendAsync(request);

            // Get the response code
            int statusCode = (int)response.StatusCode;
            Console.WriteLine("Response Code: " + statusCode);

            // Read the response body as a string
            string responseBody = await response.Content.ReadAsStringAsync();

            // Print the response body
            Console.WriteLine("Response Body:");
            Console.WriteLine(responseBody);
        }
    }
}
