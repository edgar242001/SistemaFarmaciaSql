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
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Medicamentos {
      
   private String codigo;  
   private String nombre;  
   private String precio;  
   private String componentes;  
   private String excipiente;  
   private String laboratorio;  
   private final String[] columnas = {"CODIGO", "NOMBRE", "PRECIO","COMPONENTES","EXCIPIENTE","LABORATORIO"};

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public String getExcipiente() {
        return excipiente;
    }

    public void setExcipiente(String excipiente) {
        this.excipiente = excipiente;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
     public DefaultTableModel getMedicamentoT() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);
        try {
            Connection con = new ConexionBD().conectarMySQL();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM medicamento");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicamentos med = new Medicamentos();
                med.setCodigo(rs.getString(1));
                med.setNombre(rs.getString(2));
                med.setPrecio(rs.getString(3));
                med.setComponentes(rs.getString(4));
                med.setExcipiente(rs.getString(5));
                med.setLaboratorio(rs.getString(6));
                String[] datos = {med.getCodigo(), med.getNombre(), med.getPrecio(), med.getComponentes(),med.getExcipiente(),med.getLaboratorio()};
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
