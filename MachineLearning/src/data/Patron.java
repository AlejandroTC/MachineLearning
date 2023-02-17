/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author robanac
 */
public class Patron {
    
    private double [] vector;
    private String clase;

    public Patron(double[] vector, 
            String clase) {
        this.vector = vector;
        this.clase = clase;
    }

    public Patron(int n) {
        this.vector = new double[n];
        this.clase = "Desconocida";
    }

    /**
     * @return the vector
     */
    public double[] getVector() {
        return vector;
    }

    /**
     * @param vector the vector to set
     */
    public void setVector(double[] vector) {
        this.vector = vector;
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
    
    
    
    
    
}
