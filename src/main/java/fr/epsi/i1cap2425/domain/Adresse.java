package fr.epsi.i1cap2425.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {

    @Column(name = "NUM")
    private String numero;
    @Column(name = "RUE")
    private String rue;
    @Column(name = "VILLE")
    private String ville;

    public Adresse() {
    }

    public Adresse(String numero, String rue, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("numero='").append(numero).append('\'');
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
