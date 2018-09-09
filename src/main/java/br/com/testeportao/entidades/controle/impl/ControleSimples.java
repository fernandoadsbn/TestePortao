package br.com.testeportao.entidades.controle.impl;

import br.com.testeportao.entidades.botao.Botao;
import br.com.testeportao.entidades.botao.impl.BotaoSimples;
import br.com.testeportao.entidades.controle.Controle;
import br.com.testeportao.entidades.controle.DetectadorObstaculos;
import br.com.testeportao.entidades.eventos.impl.EventoBotaoPressionado;
import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;

/**
 * @author Fernando
 * @author B. Cattany
 */
public class ControleSimples implements Controle {

  /**
   * Este controle possui apenas um botão.
   */
  private final Botao botao = new BotaoSimples();
  /**
   * Este controle possui conexão com apenas um portão.
   */
  private final Portao portao;

  public ControleSimples(Portao portao) {
    this.portao = portao;
  }

  @Override
  public StatusPortaoEnum acionarBotao() {
    return botao.executarEvento(new EventoBotaoPressionado(), portao);
  }

  @Override
  public Portao getPortao() {
    return portao;
  }

}
