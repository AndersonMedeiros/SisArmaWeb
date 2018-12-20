/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ASUS
 */
public class Equipamento {
 
    private int id;
    private String nome;
    private String serie;
    private String status;
    private int qtd;
    private String obs;
    private Arma arma;
    private Fabricante fabricante;
    private Calibre calibre;
    private Categoria categoria;
    private Equipamento acessorio;
    private String tipo;
    private FuncaoMilitar idarmeiro;
    private FuncaoMilitar idoficialDia;

    public FuncaoMilitar getOficialDia() {
        return idoficialDia;
    }

    public void setOficialDia(FuncaoMilitar oficialDia) {
        this.idoficialDia = oficialDia;
    }

    
    public FuncaoMilitar getArmeiro() {
        return idarmeiro;
    }

    public void setArmeiro(FuncaoMilitar armeiro) {
        this.idarmeiro = armeiro;
    }

    
    
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Equipamento getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Equipamento acessorio) {
        this.acessorio = acessorio;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Calibre getCalibre() {
        return calibre;
    }

    public void setCalibre(Calibre calibre) {
        this.calibre = calibre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
        return arma.toString();
    }

    
    
}
