import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        ApiService apiService = new ApiService();
        String response = apiService.getResponse(args[0]);

        if(response == null)
        {
            return;
        }

        ArrayList<String> events = apiService.parseResponse(response);
       for(String str: events)
       {
           System.out.println(str);
       }
    }

}