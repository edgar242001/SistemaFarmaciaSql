/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Venta {
    private String numero_id;
    private String clienteid;
    private String empleadoid;
    private String fecha;
    private String montototal;
    private final String[] columnas = {"NUMERO_ID", "CLIENTEID", "EMPLEADOID","FECHA","MONTOTOTAL"};

    public String getNumero_id() {
        return numero_id;
    }

    public void setNumero_id(String numero_id) {
        this.numero_id = numero_id;
    }

    public String getClienteid() {
        return clienteid;
    }

    public void setClienteid(String clienteid) {
        this.clienteid = clienteid;
    }

    public String getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(String empleadoid) {
        this.empleadoid = empleadoid;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMontototal() {
        return montototal;
    }

    public void setMontototal(String montototal) {
        this.montototal = montototal;
    }

     public DefaultTableModel getVentaT() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);
        try {
            Connection con = new ConexionBD().conectarMySQL();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ventas");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venta ven = new Venta();
                ven.setNumero_id(rs.getString(1));
                ven.setClienteid(rs.getString(2));
                ven.setEmpleadoid(rs.getString(3));
                ven.setFecha(rs.getString(4));
                ven.setMontototal(rs.getString(5));
                String[] datos = {ven.getNumero_id(), ven.getClienteid(), ven.getEmpleadoid(), ven.getFecha(),ven.getMontototal()};
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
