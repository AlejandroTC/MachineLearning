/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import data.ClasificadorInterface;
import data.Herramientas;
import data.Patron;
import data.PatronRepresentativo;
import java.util.ArrayList;

/**
 * Clasificador que utiliza la distancia como factor de 
 * Clasificación
 * @author roban
 */
public class MinimaDistancia implements ClasificadorInterface{

    ArrayList<PatronRepresentativo> medias;
    
    @Override
    public void entrenar(ArrayList<Patron> aux) {
        // calcular las medias de cada clase
        medias = new ArrayList<>();
        // recorrer la lista de entrenamiento
        for(Patron p: aux){
            // verificar si existe elemento representativo
            if(!existeRepresentativo(medias,p)){
            // tiene que generar el represntativo y acumular
                generarMediaRepresentativa(p, medias);
            }
           
        }
        // iterar las medias
        for(PatronRepresentativo pr: medias)pr.promediar();
       
        }

    private boolean existeRepresentativo(ArrayList<PatronRepresentativo> medias, Patron p) {
        
        // recorrer la medias y verificar si existe alguna con un mismo nombre de clase que "p"
        for(PatronRepresentativo media: medias){
            if (media.getClase().equals(p.getClase())){
                media.acumular(p);
                return true;
            }
        }
        return false;
    }

    private void generarMediaRepresentativa(Patron p,
            ArrayList<PatronRepresentativo> medias) {
        // generar por referencia una media representativa
        PatronRepresentativo aux = new PatronRepresentativo(new double[p.getVector().length],p.getClase());
        aux.acumular(p);
        medias.add(aux);
    }

    @Override
    public void clasificar(Patron aux) {
       // generar una hipotesis
       int i = 0;
       double di =  Herramientas.distanciaEuclidiana(this.medias.get(i),aux);
       for(int x=1; x<this.medias.size();x++){
           double j = Herramientas.distanciaEuclidiana(this.medias.get(x),aux);
           if(j<di){
               di = j;
               i = x;
           }
       
       }
       aux.setClase(this.medias.get(i).getClase());
    }
        

    public void clasificarConjunto (ArrayList<Patron> conjunto){
        //Para cada uno elemento de la coleccion se genera un proceso
        for (Patron aux:conjunto){
            clasificar(aux);
        }
    }
  


}
