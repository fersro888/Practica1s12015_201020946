/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1_edd15;

import javax.swing.ImageIcon;

/**
 *
 * @author Destroy the time
 */
public class Nodo {
    //************************************************CREACIÓN DE JUGADORES
    private Nodo siguiente;
    private Nodo siguienteIA;
    private String nombreJugador;
    private String tipoPersonaje;
    private int cantidadPersonajes;
    private String infoAdicional;
    private ImageIcon imagenes;
    //*************************************************CREACIÓN DE PLANTAS Y ZOMBIES
    private String imagen;
    private int Puntos;
    private int Ataque;
    private int Defensa;
    //*************************************************MATRIZ ORTOGONAL
    private Nodo apuntadorSiguiente;
    private Nodo apuntadorAnterior;
    private Nodo apuntadorArriba;
    private Nodo apuntadorAbajo;
    private int fila, columna;
    
     public Nodo()
     {
         
     }
     
     public Nodo(int fila, int columna)
     {
         this.fila=fila;
         this.columna=columna;
     }
     
     public Nodo(String nombreJugador, String tipo, int cantidadPersonajes) //nombre del jugador y el tipo de jugador [plantas ó zombies]
    {
        this.nombreJugador=nombreJugador;
        if(tipo.equalsIgnoreCase("zombies"))
        {
            this.tipoPersonaje=tipo;
            this.cantidadPersonajes=cantidadPersonajes;
            
        }else if(tipo.equalsIgnoreCase("plantas"))
        {
            this.tipoPersonaje=tipo;
            this.cantidadPersonajes=cantidadPersonajes;
            
        }       
    }
     
     public Nodo(String nombreJugador, String tipo, int cantidadPersonajes,String info)
     {
         this.nombreJugador=nombreJugador;
          if(tipo.equalsIgnoreCase("zombies"))
        {
            this.tipoPersonaje=tipo;
            this.cantidadPersonajes=cantidadPersonajes;
            
        }else if(tipo.equalsIgnoreCase("plantas"))
        {
            this.tipoPersonaje=tipo;
            this.cantidadPersonajes=cantidadPersonajes;
            
        }
        this.infoAdicional=info;
     }

     public Nodo(String imagen, int puntos, int ataque, int defensa)
     {
         this.imagen=imagen;
         this.Puntos=puntos;
         this.Ataque=ataque;
         this.Defensa=defensa;
     }

    public ImageIcon getImagenes() {
        return imagenes;
    }

    public void setImagenes(ImageIcon imagenes) {
        this.imagenes = imagenes;
    }

     
    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setApuntadorSiguiente(Nodo apuntadorSiguiente) {
        this.apuntadorSiguiente = apuntadorSiguiente;
    }

    public void setApuntadorAnterior(Nodo apuntadorAnterior) {
        this.apuntadorAnterior = apuntadorAnterior;
    }

    public Nodo getApuntadorSiguiente() {
        return apuntadorSiguiente;
    }

    public Nodo getApuntadorAnterior() {
        return apuntadorAnterior;
    }
     
    public void setApuntadorArriba(Nodo apuntadorArriba) {
        this.apuntadorArriba = apuntadorArriba;
    }

    public void setApuntadorAbajo(Nodo apuntadorAbajo) {
        this.apuntadorAbajo = apuntadorAbajo;
    }


    public Nodo getApuntadorArriba() {
        return apuntadorArriba;
    }

    public Nodo getApuntadorAbajo() {
        return apuntadorAbajo;
    }

     
     
    public void setSiguienteIA(Nodo siguienteIA) {
        this.siguienteIA = siguienteIA;
    }

    public Nodo getSiguienteIA() {
        return siguienteIA;
    }
     
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public void setAtaque(int Ataque) {
        this.Ataque = Ataque;
    }

    public void setDefensa(int Defensa) {
        this.Defensa = Defensa;
    }

    public String getImagen() {
        return imagen;
    }

    public int getPuntos() {
        return Puntos;
    }

    public int getAtaque() {
        return Ataque;
    }

    public int getDefensa() {
        return Defensa;
    }
     
     
    public void setTipoPersonaje(String tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }

    public String getTipoPersonaje() {
        return tipoPersonaje;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void setCantidadPersonajes(int cantidadPersonajes) {
        this.cantidadPersonajes = cantidadPersonajes;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }   

    public Nodo getSiguiente() {
        return siguiente;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getCantidadPersonajes() {
        return cantidadPersonajes;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }    
    
}
