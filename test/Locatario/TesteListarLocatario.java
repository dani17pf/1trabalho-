/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locatario;

import Pessoa.*;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author DaniNoot
 */
public class TesteListarLocatario {

    EntityManager em;

    public TesteListarLocatario() {
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
        List<Locatario> locatario = em.createQuery("from Locatario").getResultList();
        for(Locatario l: locatario){
            System.out.println(l);
        }
    }
        

}
