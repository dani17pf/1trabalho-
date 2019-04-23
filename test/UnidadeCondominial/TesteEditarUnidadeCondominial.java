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
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DaniNoot
 */
public class TesteEditarUnidadeCondominial {
    
    EntityManager em;
    
    public TesteEditarUnidadeCondominial() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();//executar teste
    }
    
    @After
    public void tearDown() {
        em.close(); //encerrar conexão
    }
    
    @Test
    public void teste(){
       
        try{
        UnidadeCondominial uc = em.find(UnidadeCondominial.class, 1);
        
        uc.setDescricao("Pera Pera Pera");
        
        em.getTransaction().begin();
        em.merge(uc); //comparar o que tem de diferente para executar modificação no BD 
        em.getTransaction().commit();
        }catch (Exception e){
        System.out.println("erro" +e);  
             e.printStackTrace();
        }
       
    }
    
}
