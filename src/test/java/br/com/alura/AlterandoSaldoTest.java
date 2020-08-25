package br.com.alura;

import br.com.alura.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Random;

public class AlterandoSaldoTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta-db");
        EntityManager manager = emf.createEntityManager();

        TypedQuery<Conta> select = manager.createQuery("SELECT cta FROM Conta cta", Conta.class);
        List<Conta> contas = select.getResultList();

        manager.getTransaction().begin();

        for (Conta conta : contas) {
            BigDecimal saldo = BigDecimal.valueOf((new Random().nextDouble() * 10000));
            saldo = saldo.setScale(2, BigDecimal.ROUND_UP);
            conta.setSaldo(saldo);
        }

        manager.getTransaction().commit();


    }

}
