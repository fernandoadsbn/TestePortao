package br.com.testeportao.entidades.eventos;

import br.com.testeportao.entidades.controle.Controle;
import br.com.testeportao.entidades.controle.impl.ControleSimples;
import br.com.testeportao.entidades.eventos.util.EventoOcorridoEnum;
import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;
import br.com.testeportao.entidades.portao.impl.PortaoSimples;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static br.com.testeportao.entidades.eventos.InterpretadorEventoParaControle.interpretarExecutarEvento;
import static br.com.testeportao.entidades.eventos.util.EventoOcorridoEnum.BOTAO_PRESSIONADO;
import static br.com.testeportao.entidades.eventos.util.EventoOcorridoEnum.EVENTO_OBSTACULO;
import static br.com.testeportao.entidades.eventos.util.EventoOcorridoEnum.NENHUM_EVENTO;
import static br.com.testeportao.entidades.portao.StatusPortaoEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

/**
 * Teste unitário para a classe {@link InterpretadorEventoParaControle}.
 *
 * @author Bruno Cattany
 * @since 02/09/2018
 */
class InterpretadorEventoParaControleTest {

  /**
   * Neste teste, haverá apenas um portão sobre controle.
   */
  private static Portao PORTAO = new PortaoSimples(FECHADO, true);
  /**
   * Neste teste, haverá apenas um controle.
   */
  private static Controle CONTROLE = new ControleSimples(PORTAO);

  @ParameterizedTest(name =  "Ocorre evento: {0} e o portão está: {1}")
  @DisplayName("Testes parametrizados - Teste 01")
  @MethodSource("retornarCenario01")
  void parameterizedTest(EventoOcorridoEnum eventoOcorridoEnum, StatusPortaoEnum statusPortaoEnum) {
    assertEquals(statusPortaoEnum, interpretarExecutarEvento(eventoOcorridoEnum, CONTROLE));
  }

  @ParameterizedTest(name =  "Ocorre evento: {0} e o portão está: {1}")
  @DisplayName("Testes parametrizados - Teste 02")
  @MethodSource("retornarCenarioExercitandoObstaculo")
  void parameterizedTest2(EventoOcorridoEnum eventoOcorridoEnum, StatusPortaoEnum statusPortaoEnum) {
    assertEquals(statusPortaoEnum, interpretarExecutarEvento(eventoOcorridoEnum, CONTROLE));
  }

  @ParameterizedTest(name =  "Ocorre evento: {0} e o portão está: {1}")
  @DisplayName("Testes parametrizados - Teste 03")
  @MethodSource("retornarCenarioExercitandoEventoObstaculoPausadoEDispausado")
  void parameterizedTest3(EventoOcorridoEnum eventoOcorridoEnum, StatusPortaoEnum statusPortaoEnum) {
    assertEquals(statusPortaoEnum, interpretarExecutarEvento(eventoOcorridoEnum, CONTROLE));
  }

  private static Collection<Arguments> retornarCenario01() {
    PORTAO = new PortaoSimples(FECHADO, true);
    CONTROLE = new ControleSimples(PORTAO);

    return Arrays.asList(
        of(NENHUM_EVENTO, FECHADO),
        of(NENHUM_EVENTO, FECHADO),
        of(BOTAO_PRESSIONADO, QUASE_FECHADO),
        of(BOTAO_PRESSIONADO, QUASE_FECHADO),
        of(BOTAO_PRESSIONADO, ABRINDO),
        of(NENHUM_EVENTO, MEIO_ABERTO),
        of(NENHUM_EVENTO, QUASE_TODO_ABERTO)
    );
  }

  private static Collection<Arguments> retornarCenarioExercitandoObstaculo() {
    PORTAO = new PortaoSimples(FECHADO, true);
    CONTROLE = new ControleSimples(PORTAO);

    return Arrays.asList(
        of(NENHUM_EVENTO, FECHADO),
        of(BOTAO_PRESSIONADO, QUASE_FECHADO),
        of(NENHUM_EVENTO, ABRINDO),
        of(NENHUM_EVENTO, MEIO_ABERTO),
        of(NENHUM_EVENTO, QUASE_TODO_ABERTO),
        of(NENHUM_EVENTO, ABERTA),
        of(NENHUM_EVENTO, ABERTA),
        of(BOTAO_PRESSIONADO, QUASE_TODO_ABERTO),
        of(NENHUM_EVENTO, MEIO_ABERTO),
        of(NENHUM_EVENTO, ABRINDO),
        of(NENHUM_EVENTO, QUASE_FECHADO),
        of(NENHUM_EVENTO, FECHADO),
        of(NENHUM_EVENTO, FECHADO),
        of(BOTAO_PRESSIONADO, QUASE_FECHADO)
    );
  }

  private static Collection<Arguments> retornarCenarioExercitandoEventoObstaculoPausadoEDispausado() {
    PORTAO = new PortaoSimples(FECHADO, true);
    CONTROLE = new ControleSimples(PORTAO);

    return Arrays.asList(
        of(NENHUM_EVENTO, FECHADO),
        of(BOTAO_PRESSIONADO, QUASE_FECHADO),
        of(NENHUM_EVENTO, ABRINDO),
        of(NENHUM_EVENTO, MEIO_ABERTO),
        of(EVENTO_OBSTACULO, ABRINDO),
        of(NENHUM_EVENTO, QUASE_FECHADO),
        of(EVENTO_OBSTACULO, ABRINDO),
        of(BOTAO_PRESSIONADO, ABRINDO),
        of(NENHUM_EVENTO, ABRINDO),
        of(NENHUM_EVENTO, ABRINDO),
        of(EVENTO_OBSTACULO, ABRINDO)
    );
  }

  // JUNIT 4
//  @RunWith(Parameterized.class)
//  public class NewEmptyJUnitTest {
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//      return Arrays.asList(new Object[][] {
//          iniciarCasoDeTeste().entrada("001234321000").esperado("..p...o.....").gerarCasoTeste(),
//          iniciarCasoDeTeste().entrada("012345").esperado(".p....").gerarCasoTeste(),
//          iniciarCasoDeTeste().entrada("000122222345").esperado("...p.p...p..").gerarCasoTeste(),
//          iniciarCasoDeTeste().entrada("123210").esperado("p..o..").gerarCasoTeste(),
//          iniciarCasoDeTeste().entrada("123333343210").esperado("p..p...po...").gerarCasoTeste(),
//          iniciarCasoDeTeste().entrada("123432344444555").esperado("p...o.o.p...p..").gerarCasoTeste(),
//          iniciarCasoDeTeste().entrada("123455433332100").esperado("123455433332100").gerarCasoTeste(),
//      });
//    }
//
//    @Parameter
//    public String entrada;
//
//    @Parameter(1) public String esperado;
//
//    private Controle c = new Controle();
//
//    @Test
//    public void execute() {
//      assertEquals(esperado, c.pressionarBotao(entrada));
//      //    assertEquals("001234321000", c.pressionarBotao("..p...o....."));
//      //    assertEquals("012345", c.pressionarBotao(".p...."));
//      //    assertEquals("000122222345", c.pressionarBotao("...p.p...p.."));
//      //    assertEquals("123210", c.pressionarBotao("p..o.."));
//      //    assertEquals("123333343210", c.pressionarBotao("p..p...po..."));
//      //    assertEquals("123432344444555", c.pressionarBotao("p...o.o.p...p.."));
//      //    assertEquals("123455433332100", c.pressionarBotao("p.....p.p..p..."));
//    }
//
//  }

//  public class NewEmptyJUnitTestBuilder {
//
//    private String esperado;
//    private String entrada;
//
//    public static NewEmptyJUnitTestBuilder iniciarCasoDeTeste() {
//      return new NewEmptyJUnitTestBuilder();
//    }
//
//    public NewEmptyJUnitTestBuilder entrada(String value) {
//      entrada = value;
//      return this;
//    }
//
//    public NewEmptyJUnitTestBuilder esperado(String value) {
//      esperado = value;
//      return this;
//    }
//
//    public String[] gerarCasoTeste() {
//      return new String[] {esperado, entrada};
//    }
//
//  }


}