package arep.proxy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/proxy")
@CrossOrigin("*")
public class ProxyController {

    //"http://localhost:8081"
    //"http://localhost:8081"
    private static List<String> servers = Arrays.asList(
            System.getenv("SERVER1_URL"),
            System.getenv("SERVER2_URL")
    );

    int roundRobin = 0;

    @GetMapping
    public ResponseEntity<?> proxy(@RequestParam("value") String value) throws IOException {
        String server = servers.get(roundRobin % servers.size());
        roundRobin++;

        System.out.println("Used server:" + ((roundRobin - 1) % servers.size()));
        String output = httpConnection(String.format("%s/lucasseq?value=%s", server, value));

        //return ResponseEntity.ok(Map.of("operation", "Secuencia de Lucas","input", value,"output", output));
        String response = "{\n" +
                " \"operation\": \"Secuencia de Lucas\",\n" +
                " \"input\":  " + value + ",\n" +
                " \"output\":  \"" + output + "\"\n" +
                "}";
        return ResponseEntity.ok(response);
    }


    public static String httpConnection(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        String ans = "";
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);
            ans = response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return ans;
    }
}
