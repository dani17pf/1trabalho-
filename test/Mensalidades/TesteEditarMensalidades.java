/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensalidades;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Mensalidades;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DaniNoot
 */
public class TesteEditarMensalidades {

    EntityManager em;

    public TesteEditarMensalidades() {
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
            Mensalidades m = em.find(Mensalidades.class, 2);
        
            m.setValor(1000.0);
            m.setValorPagamento(100.00);

            em.getTransaction().begin();
            em.merge(m); //comparar o que tem de diferente para executar modificação no BD 
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("erro" +e);  
             e.printStackTrace();
        }
    }

}
