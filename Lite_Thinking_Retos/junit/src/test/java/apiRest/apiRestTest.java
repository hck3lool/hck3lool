package apiRest;

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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.JsonSchemaValidator;

public class apiRestTest {

    HttpClient clientHttp;

    @BeforeEach
    public void setup(){
        System.out.println("------------------------------------------------");
        System.out.println("Inicio de la Prueba REST API");
        System.out.println("------------------------------------------------");
        clientHttp = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    }

    @Test
    public void consultarUsuarios() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("reqres.in")
            .setPath("/api/users")
            .addParameter("page", "2");

        System.out.println("Endpoint: " + uri.build());

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri.build())
            .build();

        HttpResponse<String> response = clientHttp.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.body());

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertTrue(response.body().contains("\"total\":12"));

        String validationSchema =  JsonSchemaValidator.validateJsonAgainstSchema(response.body(), "ConsultarUsuariosSchema.json");

        System.out.println("Resultado de la validacion del Schema: " + validationSchema);

        assertEquals("", validationSchema, "Resultado de la validacion del schema");
    }

    @Test
    public void consultarDatos() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("reqres.in")
            .setPath("api/users")
            .addParameter("page", "2")
            .addParameter("id", "12");

        System.out.println("Endpoint: " + uri.build());

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri.build())
            .build();

        HttpResponse<String> response = clientHttp.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.body());

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertTrue(response.body().contains("\"first_name\":\"Rachel\""));

        String validationSchema =  JsonSchemaValidator.validateJsonAgainstSchema(response.body(), "ConsultarDatosSchema.json");

        System.out.println("Resultado de la validacion del Schema: " + validationSchema);

        assertEquals("", validationSchema, "Resultado de la validacion del schema");
    }

    @Test
    public void consultarUsuarioInexistente() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("reqres.in")
            .setPath("api/users")
            .addParameter("id", "0");

        System.out.println("Endpoint: " + uri.build());

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri.build())
            .build();

        HttpResponse<String> response = clientHttp.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.body());

        assertEquals(HttpStatus.SC_NOT_FOUND, response.statusCode());
        assertTrue(response.body().contains(""));

        String validationSchema =  JsonSchemaValidator.validateJsonAgainstSchema(response.body(), "ConsultarUsuarioInexistenteSchema.json");

        System.out.println("Resultado de la validacion del Schema: " + validationSchema);

        assertEquals("", validationSchema, "Resultado de la validacion del schema");
    }

    @Test
    public void consultarApiUnknow() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("reqres.in")
            .setPath("api/unknow");

        System.out.println("Endpoint: " + uri.build());

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri.build())
            .build();

        HttpResponse<String> response = clientHttp.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.body());

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertTrue(response.body().contains("\"name\":\"blue turquoise\""));

        String validationSchema =  JsonSchemaValidator.validateJsonAgainstSchema(response.body(), "ConsultarApiUnknowSchema.json");

        System.out.println("Resultado de la validacion del Schema: " + validationSchema);

        assertEquals("", validationSchema, "Resultado de la validacion del schema");
    }

    @Test
    public void delayedResponse() throws URISyntaxException, IOException, InterruptedException{

        URIBuilder uri = new URIBuilder()
            .setScheme("https")
            .setHost("reqres.in")
            .setPath("/api/users")
            .addParameter("delay", "3");

        System.out.println("Endpoint: " + uri.build());

        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(uri.build())
            .build();

        HttpResponse<String> response = clientHttp.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.body());

        assertEquals(HttpStatus.SC_OK, response.statusCode());
        assertTrue(response.body().contains("\"avatar\":\"https://reqres.in/img/faces/3-image.jpg\""));

        String validationSchema =  JsonSchemaValidator.validateJsonAgainstSchema(response.body(), "delayedResponseSchema.json");

        System.out.println("Resultado de la validacion del Schema: " + validationSchema);

        assertEquals("", validationSchema, "Resultado de la validacion del schema");
    }

    @AfterEach
    public void teardown(){
        System.out.println("------------------------------------------------");
        System.out.println("Fin de la Prueba REST API");
        System.out.println("------------------------------------------------\n");
    }
}
