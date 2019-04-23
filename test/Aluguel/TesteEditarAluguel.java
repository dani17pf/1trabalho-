/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aluguel;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DaniNoot
 */
public class TesteEditarAluguel {

    EntityManager em;

    public TesteEditarAluguel() {
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
            Aluguel a = em.find(Aluguel.class, 1);
           
            a.setValor(1100.0); 
            a.setDiaVencimento(7);
           

            em.getTransaction().begin();
            em.merge(a); //comparar o que tem de diferente para executar modificação no BD 
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("erro" +e);  
             e.printStackTrace();
        }
    }

}
