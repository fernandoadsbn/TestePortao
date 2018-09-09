package br.com.testeportao.entidades.controle;

import br.com.testeportao.entidades.botao.Botao;
import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;
import br.com.testeportao.entidades.portao.impl.PortaoSimples;

/**
 * Representa um Controle, possuindo a única responsabilidade de retornar as interfaces:
 * <ul>
 * <li>{@link Botao}</li>
 * <li>{@link PortaoSimples}</li>
 * </ul>
 *
 * @author Bruno Cattany
 * @since 01/09/2018
 */
public interface Controle {

  /**
   * DOCME
   *
   * @return
   */
  StatusPortaoEnum acionarBotao();

  /**
   * DOCME
   *
   * @return
   */
  Portao getPortao();
}
