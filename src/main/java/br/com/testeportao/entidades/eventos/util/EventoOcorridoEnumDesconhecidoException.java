package br.com.testeportao.entidades.eventos.util;

/**
 * Lançada quando náo se conhece o evento que está sendo requisitado.
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
public class EventoOcorridoEnumDesconhecidoException extends RuntimeException {

  private static final String message = "EventoPortao (%s) informado não é conhecido pela enum (%s)";

  EventoOcorridoEnumDesconhecidoException(String eventoOcorrido) {
    super(String.format(message, eventoOcorrido, EventoOcorridoEnum.class));
  }
}




