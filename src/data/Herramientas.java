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

    public static void ordenarDistancias(ArrayList<Kdistance> distancias){
        Kdistance temp;
        for (int i=1; i<distancias.size(); i++){
            for(int j=0; j< distancias.size() - i; j++){
                if (distancias.get(j).getDistancia() > distancias.get(j+1).getDistancia()){
                    temp = new Kdistance(distancias.get(j).getDistancia(), distancias.get(j).getVecinos());
                    distancias.set(j, new Kdistance(temp.getDistancia(), temp.getVecinos()));
                    distancias.set(j+1, temp);
                }
            }
        }
    }


}
