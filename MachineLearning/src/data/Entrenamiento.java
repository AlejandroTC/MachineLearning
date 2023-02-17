package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import clasificadores.MinimaDistancia;

public class Entrenamiento {
    public static ArrayList<Patron> conjunto;
    
    public static void lectura (){
        MinimaDistancia md = new MinimaDistancia();
        conjunto = new ArrayList<>();
        String texto, aux;
        LinkedList<String> leido = new LinkedList();
        try{
            //Abrir archivo
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File("./"));
            file.showOpenDialog(file);
            File abrir = file.getSelectedFile(); 

            //recorrer el archivo
            if(abrir != null){
                FileReader archivos = new FileReader(abrir);
                BufferedReader leer = new BufferedReader(archivos);

                //leer el archivo y guardar en lista cada linea
                while ((aux = leer.readLine()) != null) {
                    texto = aux;
                    leido.add(texto);
                }
                leer.close();

                //Leer y clasificar
                ArrayList<String> linea = new ArrayList<>();
                String clase = "";
                for (int i=0; i < leido.size(); i++){ //Iterar hasta completar las lineas leidas anteriormente
                    StringTokenizer linealeida = new StringTokenizer(leido.get(i), ",");

                    while (linealeida.hasMoreTokens()){ //mientras se tengan tokens
                        linea.add(linealeida.nextToken());
                    }
                    double[] vector = new double [linea.size() - 1]; 

                    for (int j = 0 ; j < linea.size() -1; j++){
                        vector[j] = Double.parseDouble(linea.get(j)); //se agregan los valores leidos de la linea
                    }

                    clase = linea.get(linea.size() - 1);    //se agrega la clase de la linea leida
                    conjunto.add(new Patron(vector, clase));    //se crea un patron

                    md.entrenar(conjunto);

                    linea.clear();  //se limpia la lista para continuar con la sigueinte linea
                }
                System.out.println();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha"
                    + " encontrado el archivo", "ADVERTENCIA!!!", 
                    JOptionPane.WARNING_MESSAGE );
        } 
    }
    
}