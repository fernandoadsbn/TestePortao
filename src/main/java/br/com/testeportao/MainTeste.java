package br.com.testeportao;

import br.com.testeportao.entidades.controle.Controle;
import br.com.testeportao.entidades.controle.impl.ControleSimples;
import br.com.testeportao.entidades.eventos.InterpretadorEventoParaControle;
import br.com.testeportao.entidades.eventos.util.EventoOcorridoEnum;
import br.com.testeportao.entidades.eventos.util.EventoOcorridoEnumDesconhecidoException;
import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;
import br.com.testeportao.entidades.portao.impl.PortaoSimples;

import javax.annotation.Nullable;
import java.util.Scanner;

/**
 * @author Fernando
 * @author Bruno Cattany
 */
public class MainTeste {

  /**
   * Neste programa, haverá apenas um portão sobre controle.
   */
  private static final Portao PORTAO = new PortaoSimples();
  /**
   * Neste programa, haverá apenas um controle.
   */
  private static final Controle CONTROLE = new ControleSimples(PORTAO);
  /**
   * Responsável por capturar as interações do usuário pelo teclado.
   */
  private static final Scanner TECLADO = new Scanner(System.in);

  public static void main(String[] args) {
    interagirComUsuario();
  }

  private static void interagirComUsuario() {
    apresentarInterfaceParaUsuario();
    realizarLoopEnquantoUsuarioNaoSaiDoPrograma();
  }

  private static void realizarLoopEnquantoUsuarioNaoSaiDoPrograma() {
    EventoOcorridoEnum eventoOcorrido = recuperarEventoApartirDaInteracaoUsuario();

    while (eventoOcorrido != null) {
      StatusPortaoEnum statusPortaoDepoisDaInteracao = InterpretadorEventoParaControle
          .interpretarExecutarEvento(eventoOcorrido, CONTROLE);

      printar(statusPortaoDepoisDaInteracao.getStatusConcatenadoDescricao());

      apresentarInterfaceParaUsuario();
      eventoOcorrido = recuperarEventoApartirDaInteracaoUsuario();
    }
  }

  private static void apresentarInterfaceParaUsuario() {
    printar("** Digite o caracter do ocorrido: ** ");
    printar("___________________________________  ");
    printar("| (P ou p) - Botão pressionado.    | ");
    printar("|      (O) - Obstáculo encontrado. | ");
    printar("|      (.) - Nenhum evento.        | ");
    printar("|      (0) - Sair do programa.     | ");
    printar("|__________________________________| ");
  }

  /**
   * @return <b>o evento</b> quando o usuário digitar a opção válida. <br>
   * <b>null</b> quando o usuário deseja sair do programa.
   */
  @Nullable
  private static EventoOcorridoEnum recuperarEventoApartirDaInteracaoUsuario() {
    String valorDigitadoUsuario = TECLADO.next();

    if (verificarSeUsuarioAcionouSaidaDoPrograma(valorDigitadoUsuario)) {
      return null;
    }

    return realizarLoopEnquantoValorDigitadoInvalido(valorDigitadoUsuario);
  }

  /**
   * @return <b>o evento</b> quando o usuário digitar a opção válida. <br>
   * <b>null</b> quando o usuário deseja sair do programa.
   */
  @Nullable
  private static EventoOcorridoEnum realizarLoopEnquantoValorDigitadoInvalido(String valorDigitadoUsuario) {
    EventoOcorridoEnum eventoOcorridoEnum = validarValorDigitado(valorDigitadoUsuario);

    while (eventoOcorridoEnum == null) {
      apresentarInterfaceParaUsuario();
      valorDigitadoUsuario = TECLADO.next();

      if (verificarSeUsuarioAcionouSaidaDoPrograma(valorDigitadoUsuario)) {
        return null;
      }

      eventoOcorridoEnum = validarValorDigitado(valorDigitadoUsuario);
    }

    return eventoOcorridoEnum;
  }

  private static boolean verificarSeUsuarioAcionouSaidaDoPrograma(String valorDigitadoUsuario) {
    boolean isUsuarioRequisitouSaida = valorDigitadoUsuario.trim().equals("0");

    if (isUsuarioRequisitouSaida) {
      printar("Obrigado por usar o programa!");
    }

    return isUsuarioRequisitouSaida;
  }

  @Nullable
  private static EventoOcorridoEnum validarValorDigitado(String valorDigitadoUsuario) {
    if (valorDigitadoUsuario.length() > 1) {
      printar("\nVocê digitou um comando inválido. Por favor, digite apenas 1 caractere.\n");
      return null;
    }

    try {
      return EventoOcorridoEnum.fromValue(valorDigitadoUsuario);
    } catch (EventoOcorridoEnumDesconhecidoException execption) {
      printar("\nVocê digitou um comando inválido!\n");
      return null;
    }
  }

  private static void printar(Object o) {
    System.out.println(o);
  }

}
