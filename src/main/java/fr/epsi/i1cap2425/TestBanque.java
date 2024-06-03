package fr.epsi.i1cap2425;

import fr.epsi.i1cap2425.banque.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class TestBanque {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu-banque");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Compte compteCommun = new Compte();
        compteCommun.setNumero("89763");
        compteCommun.setSolde(2000);
        em.persist(compteCommun);

        Client client1 = new Client();
        client1.setNom("Elric");
        client1.setPrenom("Alphonse");
        client1.getComptes().add(compteCommun);
        em.persist(client1);

        Client client2 = new Client();
        client2.setNom("Duffy");
        client2.setPrenom("Joe");
        client2.getComptes().add(compteCommun);
        em.persist(client2);

        Client client3 = new Client();
        client3.setNom("Michael");
        client3.setPrenom("John");
        em.persist(client3);

        Compte assuranceVie = new AssuranceVie("89752",1000,LocalDate.now(),1.5);
        assuranceVie.getClients().add(client3);
        client3.getComptes().add(assuranceVie);
        em.persist(assuranceVie);

        Compte livretA = new LivretA("87564",2,3.5);
        livretA.getClients().add(client3);
        client3.getComptes().add(livretA);
        em.persist(livretA);

        Operation operation = new Operation(LocalDate.parse("2024-02-08"),500,"Courses",livretA);
        em.persist(operation);

        Virement virement = new Virement(LocalDate.parse("2023-06-19"),200,"Autres",compteCommun,"Waza");
        em.persist(virement);

        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }
}
