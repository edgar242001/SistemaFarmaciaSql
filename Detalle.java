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
 * @author HP
 */
class Detalle {
    private String venta_id;
    private String medicamento_id;
    private String cantidad;
    private String precioUnitario;
    private final String[] columnas = {"VENTA_ID", "MEDICAMENTO_ID", "CANTIDAD","PRECIOUNITARIO"};

    public String getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(String venta_id) {
        this.venta_id = venta_id;
    }

    public String getMedicamento_id() {
        return medicamento_id;
    }

    public void setMedicamento_id(String medicamento_id) {
        this.medicamento_id = medicamento_id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public DefaultTableModel getDetalleT() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);
        try {
            Connection con = new ConexionBD().conectarMySQL();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM detalle_venta");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Detalle de = new Detalle();
                de.setVenta_id(rs.getString(1));
                de.setMedicamento_id(rs.getString(2));
                de.setCantidad(rs.getString(3));
                de.setPrecioUnitario(rs.getString(4));
                String[] datos = {de.getVenta_id(), de.getMedicamento_id(), de.getCantidad(), de.getPrecioUnitario()};
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
    
