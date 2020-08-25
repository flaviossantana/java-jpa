package br.com.alura;

import br.com.alura.model.Categoria;
import br.com.alura.model.Conta;
import br.com.alura.model.Movimento;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static br.com.alura.tipo.TipoMovimento.SAIDA;

public class RelacionamentoMovimentoCategoriaTest {

    public static void main(String[] args) {

        Faker faker = new Faker();

        Categoria catUm = new Categoria();
        Categoria catDois = new Categoria();

        Conta conta = new Conta(faker.number().numberBetween(1L, 29L));

        Movimento movUm = new Movimento(
                SAIDA,
                conta,
                Arrays.asList(catUm, catDois),
                BigDecimal.valueOf(faker.number().randomDouble(2, 1, 99)),
                LocalDateTime.now(),
                faker.commerce().department()
        );

        Movimento movDois = new Movimento(
                SAIDA,
                conta,
                Arrays.asList(catUm, catDois),
                BigDecimal.valueOf(faker.number().randomDouble(2, 1, 99)),
                LocalDateTime.now(),
                faker.commerce().department()
        );

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta-db");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(catUm);
        manager.persist(catDois);

        manager.persist(movUm);
        manager.persist(movDois);

        manager.getTransaction().commit();
        manager.close();

    }

}
