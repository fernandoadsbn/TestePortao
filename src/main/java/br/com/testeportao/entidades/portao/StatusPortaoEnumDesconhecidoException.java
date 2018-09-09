package br.com.testeportao.entidades.portao;

/**
 * Lançada quando náo se conhece o status que está sendo requisitado.
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
class StatusPortaoEnumDesconhecidoException extends RuntimeException {

  private static final String message = "Status (%s) informado não é conhecido pela enum (%s)";

  StatusPortaoEnumDesconhecidoException(int statusDesconhecido) {
    super(String.format(message, statusDesconhecido, StatusPortaoEnum.class));
  }
}
