package enums;

public enum DirecaoPortao {
    ABRIR,
    FECHAR;

    public boolean portaoAbrindo() {
        return this == ABRIR;
    }

    public boolean portaoFechando() {
        return this == FECHAR;
    }
}