package entidades.portao;

import enums.DirecaoPortao;
import enums.StatusPortao;

abstract class Portao {

    private int tempo;
    private StatusPortao statusAtualPortao;
    private DirecaoPortao direcaoPortao;

    public Portao(int tempo, StatusPortao statusAtualPortao, DirecaoPortao direcaoPortao) {
        this.tempo = tempo;
        this.statusAtualPortao = statusAtualPortao;
        this.direcaoPortao = direcaoPortao;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public StatusPortao getStatusAtualPortao() {
        return statusAtualPortao;
    }

    public void setStatusAtualPortao(StatusPortao statusAtualPortao) {
        this.statusAtualPortao = statusAtualPortao;
    }

    public DirecaoPortao getDirecaoPortao() {
        return direcaoPortao;
    }

    public void setDirecaoPortao(DirecaoPortao direcaoPortao) {
        this.direcaoPortao = direcaoPortao;
    }

}

