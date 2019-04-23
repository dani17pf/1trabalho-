/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aluguel;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Mensalidades;
import br.edu.ifsul.modelo.UnidadeCondominial;
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
public class TestePersistirAluguel {
    
    EntityManager em;

    public TestePersistirAluguel() {
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
        try {
            Aluguel a = new Aluguel();
            
            a.setValor(1000.0);
            a.setInicioContrato(Calendar.getInstance());
            a.setFimContrato(Calendar.getInstance());
            a.setDiaVencimento(2);
            a.setLocatario(em.find(Locatario.class, 3));
            a.setUc(em.find(UnidadeCondominial.class, 1));
            
            a.AddLista(em.find(Mensalidades.class, 1));
            
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println("erro" +e);  
             e.printStackTrace();
        }
        
    }

}