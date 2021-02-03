package desafio.alfrest.api.controller;

import desafio.alfrest.api.model.DTO.AlunoRequest;
import desafio.alfrest.api.model.DTO.AlunoResponse;
import desafio.alfrest.api.services.AlunoService;
import desafio.alfrest.api.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Faz uma consulta pelo id do aluno:
    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoResponse> consultar(@PathVariable("id") Integer id) {
        // Faz e retorna a consulta:
        AlunoResponse aluno = AlunoResponse.converter(this.alunoService.findById(id));
        return ResponseEntity.ok().body(aluno);
    }

    // Cadastra um novo aluno:
    @PostMapping
    public ResponseEntity<AlunoResponse> cadastrar(@Valid @RequestBody AlunoRequest alunoRq) {
        Aluno aluno = this.alunoService.save(alunoRq.toAluno());
        return ResponseEntity.ok().body(AlunoResponse.converter(aluno));
    }

    // Consulta e retorna todos os alunos cadastrados:
    @GetMapping
    public ResponseEntity<List<AlunoResponse>> consultarAlunos() {

        // Pesquisa e armazena todos os alunos cadastrados:
        List<AlunoResponse> alunos = this.alunoService
                .findAll().stream()
                .map(AlunoResponse::converter)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(alunos);
    }

}
