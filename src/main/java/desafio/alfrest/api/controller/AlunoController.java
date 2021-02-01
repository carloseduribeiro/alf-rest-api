package desafio.alfrest.api.controller;

import desafio.alfrest.api.model.DTO.AlunoRequest;
import desafio.alfrest.api.model.DTO.AlunoResponse;
import desafio.alfrest.api.services.AlunoService;
import desafio.alfrest.api.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Faz uma consulta pelo id do aluno:
    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> consultar(@PathVariable("id") Integer id) {
        // Faz e retorna a consulta:
        Aluno aluno = this.alunoService.findById(id);
        return ResponseEntity.ok().body(aluno);
    }


    // Cadastra um novo aluno:
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<AlunoResponse> cadastrar(@RequestBody AlunoRequest alunoRq) {
        Aluno aluno = this.alunoService.save(alunoRq.toAluno());
        return ResponseEntity.ok().body(AlunoResponse.converter(aluno));
    }

    /*
    // Consulta e retorna todos os alunos cadastrados:
    @GetMapping
    public List<Aluno> consultarAlunos() {
        return this.repository.findAll();
    }
    */

}
