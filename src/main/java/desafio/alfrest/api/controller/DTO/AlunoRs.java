package desafio.alfrest.api.controller.DTO;

import desafio.alfrest.api.model.Aluno;

public class AlunoRs {

    private Integer id;
    private String nome;
    private Float media;

    // Conversor:
    // Converte uma entidade Aluno para a representação PessoaRs.
    public static AlunoRs converter(Aluno a) {
        var aluno = new AlunoRs();
        aluno.setId(a.getId());
        aluno.setNome(a.getNome());
        aluno.setMedia(a.getMedia());
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

}
