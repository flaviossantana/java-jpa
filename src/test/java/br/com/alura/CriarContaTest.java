package br.com.alura;

import br.com.alura.core.PersistenceUtil;
import br.com.alura.model.Conta;

import javax.persistence.EntityManager;

public class CriarContaTest {

    public static void main(String[] args) {

        EntityManager manager = PersistenceUtil.entityManager();
        manager.getTransaction().begin();
        manager.persist(new Conta());
        manager.getTransaction().commit();
    }

}
