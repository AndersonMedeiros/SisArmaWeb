/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Item {

    private int id;
    private int qtd;
    private Date data_cautela;
    private Date data_descautela;
    private String status;
    private String obs;
    private Cautela cautela;
    private Equipamento equipamento;
    private FuncaoMilitar armeiroDescautela;
    private FuncaoMilitar oficialDia;
    private int reserva;
    private int cautelado;
    private int total;

    public int getReserva() {
        return reserva;
    }

    public void setReserva(int reserva) {
        this.reserva = reserva;
    }

    public int getCautelado() {
        return cautelado;
    }

    public void setCautelado(int cautelado) {
        this.cautelado = cautelado;
    }

    public int getTotal() {
        if(total < 0){
            total = total * -1;
        }
        
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
    public FuncaoMilitar getOficialDia() {
        return oficialDia;
    }

    public void setOficialDia(FuncaoMilitar oficialDia) {
        this.oficialDia = oficialDia;
    }
   
    
    
    public FuncaoMilitar getArmeiroDescautela() {
        return armeiroDescautela;
    }

    public void setArmeiroDescautela(FuncaoMilitar armeiroDescautela) {
        this.armeiroDescautela = armeiroDescautela;
    }

    public Date getData_cautela() {
        return data_cautela;
    }

    public void setData_cautela(Date data_cautela) {
        this.data_cautela = data_cautela;
    }

    public Date getData_descautela() {
        return data_descautela;
    }

    public void setData_descautela(Date data_descautela) {
        this.data_descautela = data_descautela;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Cautela getCautela() {
        return cautela;
    }

    public void setCautela(Cautela cautela) {
        this.cautela = cautela;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

}
