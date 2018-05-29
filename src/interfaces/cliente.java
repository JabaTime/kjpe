/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

//import com.sun.istack.internal.logging.Logger;
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
public class cliente extends javax.swing.JFrame {
String Nombre, ApePaterno, ApeMaterno,Genero, Direccion,Telefono,Correo; //puede ser el nomnbre que querramos, no tiene que ver con la bd
    
    DefaultTableModel model, datos;
    private Object Level;
    
    /**
     * Creates new form cliente
     */
    public cliente() {
        initComponents();
        limpiar();
        bloquear();
        desbloquear();
        cargar("");
    }
  void cargar(String valor){ //para cargar los datos
      String [] titulos={"idCliente", "nombre", "ApePat", "ApeMat", "sexo", "direccion", "telefono", "correo"}; //nombre de variables de la BD
      String [] registros = new String [8];
      String sql = "SELECT * from usuario where concat(nombre) like '%"+valor+"%'";
      model = new DefaultTableModel(null, titulos);
        

      
        conectar cc = new conectar();
        Connection cn =cc.conexion();

        try {
            Statement  st =cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                registros[0]=rs.getString("idCliente");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("ApePat");
                registros[3]=rs.getString("ApeMat");
                registros[4]=rs.getString("direccion");
                registros[5]=rs.getString("sexo");
                registros[6]=rs.getString("telefono");
                registros[7]=rs.getString("correo");
                
                model.addRow(registros);
                tDatos.setModel(model);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    
  }
    void limpiar(){
        txtID.setText("");
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtDireccion.setText("");
        cbSexo.setSelectedIndex(0);
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
    
    void bloquear(){
        txtID.setEnabled(false);
        txtNombre.setEnabled(false);
        txtPaterno.setEnabled(false);
        txtMaterno.setEnabled(false);
        txtDireccion.setEnabled(false);
        cbSexo.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCorreo.setEnabled(false);
        btNuevo.setEnabled(true);
        btCancelar.setEnabled(false);
        btGuardar.setEnabled(false);
        btSalir.setEnabled(false);
    }

    void desbloquear(){
        txtID.setEnabled(false);
        txtNombre.setEnabled(true);
        txtPaterno.setEnabled(true);
        txtMaterno.setEnabled(true);
        txtDireccion.setEnabled(true);
        cbSexo.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCorreo.setEnabled(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btNuevo = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        cbSexo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        btEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btModificar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btMostrarTodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("idCliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 60, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ape.Paterno");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ape.Materno");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Dirección");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Sexo");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 100, -1));

        txtPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaternoActionPerformed(evt);
            }
        });
        getContentPane().add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 100, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 110, -1));

        txtMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaternoActionPerformed(evt);
            }
        });
        getContentPane().add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 110, -1));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 100, -1));

        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 60, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Télefono");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Correo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 100, -1));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 110, -1));

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Femenino", "Masculino" }));
        cbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexoActionPerformed(evt);
            }
        });
        getContentPane().add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 110, -1));

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
        jScrollPane1.setViewportView(tDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 740, 140));

        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 770, 330));

        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, -1, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 370, -1));

        jLabel10.setText("Buscar");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 40, 20));

        btMostrarTodo.setText("Mostrar todo");
        btMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMostrarTodoActionPerformed(evt);
            }
        });
        getContentPane().add(btMostrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        conectar c = new conectar();
        Connection cn =c.conexion();
        
        String sql= "";
        
        Nombre= txtNombre.getText();
        ApePaterno= txtPaterno.getText();
        ApeMaterno=txtMaterno.getText();
        Direccion=txtDireccion.getText();
        Genero=cbSexo.getSelectedItem().toString();
        Telefono=txtTelefono.getText();
        Correo=txtCorreo.getText();
        
        sql="INSERT INTO usuario(nombre,ApePat,ApeMat,sexo,direccion,telefono,correo) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1,Nombre);
            pst.setString(2,ApePaterno);
            pst.setString(3,ApeMaterno);
            pst.setString(4,Direccion);
            pst.setString(5,Genero);
            pst.setString(6,Telefono);
            pst.setString(7,Correo);
            
            int n=pst.executeUpdate();
            if(n>0)
                JOptionPane.showMessageDialog(null,"Registro guardado exitosamente");
            
            desbloquear();
            cargar("");         
        }
        
    catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR");
          //Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_btGuardarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
        txtTelefono.transferFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
        limpiar();
        txtNombre.requestFocus();
    }//GEN-LAST:event_btNuevoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        bloquear();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        txtNombre.transferFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaternoActionPerformed
        // TODO add your handling code here:
        txtPaterno.transferFocus();
    }//GEN-LAST:event_txtPaternoActionPerformed

    private void txtMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaternoActionPerformed
        // TODO add your handling code here:
        txtMaterno.transferFocus();
    }//GEN-LAST:event_txtMaternoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtDireccion.transferFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
        txtCorreo.transferFocus();
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        // TODO add your handling code here:
       
{
conectar c = new conectar();
     Connection cn = c.conexion();

        try{
        int fila = tDatos.getSelectedRow();
        String sql = "delete from usuario where idCliente =" + tDatos.getValueAt(fila, 0);
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
}

    }//GEN-LAST:event_btEliminarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        // TODO add your handling code here:

{
conectar c = new conectar();
            Connection cn = c.conexion();
            
        try{
            String sql = "UPDATE usuario SET nombre=?, ApePat=?, ApeMat=?, sexo=?, direccion=?, telefono=?, correo=? " +
                    "WHERE idCliente=?";
            int fila = tDatos.getSelectedRow();
            String dato =(String) tDatos.getValueAt(fila, 0);
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, txtNombre.getText());
            pst.setString(2, txtPaterno.getText());
            pst.setString(3, txtMaterno.getText());
            pst.setString(4, txtDireccion.getText());
            pst.setString(5, cbSexo.getSelectedItem().toString());
            pst.setString(6, txtTelefono.getText());
            pst.setString(7, txtCorreo.getText());
            pst.setString(8, dato);
            
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
     txtNombre.setText(tDatos.getValueAt(filasele, 1 ).toString());
     txtPaterno.setText(tDatos.getValueAt(filasele, 2 ).toString());
     txtMaterno.setText(tDatos.getValueAt(filasele, 3 ).toString());
     txtDireccion.setText(tDatos.getValueAt(filasele, 4 ).toString());
     cbSexo.setSelectedItem(tDatos.getValueAt(filasele, 5 ).toString());
     txtTelefono.setText(tDatos.getValueAt(filasele, 6 ).toString());
     txtCorreo.setText(tDatos.getValueAt(filasele, 7 ).toString());
     filas =filasele;
     desbloquear();


    }//GEN-LAST:event_tDatosMouseClicked

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        //this.dispose();  //es otra manera para salir
    }//GEN-LAST:event_btSalirActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
        cargar(txtBuscar.getText().toString());
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarTodoActionPerformed
        // TODO add your handling code here:
        cargar("");
    }//GEN-LAST:event_btMostrarTodoActionPerformed

    private void cbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexoActionPerformed
        // TODO add your handling code here:
        cbSexo.requestFocus();
    }//GEN-LAST:event_cbSexoActionPerformed

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
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente().setVisible(true);
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
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

int filas;
private void cargar(){
    
}

}