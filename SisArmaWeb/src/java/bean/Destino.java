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
public class Destino {
    
    private int id;
    private String destino;
    private Integer itemDesitno;

    public Integer getItemDesitno() {
        return itemDesitno;
    }

    public void setItemDesitno(Integer itemDesitno) {
        this.itemDesitno = itemDesitno;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return destino;
    }
    
    
}
