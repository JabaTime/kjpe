/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author AniLMora
 */
public class productos extends javax.swing.JFrame {
    String Nombre, Presentacion, ContenidoNeto, Precio; //puede ser el nomnbre que querramos, no tiene que ver con la bd

DefaultTableModel model, datos;
    private Object Level;

    /**
     * Creates new form productos
     */
    public productos() {
        initComponents();
        limpiar();
        bloquear();
        desbloquear();
        cargar("");
    }
    
    void cargar(String valor){ //para cargar los datos
      String [] titulos={"idProducto", "nombre", "presentacion", "contenido", "precio"}; //nombre de variables de la BD
      String [] registros = new String [5];
      String sql = "SELECT * from productos where concat(nombre) like '%"+valor+"%'";
      model = new DefaultTableModel(null, titulos);
        

      
        conectar cc = new conectar();
        Connection cn =cc.conexion();

        try {
            Statement  st =cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                registros[0]=rs.getString("idProducto");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("presentacion");
                registros[3]=rs.getString("contenido");
                registros[4]=rs.getString("precio");
                
                model.addRow(registros);
                tDatos.setModel(model);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    
  }
    void limpiar(){
        txtID.setText("");
        cbNombre.setSelectedIndex(0);
       cbPresentacion.setSelectedIndex(0);
       cbContenido.setSelectedIndex(0);
       cbPrecio.setSelectedIndex(0);
    }
    
    void bloquear(){
        txtID.setEnabled(false);
        
        cbNombre.setEnabled(false);
        cbPresentacion.setEnabled(false);
        cbContenido.setEnabled(false);
        cbPrecio.setEnabled(false);
        btNuevo.setEnabled(true);
        btCancelar.setEnabled(false);
        btGuardar.setEnabled(false);
        btSalir.setEnabled(false);
    }

    void desbloquear(){
        txtID.setEnabled(false);
        cbNombre.setEnabled(true);
        cbPresentacion.setEnabled(true);
        cbContenido.setEnabled(true);
        cbPrecio.setEnabled(true);
        btNuevo.setEnabled(false);
        btCancelar.setEnabled(true);
        btGuardar.setEnabled(true);
        btSalir.setEnabled(true);
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
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        cbNombre = new javax.swing.JComboBox();
        cbPresentacion = new javax.swing.JComboBox();
        cbContenido = new javax.swing.JComboBox();
        cbPrecio = new javax.swing.JComboBox();
        btNuevo = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btMostrarTodo = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        btEliminar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("id Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Presentación");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Contenido Neto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Precio");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 60, -1));
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, -1));

        cbNombre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "K'jpe Tradicional", "K'jpe Fusion", "K'jpe Panela", "K'jpe Canela" }));
        cbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNombreActionPerformed(evt);
            }
        });
        getContentPane().add(cbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 120, -1));

        cbPresentacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Bolsa", "Frasco" }));
        cbPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPresentacionActionPerformed(evt);
            }
        });
        getContentPane().add(cbPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 120, -1));

        cbContenido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "1 kg", "500 gr", "250 gr" }));
        cbContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbContenidoActionPerformed(evt);
            }
        });
        getContentPane().add(cbContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 120, -1));

        cbPrecio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Bolsa 1kg $145.00", "Bolsa 500gr $75.00", "Bolsa 250gr $40.00", "Frasco 250gr $50.00" }));
        cbPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(cbPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 120, -1));

        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 420));

        jLabel7.setText("Buscar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 330, -1));

        btMostrarTodo.setText("Mostrar todo");
        getContentPane().add(btMostrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, -1, -1));

        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, -1, -1));

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tDatos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 730, 110));

        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
         cargar(txtBuscar.getText().toString());
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void cbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNombreActionPerformed
        // TODO add your handling code here:
         cbNombre.requestFocus();
    }//GEN-LAST:event_cbNombreActionPerformed

    private void cbPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPresentacionActionPerformed
        // TODO add your handling code here:
         cbPresentacion.requestFocus();
    }//GEN-LAST:event_cbPresentacionActionPerformed

    private void cbContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbContenidoActionPerformed
        // TODO add your handling code here:
         cbContenido.requestFocus();
    }//GEN-LAST:event_cbContenidoActionPerformed

    private void cbPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrecioActionPerformed
        // TODO add your handling code here:
         cbPrecio.requestFocus();
    }//GEN-LAST:event_cbPrecioActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
        limpiar();
        cbNombre.requestFocus();
    }//GEN-LAST:event_btNuevoActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        conectar c = new conectar();
        Connection cn =c.conexion();
        
        String sql= "";
        
        Nombre= cbNombre.getSelectedItem().toString();
        Presentacion=cbPresentacion.getSelectedItem().toString();
        ContenidoNeto=cbContenido.getSelectedItem().toString();
        Precio=cbPrecio.getSelectedItem().toString();
        
        sql="INSERT INTO productos (nombre,presentacion,contenido,precio) VALUES(?, ?, ?, ?)";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1,Nombre);
            pst.setString(2,Presentacion);
            pst.setString(3,ContenidoNeto);
            pst.setString(4,Precio);
           
            int n=pst.executeUpdate();
            if(n>0)
                JOptionPane.showMessageDialog(null,"Registro guardado exitosamente");
            
            desbloquear();
            cargar("");         
        }
        
    catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR1"+ ex.getMessage());
          //Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
 
  
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
          bloquear();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
           System.exit(0);
    }//GEN-LAST:event_btSalirActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        // TODO add your handling code here:
        conectar c = new conectar();
     Connection cn = c.conexion();

        try{
        int fila = tDatos.getSelectedRow();
        String sql = "delete from productos where idProducto=" + tDatos.getValueAt(fila, 0);
        Statement  st =cn.createStatement();
        
        //PreparedStatement pst = cn.prepareStatement(sql);
        int n = st.executeUpdate(sql);
        
        if(n>0){
        cargar("");  
        //desbloquear();
        JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
        
        limpiar();
        
        } 
        
        }catch(SQLException e) {
        JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        // TODO add your handling code here:
              {
conectar c = new conectar();
            Connection cn = c.conexion();
            
        try{
            String sql = "UPDATE productos SET nombre=?, presentacion=?,contenido=?, precio=? " +
                    "WHERE idProducto=?";
            int fila = tDatos.getSelectedRow();
            String dato =(String) tDatos.getValueAt(fila, 0);
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cbNombre.getSelectedItem().toString());
            pst.setString(2, cbPresentacion.getSelectedItem().toString());
            pst.setString(3, cbContenido.getSelectedItem().toString());
            pst.setString(4, cbPrecio.getSelectedItem().toString());
            pst.setString(5, dato);
            
            int n = pst.executeUpdate();
            if(n>0){
               
               cargar("");
               limpiar();
               JOptionPane.showMessageDialog(null, "Datos Modificados");
            }
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
                
            
}

    }                                   

  
    }//GEN-LAST:event_btModificarActionPerformed

    private void tDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDatosMouseClicked
        // TODO add your handling code here:
        int filasele = tDatos.getSelectedRow();
     cbNombre.setSelectedItem(tDatos.getValueAt(filasele, 1 ).toString());
     cbPresentacion.setSelectedItem(tDatos.getValueAt(filasele, 2 ).toString());
     cbContenido.setSelectedItem(tDatos.getValueAt(filasele, 3 ).toString());
     cbPrecio.setSelectedItem(tDatos.getValueAt(filasele, 4 ).toString());
     filas =filasele;
     desbloquear();
    }//GEN-LAST:event_tDatosMouseClicked

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
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btMostrarTodo;
    private javax.swing.JButton btNuevo;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox cbContenido;
    private javax.swing.JComboBox cbNombre;
    private javax.swing.JComboBox cbPrecio;
    private javax.swing.JComboBox cbPresentacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables

int filas;
private void cargar(){
    
}

}
