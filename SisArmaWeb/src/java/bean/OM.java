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
public class OM {

    private int id;
    private String om;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOm() {
        return om;
    }

    public void setOm(String om) {
        this.om = om;
    }
    
    @Override
    public String toString() {
        return om;
    }
    
   }
