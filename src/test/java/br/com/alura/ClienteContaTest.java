package br.com.alura;

import br.com.alura.model.Cliente;
import br.com.alura.model.Conta;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;

public class ClienteContaTest {

    public static void main(String[] args) {

        EntityManager entityManager = PersistenceUtil.entityManager();

        entityManager.getTransaction().begin();

        Faker faker = new Faker();
        long idConta = faker.number().numberBetween(1, 31);

        Conta conta = entityManager.find(Conta.class, idConta);
        Cliente cliente = new Cliente(conta);

        entityManager.persist(cliente);

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("##CONTA: " + cliente.toString());

    }

}
