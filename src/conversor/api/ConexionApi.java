package conversor.api;

import conversor.model.ConversionResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {

    //Aca debe colocar la apiKey proporcionada por exchangerate
    private final String apiKey = "API_KEY";
    private final HttpClient client = HttpClient.newHttpClient();

    public ConversionResponse convertirMoneda(String base, String destino, double cantidad) {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                base + "/" + destino + "/" + cantidad;

        return hacerPeticion(url);
    }

    public ConversionResponse obtenerTasa(String base, String destino) {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                base + "/" + destino;

        return hacerPeticion(url);
    }

    private ConversionResponse hacerPeticion(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ConversionResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consultar la API: " + e.getMessage());
        }
    }
}