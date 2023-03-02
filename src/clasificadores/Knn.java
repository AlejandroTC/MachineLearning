package clasificadores;
/*
 * 1.- Distancia para inferencias importantes
 * 2.- La construcción de vecinidades
 * 3.- Establecer una cantidad fija de vecinidad representativa para poder realizar la clasificación
*/
import data.Kdistance;
import data.Patron;
import data.ClasificadorInterface;
import data.Herramientas;
import java.util.ArrayList;

public class Knn implements ClasificadorInterface{
    private ArrayList<Patron> instancias;
    private ArrayList<String> clases;
    private int k;

    public Knn(int k) {     //Constructor
        this.k = k;
        this.clases = new ArrayList<>();
    }

    @Override
    public void entrenar(ArrayList<Patron> instancias) {    //Almacenar lista y clase de patrones
        this.instancias = instancias;
        this.clases = obtenerClases(instancias);
    }

    @Override
    public void clasificar(Patron patron) {     //Clasificación del patrón
        ArrayList<Kdistance> vecinos = new ArrayList<>();
        for (Patron aux : this.instancias) {
            String clase = aux.getClase();
            double dist = Herramientas.distanciaEuclidiana(patron, aux);
            if (dist != 0) {
                vecinos.add(new Kdistance(dist, clase));
            }
        }
        Herramientas.ordenarDistancias(vecinos);
        String resultado = verificarVecindades(vecinos);
        patron.setClaseResultante(resultado);
    }

    private ArrayList<String> obtenerClases(ArrayList<Patron> instancias) {
        ArrayList<String> clases = new ArrayList<>();
        for (Patron patron : instancias) {
            String clase = patron.getClase();
            if (!clases.contains(clase)) {
                clases.add(clase);
            }
        }
        return clases;
    }

    private String verificarVecindades(ArrayList<Kdistance> vecinos) {
        int[] contadores = new int[this.clases.size()];
        for (Kdistance aux : vecinos) {
            String clase = aux.getVecinos();
            int i = this.clases.indexOf(clase);
            contadores[i]++;
            if (contadores[i] == this.k) {
                return this.clases.get(i);
            }
        }
        return "Desconocida";
    }
}