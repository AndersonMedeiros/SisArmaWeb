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
public class Cautela {
    
    private int id;
    private Destino destino;
    private Militar militar;
    private FuncaoMilitar funcaomilitar;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Militar getMilitar() {
        return militar;
    }

    public void setMilitar(Militar militar) {
        this.militar = militar;
    }

    public FuncaoMilitar getFuncaomilitar() {
        return funcaomilitar;
    }

    public void setFuncaomilitar(FuncaoMilitar funcaomilitar) {
        this.funcaomilitar = funcaomilitar;
    }
}
