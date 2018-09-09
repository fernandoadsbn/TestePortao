package br.com.testeportao.entidades.portao;

/**
 * DOCME
 *
 * @author Bruno Cattany
 * @since 08/09/2018
 */
public enum DirecaoPortao {
  ABRINDO,
  FECHANDO;

  public boolean isAbrindo() {
    return this == ABRINDO;
  }

  public boolean isFechando() {
    return this == FECHANDO;
  }
}
