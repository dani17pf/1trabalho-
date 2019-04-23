/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnidadeCondominial;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.UnidadeCondominial;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DaniNoot
 */
public class TestePersistirUnidadeCondominial {
    
    EntityManager em;

    public TestePersistirUnidadeCondominial() {
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
            UnidadeCondominial uc = new UnidadeCondominial();
            
            uc.setNumero("212");
            uc.setDescricao("Teste da descricao");
            uc.setArea(535.00);
            uc.setNumeroQuarto(2);
            uc.setCondominio(em.find(Condominio.class, 1));
            
            
            em.getTransaction().begin();
            em.persist(uc);
            em.getTransaction().commit();
            
        } catch (Exception e){
            System.out.println("erro" +e);  
             e.printStackTrace();
        }
    }

}