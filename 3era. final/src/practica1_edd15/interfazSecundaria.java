/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1_edd15;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Destroy the time
 */
public class interfazSecundaria extends javax.swing.JFrame {

    /**
     * Creates new form interfazSecundaria
     */
    
   Nodo aux, auxZ, auxP, auxListaZ, auxListaP, Zombies, Plantas;
   private BufferedImage imagenActual;
   DefaultTableModel modelo;
   String []nombreColumnas;
   Object [][]datos;
   int contadorP, contadorZ; //lleva el control de que no se sobrepase la cantidad de zombies/plantas
   listaSimple listaZ, listaP, listaInterfaz3P, listaInterfaz3Z;
   Boolean clickZ, clickP; //lleva el control para agregar plantas desde 0
  
   
public interfazSecundaria() {
        initComponents();
        setVisible(true);
       this.contadorP=0;
       this.contadorZ=0;
        this.nombreColumnas= new String[] {"","Imagen","Nombre","Puntos","Ataque","Defensa"};
        listaZ=new listaSimple();
        listaP=new listaSimple();
        listaInterfaz3P=new listaSimple();
        listaInterfaz3Z=new listaSimple();
        auxListaP=new Nodo();
        auxListaZ=new Nodo();
        Zombies=new Nodo();
        Plantas=new Nodo();
        clickZ=false;
        clickP=false;
        modelo= new DefaultTableModel(){
            @Override
                public Class getColumnClass(int c) //método que nos permite obtener la imagen en esa celda
    {
         return getValueAt(0,c).getClass();//ImageIcon.class;
    }
        };
        
       // modelo= (DefaultTableModel) tabla.getModel();
   
        this.modelo.setColumnIdentifiers(this.nombreColumnas);
        tabla.setRowHeight(50); //tamaño de la celda  igual que el de la imagen
        tabla.setShowHorizontalLines(true);
        tabla.setShowVerticalLines(true);
        
    }
  

public void crearTabla(Nodo nodo)//String nombre, int puntos, int defensa, int ataque) //Aquí de parámetro la lista completa
{   
   int aux1;
   Nodo auxLP, auxLZ;
   ImageIcon imagen=new ImageIcon(abrirImagen().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
  
  // Object nuevaFi[]={modelo.getRowCount()+1,imagen, nombre,puntos,ataque,defensa};
    
   Object nuevaFi[]={modelo.getRowCount()+1,imagen, nodo.getNombreJugador(),nodo.getPuntos(),nodo.getAtaque(),nodo.getDefensa()};
    try{   
    //this.datos=new Object[][]{{modelo.getRowCount()+1,imagen,nombre,puntos,ataque,defensa}}; //ajustando la imagen 50x50
    this.datos=new Object[][]{{modelo.getRowCount()+1,imagen,nodo.getNombreJugador(),nodo.getPuntos(),nodo.getAtaque(),nodo.getDefensa()}};
    //listaInterfaz3.crearJugador(nodo, nodo.getNombreJugador(), nodo.getTipoPersonaje(), nodo.getCantidadPersonajes());//*******************crear nueva lista para enviarla a la siguiente interfaz sería mi tablero
    
    if(nodo.getTipoPersonaje().equalsIgnoreCase("plantas")){
    System.out.println("Nodo que se agregará a la lista Plantas que va al tablero");
    aux1=obtenerRandom(nodo.getCantidadPersonajes()); //obtener el dato random
    auxLP=listaP.recorrerListaCatalogo(auxP, aux1);//recorrer la lista y hacer una búsqueda del número aleatorio, retornar ese nodo
    //hacerlo global para llevarmelo al tablero
    //aquí random
    this.Plantas=listaInterfaz3P.crearListaInterfaz3(auxLP, auxLP.getNombreJugador(), auxLP.getTipoPersonaje(), aux1, imagen);//*******************crear nueva lista para enviarla a la siguiente interfaz sería mi tablero
    
    }else if(nodo.getTipoPersonaje().equalsIgnoreCase("zombies")){
    System.out.println("Nodo que se agregará a la lista Zombies que va al tablero");   
    aux1=obtenerRandom(nodo.getCantidadPersonajes()); //obtener el dato random
    auxLZ=listaZ.recorrerListaCatalogo(auxZ, aux1);//recorrer la lista y hacer una búsqueda del número aleatorio, retornar ese nodo
    
    this.Zombies=listaInterfaz3Z.crearListaInterfaz3(auxLZ,auxLZ.getNombreJugador(), auxLZ.getTipoPersonaje(), aux1,imagen ); //*******************nueva lista al tablero
    }
    modelo.addRow(nuevaFi);
    tabla.setModel(modelo);
    
    }catch(Exception e)
    {
        System.out.println("Error en tabla *VERIFICAR "+e.getMessage());
    }

}

public BufferedImage abrirImagen()
{
    BufferedImage bi=null;
    
        JFileChooser archivo= new JFileChooser();
        //archivo.showOpenDialog(this);
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("JPG & PNG & GIF","jpg","png", "gif");
        archivo.setFileFilter(filtro); //establezco el filtro
        int bandera=archivo.showOpenDialog(this);
        
            if(bandera==JFileChooser.APPROVE_OPTION){
            try{
              File obtenerImagen=archivo.getSelectedFile();
              bi=ImageIO.read(obtenerImagen);
            
        //File obtenerArchivo=archivo.getSelectedFile();
        
            }
    
            catch(Exception e)
    {
        System.out.println("No existe"+e.getMessage());
    }
            }
    imagenActual=bi;//asigno bi en un JLabel
    return imagenActual;
 }


public void interfazPrincipal(Nodo ip1) //igualo los nodos que vienen en primer interfaz
{
    
 if(ip1.getTipoPersonaje().equalsIgnoreCase("zombies"))
 {
     this.auxZ=new Nodo();
     this.auxZ=ip1;
     
 }
 if(ip1.getTipoPersonaje().equalsIgnoreCase("plantas"))
 {
     this.auxP=new Nodo();
     this.auxP=ip1;
 }
}
   
public void crearCatalogo(Nodo nodo, int cantidadPersonajesTotal)
{
    try{
       if(nodo.getTipoPersonaje().equalsIgnoreCase("zombies") && this.contadorZ<cantidadPersonajesTotal)
        {
            if(nodo.getSiguiente()!=null){
            this.auxListaZ=listaZ.crearJugador(nodo, nodo.getNombreJugador(), nodo.getTipoPersonaje(), nodo.getCantidadPersonajes(), nodo.getInfoAdicional()); //creando nueva listaZ***********  
            crearTabla(nodo);//crearTabla(nodo.getNombreJugador(),nodo.getPuntos(),nodo.getDefensa(),nodo.getAtaque());
            //++contadorZ;
            System.out.println("Estoy en Zombies con cantidad neta de "+cantidadPersonajesTotal+" y mi contador que verifica"+ contadorZ);//******
            if(this.contadorZ==0 && clickZ==false){ //llevar control de contador zombie
            //this.contadorZ++;
            this.clickZ=true;
                System.out.println("Mi contador va en "+contadorZ); //****
                }else if(clickZ==true){
                this.contadorZ++;
                this.clickZ=true;
                System.out.println("Mi contador en el segundo if va en "+contadorZ); //*****
                }
            }
        }else if(nodo.getTipoPersonaje().equalsIgnoreCase("plantas") && this.contadorP<cantidadPersonajesTotal)
        {
            if(nodo.getSiguiente()!=null){
            this.auxListaP=listaP.crearJugador(nodo, nodo.getNombreJugador(), nodo.getTipoPersonaje(), nodo.getCantidadPersonajes(), nodo.getInfoAdicional()); //creando nueva listaP***********   
            //crearTabla(nodo.getNombreJugador(),nodo.getPuntos(),nodo.getDefensa(),nodo.getAtaque());
            crearTabla(nodo); 
            //++contadorP;
            System.out.println("Estoy en Plantas con cantidad neta de "+cantidadPersonajesTotal+" y mi contador que verifica"+ contadorP);//******
            if(this.contadorP==0 && clickP==false){ //llevar control de contador zombie
            //this.contadorZ++;
            this.clickP=true;
                System.out.println("Mi contador va en "+contadorP); //****
                }else if(clickP==true){
                this.contadorP++;
                this.clickP=true;
                System.out.println("Mi contador en el segundo if va en "+contadorP); //*****
                }
            }
        }else{
            //recorrer listas, cúando se sobre pasen se recorren las listas
         /*   if(nodo.getTipoPersonaje().equalsIgnoreCase("plantas") && this.contadorP==cantidadPersonajesTotal){
            listaZ.recorrerLista(this.auxListaZ, "C:\\DDot\\plantaListaCatalogo.dot","C:\\DDot\\plantaListaCatalogo.png");
            }
            if(nodo.getTipoPersonaje().equalsIgnoreCase("zombies") && this.contadorZ==cantidadPersonajesTotal){
                listaP.recorrerLista(this.auxListaP, "C:\\DDot\\zombieListaCatalogo.dot", "C:\\DDot\\zombieListaCatalogo.png");
            }*/
            JOptionPane.showMessageDialog(this, "Error, se sobrepasaron, no se pueden crear más","Error", JOptionPane.ERROR_MESSAGE);
        }
    }catch(Exception io)
    {
        System.out.println("Error en catálogo *VERIFICAR "+io.getMessage());
    }
}

public int obtenerRandom(int random)
{
    Random r= new Random();
    return r.nextInt(random);
}


public void obtenerFilaColumnasTabla()
{
    this.tabla.addMouseListener(new MouseAdapter(){
        
        public void mouseClicked(MouseEvent e){
            int fil= tabla.rowAtPoint(e.getPoint());
            int col= tabla.rowAtPoint(e.getPoint());
            if((fil >-1) && (col > -1))
            System.out.println(modelo.getValueAt(fil, col));
        }
        
    });
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        agregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btbModificar = new javax.swing.JButton();
        btbEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agregar.setText("Agregar Planta");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(tabla);

        btbModificar.setText("Modificar");
        btbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbModificarActionPerformed(evt);
            }
        });

        btbEliminar.setText("Eliminar");

        jButton1.setText("Agregar Zombie");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Empezar!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btbModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(btbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
 
     try{  
        int aux,aux1;
        Nodo auxLP;
            aux=auxP.getCantidadPersonajes(); //obtener el número de personajes para enviarlos al método random
           /* aux1=obtenerRandom(aux); //obtener el dato random
            auxLP=listaP.recorrerListaCatalogo(auxP, aux1);//recorrer la lista y hacer una búsqueda del número aleatorio, retornar ese nodo*/
            System.out.println("Crear plantas en el catálogo.");
            crearCatalogo(auxP, aux); //ese nodo lo envió a crear catálogo y ya tengo cargada mi nueva lista
        
               //recorrer listas, cúando se sobre pasen se recorren las listas
            
            listaP.recorrerLista(this.auxListaP, "C:\\DDot\\plantaListaCatalogo.dot","C:\\DDot\\plantaListaCatalogo.png");
            
         
             }catch(Exception e)
                {
                    System.out.println("Error para agregar Plantas "+e.getMessage());
                }
        
    }//GEN-LAST:event_agregarActionPerformed

    private void btbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbModificarActionPerformed

        obtenerFilaColumnasTabla();
        
        /*int filaSeleccionada=tabla.rowAtPoint(null);
        int columnaSeleccionada= tabla.getSelectedColumn();
        JTextField texto=new JTextField();
        texto.setText(String.valueOf(tabla.getValueAt(filaSeleccionada, columnaSeleccionada)));
        String obtener="";
        obtener=texto.getText(); //aquí obtener el resultado*/
        
    }//GEN-LAST:event_btbModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
             try{  
        int aux,aux1;
        Nodo auxLZ;
            aux=auxZ.getCantidadPersonajes(); //obtener el número de personajes para enviarlos al método random
           /* aux1=obtenerRandom(aux); //obtener el dato random
            auxLZ=listaZ.recorrerListaCatalogo(auxZ, aux1);//recorrer la lista y hacer una búsqueda del número aleatorio, retornar ese nodo*/
            System.out.println("Crear Zombies en el catálogo");
            crearCatalogo(auxZ, aux); //ese nodo lo envió a crear catálogo y ya tengo cargada mi nueva lista
        
             
            listaZ.recorrerLista(this.auxListaZ, "C:\\DDot\\zombieListaCatalogo.dot", "C:\\DDot\\zombieListaCatalogo.png");
            
            
             }catch(Exception e)
                {
                    System.out.println("Error para agregar Zombies "+e.getMessage());
                }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        interfazTercera it=new interfazTercera();
        it.interfazSecundaria(this.Plantas, this.Zombies);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfazSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfazSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfazSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfazSecundaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfazSecundaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton btbEliminar;
    private javax.swing.JButton btbModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
 
  
    

 
    
    
}
