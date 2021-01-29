package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.repository.AlunosRepository;
import desafio.alfrest.api.controller.repository.ProvaRepository;
import desafio.alfrest.api.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunosRepository repository;

    // Faz uma consulta pelo id do aluno:
    @GetMapping(path = "/api/aluno/{id}")
    public ResponseEntity consultar(@PathVariable("id") Integer id) {
        // Faz e retorna a consulta:
        return this.repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))    // Monta e retorna o ResponseBody com o registro
                .orElse(ResponseEntity.notFound().build());         // Caso contrário retorna um notFound
    }

    // Cadastra um novo aluno:
    @PostMapping(path = "/api/aluno")
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return this.repository.save(aluno); // Cadastra o aluno recebido no RequestBody e retorna
    }

    // Consulta e retorna os alunos:
    // /api/alunos?provas=true  imprime com a lista de provas.
    @GetMapping(path = "/api/alunos")
    public List<Aluno> consultarAlunos(@RequestParam(value = "provas", required = false, defaultValue = "false") Boolean val) {
        if (!val) {
            return this.repository.findAll();
        } else {
            ProvaRepository provaRepository;
            return new ArrayList<>(null);
        }
    }

}
