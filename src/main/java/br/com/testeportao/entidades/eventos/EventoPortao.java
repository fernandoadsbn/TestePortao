package br.com.testeportao.entidades.eventos;

import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;

/**
 * Inteface de marcação. REVIEW
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
public interface EventoPortao {

  StatusPortaoEnum executarEvento(Portao portao);
}
