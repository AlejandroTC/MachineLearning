/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author roban
 */
public class Herramientas {
    
    public static double distanciaEuclidiana(Patron a,Patron b){
        double acu = 0;
        for(int x=0; x < a.getVector().length;x++){
            double res = a.getVector()[x] - b.getVector()[x];
            res*=res;
            acu = acu + res;
        }
    return Math.sqrt(acu);
    }

    public static void ordenarDistancias (DistanciaKnn[] distancias){
        DistanciaKnn temp;
        for (int i=1; i<distancias.length; i++){
            for (int j=0 ; j<distancias.length - i; j++){
                    // verificar si se hará el intercambio
                    if (distancias[j].getDistancia() > distancias[j+1].getDistancia()){
                        temp = new DistanciaKnn(distancias[j].getDistancia(),
                                distancias[j].getRefClase());
                        distancias[j] = new DistanciaKnn(distancias[j+1].getDistancia(),
                                distancias[j+1].getRefClase());
                        distancias[j+1] = new DistanciaKnn(temp.getDistancia(),
                                temp.getRefClase());
                    
                    }
            }
        
        }
    
    }


}
