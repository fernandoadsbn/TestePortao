package br.com.testeportao.entidades.controle;

import br.com.testeportao.entidades.portao.StatusPortaoEnum;

/**
 * <h2>
 *   Justificativa:
 * </h2>
 * <p>
 *   Acidentes com a linha de produtos atual resultaram em danos a inúmeros carros,
 *   braços e pernas de pessoas quebradas e vários animais de estimação mortos.
 * </p>
 *
 * @author Bruno Cattany
 * @since 02/09/2018
 */
public interface DetectadorObstaculos {

  /**
   * <hr>
   *
   * <h2>
   *   Ação:
   * </h2>
   * <p>
   *  Para tornar a porta mais segura, ela foi equipada com uma detecção de obstáculos. <br>
   *  Quando a porta detecta um obstáculo, ela deve imediatamente inverter o sentido de seu movimento.
   * </p>
   */
  StatusPortaoEnum inverterMovimentoPortao();
}
