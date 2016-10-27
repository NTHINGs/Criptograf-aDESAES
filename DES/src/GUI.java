
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NTHINGs
 */
public class GUI extends javax.swing.JFrame {

    DES des;
    public GUI() {
        initComponents();
        final int limite = 8;
        KeyListener keyListener = new KeyListener() {
        public void keyPressed(KeyEvent keyEvent) {
        }

        public void keyReleased(KeyEvent keyEvent) {
        }

        public void keyTyped(KeyEvent keyEvent) {
            if (llave.getText().length() == limite) {
                    keyEvent.consume();
                }
            
        }
    };

        llave.addKeyListener(keyListener);
    }
    
    private String Binario(int Decimal) {
        String resultado="";
        int temp=Decimal;
        //Se aplica el algoritmo para convertir a binario
        while(temp != 0){
            if(temp %2 == 0){
               resultado="0"+resultado;
            }else{
                resultado="1"+resultado;
            }
            temp = temp/2;
        }
        
        //Se le agregan ceros a la izquierda, para completar 8 bits por caracter
        int cerosalaizquierda=8-resultado.length();
        for(int x=0;x<cerosalaizquierda;x++){
            resultado="0"+resultado;
        }
        return resultado;
    }
    
    private String ASCII(String binario){
        
        String caracter="";
        String caracteres[]=new String[8];
        String ascii="";
        int valor=0;
        
        
        //Separamos la cadena binario en 8 subcadenas de 8 bits
        int cont=8;
        for(int a=0;a<8;a++){
            caracteres[a]=binario.substring(cont-8, cont);
            System.out.println("Caracter "+(a+1)+" :"+caracteres[a]);
            cont=cont+8;
        }
        
       
        //Conversion del string binario a numero entero
        for(int a=0;a<8;a++){
            int longitud=caracteres[a].length();
            int potencia = longitud - 1;
            valor=0;
            for(int b=0;b<longitud;b++){
               if(caracteres[a].charAt(b)=='1'){
                valor+= Math.pow(2, potencia);
               }
               potencia --;
            }
            
            System.out.println("Caracter "+(a+1)+" :"+valor+" ASCII: "+(char)valor);

            ascii=ascii+(char)valor;
        }
        
        return ascii;
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
        entrada = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        encriptarbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        llave = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DES");
        setResizable(false);

        entrada.setColumns(20);
        entrada.setRows(5);
        jScrollPane1.setViewportView(entrada);
        entrada.setText("");

        salida.setEditable(false);
        salida.setColumns(20);
        salida.setRows(5);
        salida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(salida);
        salida.setText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Cifrado De DES");

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar Archivo de Texto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        encriptarbtn.setText("ENCRIPTAR");
        encriptarbtn.setEnabled(false);
        encriptarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encriptarbtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Entrada");

        jLabel3.setText("Salida");

        llave.setColumns(8);

        jLabel4.setText("Llave");

        jButton8.setText("GENERAR LLAVES");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encriptarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 137, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(llave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8)
                                .addGap(26, 26, 26)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(llave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jButton8))
                        .addGap(18, 18, 18)))
                .addComponent(encriptarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3)
                        .addComponent(jLabel3)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        entrada.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            //Se carga un archivo de texto al jTextArea
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar");
            chooser.setMultiSelectionEnabled(false);
            int sel = chooser.showOpenDialog(null);
            if (sel == JFileChooser.APPROVE_OPTION) {
                archivo = chooser.getSelectedFile();
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                // Lectura del fichero
                String linea;
                while ((linea = br.readLine()) != null) {
                    //linea por linea se escribe en el jTextArea llamado entrada
                    entrada.setText(entrada.getText() + linea + "\n");
                }
            } 
        }catch(HeadlessException | IOException e){
            e.printStackTrace();
        }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
        try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void encriptarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encriptarbtnActionPerformed
        // TODO add your handling code here:
        salida.setText("");
        if(!"".equals(entrada.getText())&&!"".equals(llave.getText())){
            Vector entradabits=new Vector();
            boolean[] paquete;
            String binario="";

            //Se convierte el contenido del jTextArea a un arreglo de caracteres
            String entradaarray=entrada.getText().trim().toString();

            //Mediante el ciclo se convierte caracter a caracter a binario de 8 bits
            for(int i=0;i<entradaarray.length();i++){
                binario=binario+Binario(entradaarray.charAt(i)); 
            }

            //Ahora obtendremos los paquetes de 64 bits de la cadena ya convertida a binario
            //Una variable auxiliar para almacenar el string de tamaño 64
            String sub;
            //Este ciclo se repetirá tantas veces como elementos tenga la cadena binario
            while(!"".equals(binario)){
                //Si la longitud de binario es menor a 64 ya no completamos otro paquete
                if(binario.length()<64){
                    //Vaciamos lo que tenga el arreglo paquete para almacenar el nuevo
                    paquete=new boolean[64];
                    //Calculamos cuantos bits le hacen falta al paquete para tener una longitud de 64
                    int restante=64-binario.length();
                    //Aquí rellenamos esa cantidad restante de bits con ceros
                    for(int x=0;x<restante;x++){
                        binario="0"+binario;
                    }
                    //Ahora sacamos todos los caracteres del paquete y verificamos si es un uno o cero para llenar el arreglo de booleanos
                    System.out.print("Paquete : ");
                    for(int x=0;x<64;x++){
                        paquete[x] = binario.charAt(x)=='1';
                        System.out.print(paquete[x]+", ");
                    }
                    System.out.print("\n");
                    //Agregamos el arreglo paquete al objeto Vector para separarlo
                    entradabits.add(paquete);
                    //Se sale del ciclo ya que se acabaron los paquetes
                    break;
                }else{
                    //Si la longitud es mayor o igual a 64 entonces aun nos quedan paquetes por procesar
                    //Vaciamos lo que tenga el arreglo paquete para almacenar el nuevo
                    paquete=new boolean[64];
                    //Extraemos una subcadena de 64 posiciones de la cadena binario para obtener los 64 bits
                    sub=binario.substring(0, 64);
                    //Ahora sacamos todos los caracteres del paquete y verificamos si es un uno o cero para llenar el arreglo de booleanos
                    System.out.print("Paquete : ");
                    for(int x=0;x<64;x++){
                        
                        paquete[x] = sub.charAt(x)=='1';
                        System.out.print(paquete[x]+", ");
                    }
                    System.out.print("\n");
                    //Agregamos el arreglo paquete al objeto Vector para separarlo
                    entradabits.add(paquete);
                    //Eliminamos esos 64 bits procesados de la cadena para continuar con los otros 64
                    binario=binario.substring(64,binario.length());
                }
            }

            //Dependiendo del tamaño del objeto Vector es las veces que se ejecutará DES, debido que solo puede encriptar 64 bits
            for(int y=0;y<entradabits.size();y++){
                paquete=(boolean [])entradabits.get(y);
                System.out.println("ENTRADABITS");
                for(int x=0;x<64;x++){
                    System.out.print(paquete[x]+", ");
                }
                System.out.println("");
                salida.setText(salida.getText()+ASCII(des.encriptar(paquete)));
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "INGRESA TEXTO EN LA ENTRADA O CARGA UN ARCHIVO","ERROR",JOptionPane.ERROR_MESSAGE);
        }
            
    }//GEN-LAST:event_encriptarbtnActionPerformed
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(llave.getText().toString().length()<9){
            if(!"".equals(llave.getText())){
                boolean[] paquete;
                String binario="";

                //Se convierte el contenido del jTextArea a un arreglo de caracteres
                char[] entradaarray=llave.getText().trim().toCharArray();

                //Mediante el ciclo se convierte caracter a caracter a binario de 8 bits
                for(int i=0;i<entradaarray.length;i++){
                    binario=binario+Binario(entradaarray[i]); 
                }

                //Ahora obtendremos los paquetes de 64 bits de la cadena ya convertida a binario
                //Una variable auxiliar para almacenar el string de tamaño 64
                String sub;
                //Este ciclo se repetirá tantas veces como elementos tenga la cadena binario
                        //Vaciamos lo que tenga el arreglo paquete para almacenar el nuevo
                        paquete=new boolean[64];
                        //Calculamos cuantos bits le hacen falta al paquete para tener una longitud de 64
                        int restante=64-binario.length();
                        //Aquí rellenamos esa cantidad restante de bits con ceros
                        for(int x=0;x<restante;x++){
                            binario="0"+binario;
                        }
                        //Ahora sacamos todos los caracteres del paquete y verificamos si es un uno o cero para llenar el arreglo de booleanos
                        for(int x=0;x<64;x++){
                            paquete[x] = binario.charAt(x)=='1';
                        }

                des=new DES(paquete);
                encriptarbtn.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "INGRESA UNA LLAVE","ERROR",JOptionPane.ERROR_MESSAGE);

            }
        }else{
            JOptionPane.showMessageDialog(null, "EL TAMAÑO MAXIMO DE LA LLAVE ES DE 8 CARACTERES","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        salida.setText("");
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton encriptarbtn;
    private javax.swing.JTextArea entrada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField llave;
    private javax.swing.JTextArea salida;
    // End of variables declaration//GEN-END:variables
}