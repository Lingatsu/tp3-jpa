package fr.epsi.i1cap2425.banque;

import jakarta.persistence.Entity;

@Entity
public class LivretA extends Compte {
    private double taux;

    public LivretA() {
    }

    public LivretA(double taux) {
        this.taux = taux;
    }

    public LivretA(String numero, double solde) {
        super(numero, solde);
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }
}
