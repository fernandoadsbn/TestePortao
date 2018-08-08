/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Fernando
 */
public class Controle {

    private int qtdClicksP;
    private ArrayList<String> comando = new ArrayList<>();
    public ArrayList<Integer> resultado = new ArrayList<>();
    public static String result;
    private int qtdClicksO;
    Portao portao = new Portao();

    public Controle() {
        portao.setTime(0);
    }

    public int getQtdClicksP() {
        return qtdClicksP;
    }

    public void setQtdClicksP(int qtdClicksP) {
        this.qtdClicksP = qtdClicksP;
    }

    public int getQtdClicksO() {
        return qtdClicksO;
    }

    public void setQtdClicksO(int qtdClicksO) {
        this.qtdClicksO = qtdClicksO;
    }

    public ArrayList<String> getComando() {
        return comando;
    }

    public void setComando(ArrayList<String> comando) {
        this.comando = comando;
    }

    public String execute(String op) {
        for (int i = 0; i < op.length(); i++) {
            comando.add(op.substring(i, i + 1));
        }
        for (int i = 0; i < comando.size(); i++) {
            switch (comando.get(i)) {
                case "p":
                    resultado.add(eventoP());
                    break;
                case "o":
                    resultado.add(eventoObs());
                    break;
                case ".":
                    resultado.add(eventoPonto());
                    break;
            }
        }
        result = resultado.toString().replaceAll("[^0-9A-Za-z]", "");
        return result;
    }

    public int eventoP() {
        qtdClicksP = qtdClicksP + 1;
        if (qtdClicksP == 1) {
            portao.setStatus("Abrindo");
        } else if (qtdClicksP == 2) {
            portao.setStatus("Parado");
        } else if (qtdClicksP == 6) {
            portao.setStatus("Parado");

        } else if (qtdClicksP == 7) {
            portao.setStatus("Fechando");
        } else {
            portao.setStatus("Abrindo");
            qtdClicksP = 1;
        }
        if (portao.getTime() < 5) {
            switch (portao.getStatus()) {
                case "Abrindo":
                    portao.setTime(portao.getTime() + 1);
                    portao.setStatus("Abrindo");
                    break;
                case "Parado":
                    portao.setStatus("Parado");
                    break;
                case "Fechando":
                    portao.setTime(portao.getTime() - 1);
                    portao.setStatus("Fechando");
                    break;
                default:
                    qtdClicksP = 1;
                    portao.setTime(portao.getTime() + 1);
                    portao.setStatus("Abrindo");
                    break;
            }
        } else {
            portao.setTime(portao.getTime() - 1);
            qtdClicksP = 5;
            portao.setStatus("Fechando");
        }
        return portao.getTime();
    }

    public int eventoObs() {
        if (portao.getTime() > 0) {
            qtdClicksO = qtdClicksO + 1;
            switch (qtdClicksO) {
                case 1:
                    portao.setTime(portao.getTime() - 1);
                    portao.setStatus("Obstaculo");
                    break;
                case 2:
                    portao.setTime(portao.getTime() + 1);
                    portao.setStatus("Abrindo");
                    qtdClicksP = 1;
                    break;
            }
        } else {
            System.out.println("Comando Invalido.");
        }
        return portao.getTime();
    }

    public int eventoPonto() {
        if (portao.getTime() > 0 && portao.getTime() < 5) {
            if (portao.getStatus().equalsIgnoreCase("Abrindo")) {
                portao.setTime(portao.getTime() + 1);
            } else if (portao.getStatus().equalsIgnoreCase("Parado")) {
                portao.setTime(portao.getTime());
            } else {
                portao.setTime(portao.getTime() - 1);
            }
        }
        return portao.getTime();
    }

}
