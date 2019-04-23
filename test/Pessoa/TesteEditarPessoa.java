/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

import br.edu.ifsul.testes.junit.*;
import br.edu.ifsul.jpa.EntityManagerUtil;
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
public class TesteEditarPessoa {

    EntityManager em;

    public TesteEditarPessoa() {
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
            Pessoa p = em.find(Pessoa.class, 2);
        
            p.setNome("Rodrigo");
            p.setEmail("rodrigo@gmail.com");
            p.setTelefone("(54)99123-3210");
            p.setCpf("025.175.320-44");

            em.getTransaction().begin();
            em.merge(p); //comparar o que tem de diferente para executar modificação no BD 
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("erro" +e);  
             e.printStackTrace();
        }
    }

}
