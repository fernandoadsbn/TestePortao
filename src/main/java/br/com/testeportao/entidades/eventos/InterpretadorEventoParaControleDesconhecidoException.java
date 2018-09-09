package br.com.testeportao.entidades.eventos;

import br.com.testeportao.entidades.eventos.util.EventoOcorridoEnum;

/**
 * Lançada quando náo se conhece a interpretação para o evento em questão.
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
class InterpretadorEventoParaControleDesconhecidoException extends RuntimeException {

  private static final String message = "Não é possível interpretrar o evento (%s) informado não é conhecido pela classe (%s)";

  InterpretadorEventoParaControleDesconhecidoException(EventoOcorridoEnum eventoOcorrido) {
    super(String.format(message, eventoOcorrido, InterpretadorEventoParaControle.class));
  }
}