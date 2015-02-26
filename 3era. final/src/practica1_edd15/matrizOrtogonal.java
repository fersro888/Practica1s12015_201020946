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
public class matrizOrtogonal {
    
    Nodo raiz1, raiz2;//, auxF, auxC;   
    listaSimple lista,lista2;
    
    public matrizOrtogonal(){
        this.lista=new listaSimple();
        
    }
    
    public void crearNodoMatriz(int filas, int columnas)//traerme un tipo objeto a la matriz zombie/planta
    {    
      
      try{
      Nodo aux1;//=raiz1;
      Nodo aux2;//=raiz1.getApuntadorSiguiente();
      Nodo aux3;//raiz2
      Nodo aux4;
      Nodo aux5;
      Nodo primero;
      Nodo ultimo;
      //listaSimple raiz2;
      
      for(int i=0; i<filas; i++){
          //aux2=raiz1;
          aux1=raiz1;
          aux3=raiz2;
          /*primero=raiz2;
          this.lista2=new listaSimple();*/
          this.lista2=new listaSimple();
          
          for(int j=0; j<columnas;j++)
      {
         // aux1=raiz1; 
         // aux2= raiz1.getApuntadorSiguiente();
      
          if(i==0){   //si estoy en la primer fila
           raiz1=this.lista.insertarNodoMatrizOrtogonal(raiz1, i, j);      
           
 
         }else{
              
           raiz2=this.lista2.insertarNodoMatrizOrtogonal(raiz2, i, j);
           //aux3=raiz2;
           //primero=raiz2;
           if(aux1!=null && aux3!=null) //VERIFICAR
           {
             if(aux3.getApuntadorSiguiente()==null){
             aux3.setApuntadorArriba(aux1);
             aux3.getApuntadorArriba().setApuntadorAbajo(aux1); 
             aux4=aux3; //estando en raiz2
             //aux5=aux1; //estando en raiz1
             aux3=aux3.getApuntadorSiguiente();
             aux1=aux1.getApuntadorSiguiente();
             }else{
             
             aux3.setApuntadorArriba(aux1);
             aux3.getApuntadorArriba().setApuntadorAbajo(aux1); 
             aux4=aux3;
             aux3.setApuntadorAnterior(aux4); 
             aux3.getApuntadorAnterior().setApuntadorSiguiente(aux3); 
             }
           }  
          }
      }
    }
      
      
      
      
      }catch(Exception e){
          System.out.println("PROBLEMA EN LA MATRIZ ORTOGONAL -REVISAR "+e.getMessage());
              }
      
      
     }
    
    
    public void recorrerFilas(Nodo nodo, int filas, int columnas) //verificar siempre antes de crear las columnas para enlazarlas con lo que viene
    {
          while(nodo!=null)//recorrer auxC
                {
                   // if(filas!=0) //que no sea la primer fila
                    crearNodoMatriz(filas, columnas); 
                    //debería de enlazar cada nodo con su otra fila
                }
    }
    
}
