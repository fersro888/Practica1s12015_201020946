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
public class Nodo {
    //************************************************CREACIÓN DE JUGADORES
    private Nodo siguiente;
    private String nombreJugador;
    private String tipoPersonaje;
    private int cantidadPersonajes;
    private String infoAdicional;
    //*************************************************CREACIÓN DE PLANTAS Y ZOMBIES
    private String imagen;
    private int Puntos;
    private int Ataque;
    private int Defensa;
    
    
     public Nodo()
     {
         
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
