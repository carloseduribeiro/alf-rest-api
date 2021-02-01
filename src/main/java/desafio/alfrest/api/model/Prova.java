package desafio.alfrest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Prova {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Float nota;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @OneToMany(mappedBy = "prova")
    private List<Questao> questoes;


    // Contrutor para estabelecer os valores padrão:
    public Prova() {
        this.setNota(0.0f);
        this.aluno = new Aluno();
        this.questoes = new ArrayList<>();
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

}
