/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import com.sun.corba.se.pept.transport.ContactInfoListIterator;
import data.ClasificadorInterface;
import data.ContadorKnn;
import data.DistanciaKnn;
import data.Herramientas;
import data.Patron;
import java.util.ArrayList;

/**
 * 1.- distancia
 * 2.- la construcción de vecinidades
 * 3.- establacer una cantidad fija de
 * vecinidad representativa para poder 
 * realizar la clasificación
 * @author robanac
 */
public class Knn implements ClasificadorInterface{
    ArrayList<Patron> conjuntoEntrenamiento;
    int k;
    public Knn(int k) {
        this.k = k;
    }
        
    @Override
    public void entrenar(ArrayList<Patron> aux) {
        this.conjuntoEntrenamiento = aux;
    }

    @Override
    public void clasificar(Patron aux) {
        DistanciaKnn distancias[] =
                new DistanciaKnn[this.conjuntoEntrenamiento.size()];
        // distancia
        for(int i=0; i < this.conjuntoEntrenamiento.size();i++){
            double d = Herramientas.distanciaEuclidiana(aux,
                    this.conjuntoEntrenamiento.get(i));
            String c = this.conjuntoEntrenamiento.get(i).getClase();
            distancias[i] = new DistanciaKnn(d,c);
           
        }
        // ordenar
        Herramientas.ordenarDistancias(distancias);
        //verificar K (recorriendo las distancias)
        ArrayList<ContadorKnn> contadores = new ArrayList<>();
        int pos;
        for(int i=0;i<distancias.length;i++){
            String clase = distancias[i].getRefClase();
            ContadorKnn c = new ContadorKnn(clase);
            pos = contadores.indexOf(c);        //
            if(pos>=0){
                contadores.get(pos).acumular();
                if(contadores.get(pos).getCantidad()==this.k){
                   // clasificación
                   aux.setClaseResultante(contadores.get(pos).getClase());
                   break;
                }
                
            }else{
                contadores.add(new ContadorKnn(clase));
            }
        }
        System.out.println();
        
    }
    
}
