/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.de.filas;
import Serial.SerialRxTx;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Gereciador_de_filas extends javax.swing.JFrame {
        public static int textoexternoAv=0;
        public static String textoexterno="";
        
        private String txtsend="pk";
    
        Timer timer = new Timer();
    
        final long SEGUNDOS = (1000 );
        
        TimerTask tarefa = new TimerTask() {
           @Override
            public void run() {
              //repetido de tempos em tempos
              ArrayList<String> porta =  serial.Lista_Portas();
              int nlista=porta.size();
              int ncombo=combobox.getItemCount();
               
              
              if(nlista != ncombo)
                 for(int i=0;i<porta.size();i++)
                    combobox.add(porta.get(i).toString());
               
                
            }
         };
    
         Timer timerrecepcao = new Timer();
    
        final long temporecepcao = (100 );
        
        TimerTask tarefarecepcao = new TimerTask() { // pega string da porta serial
           @Override
            public void run() {
                if(textoexternoAv==1){
                    
                    //txtrecebe.setText(txtrecebe.getText()+"\n");
                    String  textoseparado[];
                    textoseparado= textoexterno.split(";");
                    
                    txtatual.setText(textoseparado[0]);
                    txtqtd.setText(textoseparado[1]);
                    textoexternoAv=0;
                }
            }
         };
        
    SerialRxTx serial = new SerialRxTx();
    
    /**
     * Creates new form Gereciador_de_filas
     */
    public Gereciador_de_filas() {
         initComponents();
        // ArrayList<String> porta =  serial.Lista_Portas();
        //     for(int i=0;i<porta.size();i++)
                // combobox.add(porta.get(i).toString());
                 
        timer.scheduleAtFixedRate(tarefa, 0, SEGUNDOS); // ativa o timer
        timerrecepcao.scheduleAtFixedRate(tarefarecepcao, 0, temporecepcao); // ativa o timer
      
      //combobox.add("COM9");
    }

   
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConectar = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        combobox = new java.awt.Choice();
        txtatual = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtqtd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConectar.setLabel("Conectar");
        btnConectar.setName(""); // NOI18N
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        btnSend.setText("PROX");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setText("Desconectado");

        txtatual.setEditable(false);
        txtatual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtatual.setText("           -");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ATUAL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("QUANTIDADE");

        txtqtd.setEditable(false);
        txtqtd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtqtd.setText("           -");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(label1)))))
                    .addComponent(txtatual, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label1)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtatual, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        btnConectar.getAccessibleContext().setAccessibleName("btnConectar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        if(btnConectar.getText().equals("Conectar")){
            btnConectar.setText("Desconectar");
            label1.setText(serial.iniciaSerial("COM9"));
            
            
        }else{
            btnConectar.setText("Conectar");
            label1.setText(serial.close());
        }
        /*
        
        serial.iniciaSerial();
        serial.sendData("1\r");
        serial.close();
        */

    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        //serial.sendData(txtsend.getText()+"\r");
        serial.sendData(txtsend);
          
    }//GEN-LAST:event_btnSendActionPerformed

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
            java.util.logging.Logger.getLogger(Gereciador_de_filas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gereciador_de_filas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gereciador_de_filas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gereciador_de_filas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gereciador_de_filas().setVisible(true);
            }
        });
    }
   

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnSend;
    private java.awt.Choice combobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label1;
    private javax.swing.JTextField txtatual;
    private javax.swing.JTextField txtqtd;
    // End of variables declaration//GEN-END:variables
}
