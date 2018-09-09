package br.com.testeportao.entidades.eventos.impl;

import br.com.testeportao.entidades.eventos.EventoPortao;
import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;

/**
 * DOCME
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
public class EventoBotaoPressionado implements EventoPortao {

  @Override
  public StatusPortaoEnum executarEvento(Portao portao) {
    StatusPortaoEnum statusPortao = portao.getStatus();

    if (statusPortao.isFechado()) {
      portao.abrir();
      return portao.getStatus();
    }

    if (statusPortao.isEmMovimento()) {
      if (portao.isStatusPausado()) {
        portao.continuar();
      } else {
        portao.pausar();
      }

      return portao.getStatus();
    }

    if (statusPortao.isAberto()) {
      portao.fechar();
      return portao.getStatus();
    }

    throw new RuntimeException("Não se conhece o status do portão");
  }
}
