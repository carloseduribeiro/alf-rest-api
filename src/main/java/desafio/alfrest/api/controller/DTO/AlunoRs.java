package desafio.alfrest.api.controller.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.alfrest.api.model.Aluno;

import java.util.List;

public class AlunoRs {

    private Integer id;
    private String nome;
    private Float media;

    // Armazena a lista de provas do aluno:
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ProvaRs> provas;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean situacao;

    private String situacao_aluno;

    // Conversor:
    // Converte uma entidade Aluno para a representação PessoaRs.
    public static AlunoRs converter(Aluno a) {
        var aluno = new AlunoRs();
        aluno.setId(a.getId());
        aluno.setNome(a.getNome());
        aluno.setMedia(a.getMedia());
        aluno.setSituacao(a.getSituacao());

        if (a.getSituacao()) {
            aluno.setSituacao_aluno("APROVADO");
        } else {
            aluno.setSituacao_aluno("REPROVADO");
        }

        return aluno;
    }

    // Contrutor para definir os valores padrão:
    public AlunoRs() {
        this.setMedia(0.0f);
    }

    // Getters | Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public List<ProvaRs> getProvas() {
        return provas;
    }

    public void setProvas(List<ProvaRs> provas) {
        this.provas = provas;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public String getSituacao_aluno() {
        return situacao_aluno;
    }

    public void setSituacao_aluno(String situacao_aluno) {
        this.situacao_aluno = situacao_aluno;
    }
}
