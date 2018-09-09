/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testeportao.entidades.portao.impl;

import br.com.testeportao.entidades.controle.DetectadorObstaculos;
import br.com.testeportao.entidades.eventos.EventoPortao;
import br.com.testeportao.entidades.portao.DirecaoPortao;
import br.com.testeportao.entidades.portao.Portao;
import br.com.testeportao.entidades.portao.StatusPortaoEnum;

/**
 * @author Fernando
 * @author Bruno Cattany
 */
public class PortaoSimples implements Portao, DetectadorObstaculos {

  private StatusPortaoEnum status = StatusPortaoEnum.FECHADO;
  private boolean statusPausado;
  private DirecaoPortao direcaoPortao;

  public PortaoSimples() {
  }

  public PortaoSimples(StatusPortaoEnum status, boolean statusPausado) {
    this.status = status;
    this.statusPausado = statusPausado;
  }

  public StatusPortaoEnum getStatus() {
    return status;
  }

  public void abrir() {
    status = status.realizarMovimentoParaAbrir();
    statusPausado = false;
    direcaoPortao = DirecaoPortao.ABRINDO;
  }

  @Override
  public void fechar() {
    status = status.realizarMovimentoParaFechar();
    statusPausado = false;
    direcaoPortao = DirecaoPortao.FECHANDO;
  }

  @Override
  public void pausar() {
    statusPausado = true;
  }

  @Override
  public void continuar() {
    statusPausado = false;
    abrir();
  }

  public boolean isStatusPausado() {
    return statusPausado;
  }

  @Override
  public DirecaoPortao getDirecao() {
    return direcaoPortao;
  }

  @Override
  public StatusPortaoEnum executarEvento(EventoPortao eventoPortao) {
    return eventoPortao.executarEvento(this);
  }

  @Override
  public StatusPortaoEnum inverterMovimentoPortao() {
    if (isStatusPausado()) {
      return getStatus();
    }

    if (getDirecao().isAbrindo()) {
      fechar();
    } else if (getDirecao().isFechando()) {
      abrir();
    }

    return getStatus();
  }
}
