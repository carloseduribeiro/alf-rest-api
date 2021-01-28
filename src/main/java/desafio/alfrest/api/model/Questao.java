package desafio.alfrest.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Questao {

    @Id
    private Integer id;

    //private Integer idProva;

    @Column(nullable = false, length = 1)
    private String alternativa;

    @Column(nullable = false)
    private Integer peso;

    @Column(nullable = false)
    private boolean gabarito;

}
