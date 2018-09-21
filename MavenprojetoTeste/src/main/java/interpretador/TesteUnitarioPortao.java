package interpretador;


import static org.junit.jupiter.api.Assertions.assertEquals;

import entidades.controle.Controle;
import entidades.portao.PortaoSimples;
import eventos.BotaoPressionado;
import eventos.MotorPortao;
import eventos.NenhumEvento;
import eventos.ObstaculoDetectado;
import org.junit.jupiter.api.Test;

class TesteUnitarioPortao {

    @Test
    void myFirstTest() {
        PortaoSimples portaoSimples = new PortaoSimples();
        Controle controle = new Controle();
        BotaoPressionado botaoPressionado = new BotaoPressionado();
        ObstaculoDetectado obstaculoDetectado = new ObstaculoDetectado();
        NenhumEvento nenhumEvento = new NenhumEvento();
        MotorPortao executarTeste = new MotorPortao();

        //Abaixo estão todos testes unitarios que se pede por favor retirar o comentario e executar 1 de cada vez.

//        assertEquals("001234321000", executarTeste.executarEvento("..p...o.....", botaoPressionado, portaoSimples, nenhumEvento, obstaculoDetectado));
//        assertEquals("012345", executarTeste.executarEvento(".p....", botaoPressionado, portaoSimples, nenhumEvento, obstaculoDetectado));
//        assertEquals("000122222345", executarTeste.executarEvento("...p.p...p..", botaoPressionado, portaoSimples, nenhumEvento, obstaculoDetectado));
//        assertEquals("123210", executarTeste.executarEvento("p..o..", botaoPressionado, portaoSimples, nenhumEvento, obstaculoDetectado));
//        assertEquals("123333343210", executarTeste.executarEvento("p..p...po...", botaoPressionado, portaoSimples, nenhumEvento, obstaculoDetectado));
//        assertEquals("123432344444555", executarTeste.executarEvento("p...o.o.p...p..", botaoPressionado, portaoSimples, nenhumEvento, obstaculoDetectado));
//        assertEquals("123455433332100", executarTeste.executarEvento("p.....p.p..p...", botaoPressionado, portaoSimples, nenhumEvento, obstaculoDetectado));

    }

}

