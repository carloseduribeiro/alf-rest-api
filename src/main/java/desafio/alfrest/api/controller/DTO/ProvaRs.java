package desafio.alfrest.api.controller.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.alfrest.api.model.Prova;

import java.util.List;

public class ProvaRs {

    private Integer id;
    private Float nota;
    private Integer id_aluno;

    // Armazena a lista de questões da prova:
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<QuestaoRs> questoes;

    // Conversor:
    // Converte uma entidade Prova para uma representação ProvaRs:
    public static ProvaRs converter(Prova a) {
        var prova = new ProvaRs();
        prova.setId(a.getId());
        prova.setId_aluno(a.getId_aluno());
        return prova;
    }

    // Contrutor:
    public ProvaRs() {
        this.setNota(0.0f); // define a nota padrão
    }

    // Getters | Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Integer getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Integer id_aluno) {
        this.id_aluno = id_aluno;
    }

    public List<QuestaoRs> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoRs> questoes) {
        this.questoes = questoes;
    }
}
