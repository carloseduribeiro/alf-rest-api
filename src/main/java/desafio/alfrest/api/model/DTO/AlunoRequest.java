package desafio.alfrest.api.model.DTO;

import desafio.alfrest.api.model.Aluno;

import javax.validation.constraints.NotBlank;

public class AlunoRequest {

    @NotBlank
    private String nome;


    // Getters | Setters:

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Cria um objeto da entidade Aluno e retorna:
    public Aluno toAluno() {
        return new Aluno(this.getNome());
    }

}
