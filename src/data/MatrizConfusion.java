package data;

import java.util.ArrayList;

public class MatrizConfusion {
    
    private double[][] matriz;
    private ArrayList<Patron> conjunto;
    private ArrayList<String> clases;

    public MatrizConfusion(ArrayList<Patron> conjunto) {
        this.conjunto = conjunto;
        this.clases = new ArrayList<>();
        this.matriz = null;
        System.out.println();
        inicializarMatriz();
    }

    private void inicializarMatriz() {
       for(Patron p: this.conjunto){
           if(!this.clases.contains(p.getClase())){
                this.clases.add(p.getClase());
           }
       }
       int m = this.clases.size();
       this.matriz = new double[m][m];
       // recorremos las conjunto nuevamente
       for(Patron p: this.conjunto){
           int r = this.clases.indexOf(p.getClase());
           int c = this.clases.indexOf(p.getClaseResultante()) ;
           this.matriz[r][c]++;
       }
       System.out.println();
    }
    
}