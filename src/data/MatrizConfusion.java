package data;

import java.util.ArrayList;

public class MatrizConfusion {
    
    private double[][] matriz;
    private ArrayList<Patron> instancias;
    private ArrayList<String> clases;

    public MatrizConfusion(ArrayList<Patron> instancias) {
        this.instancias = instancias;
        this.clases = new ArrayList<>();
        this.matriz = null;
        inicializarMatriz();
    }

    private void inicializarMatriz() {
       for(Patron p: this.instancias){
           if(!this.clases.contains(p.getClase())){
                this.clases.add(p.getClase());
           }
       }
       int m = this.clases.size();
       this.matriz = new double[m][m];
       // recorremos las instancias nuevamente
       for(Patron p: this.instancias){
           int r = this.clases.indexOf(p.getClase());
           int c = this.clases.indexOf(p.getClaseResultante()) ;
           this.matriz[r][c]++;
       }
       
      
    }

    @Override
    public String toString() {
        String aux = "";
        for(int r=0;r<this.matriz.length;r++){
            aux+="|";
            for(int c=0;c<this.matriz[0].length;c++){
                aux+=" "+this.matriz[r][c]+",";
            }
            aux+="\n";
        }
        return aux;
    }
    
}