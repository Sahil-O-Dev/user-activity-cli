import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ApiService
{
    public String getResponse(String user)
    {
        String str = "";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/" + user + "/events"))
                .GET()
                .header("accept", "application/json")
                .build();
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            str = response.body();
        }catch (IOException | InterruptedException e)
        {
            System.out.println("Failed to receive a response: " + e.getMessage());
        }
        client.close();
        if(str.isEmpty() || str.equals("[]"))
        {
            System.out.println("Empty Request, Could Not Find Events! Try Another User");
            return null;
        }
        return str;
    }

    public ArrayList<String> parseResponse(String response)
    {
        String[] str = response.split("},\\{");
        ArrayList<String> cleanJson = new ArrayList<>();


        String mostRecentEvent = "";
        String name = "";
        String event = "";
        String login = "";
        String date = "";

        for(int i = 0; i < str.length; i++)
        {
            mostRecentEvent = str[i];
            name = parseField("name", mostRecentEvent);
            event = parseField("type", mostRecentEvent);
            login = parseField("login", mostRecentEvent);
            date = parseField("created_at", mostRecentEvent);


            switch (event)
            {
                case "PushEvent":
                {
                    cleanJson.add(login + " made a push to " + name + " at " + date);
                    break;
                }
                case "PullRequestEvent":
                {
                    cleanJson.add(login + " made a pull request from " + name + " at " + date);
                    break;
                }
                default:
                {
                    cleanJson.add(login + " made a " + event + " to/from " + name + " at " + date);
                }
            }

        }


        return cleanJson;
    }

    private String parseField(String objectName, String mostRecentEvent)
    {
        if(!mostRecentEvent.contains("\"" + objectName + "\""))
        {
            return "(Object Not Found)";
        }

        int startOfString = mostRecentEvent.indexOf("\"" + objectName + "\"") + (objectName.length() - 1) + 5;
        int endOfString = mostRecentEvent.indexOf("\"", startOfString + 1);

        return mostRecentEvent.substring(startOfString, endOfString);
    }


}
