package desafio.alfrest.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvaController {

    // Faz uma consulta pelo id da prova:
    @GetMapping(path = "/api/prova/{id}")
    public ResponseEntity consultar(@PathVariable(name = "id") Integer id) {
        return null;
    }

}
