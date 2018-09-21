package entidades.controle;

import entidades.portao.PortaoSimples;
import eventos.BotaoPressionado;
import interfaces.IControle;

public class Controle implements IControle {


    public Controle() {
    }

    public void executarBotaoPressioando(PortaoSimples portaoSimples, BotaoPressionado botaoPressionado) {
        botaoPressionado.botaoPressionado(portaoSimples);
    }

}