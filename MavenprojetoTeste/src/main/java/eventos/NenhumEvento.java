package eventos;

import entidades.portao.PortaoSimples;
import interfaces.INenhumEvento;

public class NenhumEvento implements INenhumEvento {

    public void nenhumEvento(PortaoSimples portaoSimples) {
        portaoSimples.getStatusAtualPortao().portaoFechadoOuAberto(portaoSimples);//Verifica se o portão está totalmente Aberto ou Totalmente Fechado.
        switch (portaoSimples.getStatusAtualPortao()) {
            case ABRINDO:
                portaoSimples.abrir();
                break;
            case FECHANDO:
                portaoSimples.fechar();
                break;
            case PARADO:
                portaoSimples.pausar();
                break;
            case TOTALMENTE_FECHADO:
            case TOTALMENTE_ABERTO:
                portaoSimples.pausar();
                break;
        }
    }
}
