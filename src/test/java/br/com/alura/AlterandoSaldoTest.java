package br.com.alura;

import br.com.alura.core.PersistenceUtil;
import br.com.alura.model.Conta;
import com.github.javafaker.Faker;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class AlterandoSaldoTest {

    public static void main(String[] args) {


        EntityManager manager = PersistenceUtil.entityManager();

        TypedQuery<Conta> select = manager.createQuery("SELECT cta FROM Conta cta ", Conta.class);
        select.setHint("javax.persistence.query.timeout", "1");
        List<Conta> contas = select.getResultList();

        manager.getTransaction().begin();

        for (Conta conta : contas) {
            conta.setSaldo(BigDecimal.valueOf(new Faker().number().randomDouble(2, 1000, 99999)));
        }

        manager.getTransaction().commit();


    }

}
