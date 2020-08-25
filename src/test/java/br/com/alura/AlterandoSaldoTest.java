package br.com.alura;

import br.com.alura.model.Conta;
import com.github.javafaker.Faker;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class AlterandoSaldoTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta-db");
        EntityManager manager = emf.createEntityManager();

        TypedQuery<Conta> select = manager.createQuery("SELECT cta FROM Conta cta", Conta.class);
        select.setHint("javax.persistence.query.timeou", "1");
        List<Conta> contas = select.getResultList();

        manager.getTransaction().begin();

        for (Conta conta : contas) {
            conta.setSaldo(BigDecimal.valueOf(new Faker().number().randomDouble(2, 1000, 99999)));
        }

        manager.getTransaction().commit();


    }

}
