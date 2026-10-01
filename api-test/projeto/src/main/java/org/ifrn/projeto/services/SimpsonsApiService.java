package org.ifrn.projeto.services;

import org.ifrn.projeto.factory.SimpsonFactory;
import org.ifrn.projeto.models.SimpsonsCharacter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import tools.jackson.databind.JsonNode;

@Service
public class SimpsonsApiService {

    private final RestClient simpsonsClient;
    private final SimpsonFactory simpsonFactory;

    public SimpsonsApiService(RestClient simpsonsClient, SimpsonFactory simpsonFactory) {
        this.simpsonsClient = simpsonsClient;
        this.simpsonFactory = simpsonFactory;
    }

    public SimpsonsCharacter findCharacterById(int id) {
        JsonNode response = simpsonsClient.get()
                .uri("/characters/{id}", id)
                .retrieve()
                .body(JsonNode.class);

        if (response == null || response.isNull()) {
            return null;
        }
        return simpsonFactory.createCharacter(response);
    }
}
