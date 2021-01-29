package desafio.alfrest.api.controller.response;

import desafio.alfrest.api.model.Aluno;

public class AlunoRs {

    private Integer id;
    private String nome;
    private Float media;

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

}
