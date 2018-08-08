/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entidades.Controle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernando
 */
public class NewEmptyJUnitTest {

    Controle c = new Controle();

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void execute() {
        // /*1*/ assertEquals("001234321000", c.execute("..p...o....."));
        ///*2*/ assertEquals("012345", c.execute(".p...."));
        ///*3*/ assertEquals("000122222345", c.execute("...p.p...p.."));
        // /*4*/ assertEquals("123210", c.execute("p..o.."));
        //  /*5*/ assertEquals("123333343210", c.execute("p..p...po..."));
        //  /*6*/ assertEquals("123432344444555", c.execute("p...o.o.p...p.."));
        ///*7*/ assertEquals("123455433332100", c.execute("p.....p.p..p..."));
    }

}
