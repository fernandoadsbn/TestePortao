package eventos;

import entidades.portao.PortaoSimples;
import interfaces.IBotaoPressionado;

public class BotaoPressionado implements IBotaoPressionado {

    public void botaoPressionado(PortaoSimples portaoSimples) {
        portaoSimples.getStatusAtualPortao().portaoFechadoOuAberto(portaoSimples);
        if (portaoSimples.getStatusAtualPortao().isMovimento(portaoSimples)) {
            portaoSimples.pausar();
        } else {
            switch (portaoSimples.getStatusAtualPortao()) {
                case ABRINDO:
                    portaoSimples.abrir();
                    break;
                case FECHANDO:
                    portaoSimples.fechar();
                    break;
                case TOTALMENTE_FECHADO:
                    portaoSimples.abrir();
                    break;
                case TOTALMENTE_ABERTO:
                    portaoSimples.fechar();
                    break;
                case PARADO:
                    portaoSimples.despausar();
                    break;
            }
        }
    }
}
