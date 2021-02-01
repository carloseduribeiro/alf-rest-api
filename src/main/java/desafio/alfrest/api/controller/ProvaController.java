package desafio.alfrest.api.controller;

import desafio.alfrest.api.repository.ProvaRepository;
import desafio.alfrest.api.model.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProvaController {

    @Autowired
    private ProvaRepository repository;

    // Faz uma consulta pelo id da prova:
    @GetMapping(path = "/api/prova/{id}")
    public ResponseEntity consultar(@PathVariable("id") Integer id) {
        // Faz e retorna a consulta:
        return this.repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))    // Monta e retorna o Response Body com o registro
                .orElse(ResponseEntity.notFound().build());         // caso contrário retorna um notFound.
    }

    // Cadastra uma nova prova
    @PostMapping(path = "/api/prova/cadastrar")
    public Prova cadastrar(@RequestBody Prova prova) {
        return this.repository.save(prova); // Cadastra a prova recebida no RequestBody e retorna
    }

    // Consulta e retorna todas as provas cadastradas:
    @GetMapping(path = "/api/provas")
    public List<Prova> consultarProvas() {
        return this.repository.findAll();
    }

}
