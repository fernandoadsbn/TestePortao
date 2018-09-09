package br.com.testeportao.entidades.botao.impl;

import br.com.testeportao.entidades.botao.Botao;
import br.com.testeportao.entidades.eventos.EventoPortao;
import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;

/**
 * DOCME
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
public class BotaoSimples implements Botao {

  @Override
  public StatusPortaoEnum executarEvento(EventoPortao eventoPortao, Portao portao) {
    return eventoPortao.executarEvento(portao);
  }

}
