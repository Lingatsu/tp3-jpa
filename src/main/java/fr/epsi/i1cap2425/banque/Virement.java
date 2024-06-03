package fr.epsi.i1cap2425.banque;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Virement extends Operation {
    private String beneficiaire;

    public Virement() {
    }

    public Virement(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Virement(LocalDate date, double montant, String motif, Compte comptes, String beneficiaire) {
        super(date, montant, motif, comptes);
        this.beneficiaire = beneficiaire;
    }

}
