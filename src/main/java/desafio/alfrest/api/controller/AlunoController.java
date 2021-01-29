package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.repository.AlunosRepository;
import desafio.alfrest.api.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunosRepository repository;

    // Faz uma consulta pelo id do aluno:
    @GetMapping(path = "/api/aluno/{id}")
    public ResponseEntity consultar(@PathVariable(name = "id") Integer id) {
        // Faz e retorna a consulta:
        return this.repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))    // Monta e retorna o ResponseBody com o registro
                .orElse(ResponseEntity.notFound().build());         // Caso contrário retorna um notFound
    }

    // Cadastra um novo aluno:
    @PostMapping(path = "/api/aluno/cadastrar")
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return this.repository.save(aluno); // Cadastra o aluno recebido no RequestBody e retorna
    }

    // Retorna todos os alunos cadastrados:
    @GetMapping(path = "/api/alunos")
    public @ResponseBody ResponseEntity<Aluno> consultarAlunos() {
        List<Aluno> alunos = new ArrayList<>(); // Cria uma lista para receber o resultado da request
        repository.findAll().forEach(alunos::add);  // Preenche a lista com os registros obtidos

        return new ResponseEntity(alunos, HttpStatus.OK);   // Cria e retorna os resultados.
    }

}
