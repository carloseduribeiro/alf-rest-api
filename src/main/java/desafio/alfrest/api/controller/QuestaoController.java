package desafio.alfrest.api.controller;

import desafio.alfrest.api.model.Questao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestaoController {

    // Faz uam consulta pelo id do gabarito:
    @GetMapping(path = "/api/questao/{id}")
    public ResponseEntity consulta(@PathVariable(name = "id") Integer id) {
        return null;
    }

}
