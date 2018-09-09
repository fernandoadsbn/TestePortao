package br.com.testeportao.entidades.portao;

import br.com.testeportao.entidades.eventos.EventoPortao;

/**
 * DOCME
 *
 * @author Bruno Cattany
 * @since 02/09/2018
 */
public interface Portao {

  StatusPortaoEnum getStatus();

  void abrir();

  void fechar();

  void pausar();

  void continuar();

  boolean isStatusPausado();

  DirecaoPortao getDirecao();

  StatusPortaoEnum executarEvento(EventoPortao eventoPortao);

}
