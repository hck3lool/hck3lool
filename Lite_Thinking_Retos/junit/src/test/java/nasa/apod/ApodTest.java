package nasa.apod;

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

import utils.JsonSchemaValidator;

public class ApodTest {

    HttpClient clientHttp;

    @BeforeEach
    public void setup(){
        System.out.println("Inicio de la Configuracion de la Prueba REST API");
        clientHttp = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    }

    @Test
    public void pictureOfDay() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("api.nasa.gov")
            .setPath("planetary/apod")
            .addParameter("api_key", "7zmkWLzoIo4pCeApBazRH0gmrtu79131G0yNDtDO")
            .addParameter("date", "2023-05-27");

        System.out.println("Endpoint: " + uri.build());

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri.build())
            .build();

        HttpResponse<String> response = clientHttp.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.body());

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertTrue(response.body().contains("\"title\":\"Crescent Neptune and Triton\""));

        String validationSchema =  JsonSchemaValidator.validateJsonAgainstSchema(response.body(), "ApodSchema.json");

        System.out.println("Resultado de la validacion del Schema: " + validationSchema);

        assertEquals("", validationSchema, "Resultado de la validacion del schema");
    }
}
