/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnidadeCondominial;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.UnidadeCondominial;

import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DaniNoot
 */
public class TesteListarUnidadeCondominial {

    EntityManager em;

    public TesteListarUnidadeCondominial() {
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
        List<UnidadeCondominial> unidade = em.createQuery("from UnidadeCondominial").getResultList();
        for(UnidadeCondominial u: unidade){
            System.out.println(u);
        }
    }
        

}
