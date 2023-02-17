/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author roban
 */
public interface ClasificadorInterface {
    
    // comportamientos base
    public void entrenar(ArrayList<Patron> aux);
    // claisifica 1 patron "desconocido"
    public void clasificar(Patron aux);
    
}
