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
public class frm_menu extends javax.swing.JFrame {
    
    
    private static final Color FONDO_NORMAL = new Color(102, 102, 102);
    private static final Color FONDO_HOVER = Color.DARK_GRAY;
    private static final Color TEXTO_NORMAL = Color.WHITE;
    private static final Color TEXTO_HOVER = Color.decode("#FFB347");
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frm_menu.class.getName());

    /**
     * Creates new form frm_menu
     */
    public frm_menu() {
        initComponents();
        this.setLocationRelativeTo(null);
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

        jLabel1 = new javax.swing.JLabel();
        pan_servicios = new javax.swing.JPanel();
        lb_serviciodescripcion = new javax.swing.JLabel();
        lb_iconoservicio = new javax.swing.JLabel();
        lb_servicio = new javax.swing.JLabel();
        pan_venta = new javax.swing.JPanel();
        lb_ventadescripcion = new javax.swing.JLabel();
        lb_iconoventa = new javax.swing.JLabel();
        lb_venta = new javax.swing.JLabel();
        pan_inventario = new javax.swing.JPanel();
        lb_inventariodescripcion = new javax.swing.JLabel();
        lb_iconoinventario = new javax.swing.JLabel();
        lb_inventario = new javax.swing.JLabel();
        pan_reportes = new javax.swing.JPanel();
        lb_reportesdescripcion = new javax.swing.JLabel();
        lb_iconoreportes = new javax.swing.JLabel();
        lb_reportes = new javax.swing.JLabel();
        lb_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Gestión Automotriz");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 890, -1));

        pan_servicios.setBackground(new java.awt.Color(102, 102, 102));
        pan_servicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_servicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan_serviciosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan_serviciosMouseExited(evt);
            }
        });
        pan_servicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_serviciodescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lb_serviciodescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_serviciodescripcion.setText("Registro de reparaciones y mantenimiento");
        pan_servicios.add(lb_serviciodescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 260, -1));

        lb_iconoservicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_iconoservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_Servicio_naranja.png"))); // NOI18N
        pan_servicios.add(lb_iconoservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 30, 40, -1));

        lb_servicio.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lb_servicio.setForeground(new java.awt.Color(255, 255, 255));
        lb_servicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_servicio.setText("Servicio");
        pan_servicios.add(lb_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 260, -1));

        getContentPane().add(pan_servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 260, 120));

        pan_venta.setBackground(new java.awt.Color(102, 102, 102));
        pan_venta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pan_ventaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan_ventaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan_ventaMouseExited(evt);
            }
        });
        pan_venta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_ventadescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lb_ventadescripcion.setText("Venta y compra de repuestos y accesorios");
        pan_venta.add(lb_ventadescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lb_iconoventa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_iconoventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_venta_naranja.png"))); // NOI18N
        pan_venta.add(lb_iconoventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 40, -1));

        lb_venta.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lb_venta.setForeground(new java.awt.Color(255, 255, 255));
        lb_venta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_venta.setText("Venta y compra");
        pan_venta.add(lb_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 260, -1));

        getContentPane().add(pan_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 260, 120));

        pan_inventario.setBackground(new java.awt.Color(102, 102, 102));
        pan_inventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan_inventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan_inventarioMouseExited(evt);
            }
        });
        pan_inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_inventariodescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lb_inventariodescripcion.setText("Control de inventario y stock de repuestos");
        pan_inventario.add(lb_inventariodescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lb_iconoinventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_iconoinventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_inventario_naranja.png"))); // NOI18N
        pan_inventario.add(lb_iconoinventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 40, -1));

        lb_inventario.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lb_inventario.setForeground(new java.awt.Color(255, 255, 255));
        lb_inventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_inventario.setText("Inventario");
        pan_inventario.add(lb_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 260, -1));

        getContentPane().add(pan_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 260, 120));

        pan_reportes.setBackground(new java.awt.Color(102, 102, 102));
        pan_reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pan_reportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pan_reportesMouseExited(evt);
            }
        });
        pan_reportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_reportesdescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lb_reportesdescripcion.setText("Ingresos por día, mes y año, etc");
        pan_reportes.add(lb_reportesdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lb_iconoreportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_iconoreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_reportes_naranja.png"))); // NOI18N
        pan_reportes.add(lb_iconoreportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 40, -1));

        lb_reportes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lb_reportes.setForeground(new java.awt.Color(255, 255, 255));
        lb_reportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_reportes.setText("Reportes");
        pan_reportes.add(lb_reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 260, -1));

        getContentPane().add(pan_reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 260, 120));

        lb_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fonodmenumecanica__mejora.png"))); // NOI18N
        getContentPane().add(lb_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pan_serviciosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_serviciosMouseEntered
        activar(pan_servicios,  lb_servicio);
        lb_iconoservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_servicio_naranjaclaro.png")));
    }//GEN-LAST:event_pan_serviciosMouseEntered

    private void pan_serviciosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_serviciosMouseExited
        desactivar(pan_servicios, lb_servicio);
        lb_iconoservicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_Servicio_naranja.png")));
    }//GEN-LAST:event_pan_serviciosMouseExited

    private void pan_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_ventaMouseClicked
        frm_venta venta = new frm_venta();
        venta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pan_ventaMouseClicked

    private void pan_ventaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_ventaMouseEntered
        activar(pan_venta, lb_venta);
        lb_iconoventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_venta_naranjaclaro.png")));
    }//GEN-LAST:event_pan_ventaMouseEntered

    private void pan_ventaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_ventaMouseExited
        desactivar(pan_venta, lb_venta);
        lb_iconoventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_venta_naranja.png")));
    }//GEN-LAST:event_pan_ventaMouseExited

    private void pan_inventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_inventarioMouseEntered
        activar(pan_inventario, lb_inventario);
        lb_iconoinventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_inventario_naranjaclaro.png")));
    }//GEN-LAST:event_pan_inventarioMouseEntered

    private void pan_inventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_inventarioMouseExited
        desactivar(pan_inventario, lb_inventario);
        lb_iconoinventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_inventario_naranja.png")));
    }//GEN-LAST:event_pan_inventarioMouseExited

    private void pan_reportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_reportesMouseEntered
        activar(pan_reportes, lb_reportes);
        lb_iconoreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_reportes_naranjaclaro.png")));
    }//GEN-LAST:event_pan_reportesMouseEntered

    private void pan_reportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pan_reportesMouseExited
        desactivar(pan_reportes, lb_reportes);
        lb_iconoreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icono_reportes_naranja.png")));
    }//GEN-LAST:event_pan_reportesMouseExited

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frm_menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_fondo;
    private javax.swing.JLabel lb_iconoinventario;
    private javax.swing.JLabel lb_iconoreportes;
    private javax.swing.JLabel lb_iconoservicio;
    private javax.swing.JLabel lb_iconoventa;
    private javax.swing.JLabel lb_inventario;
    private javax.swing.JLabel lb_inventariodescripcion;
    private javax.swing.JLabel lb_reportes;
    private javax.swing.JLabel lb_reportesdescripcion;
    private javax.swing.JLabel lb_servicio;
    private javax.swing.JLabel lb_serviciodescripcion;
    private javax.swing.JLabel lb_venta;
    private javax.swing.JLabel lb_ventadescripcion;
    private javax.swing.JPanel pan_inventario;
    private javax.swing.JPanel pan_reportes;
    private javax.swing.JPanel pan_servicios;
    private javax.swing.JPanel pan_venta;
    // End of variables declaration//GEN-END:variables
}
