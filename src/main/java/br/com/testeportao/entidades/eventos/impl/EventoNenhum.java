package br.com.testeportao.entidades.eventos.impl;

import br.com.testeportao.entidades.eventos.EventoPortao;
import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;

/**
 * DOCME
 *
 * @author Bruno Cattany
 * @since 08/09/2018
 */
public class EventoNenhum implements EventoPortao {

  @Override
  public StatusPortaoEnum executarEvento(Portao portao) {
    if (portao.isStatusPausado()) {
      return portao.getStatus();
    } else if (portao.getDirecao().isAbrindo()) {
      portao.abrir();
    } else if (portao.getDirecao().isFechando()) {
      portao.fechar();
    }

    return portao.getStatus();
  }
}
