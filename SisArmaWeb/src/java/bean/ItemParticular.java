/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class ItemParticular {
   
    private int id;
    private Equipamento equipamento;
    private FuncaoMilitar armeiro;
    private Militar militar;
    private String situacao;
    private Date dataentrada;
    private Date datasaida;
    private Militar responsavelEntrada;
    private Militar responsavelSaida;
    private Militar armeiroEntrada;
    private Militar armeiroSaida;

    public Militar getResponsavelEntrada() {
        return responsavelEntrada;
    }

    public void setResponsavelEntrada(Militar responsavelEntrada) {
        this.responsavelEntrada = responsavelEntrada;
    }

    public Militar getResponsavelSaida() {
        return responsavelSaida;
    }

    public void setResponsavelSaida(Militar responsavelSaida) {
        this.responsavelSaida = responsavelSaida;
    }

    public Militar getArmeiroEntrada() {
        return armeiroEntrada;
    }

    public void setArmeiroEntrada(Militar armeiroEntrada) {
        this.armeiroEntrada = armeiroEntrada;
    }

    public Militar getArmeiroSaida() {
        return armeiroSaida;
    }

    public void setArmeiroSaida(Militar armeiroSaida) {
        this.armeiroSaida = armeiroSaida;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public FuncaoMilitar getArmeiro() {
        return armeiro;
    }

    public void setArmeiro(FuncaoMilitar armeiro) {
        this.armeiro = armeiro;
    }

    public Militar getMilitar() {
        return militar;
    }

    public void setMilitar(Militar militar) {
        this.militar = militar;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }
    
    
    
}
