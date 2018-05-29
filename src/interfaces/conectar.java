/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author AniLMora
 */
import java.sql.*;
import javax.swing.*;

class conectar {
    Connection conect = null;
	public Connection conexion()
		{
			try {
				//Cargamos el Driver MySQL
				Class.forName("com.mysql.jdbc.Driver");
				//Class.forName("org.gjt.mm.mysql.Driver");
				conect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdkjpe","root","");
				System.out.println("conexion establecida");
				JOptionPane.showMessageDialog(null,"Conectado");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("error de conexion");
				JOptionPane.showMessageDialog(null,"Error de conexion"+e);
			}
			return conect;
                }
}
