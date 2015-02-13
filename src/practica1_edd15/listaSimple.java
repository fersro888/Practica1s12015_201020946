/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1_edd15;

/**
 *
 * @author Destroy the time
 */
public class listaSimple {
    
    Nodo cabezaJugador;
    
    public listaSimple()
    {
    
    }
    
    public Nodo crearJugador(String nombreJugador, String tipoPersonaje, int cantPersonajes) //crear el primer jugador nodo
    {
            Nodo jugador=new Nodo(nombreJugador, tipoPersonaje,cantPersonajes);
            jugador.setNombreJugador(nombreJugador);
            jugador.setTipoPersonaje(tipoPersonaje);
            jugador.setCantidadPersonajes(cantPersonajes);
            jugador.setSiguiente(null);
            this.cabezaJugador=jugador;
            return jugador;
    }
    
    public void insertarInfoJugador(Nodo jugador, String info) //insertar información adicional del jugador
    {
     
            jugador=new Nodo(info);
            jugador.setInfoAdicional(info);
            jugador.setSiguiente(null);
            this.cabezaJugador=jugador;
   
    }
    
    public void recorrerLista(Nodo jugador)
    {
        
        while(jugador!=null)
        {
            //System.out.println("Jugador de:\t"+jugador.getNombreJugador());//imprimir los datos, aquí archivo .DOT
            recorrerLista(jugador.getSiguiente());
        }
        
    }
    
    
}
