/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locatario;

import Pessoa.*;
import br.edu.ifsul.testes.junit.*;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Pessoa;
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
public class TestePersistirLocatario {
    
    EntityManager em;

    public TestePersistirLocatario() {
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
            Locatario l = new Locatario();
            l.setNome("Rosane Pera");
            l.setCpf("025.175.320-44");
            l.setTelefone("(54)99189-1622");
            l.setEmail("RosanePera@gmail.com");
             
            l.setRenda(650.00);
            l.setLocalTrabalho("Escritorio");
            l.setTelefoneTrabalho("(54)99213-2502");
            
            
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e){
           System.out.println("erro" +e);  
             e.printStackTrace();
        }
        
    }

}