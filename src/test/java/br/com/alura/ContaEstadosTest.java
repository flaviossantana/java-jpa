package br.com.alura;

import br.com.alura.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContaEstadosTest {

    public static void main(String[] args) {

        //TRANSIENT
        Conta conta = new Conta();

        EntityManager manager = PersistenceUtil.entityManager();

        manager.getTransaction().begin();

        System.out.println("TRANSIENT: " + conta);

        //TRANSIENT -> MANAGED
        manager.persist(conta);

        System.out.println("MANAGED: " + conta);

        //TRANSIENT -> MANAGED -> REMOVED
        manager.remove(conta);

        System.out.println("REMOVED: " + conta);

        manager.getTransaction().commit();

    }

}
