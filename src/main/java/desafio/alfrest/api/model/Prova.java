package desafio.alfrest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prova {

    @Id
    private Integer id;

    @Column
    private float nota;

    // private ArrayList<Questao> questoes;

}
