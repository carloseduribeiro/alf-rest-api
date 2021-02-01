package desafio.alfrest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Questao {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_prova")
    private Prova prova;

    @Column(nullable = false, length = 1)
    private String alternativa;

    @Column(nullable = false)
    private Integer peso;

    @Column(nullable = false)
    private Boolean gabarito;


    // Contrutor para definir os valores padrão:
    public Questao() {
        this.setPeso(1);
        this.prova = new Prova();
    }


    // Getters | Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Boolean getGabarito() {
        return gabarito;
    }

    public void setGabarito(Boolean gabarito) {
        this.gabarito = gabarito;
    }

}
