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
}
