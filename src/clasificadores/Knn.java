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
    public void clasificar(Patron patron) {     //Clasificacion del patron
        ArrayList<Kdistance> vecinos = vecinos(patron);
        String resultado = this.clases.get(0); // Se toma la primera clase como default
        int maxVecinos = 0;
        for (int i = 0; i < this.clases.size(); i++) {
            int contadores = 0;
            for (Kdistance aux : vecinos) {
                if (aux.getVecinos().equals(this.clases.get(i))) {
                    contadores++;
                }
            }
            if (contadores > maxVecinos) {
                maxVecinos = contadores;
                resultado = this.clases.get(i);
            }
        }
        patron.setClaseResultante(resultado);
    }

    public void clasificaConjunto(ArrayList<Patron> instancias) {
        int total = instancias.size();
        int correctas = 0;
        for (Patron patron : instancias) {
            clasificar(patron);
            if (patron.getClaseResultante().equals(patron.getClase())) {
                correctas++;
            }
        }
        double eficacia = correctas * 100 / total;
        System.out.println("Eficacia: " + eficacia + "%");
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

    private ArrayList<Kdistance> vecinos(Patron patron) {
        ArrayList<Kdistance> vecinos = new ArrayList<>();
        for (Patron aux : this.instancias) {
            String clase = aux.getClase();
            double dist = Herramientas.distanciaEuclidiana(patron, aux);
            if (dist != 0) {
                vecinos.add(new Kdistance(dist, clase));
            }
        }
        return vecinos;
    }
}
