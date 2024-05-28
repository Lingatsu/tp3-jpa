package fr.epsi.i1cap2425;

import fr.epsi.i1cap2425.domain.Adresse;
import fr.epsi.i1cap2425.domain.Client;
import fr.epsi.i1cap2425.domain.Emprunt;
import fr.epsi.i1cap2425.domain.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class TestBibliotheque {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-biblio");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés
        Emprunt emprunt = em.find(Emprunt.class, 2);
        System.out.println("fin du chargement de l'emprunt");
        if (null != emprunt) {

            System.out.println(emprunt.getClient().getNom());
            System.out.println("Fin affichage nom client");
            System.out.println(emprunt);
            System.out.println("Fin affichage ensemble emprunts");
        }

        //Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné
        Client client = em.find(Client.class, 2);
        if (null != client) {
            System.out.println(client.getEmprunts());
        }

        Livre livre = new Livre("The rose ...", "2Pac");


        Client steven = new Client("DELLA R", "Steven", new Adresse("11", "rue de la soif", "NTE"));

        Emprunt emprunt1 = new Emprunt(LocalDate.now(), 18, LocalDate.now());
        emprunt1.getLivres().add(livre);
        emprunt1.setClient(steven);
        steven.getEmprunts().add(emprunt1);

//        em.persist(livre);
        em.persist(steven);
//        em.persist(emprunt1);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}