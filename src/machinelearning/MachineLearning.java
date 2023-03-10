/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machinelearning;


import clasificadores.MinimaDistancia;
import data.Herramientas;
import data.Patron;
import data.PatronRepresentativo;
import java.util.ArrayList;

import data.Entrenamiento;


/**
 *
 * @author roban
 */
public class MachineLearning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        Patron a = new Patron(new double[]{4,1}, "A");
        Patron a1 = new Patron(new double[]{6,9}, "A");
        Patron a2 = new Patron(new double[]{5.6,9}, "B");
        Patron a3 = new Patron(new double[]{6,9.45}, "B");
        Patron a4 = new Patron(new double[]{23,0.11}, "A");
        Patron a5 = new Patron(new double[]{23,0.11}, "C");
        Patron a6 = new Patron(new double[]{23,0.11}, "F");
        Patron a7 = new Patron(new double[]{23,0.11}, "F");
        //Patron b = new Patron(new double[]{7,8}, "B");
        
        lista.add(a);
        lista.add(a1);
        lista.add(a2);
        lista.add(a3);
        lista.add(a4);
        lista.add(a5);
        lista.add(a6);
        lista.add(a7);
        */
        Entrenamiento.lectura();
        Patron des = new Patron(new double[]{2.34,1.45},"Desconocido");
        MinimaDistancia md = new MinimaDistancia();
        
        md.clasificar(des);
        System.out.println();
    }
    
}
