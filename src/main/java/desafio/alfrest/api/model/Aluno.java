package desafio.alfrest.api.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false)
    private Float media;

    // Um aluno contem uma lista de Provas:
    @OneToMany(mappedBy = "aluno")
    private List<Prova> provas;

}
