package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.repository.QuestaoRepository;
import desafio.alfrest.api.model.Questao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestaoController {

    @Autowired
    private QuestaoRepository repository;

    // Faz uam consulta pelo id do gabarito:
    @GetMapping(path = "/api/questao/{id}")
    public ResponseEntity consulta(@PathVariable(name = "id") Integer id) {
        // Faz e retorna a consulta:
        return this.repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))    // Monta e retorna o response body com o registro
                .orElse(ResponseEntity.notFound().build());         // Caso contrário retorna um not found.
    }

    // Cadastra uma nova questão:
    @PostMapping(path = "/api/questao/cadastrar")
    public Questao cadastrar(@RequestBody Questao questao) {
        return this.repository.save(questao);   // Cadastra a questão recebida no RequestBody e retorna.
    }

}