package org.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.application.dto.DtoAddress;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ApiService {

    DtoAddress dtoAddress = new DtoAddress();

    public DtoAddress getAddress(String cep) throws IOException, InterruptedException {
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            dtoAddress = mapper.readValue(response.body(), DtoAddress.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return dtoAddress;
    }

}
