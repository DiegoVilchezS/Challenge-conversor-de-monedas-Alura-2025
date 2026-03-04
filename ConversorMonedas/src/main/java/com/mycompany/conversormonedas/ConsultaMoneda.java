package com.mycompany.conversormonedas;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {


    private static final String API_KEY = "d1a046c59ff8387c207be95a"; 

    public MonedaDTO buscarTasa(String monedaBase, String monedaObjetivo) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaBase + "/" + monedaObjetivo);
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedaDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo conectar a la API o procesar la tasa de cambio.");
        }
    }
}