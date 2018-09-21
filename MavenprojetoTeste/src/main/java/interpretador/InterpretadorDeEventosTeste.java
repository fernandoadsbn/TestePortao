package interpretador;

import entidades.controle.Controle;
import entidades.portao.PortaoSimples;
import eventos.BotaoPressionado;
import eventos.MotorPortao;
import eventos.NenhumEvento;
import eventos.ObstaculoDetectado;

import java.util.ArrayList;

public class InterpretadorDeEventosTeste {


    public static void main(String[] args) {
        PortaoSimples portaoSimples = new PortaoSimples();
        Controle controle = new Controle();
        BotaoPressionado botaoPressionado = new BotaoPressionado();
        ObstaculoDetectado obstaculoDetectado = new ObstaculoDetectado();
        NenhumEvento nenhumEvento = new NenhumEvento();
//        executarEvento(portaoSimples, botaoPressionado, "", nenhumEvento, obstaculoDetectado);
        MotorPortao executarTeste = new MotorPortao();
        System.out.println(executarTeste.executarEvento("p.....o", botaoPressionado, portaoSimples, nenhumEvento, obstaculoDetectado));
    }

    private static void executarEvento(PortaoSimples portaoSimples, BotaoPressionado botaoPressionado, String comando, NenhumEvento nenhumEvento, ObstaculoDetectado obstaculoDetectado) {
        ArrayList<String> evento = new ArrayList<String>();
        for (int i = 0; i < comando.length(); i++) {
            evento.add(comando.substring(i, i + 1));
        }

        for (int i = 0; i < evento.size(); i++) {
            if ("p".equals(evento.get(i))) {
                botaoPressionado.botaoPressionado(portaoSimples);
            } else if (".".equals(evento.get(i))) {
                nenhumEvento.nenhumEvento(portaoSimples);
            } else if ("o".equals(evento.get(i))) {
                obstaculoDetectado.obstaculoDetectado(portaoSimples);
            }
        }
    }
}
