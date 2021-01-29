package desafio.alfrest.api.controller.DTO;

public class QuestaoRq {

    private Integer id_prova;
    private String alternativa;
    private Integer peso;
    private Boolean gabarito;

    // Getters | Setters

    public Integer getId_prova() {
        return id_prova;
    }

    public void setId_prova(Integer id_prova) {
        this.id_prova = id_prova;
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
