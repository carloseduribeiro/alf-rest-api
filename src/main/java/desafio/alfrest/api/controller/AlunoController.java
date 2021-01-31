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
        a.setSituacao(false);
        return AlunoRs.converter(this.repository.save(a));
    }

    // Verifica e exibe a situação de um aluno:
    @PostMapping(path = "/aluno/{id}/situacao")
    public AlunoRs consultaSituacao(@PathVariable("id") Integer id) {
        var aluno = this.repository.getOne(id);
        AlunoRs result = AlunoRs.converter(aluno);

        List<String> respostas = this.provaRepository.findRespostasByIdProva(id);
        List<String> gabarito = this.provaRepository.findGabaritoByIdProva(id);
        List<Float> pesos = this.provaRepository.findQuestaoPesoByIdProva(id);

        Float media = 0.0f;

        /* Se o número de questões respondidas forem menor que o numero de questões gabarito
        * as não respondidas serão consideradas erradas para calcular a nota. */
        if (respostas.size() <= gabarito.size()) {
            if (respostas.size() <= gabarito.size())
                for (int i = 0; i < (respostas.size()-gabarito.size()); i++ )
                    respostas.add(null);

            media = ProvaRs.calculaNota(respostas, gabarito, pesos);
        } else {
            result.setSituacao_aluno("Não foi possível verificar a situação! Verifique as se o gabarito possui todas as questões cadastradas.");
        }

        // Atribui a média calculada:
        result.setMedia(media);;

        // Se a média for maior que
        if (media >= 7) {
            result.setSituacao(true);
            result.setSituacao_aluno("APROVADO");
        } else {
            result.setSituacao(false);
            result.setSituacao_aluno("REPROVADO");
        }

        // Retorna o resultado:
        return result;
    }

    // Consulta e retorna uma lista dos alunos aprovados:
    @GetMapping(path = "/aluno/aprovados")
    public List<AlunoRs> consultaLunosAprovados() {
        var alunos = this.repository.findAlunosAprovados();
        return alunos
                .stream().map(aluno -> AlunoRs.converter(aluno))
                .collect(Collectors.toList());
    }


}
