package org.ifrn.projeto.factory;

import java.util.ArrayList;
import java.util.List;

import org.ifrn.projeto.models.SimpsonsCharacter;
import org.springframework.stereotype.Component;

import tools.jackson.databind.JsonNode;

@Component
public class SimpsonFactory {

    public SimpsonsCharacter createCharacter(JsonNode data) {
        SimpsonsCharacter character = new SimpsonsCharacter();
        character.setId(integerOrNull(data, "id"));
        character.setAge(integerOrNull(data, "age"));
        character.setBirthdate(textOrNull(data, "birthdate"));
        character.setGender(textOrNull(data, "gender"));
        character.setName(textOrNull(data, "name"));
        character.setOccupation(textOrNull(data, "occupation"));
        character.setPortraitPath(textOrNull(data, "portrait_path"));
        character.setStatus(textOrNull(data, "status"));

        List<String> phrases = new ArrayList<>();
        JsonNode phrasesNode = data.path("phrases");
        if (phrasesNode.isArray()) {
            phrasesNode.forEach(phrase -> phrases.add(phrase.asText()));
        }
        character.setPhrases(phrases);
        return character;
    }

    private Integer integerOrNull(JsonNode data, String field) {
        JsonNode value = data.get(field);
        return value != null && value.canConvertToInt() ? value.intValue() : null;
    }

    private String textOrNull(JsonNode data, String field) {
        JsonNode value = data.get(field);
        return value == null || value.isNull() ? null : value.asText();
    }
}
