
package Vista;

import Dao.VentaDAO;
import Dao.DetalleVentaDAO;
import Modelo.Venta;
import Modelo.DetalleVenta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frm_venta extends javax.swing.JFrame {

    private int codigoVentaActual = 0;
    DefaultTableModel modelo;
    int filaSeleccionada = -1;

    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public frm_venta() {
        initComponents();
        
        configurarTabla();
        tblItems.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarItem();
            }
        });
        txtFecha.setText(LocalDateTime.now().format(formatoFecha));
        txtMonto.setText("0.00");
    }
    
    // Método para configurar la tabla
    private void configurarTabla() {
        modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        modelo.addColumn("Item");
        modelo.addColumn("Cod. Producto");
        modelo.addColumn("N. Producto");
        modelo.addColumn("N. Cliente");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");

        tblItems.setModel(modelo);

        txtCodVenta.setEditable(false);
        txtFecha.setEditable(false);
        txtMonto.setEditable(false);
    }
    
    public void cargarVenta(int codigoVenta) {

        VentaDAO ventaDAO = new VentaDAO();
        DetalleVentaDAO detalleDAO = new DetalleVentaDAO();

        // Buscar la cabecera
        Venta venta = ventaDAO.buscar(codigoVenta);

        if (venta == null) {

            JOptionPane.showMessageDialog(this,
                    "No se encontró la venta.");
            return;
        }

        // Buscar los productos
        List<DetalleVenta> detalles =
                detalleDAO.listar(codigoVenta);

        // Guardar el código de la venta actual
        codigoVentaActual = venta.getCodigo();

        // Mostrar la cabecera
        txtCodVenta.setText(
                String.valueOf(venta.getCodigo()));

        txtCliente.setText(venta.getNombreCliente());

        txtFecha.setText(
                venta.getFecha().format(formatoFecha));

        txtMonto.setText(
                venta.getMontoTotal().toPlainString());

        // Limpiar la tabla
        modelo.setRowCount(0);

        // Agregar los productos registrados
        for (DetalleVenta d : detalles) {

            Object[] fila = {
                modelo.getRowCount() + 1,
                d.getCodigoProducto(),
                d.getNombreProducto(),
                venta.getNombreCliente(),
                d.getCantidad(),
                d.getPrecioUnitario(),
                d.getSubtotal()
            };

            modelo.addRow(fila);
        }

        // Quitar la selección
        tblItems.clearSelection();
        filaSeleccionada = -1;

        limpiarItem();
    }
    
    public void nuevaVenta() {
        codigoVentaActual = 0;

        txtCodVenta.setText("");
        txtCliente.setText("");

        txtFecha.setText(
                LocalDateTime.now().format(formatoFecha));

        txtMonto.setText("0.00");

        modelo.setRowCount(0);

        tblItems.clearSelection();
        filaSeleccionada = -1;

        limpiarItem();

        txtCliente.requestFocus();
    }

    private void limpiarItem() {
        txtCodProducto.setText("");
        txtProducto.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
    }
    
    private void seleccionarItem() {
        int fila = tblItems.getSelectedRow();
        
        if (fila == -1) {
            filaSeleccionada = -1;
            limpiarItem();
            return;
        }
        
        filaSeleccionada = tblItems.convertRowIndexToModel(fila);

        // Cargar datos de la fila seleccionada
        Object codigo = modelo.getValueAt(filaSeleccionada, 1);
        Object producto = modelo.getValueAt(filaSeleccionada, 2);
        Object cantidad = modelo.getValueAt(filaSeleccionada, 4);
        Object precio = modelo.getValueAt(filaSeleccionada, 5);

        txtCodProducto.setText(codigo == null ? "" : codigo.toString());
        txtProducto.setText(producto == null ? "" : producto.toString());
        txtCantidad.setText(cantidad == null ? "" : cantidad.toString());
        txtPrecio.setText(precio == null ? "" : precio.toString());
    }
    
    private void calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object valor = modelo.getValueAt(i, 6);
            if (valor != null) {
                BigDecimal subtotal = new BigDecimal(valor.toString());
                total = total.add(subtotal);
            }
        }
        txtMonto.setText(total.toPlainString());
    }

    private void renumerarItems() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(i + 1, i, 0);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnNuevoItem = new javax.swing.JButton();
        btnEliminarItem = new javax.swing.JButton();
        btnGuardarItem = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodVenta = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Cod. Producto", "N. Producto", "N. Cliente", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblItems);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Items"));
        jPanel2.setToolTipText("");
        jPanel2.setFocusable(false);
        jPanel2.setName(""); // NOI18N

        jLabel2.setText("Cod. Producto:");

        jLabel4.setText("N. Producto:");

        jLabel6.setText("Precio:");

        jLabel7.setText("Cantidad:");

        txtCodProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProductoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        btnNuevoItem.setText("Nuevo Item");
        btnNuevoItem.setPreferredSize(new java.awt.Dimension(90, 23));
        btnNuevoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoItemActionPerformed(evt);
            }
        });

        btnEliminarItem.setText("Eliminar Item");
        btnEliminarItem.setPreferredSize(new java.awt.Dimension(90, 23));
        btnEliminarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarItemActionPerformed(evt);
            }
        });

        btnGuardarItem.setText("Guardar Item");
        btnGuardarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Fecha:");

        jLabel10.setText("Monto:");

        jLabel11.setText("N. Cliente:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jLabel10)
                .addGap(28, 28, 28)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(20, 20, 20))
        );

        jLabel3.setText("Cod. Venta:");

        txtCodVenta.setEditable(false);
        txtCodVenta.setEnabled(false);
        txtCodVenta.setFocusable(false);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodProductoActionPerformed

    private void btnNuevoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoItemActionPerformed
        // Crear una fila vacía
        Object[] fila = {
            modelo.getRowCount() + 1,
            null,
            null,
            null,
            null,
            null,
            null
        };

        modelo.addRow(fila);

        // Obtener la posición de la nueva fila
        int nuevaFila = modelo.getRowCount() - 1;

        // Seleccionar automáticamente la nueva fila
        int filaVista = tblItems.convertRowIndexToView(nuevaFila);

        tblItems.setRowSelectionInterval(filaVista, filaVista);
        
        // Guardar la fila seleccionada
        filaSeleccionada = nuevaFila;

        // Limpiar los campos
        limpiarItem();
        
        // Colocar el cursor en código de producto
        txtCodProducto.requestFocus();
    }//GEN-LAST:event_btnNuevoItemActionPerformed

    private void btnGuardarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarItemActionPerformed
        // Verificar que exista una fila seleccionada
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,"Primero cree o seleccione un item.");
            return;
        }
        try {
            // Validar los campos
            if (txtCodProducto.getText().trim().isEmpty() || txtProducto.getText().trim().isEmpty() || txtCantidad.getText().trim().isEmpty() || txtPrecio.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete los datos del item.");
                return;
            }

            int codigo = Integer.parseInt(txtCodProducto.getText().trim());

            String producto = txtProducto.getText().trim();

            int cantidad = Integer.parseInt(txtCantidad.getText().trim());

            BigDecimal precio = new BigDecimal(txtPrecio.getText().trim());

            if (codigo <= 0 || cantidad <= 0 || precio.compareTo(BigDecimal.ZERO) < 0) {
                JOptionPane.showMessageDialog(this,"Ingrese valores válidos.");
                return;
            }

            precio = precio.setScale(2, RoundingMode.HALF_UP);

            BigDecimal subtotal = precio.multiply(BigDecimal.valueOf(cantidad));

            // Guardar datos en la fila seleccionada
            modelo.setValueAt(codigo, filaSeleccionada, 1);
            modelo.setValueAt(producto, filaSeleccionada, 2);
            modelo.setValueAt(
                    txtCliente.getText().trim(), filaSeleccionada, 3);
            modelo.setValueAt(cantidad, filaSeleccionada, 4);
            modelo.setValueAt(precio, filaSeleccionada, 5);
            modelo.setValueAt(subtotal, filaSeleccionada, 6);

            // Actualizar monto total
            calcularTotal();

            JOptionPane.showMessageDialog(this,"Item guardado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Ingrese una cantidad y precio válidos.");
        }
    }//GEN-LAST:event_btnGuardarItemActionPerformed

    private void btnEliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarItemActionPerformed
        int fila = tblItems.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this,"Seleccione un item para eliminar.");
            return;
        }
        
        int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Desea eliminar el item seleccionado?",
            "Eliminar item",
            JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            int filaModelo = tblItems.convertRowIndexToModel(fila);

            // Eliminar fila seleccionada
            modelo.removeRow(filaModelo);

            // Renumerar los items
            renumerarItems();

            // Quitar selección
            tblItems.clearSelection();
            filaSeleccionada = -1;

            // Limpiar formulario
            limpiarItem();

            // Actualizar monto
            calcularTotal();
        }
    }//GEN-LAST:event_btnEliminarItemActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String cliente = txtCliente.getText().trim();

        // Validar cliente
        if (cliente.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese el nombre del cliente.");
            return;
        }

        // Validar que existan productos
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Agregue al menos un item.");
            return;
        }

        // Comprobar que todas las filas estén completas
        for (int i = 0; i < modelo.getRowCount(); i++) {

            int[] columnas = {1, 2, 4, 5, 6};

            for (int columna : columnas) {

                Object dato = modelo.getValueAt(i, columna);

                if (dato == null ||
                        dato.toString().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(this,
                            "El item " + (i + 1)
                            + " está incompleto.\n"
                            + "Guárdelo o elimínelo primero.");
                    return;
                }
            }
        }

        try {

            // Crear la cabecera
            Venta venta = new Venta();

            venta.setCodigo(codigoVentaActual);
            venta.setNombreCliente(cliente);

            // Para una venta nueva, registrar fecha actual
            if (codigoVentaActual == 0) {
                venta.setFecha(LocalDateTime.now());
            }

            List<DetalleVenta> detalles = new ArrayList<>();

            // Convertir la JTable en objetos DetalleVenta
            for (int i = 0; i < modelo.getRowCount(); i++) {

                DetalleVenta d = new DetalleVenta();

                d.setCodigoProducto(Integer.parseInt(
                        modelo.getValueAt(i, 1).toString()));

                d.setNombreProducto(
                        modelo.getValueAt(i, 2).toString());

                d.setCantidad(Integer.parseInt(
                        modelo.getValueAt(i, 4).toString()));

                d.setPrecioUnitario(new BigDecimal(
                        modelo.getValueAt(i, 5).toString()));

                d.setSubtotal(new BigDecimal(
                        modelo.getValueAt(i, 6).toString()));

                detalles.add(d);
            }

            VentaDAO dao = new VentaDAO();

            boolean resultado;

            // Nueva venta o actualización
            if (codigoVentaActual == 0) {

                resultado = dao.guardar(venta, detalles);

            } else {

                resultado = dao.actualizar(venta, detalles);
            }

            if (resultado) {

                // Conservar el código del registro
                codigoVentaActual = venta.getCodigo();

                JOptionPane.showMessageDialog(this,
                        "Venta guardada correctamente.\n"
                        + "Código de venta: "
                        + codigoVentaActual);

                // Recargar datos desde MySQL
                cargarVenta(codigoVentaActual);

            } else {

                JOptionPane.showMessageDialog(this,
                        "No se pudo guardar la venta.\n"
                        + "Revise la conexión y el inventario.");
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Existen datos numéricos incorrectos.");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Error al guardar:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminarItem;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarItem;
    private javax.swing.JButton btnNuevoItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblItems;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtCodVenta;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
