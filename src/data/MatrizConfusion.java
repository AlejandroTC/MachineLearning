package data;

import java.util.ArrayList;

public class MatrizConfusion {
    
    private double[][] matriz;
    private ArrayList<Patron> conjunto;
    private ArrayList<String> clases;
    private double precision[][];
    private double exactitud;

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
       calcularexatitud();
       calcularprecision();
    }
    
    private void calcularexatitud(){
        int m = this.clases.size();
        double total = 0;//Suma
        double verdaderos = 0;//Suma
        for(int i=0; i<m;i++){
            for(int j=0; j<m;j++){
                //verdaderos
                if(i == j){
                    verdaderos += this.matriz[i][j]; 
                }
                total += this.matriz[i][j];
            }   
        }
        exactitud = verdaderos/total;
        System.out.println();
    }
    private void calcularprecision(){
        int m = this.clases.size();
        double todo = 0;//Suma
        double verdad = 0;//Suma
        precision = new double[m][1];
        for(int i=0; i<m;i++){
            for(int j=0; j<m;j++){
                //verdaderos
                if(i == j){
                    verdad = this.matriz[i][j]; 
                }
                todo += this.matriz[i][j];
            }   
            precision[i][0] = verdad /todo;
            todo = 0;
        }
        System.out.println();
    }
}