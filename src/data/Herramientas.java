/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author roban
 */
public class Herramientas {
    
    public static double distanciaEuclidiana(Patron a,Patron b){
        double acu = 0;
        for(int x=0; x < a.getVector().length;x++){
            double res = a.getVector()[x] - b.getVector()[x];
            res*=res;
            acu = acu + res;
        }
    return Math.sqrt(acu);
    }

    public static ArrayList<Patron> abrirArchivo(){
        
        String texto, aux;
     LinkedList<String> lista = new LinkedList();
     ArrayList<Patron> patrones = new ArrayList<>();
        try {
            //llamamos el metodo que permite cargar la ventana
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(file);
            //abrimos el archivo seleccionado
            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
                String clase = "";
                for (int i = 0; i < lista.size(); i++) {
                    StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                        lista2.add(st.nextToken());
                    }
                  
                    
                    
                    double[] vector = new double[lista2.size()-1];

                    for (int x = 0; x < lista2.size() - 1; x++) {
                        vector[x] = Double.parseDouble(lista2.get(x));
                    }

                    clase = lista2.get(lista2.size()-1);
                    patrones.add(new Patron(vector, clase));
                    lista2 = new ArrayList<>();

                }
           // 3,4,5,6,clase
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            return null;
        }
       
        return patrones;
    
    
    }

    public static void ordenarDistancias (DistanciaKnn[] distancias){
        DistanciaKnn temp;
        for (int i=1; i<distancias.length; i++){
            for (int j=0 ; j<distancias.length - i; j++){
                    // verificar si se hará el intercambio
                    if (distancias[j].getDistancia() > distancias[j+1].getDistancia()){
                        temp = new DistanciaKnn(distancias[j].getDistancia(),
                                distancias[j].getRefClase());
                        distancias[j] = new DistanciaKnn(distancias[j+1].getDistancia(),
                                distancias[j+1].getRefClase());
                        distancias[j+1] = new DistanciaKnn(temp.getDistancia(),
                                temp.getRefClase());
                    
                    }
            }
        
        }
    
    }


}
