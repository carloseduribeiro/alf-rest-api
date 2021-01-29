package desafio.alfrest.api.model;

import javax.persistence.*;
import java.util.ArrayList;
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


    // Construtor

    public Aluno() {
        this.setMedia(0.0f);
        this.provas = new ArrayList<>();
    }


    // Getters | Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

}
