package interfaces;

import entidades.portao.PortaoSimples;
import eventos.BotaoPressionado;

public interface IControle {

    void executarBotaoPressioando(PortaoSimples portaoSimples, BotaoPressionado botaoPressionado);
}
