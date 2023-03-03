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
public class DistanciaKnn {
    private double distancia;
    private String refClase;

    public DistanciaKnn(double distancia, String refClase) {
        this.distancia = distancia;
        this.refClase = refClase;
    }

    /**
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * @return the refClase
     */
    public String getRefClase() {
        return refClase;
    }
    
    
    
    
    
}
