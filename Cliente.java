/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgar
 */
public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private final String[] columnas = {"CI", "NOMBRES", "APELLIDOS"};
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public DefaultTableModel getClienteT() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);
        try {
            Connection con = new ConexionBD().conectarMySQL();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setDni(rs.getString(1));
                cli.setNombre(rs.getString(2));
                cli.setApellido(rs.getString(3));
                String[] datos = {cli.getDni(), cli.getNombre(), cli.getApellido()};
                modelo.addRow(datos);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;

    } 

    
    
}
   