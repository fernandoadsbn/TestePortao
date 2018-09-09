package br.com.testeportao.entidades.portao;

/**
 * Enumera os status que um portão pode estar.
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
public enum StatusPortaoEnum {

  FECHADO(0, "Portão fechado."),
  QUASE_FECHADO(1, "Portão quase fechado."),
  ABRINDO(2, "Portão semi-aberto."),
  MEIO_ABERTO(3, "Portão aberto pela metade."),
  QUASE_TODO_ABERTO(4, "Portão quase todo aberto."),
  ABERTA(5, "Portão aberto por completo");

  private final int status;
  private final String descricaoStatus;

  StatusPortaoEnum(int status, String descricaoStatus) {
    this.status = status;
    this.descricaoStatus = descricaoStatus;
  }

  public int getStatus() {
    return status;
  }

  public static StatusPortaoEnum fromValue(int status) {
    for (StatusPortaoEnum statusPortaoEnum : values()) {
      if (statusPortaoEnum.status == status) {
        return statusPortaoEnum;
      }
    }

    throw new StatusPortaoEnumDesconhecidoException(status);
  }

  public boolean isEmMovimento() {
    switch (this) {
      case FECHADO:
      case ABERTA:
        return false;

      default:
        return true;
    }
  }

  public StatusPortaoEnum realizarMovimentoParaAbrir() {
    if (this == ABERTA) {
      return ABERTA;
    }

    return fromValue(status + 1);
  }

  public StatusPortaoEnum realizarMovimentoParaFechar() {
    if (this == FECHADO) {
      return FECHADO;
    }

    return fromValue(status - 1);
  }

  public String getDescricaoStatus() {
    return descricaoStatus;
  }

  public String getStatusConcatenadoDescricao() {
    return status + " - " + descricaoStatus;
  }

  public boolean isFechado() {
    return this == FECHADO;
  }

  public boolean isAberto() {
    return this == ABERTA;
  }
}
