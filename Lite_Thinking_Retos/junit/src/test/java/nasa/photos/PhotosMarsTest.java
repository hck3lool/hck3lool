package nasa.photos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhotosMarsTest {

    HttpClient client;

    @BeforeEach
    public void setup(){
        client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    }

    @Test
    public void getPhotoMarsTest() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("api.nasa.gov")
            .setPath("mars-photos/api/v1/rovers/Curiosity/photos")
            .addParameter("api_key", "7zmkWLzoIo4pCeApBazRH0gmrtu79131G0yNDtDO")
            .addParameter("sol", "1000");

        System.out.println("Endpoint: " + uri.build());

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri.build())
            .build();

        HttpResponse<String> reponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + reponse.body());

        assertEquals(HttpStatus.SC_OK, reponse.statusCode());
        assertTrue(reponse.body().contains("\"sol\":1000"));

    }

}
