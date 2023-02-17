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
public class PatronRepresentativo extends Patron {
    
    private int acumulador;
    
    public PatronRepresentativo(double[] vector, String clase) {
        super(vector, clase);
        this.acumulador = 0;
    }

    public PatronRepresentativo(int n) {
        super(n);
        this.acumulador = 0;
    }
    
    public void acumular (Patron aux){
        // recorrer el vector caracteristico para acumular
        for(int x=0; x<super.getVector().length;x++){
            super.getVector()[x]+=aux.getVector()[x];
        }
        this.acumulador++;
    
    }
    
    public void promediar (){
        for(int x=0; x<super.getVector().length;x++){
            super.getVector()[x]/=this.acumulador;
        }
    }
    
    
}
