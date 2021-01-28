package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvaController {

    @Autowired
    private ProvaRepository repository;

    // Faz uma consulta pelo id da prova:
    @GetMapping(path = "/api/prova/{id}")
    public ResponseEntity consultar(@PathVariable(name = "id") Integer id) {
        // Faz e retorna a consulta:
        return this.repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))    // Monta e retorna o Response Body com o registro
                .orElse(ResponseEntity.notFound().build());         // caso contrário retorna um notFound.
    }



}
