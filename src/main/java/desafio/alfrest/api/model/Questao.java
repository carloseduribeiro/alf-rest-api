package desafio.alfrest.api.model;

import javax.persistence.*;

@Entity
public class Questao {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_prova")
    private Prova prova;

    @Column(nullable = false, length = 1)
    private String alternativa;

    @Column(nullable = false)
    private Integer peso;

    @Column(nullable = false)
    private Boolean gabarito;

}
