/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnidadeCondominial;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.UnidadeCondominial;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DaniNoot
 */
public class TesteRemoverUnidadeCondominial {

    EntityManager em;

    public TesteRemoverUnidadeCondominial() {
    }

    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void teste() {
        
        try {
            UnidadeCondominial u = em.find(UnidadeCondominial.class, 1);

            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("erro" +e);  
             e.printStackTrace();
        }
    }

}
