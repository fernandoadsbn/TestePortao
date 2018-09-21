package eventos;

import entidades.portao.PortaoSimples;
import interfaces.IObstaculoDetectado;

public class ObstaculoDetectado implements IObstaculoDetectado {


    public void obstaculoDetectado(PortaoSimples portaoSimples) {
        switch (portaoSimples.getStatusAtualPortao()) {
            case TOTALMENTE_ABERTO:
            case ABRINDO:
                portaoSimples.fechar();
                break;
            case TOTALMENTE_FECHADO:
            case FECHANDO:
                portaoSimples.abrir();
                break;
            case PARADO:
                portaoSimples.despausar();
                break;
        }
    }
}
