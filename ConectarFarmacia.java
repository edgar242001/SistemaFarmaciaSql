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

/**
 *
 * @author Edgar
 */
class ConectarFarmacia extends ConexionBD {
    public boolean registrar(Cliente usr) {

        PreparedStatement ps = null;
        Connection con = conectarMySQL();

        String sql = "INSERT INTO Cliente (dni, Nombre, Apellido) VALUES(?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString((2), usr.getNombre());
            ps.setString((3), usr.getApellido());
            ps.setString((1), usr.getDni());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConectarFarmacia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean login(Cliente usr) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = conectarMySQL();

        String sql = "SELECT Dni, Nombre, Apellido FROM Cliente WHERE Cliente = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(2, usr.getNombre());

            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getDni().equals(rs.getString(1))) {
                    
                    usr.setDni(rs.getString(1));
                    usr.setNombre(rs.getString(2));
                    usr.setApellido(rs.getString(3));
                    

                    return true;

                } else {
                    return false;
                }

            }

            return false;

        } catch (SQLException ex) {
            Logger.getLogger(ConectarFarmacia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
   /* public boolean Detalle(Detalle usr) {

        PreparedStatement ps = null;
        Connection con = conectarMySQL();

        String sql = "INSERT INTO detalle_venta(venta_id, medicamento_id, capacidad, precioUnitario) VALUES(?,?,?.?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString((1), usr.getVenta_id());
            ps.setString((2), usr.getMedicamento_id());
            ps.setString((3), usr.getCantidad());
            ps.setString((3), usr.getPrecioUnitario());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConectarFarmacia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }*/

    
    }

    

