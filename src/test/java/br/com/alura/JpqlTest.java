package br.com.alura;

import br.com.alura.model.Conta;
import br.com.alura.model.Movimento;
import com.github.javafaker.Faker;

import javax.persistence.*;
import java.util.List;

public class JpqlTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta-db");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        StringBuilder select = new StringBuilder();
        select.append("select m ");
        select.append("from Movimento m ");
        select.append("where m.conta = :pConta ");
        select.append("order by m.valor desc ");

        TypedQuery<Movimento> query = entityManager.createQuery(select.toString(), Movimento.class);
        query.setParameter("pConta", new Conta(new Faker().number().numberBetween(1L, 32L)));


        List<Movimento> movimentos = query.getResultList();


        for (Movimento movimento: movimentos) {
            System.out.println(movimento.toString());
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
