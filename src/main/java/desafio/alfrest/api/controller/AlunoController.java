package desafio.alfrest.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    // Faz uma consulta pelo id do aluno:
    @GetMapping(path = "/api/aluno/{id}")
    public ResponseEntity consultar(@PathVariable(name = "id") Integer id) {
        return null;
    }

}
