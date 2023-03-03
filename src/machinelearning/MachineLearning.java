package machinelearning;
import java.util.ArrayList;
import clasificadores.Knn;
/*
import clasificadores.MinimaDistancia;
import data.Herramientas;
import data.Patron;
import data.PatronRepresentativo;
import java.util.ArrayList;
import data.Entrenamiento;
*/
import data.Herramientas;
import data.Patron;

public class MachineLearning {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        //Entrenamiento minima distancia con datos especificos
        Patron a = new Patron(new double[]{4,1}, "A");
        Patron a1 = new Patron(new double[]{6,9}, "A");
        Patron a2 = new Patron(new double[]{5.6,9}, "B");
        Patron a3 = new Patron(new double[]{6,9.45}, "B");
        Patron a4 = new Patron(new double[]{23,0.11}, "A");
        Patron a5 = new Patron(new double[]{23,0.11}, "C");
        Patron a6 = new Patron(new double[]{23,0.11}, "F");
        Patron a7 = new Patron(new double[]{23,0.11}, "F");
        //Patron b = new Patron(new double[]{7,8}, "B");
        ArrayList<Patron> lista = new ArrayList<>();
        lista.add(a);
        lista.add(a1);
        lista.add(a2);
        lista.add(a3);
        lista.add(a4);
        lista.add(a5);
        lista.add(a6);
        lista.add(a7);
        
        Entrenamiento.lectura();
        */
        /* //Minima distancia entrenamiento lectura de archivos
        Patron des = new Patron(new double[]{2.34,1.45},"Desconocido");
        MinimaDistancia md = new MinimaDistancia();
        md.entrenar(lista);
        md.clasificar(des);*/

        //Knn entrenamiento
        ArrayList<Patron> setEntrenamiento = Herramientas.abrirArchivo();
        System.out.println();
        Patron des = new Patron(new double[]{2.34,1.45},"Desconocido");
        Knn knn = new Knn(2);
        knn.entrenar(setEntrenamiento);
        knn.clasificar(des);

        //Para Debug
        System.out.println();
    }
}
