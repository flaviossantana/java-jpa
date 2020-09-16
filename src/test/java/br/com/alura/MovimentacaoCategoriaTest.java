package br.com.alura;

import br.com.alura.model.Categoria;
import br.com.alura.model.Movimento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovimentacaoCategoriaTest {

    public static void main(String[] args) {

        EntityManager em = PersistenceUtil.entityManager();

        em.getTransaction().begin();

        StringBuilder select = new StringBuilder();
        select.append("select m ");
        select.append("from Movimento m ");
        select.append("join m.categorias c ");
        select.append("where c = :pCategoria ");

        TypedQuery<Movimento> query = em.createQuery(select.toString(), Movimento.class);
        query.setParameter("pCategoria", new Categoria(13l));

        List<Movimento> movimentos = query.getResultList();

        for (Movimento movimento : movimentos){
            System.out.println("### MOVIMENTO: " + movimento);
        }

        em.getTransaction().commit();
    }

}
