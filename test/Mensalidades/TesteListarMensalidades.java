/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mensalidades;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Mensalidades;
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
public class TesteListarMensalidades {

    EntityManager em;

    public TesteListarMensalidades() {
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
        List<Mensalidades> mensalidades = em.createQuery("from Mensalidades").getResultList();
        for(Mensalidades m: mensalidades){
            System.out.println(m);
        }
    }
        

}
