package br.com.testeportao.entidades.eventos.util;

import br.com.testeportao.entidades.controle.Controle;

/**
 * Enumera os evento que pode ocorrer ao clicar no {@link Controle#getBotao()}.
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
public enum EventoOcorridoEnum {

  BOTAO_PRESSIONADO("p", "Botão foi pressionado!"),
  NENHUM_EVENTO(".", "Nenhum evento ocorreu."),
  EVENTO_OBSTACULO("o", "Obstáculo dectado!");

  private final String charEvento;
  private final String descricaoEvento;

  EventoOcorridoEnum(String charEvento, String descricaoEvento) {
    this.charEvento = charEvento;
    this.descricaoEvento = descricaoEvento;
  }

  public String getCharEvento() {
    return charEvento;
  }

  public static EventoOcorridoEnum fromValue(String eventoOcorrido) {
    for (EventoOcorridoEnum c : values()) {
      if (c.charEvento.equalsIgnoreCase(eventoOcorrido)) {
        return c;
      }
    }

    throw new EventoOcorridoEnumDesconhecidoException(eventoOcorrido);
  }

  public String getDescricaoEvento() {
    return descricaoEvento;
  }
}
