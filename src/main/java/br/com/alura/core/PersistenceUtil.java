package br.com.alura.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static final String PERSISTENCE_UNIT_NAME = "conta-db";

    private PersistenceUtil() {
        super();
    }

    public static EntityManager entityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return emf.createEntityManager();
    }

}
