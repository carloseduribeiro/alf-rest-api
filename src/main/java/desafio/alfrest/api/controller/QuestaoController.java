package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.DTO.ProvaRs;
import desafio.alfrest.api.controller.DTO.QuestaoRq;
import desafio.alfrest.api.controller.DTO.QuestaoRs;
import desafio.alfrest.api.controller.repository.QuestaoRepository;
import desafio.alfrest.api.model.Questao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class QuestaoController {

    @Autowired
    private QuestaoRepository repository;

    // Consulta e retorna as questoes que nao sao de gabarito:
    @GetMapping(path = "/questoes")
    public List<QuestaoRs> consultarQuestoes() {
        var questoes = this.repository.findAll();
        return questoes
                .stream().map(questao -> QuestaoRs.converter(questao))
                .collect(Collectors.toList());
    }

    // Faz uam consulta pelo id da questao:
    @GetMapping(path = "/questao/{id}")
    public QuestaoRs consulta(@PathVariable("id") Integer id) {
        var questao = this.repository.getOne(id);
        return QuestaoRs.converter(questao);
    }

    // Cadastra uma nova questão:
    @PostMapping(path = "/questao/cadastrar")
    public QuestaoRs cadastrar(@RequestBody QuestaoRq questao) {
        var q = new Questao();
        q.setAlternativa(questao.getAlternativa());
        q.setPeso(questao.getPeso());
        q.setId_prova(questao.getId_prova());
        q.setGabarito(false);
        return QuestaoRs.converter(this.repository.save(q));
    }

}
