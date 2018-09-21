package entidades.portao;

import enums.DirecaoPortao;
import enums.StatusPortao;
import eventos.MotorPortao;
import interfaces.IPortao;

public class PortaoSimples extends Portao implements IPortao {

    public PortaoSimples() {
        super(0, StatusPortao.TOTALMENTE_FECHADO, DirecaoPortao.ABRIR);
    }

    public void abrir() {
        this.setDirecaoPortao(DirecaoPortao.ABRIR);
        this.setStatusAtualPortao(StatusPortao.ABRINDO);
        this.setTempo(this.getTempo() + 1);
        MotorPortao.resultadoTeste.add(String.valueOf(this.getTempo()));
    }

    public void fechar() {
        this.setDirecaoPortao(DirecaoPortao.FECHAR);
        this.setStatusAtualPortao(StatusPortao.FECHANDO);
        this.setTempo(this.getTempo() - 1);
        MotorPortao.resultadoTeste.add(String.valueOf(this.getTempo()));
    }

    public void pausar() {
        this.setStatusAtualPortao(StatusPortao.PARADO);
        MotorPortao.resultadoTeste.add(String.valueOf(this.getTempo()));
    }

    public void despausar() {
        if (this.getDirecaoPortao().portaoAbrindo()) {
            this.abrir();
        } else if (this.getDirecaoPortao().portaoFechando()) {
            this.fechar();
        }
    }


}
