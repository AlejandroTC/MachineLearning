/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author roban
 */
public class ContadorKnn {
    private int cantidad;
    private String clase;

    public ContadorKnn() {
        this.cantidad = 0;
        this.clase = "";
    }

    public ContadorKnn(String clase) {
        this.cantidad = 1;
        this.clase = clase;
    }
    
    
    public void acumular(){
        this.cantidad++;
    }
    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public boolean equals(Object o) {
        
        return this.clase.equals(o); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
