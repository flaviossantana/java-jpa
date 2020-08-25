package br.com.alura;

import br.com.alura.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CriarContaComSaldoTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta-db");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(
                new Conta(2032, 120987, "Osvaldo Costa", BigDecimal.valueOf(22328.90))
        );
        manager.getTransaction().commit();
    }

}