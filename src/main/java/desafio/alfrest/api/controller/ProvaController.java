package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.DTO.ProvaRq;
import desafio.alfrest.api.controller.DTO.ProvaRs;
import desafio.alfrest.api.controller.DTO.QuestaoRs;
import desafio.alfrest.api.controller.repository.ProvaRepository;
import desafio.alfrest.api.controller.repository.QuestaoRepository;
import desafio.alfrest.api.model.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProvaController {

    @Autowired
    private ProvaRepository repository;

    @Autowired
    private QuestaoRepository questaoRepository;

    // Consulta e retorna todas as provas:
    @GetMapping(path = "/provas")
    public List<ProvaRs> consultarProvas(@RequestParam(value = "questoes", required = false, defaultValue = "false") Boolean val) {
        var provas = this.repository.findAll();
        List<ProvaRs> result = new ArrayList<>();

        if (!val) {
            // caso a propriedade não seja informada ou seja igual a false:
            // Retorna uma lista das provas cadastradas no banco.
            result = provas
                    .stream().map(prova -> ProvaRs.converter(prova))
                    .collect(Collectors.toList());
        } else {
            // Consulta e cria uma lista das provas cadastradas no banco:
            result = provas
                    .stream().map(prova -> ProvaRs.converter(prova))
                    .collect(Collectors.toList());

            // Percorre e adiciona a lista de questôes ao resultado:
            for( ProvaRs prova : result ) {
                List<QuestaoRs> questoes = new ArrayList<>();   // armazena a lista das questões.

                // Consulta e armazena a lista das questões:
                questoes = questaoRepository.findGabaritoByIdProva(prova.getId())
                        .stream()
                        .map(questao -> QuestaoRs.converter(questao))
                        .collect(Collectors.toList());
                // Atribui a lista de questão ao objeto prova:
                prova.setQuestoes(questoes);
            }
        }
        // Retorna o resultado:
        return result;
    }

    // Faz uma consulta pelo id da prova:
    @GetMapping(path = "/prova/{id}")
    public ProvaRs consultar(@PathVariable("id") Integer id) {
        var prova = this.repository.getOne(id);
        return ProvaRs.converter(prova);
    }

    // Cadastra uma nova prova
    @PostMapping(path = "/prova")
    public ProvaRs cadastrar(@RequestBody ProvaRq prova) {
        var p = new Prova();
        p.setNota(prova.getNota());
        p.setId_aluno(prova.getId_aluno());
        return ProvaRs.converter(this.repository.save(p));

    }

}
