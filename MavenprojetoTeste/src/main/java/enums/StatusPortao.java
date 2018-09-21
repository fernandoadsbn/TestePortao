package enums;

import entidades.portao.PortaoSimples;

public enum StatusPortao {
    TOTALMENTE_FECHADO,
    TOTALMENTE_ABERTO,
    ABRINDO,
    FECHANDO,
    PARADO;

    public boolean isMovimento(PortaoSimples portaoSimples) {
        switch (portaoSimples.getStatusAtualPortao()) {
            case ABRINDO:
            case FECHANDO:
                return true;
            default:
                return false;
        }
    }

    public void portaoFechadoOuAberto(PortaoSimples portaoSimples) {
        switch (portaoSimples.getTempo()) {
            case 5:
                portaoSimples.setStatusAtualPortao(StatusPortao.TOTALMENTE_ABERTO);
                break;
            case 0:
                portaoSimples.setStatusAtualPortao(StatusPortao.TOTALMENTE_FECHADO);
                break;
        }
    }

}
