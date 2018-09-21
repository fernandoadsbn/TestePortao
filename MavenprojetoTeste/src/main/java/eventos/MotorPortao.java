package eventos;

import entidades.portao.PortaoSimples;

import java.util.ArrayList;

public class MotorPortao {

    public ArrayList<String> getEvento() {
        return evento;
    }

    public void setEvento(ArrayList<String> evento) {
        this.evento = evento;
    }

    public static ArrayList<String> getResultadoTeste() {
        return resultadoTeste;
    }

    public static void setResultadoTeste(ArrayList<String> resultadoTeste) {
        MotorPortao.resultadoTeste = resultadoTeste;
    }

    private ArrayList<String> evento = new ArrayList<String>();
    public static ArrayList<String> resultadoTeste = new ArrayList<String>();

    public void separarStringEvento(String comandoParaRefatorar) {
        for (int i = 0; i < comandoParaRefatorar.length(); i++) {
            evento.add(comandoParaRefatorar.substring(i, i + 1));
        }
    }

    public String executarEvento(String comando, BotaoPressionado botaoPressionado, PortaoSimples portaoSimples, NenhumEvento nenhumEvento, ObstaculoDetectado obstaculoDetectado) {
        String resultadoSemCaracterEspeciais;
        separarStringEvento(comando);
        for (int i = 0; i < evento.size(); i++) {
            if ("p".equals(evento.get(i))) {
                botaoPressionado.botaoPressionado(portaoSimples);
            } else if (".".equals(evento.get(i))) {
                nenhumEvento.nenhumEvento(portaoSimples);
            } else if ("o".equals(evento.get(i))) {
                obstaculoDetectado.obstaculoDetectado(portaoSimples);
            }
        }
        resultadoSemCaracterEspeciais = resultadoTeste.toString();
        return resultadoSemCaracterEspeciais.replaceAll("[^0-9A-Za-z]", "");
    }


}
