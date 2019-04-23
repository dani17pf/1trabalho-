/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Condominio;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Condominio;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DaniNoot
 */
public class TesteRemoverCondominio {

    EntityManager em;

    public TesteRemoverCondominio() {
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
            Condominio c = em.find(Condominio.class, 2);

            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("erro" +e);  
             e.printStackTrace();
        }
    }

}
