package br.com.alura;

import br.com.alura.core.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaTabelaTest {

    public static void main(String[] args) {
        EntityManager entityManager = PersistenceUtil.entityManager();
        entityManager.close();
    }

}
