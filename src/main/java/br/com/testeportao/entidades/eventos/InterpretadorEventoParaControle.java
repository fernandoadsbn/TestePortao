package br.com.testeportao.entidades.eventos;

import br.com.testeportao.entidades.controle.Controle;
import br.com.testeportao.entidades.controle.DetectadorObstaculos;
import br.com.testeportao.entidades.controle.impl.ControleSimples;
import br.com.testeportao.entidades.eventos.impl.EventoNenhum;
import br.com.testeportao.entidades.eventos.util.EventoOcorridoEnum;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;
import br.com.testeportao.general.AcidenteException;

/**
 * Possui a responsabilidade de interpretrar um {@link EventoOcorridoEnum} e realizar o correto acionamento de um {@link Controle}.
 *
 * @author Bruno Cattany
 * @since 02/09/2018
 */
public class InterpretadorEventoParaControle {

  public static StatusPortaoEnum interpretarExecutarEvento(EventoOcorridoEnum eventoOcorrido, Controle controle) {
    switch (eventoOcorrido) {
      case BOTAO_PRESSIONADO:
        return controle.acionarBotao();

      case NENHUM_EVENTO:
        return controle.getPortao().executarEvento(new EventoNenhum());

      case EVENTO_OBSTACULO:
        if (controle.getPortao() instanceof DetectadorObstaculos) {
          return ((DetectadorObstaculos) controle.getPortao()).inverterMovimentoPortao();
        }

        throw new AcidenteException();
    }

    throw new InterpretadorEventoParaControleDesconhecidoException(eventoOcorrido);
  }

}
