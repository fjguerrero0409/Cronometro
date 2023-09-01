
package Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Ventana extends javax.swing.JFrame {

    private Timer tiempo;
    private int centesimaSegundos = 0 , segundos = 0 , minutos =0 , horas =0;
    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
           centesimaSegundos++;
           if(centesimaSegundos ==100){
               segundos++;
               centesimaSegundos=0;
           }
           if(segundos == 60){
               minutos++;
               segundos=0;
           }
           if (minutos ==60){
               horas++;
               minutos=0;
           }
           
           
           actualizarEtiquetaTiempo();
        }
    
    };
    
    private void actualizarEtiquetaTiempo (){
       String texto =(horas<=9? "0" :"")+horas+(":")+ (minutos <=9?"0":"")+minutos+(":") +(segundos<=9?"0":"")+segundos+(":")+(centesimaSegundos<=9?"0":"")+centesimaSegundos;
       etiquetaTiempo.setText(texto);
    }
    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        tiempo = new Timer(10,acciones);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        etiquetaCronometro = new javax.swing.JLabel();
        etiquetaTitulo = new javax.swing.JLabel();
        botonIniciar = new javax.swing.JButton();
        botonPausar = new javax.swing.JButton();
        botonDetener = new javax.swing.JButton();
        etiquetaTiempo = new javax.swing.JLabel();
        etiquetaFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronometro");
        setName("Cronometro\n"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetaCronometro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/cronometro.png"))); // NOI18N
        panel.add(etiquetaCronometro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 150));

        etiquetaTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        etiquetaTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaTitulo.setText("Cronometro");
        panel.add(etiquetaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 200, 20));

        botonIniciar.setBackground(new java.awt.Color(51, 153, 0));
        botonIniciar.setForeground(new java.awt.Color(255, 255, 255));
        botonIniciar.setText("Iniciar");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });
        panel.add(botonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        botonPausar.setBackground(new java.awt.Color(255, 255, 255));
        botonPausar.setText("Pausar");
        botonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPausarActionPerformed(evt);
            }
        });
        panel.add(botonPausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        botonDetener.setBackground(new java.awt.Color(255, 0, 51));
        botonDetener.setForeground(new java.awt.Color(255, 255, 255));
        botonDetener.setText("Detener");
        botonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetenerActionPerformed(evt);
            }
        });
        panel.add(botonDetener, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        etiquetaTiempo.setFont(new java.awt.Font("HP Simplified", 1, 36)); // NOI18N
        etiquetaTiempo.setText("00:00:00:00");
        panel.add(etiquetaTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 210, 40));

        etiquetaFondo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/velo.jpg"))); // NOI18N
        etiquetaFondo.setText("tiempo");
        panel.add(etiquetaFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, -1));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPausarActionPerformed
        tiempo.stop();
        botonPausar.setEnabled(false);
        botonIniciar.setEnabled(true);
        botonDetener.setEnabled(true);
    }//GEN-LAST:event_botonPausarActionPerformed

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed
        tiempo.start();
        botonIniciar.setEnabled(false);
        botonIniciar.setText("Reanudar");
        botonPausar.setEnabled(true);
        botonDetener.setEnabled(true);
    }//GEN-LAST:event_botonIniciarActionPerformed

    private void botonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetenerActionPerformed
        if (tiempo.isRunning()){
            tiempo.stop();
            botonIniciar.setEnabled(true);
        }
        botonIniciar.setText("Iniciar");
        botonPausar.setEnabled(false);
        botonDetener.setEnabled(false);
        horas=0;
        minutos=0;
        segundos=0;
        centesimaSegundos=0;
        actualizarEtiquetaTiempo();
    }//GEN-LAST:event_botonDetenerActionPerformed

    
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDetener;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonPausar;
    private javax.swing.JLabel etiquetaCronometro;
    private javax.swing.JLabel etiquetaFondo;
    private javax.swing.JLabel etiquetaTiempo;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
