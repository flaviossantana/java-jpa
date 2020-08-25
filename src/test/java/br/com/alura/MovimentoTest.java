package br.com.alura;

import br.com.alura.model.Conta;
import br.com.alura.model.Movimento;
import br.com.alura.tipo.TipoMovimento;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class MovimentoTest {

    public static void main(String[] args) {

        Conta conta = new Conta();
         Movimento movimento = new Movimento(
                BigDecimal.valueOf(new Faker().number().randomDouble(2, 1, 100)),
                TipoMovimento.SAIDA,
                conta,
                LocalDateTime.now(ZoneId.systemDefault()),
                new Faker().beer().name());

        EntityManagerFactory contadb = Persistence.createEntityManagerFactory("conta-db");
        EntityManager entityManager = contadb.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(conta);
        entityManager.persist(movimento);

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("MOVIMENTO: " + movimento);

    }

}
