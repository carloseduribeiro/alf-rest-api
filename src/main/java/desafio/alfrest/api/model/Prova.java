package desafio.alfrest.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Prova {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Float nota;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @OneToMany(mappedBy = "prova")
    private List<Questao> questoes;

}
