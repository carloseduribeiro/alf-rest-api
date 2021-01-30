package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.DTO.AlunoRq;
import desafio.alfrest.api.controller.DTO.ProvaRs;
import desafio.alfrest.api.controller.repository.AlunoRepository;
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
    private AlunoRepository repository;

    @Autowired
    ProvaRepository provaRepository;

    // Consulta e retorna os alunos:
    // /api/alunos?provas=true  imprime com a lista de provas.
    @GetMapping(path = "/aluno")
    public List<AlunoRs> consultarAlunos(@RequestParam(value = "provas", required = false, defaultValue = "false") Boolean val) {
        var alunos = this.repository.findAll();
        List<AlunoRs> result = new ArrayList<>();

        if (!val) {
            // caso a propriedade não seja informada ou seja igual a false:
            // Retorna uma lista das alunos cadastradas no banco.
            result = alunos
                    .stream().map(aluno -> AlunoRs.converter(aluno))
                    .collect(Collectors.toList());
        } else {

            // Cria a lista dos alunos cadastrados no banco:
            result = alunos
                    .stream().map(aluno -> AlunoRs.converter(aluno))
                    .collect(Collectors.toList());

            // Percorre e adiciona a lista de provas ao resultado:
            for( AlunoRs aluno : result ) {
                List<ProvaRs> provas = new ArrayList<>();   // armazena a lista das questões.

                // Consulta e armazena a lista das questões:
                provas = provaRepository.findAll()
                        .stream()
                        .map(prova -> ProvaRs.converter(prova))
                        .collect(Collectors.toList());
                // Atribui a lista de questão ao objeto prova:
                aluno.setProvas(provas);
            }

        }
        // Retorna o resultado:
        return result;
    }

    // Faz uma consulta pelo id do aluno:
    @GetMapping(path = "/aluno/{id}")
    public AlunoRs consultar(
            @PathVariable("id") Integer id,
            @RequestParam(value = "provas", required = false, defaultValue = "false") Boolean val) {

        var aluno = this.repository.getOne(id);
        AlunoRs result = AlunoRs.converter(aluno);

        if ( val) {
            List<ProvaRs> provas = new ArrayList<>();   // armazena a lista das provas.

            // Consulta e armazena a lista das provas:

            provas = provaRepository.findProvaByIdAluno(aluno.getId())
                    .stream().map(prova -> ProvaRs.converter(prova))
                    .collect(Collectors.toList());

            result.setProvas(provas);
        }

        // Retorna o resultado:
        return result;
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
