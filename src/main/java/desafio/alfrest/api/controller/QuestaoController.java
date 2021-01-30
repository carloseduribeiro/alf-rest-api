package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.DTO.QuestaoRq;
import desafio.alfrest.api.controller.DTO.QuestaoRs;
import desafio.alfrest.api.controller.repository.QuestaoRepository;
import desafio.alfrest.api.model.Questao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class QuestaoController {

    @Autowired
    private QuestaoRepository repository;

    // ====== QUESTOES ======

    // Consulta e retorna todas as questoes cadastradas:
    @GetMapping(path = "/questao")
    public List<QuestaoRs> consultarQuestoes() {
        var questoes = this.repository.findQuestoes();
        return questoes
                .stream().map(questao -> QuestaoRs.converter(questao))
                .collect(Collectors.toList());
    }

    // Consulta e retorna as questôes pelo id da prova:
    @GetMapping(path = "/questao/prova/{id_prova}")
    public List<QuestaoRs> consultarQuestaoIdProva(@PathVariable("id_prova") Integer id_prova) {
        var questoes = this.repository.findByIdProva(id_prova);
        return questoes
                .stream().map(questao -> QuestaoRs.converter(questao))
                .collect(Collectors.toList());
    }

    // Cadastra uma nova questão para a prova pelo id:
    @PostMapping(path = "/questao/prova")
    public QuestaoRs cadastrarQuestao(
            @RequestBody QuestaoRq questao,
            @RequestParam(value = "id", required = false, defaultValue = "0") Integer id_prova) {
        var q = new Questao();
        q.setId(null);
        q.setAlternativa(questao.getAlternativa());
        q.setPeso(questao.getPeso());
        q.setGabarito(false);

        // Define id_prova == 0 se ele não for informado no RequestBody
        if (questao.getId_prova() == null)
            questao.setId_prova(0);

        if (id_prova != questao.getId_prova() && id_prova == 0) {
            // se o parametro for 0 e o id não
            q.setId_prova(questao.getId_prova());
        } else {
            if (id_prova != questao.getId_prova() && questao.getId_prova() == 0) {
                // se o id for 0 e o parametro não
                q.setId_prova(id_prova);
            } else {
                if( id_prova == questao.getId_prova() && id_prova != 0) {
                    q.setId_prova(id_prova);
                } else {
                    q.setId_prova(null);
                }
            }
        }
        return QuestaoRs.converter(this.repository.save(q));
    }

    // Cadastra uma lista de questões:
    @PostMapping(path = "/questao/lista/{id_prova}",  consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public List<QuestaoRs> cadastrarQuestoes(@RequestBody List<QuestaoRs> questoes) {
        List<QuestaoRs> result = new ArrayList<>();
        // percorre a lista de questões recebida:
        for (QuestaoRs q : questoes) {
            var questao = new Questao();
            questao.setId(null);
            questao.setId_prova(q.getId_prova());
            questao.setAlternativa(q.getAlternativa());
            questao.setPeso(q.getPeso());
            questao.setGabarito(false);
            result.add(QuestaoRs.converter(this.repository.save(questao)));
        }
        return result;
    }

    // ====== GABARITO ======

    // Consulta e retorna todas as questoes que nao sao de gabarito:
    @GetMapping(path = "/gabarito")
    public List<QuestaoRs> consultarGabaritos() {
        var questoes = this.repository.findGabaritos();
        return questoes
                .stream().map(questao -> QuestaoRs.converter(questao))
                .collect(Collectors.toList());
    }

    // Faz uma consulta pelo id da prova:
    @GetMapping(path = "/gabarito/prova/{id_prova}")
    public List<QuestaoRs> consultarGabaritoIdProva(@PathVariable("id_prova") Integer id_prova) {
        var questoes = this.repository.findGabaritoByIdProva(id_prova);
        return questoes
                .stream().map(questao -> QuestaoRs.converter(questao))
                .collect(Collectors.toList());
    }


    // Cadastra uma nova resposta para o gabarito pelo id:
    @PostMapping(path = "/gabarito/resposta/prova")
    public QuestaoRs cadastrarQuestaoGabarito(
            @RequestBody QuestaoRq questao,
            @RequestParam(value = "id", required = false, defaultValue = "0") Integer id_prova) {
        var q = new Questao();
        q.setId(null);
        q.setAlternativa(questao.getAlternativa());
        q.setPeso(questao.getPeso());
        q.setGabarito(true);

        // Define id_prova == 0 se ele não for informado no RequestBody
        if (questao.getId_prova() == null)
            questao.setId_prova(0);

        if (id_prova != questao.getId_prova() && id_prova == 0) {
            // se o parametro for 0 e o id não
            q.setId_prova(questao.getId_prova());
        } else {
            if (id_prova != questao.getId_prova() && questao.getId_prova() == 0) {
                // se o id for 0 e o parametro não
                q.setId_prova(id_prova);
            } else {
                if( id_prova == questao.getId_prova() && id_prova != 0) {
                    q.setId_prova(id_prova);
                } else {
                    q.setId_prova(null);
                }
            }
        }
        return QuestaoRs.converter(this.repository.save(q));
    }

    // Cadastra uma lista de questões gabarito:
    @PostMapping(path = "/gabarito/resposta/lista/{id_prova}",  consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public List<QuestaoRs> cadastrarQuestoesGabarito(@RequestBody List<QuestaoRs> questoes) {
        List<QuestaoRs> result = new ArrayList<>();
        // percorre a lista de questões recebida:
        for (QuestaoRs q : questoes) {
            var questao = new Questao();
            questao.setId(null);
            questao.setId_prova(q.getId_prova());
            questao.setAlternativa(q.getAlternativa());
            questao.setPeso(q.getPeso());
            questao.setGabarito(true);
            result.add(QuestaoRs.converter(this.repository.save(questao)));
        }
        return result;
    }

}
