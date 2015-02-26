/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1_edd15;

import java.io.File;
import java.io.FileWriter;
import java.awt.Desktop;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
/**
 *
 * @author Destroy the time
 */
public class listaSimple {
     Nodo cabezaJugador,ultimo;//, ultimo;
     String dot;
     
     public listaSimple()
     {
         this.dot="";
     }
    
    public Nodo crearJugador(Nodo nodo, String nombreJugador, String tipoPersonaje, int cantPersonajes, String infoAdicional) //crear el primer jugador nodo
    {
      
        if(cabezaJugador==null){
            Nodo jugador=new Nodo(nombreJugador, tipoPersonaje,cantPersonajes);
            jugador.setNombreJugador(nombreJugador);
            jugador.setTipoPersonaje(tipoPersonaje);
            jugador.setCantidadPersonajes(cantPersonajes);
            jugador.setInfoAdicional(infoAdicional);
            cabezaJugador=jugador;
            nodo=cabezaJugador;
            return nodo;
        }else{
            Nodo jugador=new Nodo(nombreJugador, tipoPersonaje,cantPersonajes);
            jugador.setNombreJugador(nombreJugador);
            jugador.setTipoPersonaje(tipoPersonaje);
            jugador.setCantidadPersonajes(cantPersonajes);
            jugador.setInfoAdicional(infoAdicional);
            jugador.setSiguiente(cabezaJugador);
            cabezaJugador=jugador;
            nodo=cabezaJugador;
            //this.cabezaJugador=jugador;
            return nodo;
        }
      
    }
    
     public Nodo crearListaInterfaz3(Nodo nodo, String nombreJugador, String tipoPersonaje, int cantPersonajes, ImageIcon imagen) //crear el primer jugador nodo
    {
      
        if(cabezaJugador==null){
            Nodo jugador=new Nodo(nombreJugador, tipoPersonaje,cantPersonajes);
            jugador.setNombreJugador(nombreJugador);
            jugador.setTipoPersonaje(tipoPersonaje);
            jugador.setCantidadPersonajes(cantPersonajes);
            jugador.setImagenes(imagen);
            cabezaJugador=jugador;
            nodo=cabezaJugador;
            return nodo;
        }else{
            Nodo jugador=new Nodo(nombreJugador, tipoPersonaje,cantPersonajes);
            jugador.setNombreJugador(nombreJugador);
            jugador.setTipoPersonaje(tipoPersonaje);
            jugador.setCantidadPersonajes(cantPersonajes);
            jugador.setImagenes(imagen);
            jugador.setSiguiente(cabezaJugador);
            cabezaJugador=jugador;
            nodo=cabezaJugador;
            //this.cabezaJugador=jugador;
            return nodo;
        }
      
    }
    
    
    
    public Nodo insertarInfoJugador(Nodo nodo, String info) //insertar información adicional del jugador
    {
            
            Nodo jugador=new Nodo(cabezaJugador.getNombreJugador(), cabezaJugador.getTipoPersonaje(), cabezaJugador.getCantidadPersonajes(),info);
            jugador.setInfoAdicional(info);
            cabezaJugador.setSiguienteIA(jugador);
            nodo=cabezaJugador;
            return nodo;
    }
    
    public Nodo insertarNodoMatrizOrtogonal(Nodo nodo, int fila, int columna)
    {
        Nodo aux, aux2=nodo;
        if(cabezaJugador==null)
        {
            Nodo matriz= new Nodo(fila, columna);
            cabezaJugador=matriz;
            nodo= cabezaJugador;
            return nodo;
        }else{
            if(ultimo==null){
            Nodo matriz = new Nodo(fila, columna);
            cabezaJugador.setApuntadorSiguiente(matriz); 
            ultimo=cabezaJugador;
            ultimo=ultimo.getApuntadorSiguiente();
            nodo=cabezaJugador;
            return nodo;
            }else{
            Nodo matriz = new Nodo(fila, columna);
            ultimo.setApuntadorSiguiente(matriz);
            cabezaJugador.setApuntadorSiguiente(ultimo);
            ultimo=ultimo.getApuntadorSiguiente();
            nodo=cabezaJugador;
            return nodo;
            }
        }
        
    }
    
    public void eliminarPilaZombies(Nodo nodo) //PILA
    {
        while(nodo!=null)
        {
            if(nodo.getSiguiente()==null)
            {
                nodo=null;//extraer nodo, ya que es una pila , el último que entra apunta a NULL y se elimina
            }else{
                eliminarPilaZombies(nodo.getSiguiente());
            }
        }
    }
    
    public void eliminarColaPlantas(Nodo nodo) //COLA
    {
       
            if(nodo.getSiguiente()!=null) //es el primero de la lista
            {
                nodo=null; //se elimina
            }  
        
    }
    
    public void recorrerLista(Nodo jugador, String direccion, String pathPNG)
    {
        dot="digraph g{\nrankdir=LR;\n"+dot;
        int contador1=0;
        int contador2=1;
        try{
        Nodo temp1=jugador.getSiguiente();
        Nodo temp2=jugador;
        while(temp1!=null)
        {
            
            System.out.println(temp2.getCantidadPersonajes()+" "+temp2.getNombreJugador());
            //temp2=temp1;
            if(temp1.getInfoAdicional()==null){
            dot=dot+(++contador1)+"[label=\""+temp1.getNombreJugador()+(contador1)+"\",shape=\"box\"];\n";
            dot=dot+(++contador2)+"[label=\""+temp2.getNombreJugador()+(contador2)+"\",shape=box];\n";
            dot=dot+(contador1)+"->"+(contador2)+"->"+ jugador.getInfoAdicional()+";\n";
            }else{
               dot=dot+(++contador1)+"[label=\""+temp2.getNombreJugador()+(contador1)+"\",shape=box];\n";
               dot=dot+(++contador2)+"[label=\""+temp2.getInfoAdicional()+(contador2)+"\",shape=box];\n";
               //dot=dot+"->"+temp1.getSiguienteIA().getInfoAdicional()+"\n";
               dot=dot+(contador1)+"->"+(contador2)+"->"+jugador.getInfoAdicional()+";\n";
            }
            temp2=temp1;
            temp1=temp1.getSiguiente();
        }
        dot=dot+"}\n";
        escribirArchivo(dot,direccion, pathPNG);
        ejecutarDot(direccion, pathPNG);//******************************
          //  System.out.println("Llego al final de la lista"+temp2.getNombreJugador());
        }catch(Exception e)
        {
            System.out.println("ERROR---->"+e.getMessage());
        }
    }
    
    public Nodo recorrerListaCatalogo(Nodo jugador, int random)
    {
        Nodo temp1= jugador.getSiguiente();
        Nodo temp2=jugador;
        
            while(temp1!=null){
                if(temp2.getCantidadPersonajes()==random) //sí es igual a cantidad de personajes
                {
                    System.out.println("Encontrado");
                    temp1=null;
                  
                }else{
                temp2=temp1;
                temp1=temp1.getSiguiente();
                }
            }
        return temp2;
    }
    
    
    public void escribirArchivo(String datos, String direccion, String pathPNG)
    {
        try{
                       
            FileWriter fichero=new FileWriter(direccion);
            fichero.write(datos);
            fichero.close();
            //ejecutarDot(direccion,pathPNG);
        }catch(Exception e)
        {
            System.out.println("Problema en archivo.dot- REVISAR"+e.getMessage());
        }
        
    }
    
    public void ejecutarDot(String direccionDot, String direccionPng) //PENDIENTE
    {
        try{
            //String []comando={"cmd.exe","/c","dot -Tpng "+direccionDot+" -o "+ direccionPng};
            //String cmd="cd C:\\DDot dot -Tpng "+direccionDot+" -o "+direccionPng;
            Runtime.getRuntime().exec("cmd /c C:\\DDot dot -Tpng"+direccionDot+"-o"+direccionPng);
          /*  try{
           // Process p= Runtime.getRuntime().exec(" dot -Tpng "+direccionDot+" -o "+ direccionPng);  REVISAR  
            //File archivo= new File("C:\\DDot"); //enviarlo a un label
            //Desktop.getDesktop().open(archivo);
            }catch(Exception e){
            Logger.getLogger(Practica1_EDD15.class.getName()).log(Level.SEVERE, null, e);}
        }*/ }catch(Exception e){
            System.out.println("problema al ejecutar .DOT- REVISAR "+e.getMessage());
         //   Logger.getLogger(Practica1_EDD15.class.getName()).log(Level.SEVERE, null, e);
            
            //e.printStackTrace();
        }
    }
    

    
}
