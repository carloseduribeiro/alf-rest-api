package desafio.alfrest.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestaoController {

    @GetMapping(path = "/api/gabarito/{id}")
    public ResponseEntity consulta(Integer id) {
        return null;
    }

}
