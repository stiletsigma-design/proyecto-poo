/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author USUARIO
 */
public class frm_Menu extends javax.swing.JFrame {

    private static final Color FONDO_NORMAL = new Color(102, 102, 102);
    private static final Color FONDO_HOVER = Color.DARK_GRAY;
    private static final Color TEXTO_NORMAL = Color.WHITE;
    private static final Color TEXTO_HOVER = Color.decode("#FFB347");

    public frm_Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); // Desactiva maximizar
    }

    // Cuando el mouse ENTRA
    public static void activar(JPanel panel, JLabel label) {
        panel.setBackground(FONDO_HOVER);
        label.setForeground(TEXTO_HOVER);
    }

    // Cuando el mouse SALE
    public static void desactivar(JPanel panel, JLabel label) {
        panel.setBackground(FONDO_NORMAL);
        label.setForeground(TEXTO_NORMAL);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pan_servicio = new javax.swing.JPanel();
        lb_servicios = new javax.swing.JLabel();
        lb_ventadescripcion = new javax.swing.JLabel();
        lb_servicioicon = new javax.swing.JLabel();
        pan_ventas = new javax.swing.JPanel();
        lb_ventasdescripcion = new javax.swing.JLabel();
        lb_ventas = new javax.swing.JLabel();
        lb_ventaicon = new javax.swing.JLabel();
        pan_almacen = new javax.swing.JPanel();
        lb_almacendescripcion = new javax.swing.JLabel();
        lb_almacen = new javax.swing.JLabel();
        lb_almacenicon = new javax.swing.JLabel();
        pan_ganancias = new javax.swing.JPanel();
        lb_gananciasdescripcion = new javax.swing.JLabel();
        lb_ganancias = new javax.swing.JLabel();
        lb_gananciasicon = new javax.swing.JLabel();
        lb_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sistema de Gestión Automotriz");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        pan_servicio.setBackground(new java.awt.Color(102, 102, 102));
        pan_servicio.setForeground(new java.awt.Color(102, 102, 102));
        pan_servicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_servicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pan_servicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan_servicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan_servicioMouseExited(evt);
            }
        });
        pan_servicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_servicios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_servicios.setForeground(new java.awt.Color(255, 255, 255));
        lb_servicios.setText("Servicios");
        pan_servicio.add(lb_servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        lb_ventadescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lb_ventadescripcion.setText("Registro de reparaciones y mantenimiento");
        pan_servicio.add(lb_ventadescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 100, -1, 20));

        lb_servicioicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_Servicio_naranja.png"))); // NOI18N
        pan_servicio.add(lb_servicioicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jPanel1.add(pan_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 260, 130));

        pan_ventas.setBackground(new java.awt.Color(102, 102, 102));
        pan_ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_ventas.setRequestFocusEnabled(false);
        pan_ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan_ventasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan_ventasMouseExited(evt);
            }
        });
        pan_ventas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_ventasdescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lb_ventasdescripcion.setText("Venta y compra de repuestos y accesorios");
        pan_ventas.add(lb_ventasdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lb_ventas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_ventas.setForeground(new java.awt.Color(255, 255, 255));
        lb_ventas.setText("Ventas y Compra");
        pan_ventas.add(lb_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        lb_ventaicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_venta_naranja.png"))); // NOI18N
        pan_ventas.add(lb_ventaicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jPanel1.add(pan_ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 260, 130));

        pan_almacen.setBackground(new java.awt.Color(102, 102, 102));
        pan_almacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_almacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan_almacenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan_almacenMouseExited(evt);
            }
        });
        pan_almacen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_almacendescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lb_almacendescripcion.setText("Control de inventario y stock de repuestos");
        pan_almacen.add(lb_almacendescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lb_almacen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_almacen.setForeground(new java.awt.Color(255, 255, 255));
        lb_almacen.setText("Almacén");
        pan_almacen.add(lb_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        lb_almacenicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_inventario_naranja.png"))); // NOI18N
        pan_almacen.add(lb_almacenicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 30, -1, -1));

        jPanel1.add(pan_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 260, 130));

        pan_ganancias.setBackground(new java.awt.Color(102, 102, 102));
        pan_ganancias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_ganancias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan_gananciasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan_gananciasMouseExited(evt);
            }
        });
        pan_ganancias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_gananciasdescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lb_gananciasdescripcion.setText("Ingresos por día, mes y año");
        pan_ganancias.add(lb_gananciasdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        lb_ganancias.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_ganancias.setForeground(new java.awt.Color(255, 255, 255));
        lb_ganancias.setText("Reportes y Ganancias");
        pan_ganancias.add(lb_ganancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        lb_gananciasicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_ganancias_naranja.png"))); // NOI18N
        pan_ganancias.add(lb_gananciasicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jPanel1.add(pan_ganancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 260, 130));

        lb_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_mecanicos_900x700_sin_recortar.png"))); // NOI18N
        jPanel1.add(lb_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pan_servicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_servicioMouseEntered
        activar(pan_servicio, lb_servicios);
        lb_servicioicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_servicio_naranjaclaro.png")));
    }//GEN-LAST:event_pan_servicioMouseEntered

    private void pan_servicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_servicioMouseExited
        desactivar(pan_servicio, lb_servicios);
        lb_servicioicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_Servicio_naranja.png")));
    }//GEN-LAST:event_pan_servicioMouseExited

    private void pan_ventasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_ventasMouseEntered
        activar(pan_ventas, lb_ventas);
        lb_ventaicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_venta_naranjaclaro.png")));
    }//GEN-LAST:event_pan_ventasMouseEntered

    private void pan_ventasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_ventasMouseExited
        desactivar(pan_ventas, lb_ventas);
        lb_ventaicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_venta_naranja.png")));
    }//GEN-LAST:event_pan_ventasMouseExited

    private void pan_almacenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_almacenMouseEntered
        activar(pan_almacen, lb_almacen);
        lb_almacenicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_inventario_naranjaclaro.png")));
    }//GEN-LAST:event_pan_almacenMouseEntered

    private void pan_almacenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_almacenMouseExited
        desactivar(pan_almacen, lb_almacen);
        lb_almacenicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_inventario_naranja.png")));
    }//GEN-LAST:event_pan_almacenMouseExited

    private void pan_gananciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_gananciasMouseEntered
        activar(pan_ganancias, lb_ganancias);
        lb_gananciasicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_ganancias_naranjaclaro.png")));
    }//GEN-LAST:event_pan_gananciasMouseEntered

    private void pan_gananciasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_gananciasMouseExited
        desactivar(pan_ganancias, lb_ganancias);
        lb_gananciasicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_ganancias_naranja.png")));
    }//GEN-LAST:event_pan_gananciasMouseExited

    private void pan_servicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_servicioMouseClicked
        
    }//GEN-LAST:event_pan_servicioMouseClicked

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
            java.util.logging.Logger.getLogger(frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_almacen;
    private javax.swing.JLabel lb_almacendescripcion;
    private javax.swing.JLabel lb_almacenicon;
    private javax.swing.JLabel lb_fondo;
    private javax.swing.JLabel lb_ganancias;
    private javax.swing.JLabel lb_gananciasdescripcion;
    private javax.swing.JLabel lb_gananciasicon;
    private javax.swing.JLabel lb_servicioicon;
    private javax.swing.JLabel lb_servicios;
    private javax.swing.JLabel lb_ventadescripcion;
    private javax.swing.JLabel lb_ventaicon;
    private javax.swing.JLabel lb_ventas;
    private javax.swing.JLabel lb_ventasdescripcion;
    private javax.swing.JPanel pan_almacen;
    private javax.swing.JPanel pan_ganancias;
    private javax.swing.JPanel pan_servicio;
    private javax.swing.JPanel pan_ventas;
    // End of variables declaration//GEN-END:variables
}
