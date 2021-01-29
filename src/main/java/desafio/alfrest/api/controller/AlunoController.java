package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.DTO.AlunoRq;
import desafio.alfrest.api.controller.repository.AlunosRepository;
import desafio.alfrest.api.controller.repository.ProvaRepository;
import desafio.alfrest.api.controller.DTO.AlunoRs;
import desafio.alfrest.api.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AlunoController {

    @Autowired
    private AlunosRepository repository;

    // Consulta e retorna os alunos:
    // /api/alunos?provas=true  imprime com a lista de provas.
    @GetMapping(path = "/alunos")
    public List<AlunoRs> consultarAlunos(@RequestParam(value = "provas", required = false, defaultValue = "false") Boolean val) {
        var alunos = this.repository.findAll();
        if (!val) {
            return alunos
                    .stream().map(aluno -> AlunoRs.converter(aluno))
                    .collect(Collectors.toList());
        } else {
            // retorna uma lista dos alunos junto a lista de suas provas:
            return new ArrayList<>(null);
        }
    }

    // Faz uma consulta pelo id do aluno:
    @GetMapping(path = "/aluno/{id}")
    public AlunoRs consultar(@PathVariable("id") Integer id) {
        var aluno = this.repository.getOne(id);
        return AlunoRs.converter(aluno);
    }

    // Cadastra um novo aluno:
    @PostMapping(path = "/aluno")
    public AlunoRs cadastrar(@RequestBody AlunoRq aluno) {
        var a = new Aluno();
        a.setNome(aluno.getNome());
        a.setMedia(aluno.getMedia());
        return AlunoRs.converter(this.repository.save(a));
    }

}
