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
public class TestePersistirCondominio {
    
    EntityManager em;

    public TestePersistirCondominio() {
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
            Condominio c = new Condominio();
            
            c.setNome("No Name");
            c.setEndereco("Annes");
            c.setNumero("555");
            c.setCep("99062390");
            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e){
           System.out.println("erro" +e);  
             e.printStackTrace();
        }
        
    }

}