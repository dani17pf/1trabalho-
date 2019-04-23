/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensalidades;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Mensalidades;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DaniNoot
 */
public class TestePersistirMensalidades {
    
    EntityManager em;

    public TestePersistirMensalidades() {
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
    public void teste(){
        boolean erro = false;
        try {
            Mensalidades m = new Mensalidades();
            
            m.setValor(1000.0);
            m.setVencimento(Calendar.getInstance());
            m.setValorPagamento(1000.0);
            m.setDataPagamento(Calendar.getInstance());
            m.setAluguel(em.find(Aluguel.class, 1));
            
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println("erro" +e);  
             e.printStackTrace();
        }
    }

}