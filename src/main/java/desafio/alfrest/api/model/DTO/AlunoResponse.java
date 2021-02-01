package desafio.alfrest.api.model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import desafio.alfrest.api.model.Aluno;
import desafio.alfrest.api.model.Prova;

import java.util.List;

public class AlunoResponse {

    private Integer id;
    private String nome;
    private Float media;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Prova> provas;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean status;

    /* Armazena a situação do aluno:
     * if status == null : NÃO CALCULADO
     * if status == true : APROVADO
     * if status == false : REPROVADO
    * */
    private String situacao;

    // Converte uma entidade Aluno para a representação AlunoResponse:
    public static AlunoResponse converter(Aluno a) {
        var alunoRs = new AlunoResponse();
        alunoRs.setId(a.getId());
        alunoRs.setNome(a.getNome());
        alunoRs.setMedia(a.getMedia());
        alunoRs.setStatus(a.getStatus());
        alunoRs.setProvas(a.getProvas());
        return alunoRs;
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

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;

        // Define a situação:
        if (this.status == null) {
            this.setSituacao("NÃO CALCULADO");
        } else if (this.status) {
            this.setSituacao("APROVADO");
        } else {
            this.setSituacao("REPROVADO");
        }
    }

    public String getSituacao() {
        return situacao;
    }

    private void setSituacao(String s) {
        this.situacao = s;
    }
}
