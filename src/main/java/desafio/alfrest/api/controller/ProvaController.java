package desafio.alfrest.api.controller;

import desafio.alfrest.api.controller.DTO.AlunoRq;
import desafio.alfrest.api.controller.DTO.AlunoRs;
import desafio.alfrest.api.controller.DTO.ProvaRq;
import desafio.alfrest.api.controller.DTO.ProvaRs;
import desafio.alfrest.api.controller.repository.ProvaRepository;
import desafio.alfrest.api.model.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    // Consulta e retorna todas as provas:
    @GetMapping(path = "/provas")
    public List<ProvaRs> consultarProvas(@RequestParam(value = "questoes", required = false, defaultValue = "false") Boolean val) {
        var provas = this.repository.findAll();
        if (!val) {
            // caso a propriedade não seja informada ou seja igual a false:
            // Retorna uma lista das provas cadastradas no banco.
            return provas
                    .stream().map(prova -> ProvaRs.converter(prova))
                    .collect(Collectors.toList());
        } else {
            // Retorna uma lista das provas e suas questões:
            return new ArrayList<>(null);
        }
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
