package desafio.alfrest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "aluno")
public class Aluno {

    @Id
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column
    private float media;

}
