package br.com.alura;

import br.com.alura.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CriarContaComSaldoTest {

    public static void main(String[] args) {
        EntityManager manager = PersistenceUtil.entityManager();
        manager.getTransaction().begin();
        Conta conta = new Conta();
        conta.setSaldo(BigDecimal.valueOf(28943.98));
        manager.persist(conta);
        manager.getTransaction().commit();
    }

}
