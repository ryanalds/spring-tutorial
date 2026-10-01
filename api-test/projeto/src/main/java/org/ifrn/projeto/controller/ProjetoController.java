package org.ifrn.projeto.controller;

import org.ifrn.projeto.models.SimpsonsCharacter;
import org.ifrn.projeto.services.SimpsonsApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;

@Controller
public class ProjetoController {

    private final SimpsonsApiService simpsonsApiService;

    public ProjetoController(SimpsonsApiService simpsonsApiService) {
        this.simpsonsApiService = simpsonsApiService;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            if (id < 1) {
                model.addAttribute("error", "Informe um ID maior que zero.");
            } else {
                try {
                    SimpsonsCharacter character = simpsonsApiService.findCharacterById(id);
                    if (character == null) {
                        model.addAttribute("error", "A API não retornou um personagem para esse ID.");
                    } else {
                        model.addAttribute("character", character);
                    }
                } catch (RestClientException exception) {
                    model.addAttribute("error", "Não foi possível consultar a API. Verifique a URL e tente novamente.");
                }
            }
            model.addAttribute("searchedId", id);
        }
        return "index";
    }
}
