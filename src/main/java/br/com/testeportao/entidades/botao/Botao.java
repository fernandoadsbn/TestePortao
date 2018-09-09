package br.com.testeportao.entidades.botao;

import br.com.testeportao.entidades.eventos.EventoPortao;
import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;

/**
 * DOCME
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
public interface Botao {

  StatusPortaoEnum executarEvento(EventoPortao eventoPortao, Portao portao);

}
