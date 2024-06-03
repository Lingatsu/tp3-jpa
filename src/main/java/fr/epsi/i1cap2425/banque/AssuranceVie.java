package fr.epsi.i1cap2425.banque;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte {
    private LocalDate dateFin;
    private double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(LocalDate dateFin, double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public AssuranceVie(String numero, double solde) {
        super(numero, solde);
    }

    public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }
}
