package fr.epsi.i1cap2425.banque;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "DATE_DE_NAISSANCE")
    private LocalDate dateNaissance;
    @Embedded
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;
    @ManyToMany
    @JoinTable(
            name = "CPT_CLI",
            joinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_CPT", referencedColumnName = "ID")
    )
    private Set<Compte> comptes = new HashSet<>();

    public Client() {
    }

    public Client(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", adresse=" + adresse +
                ", banque=" + banque +
                ", compte=" + comptes +
                '}';
    }
}
