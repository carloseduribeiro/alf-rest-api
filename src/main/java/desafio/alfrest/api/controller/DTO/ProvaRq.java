package desafio.alfrest.api.controller.DTO;

import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public class ProvaRq {

    private Float nota;
    private Integer id_aluno;

    // Setters | Getters

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
}
