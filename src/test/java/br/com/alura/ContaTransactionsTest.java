package br.com.alura;

import br.com.alura.model.Conta;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ContaTransactionsTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta-db");
        EntityManager manager = emf.createEntityManager();

        manager.getTransaction().begin();

        Conta conta = new Conta();

        manager.persist(conta);
        manager.getTransaction().commit();

        emf = Persistence.createEntityManagerFactory("conta-db");
        manager = emf.createEntityManager();

        manager.getTransaction().begin();

        conta.setTitular(new Faker().name().fullName());
        manager.merge(conta);

        manager.getTransaction().commit();

    }

}
