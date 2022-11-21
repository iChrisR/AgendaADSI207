/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Mdl_Persona;

/**
 *
 * @author scorpion
 */
public class Ctr_Personas {
    public Mdl_Persona consultar(int id) {
        Conexion conectar = new Conexion();
        Mdl_Persona persona = new Mdl_Persona();
        String sql = "SELECT * FROM personas WHERE idpersona = "+id;
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            if(rs.next()){                
                persona.setIdpersona(rs.getInt("IDPERSONA"));
                persona.setNombres(rs.getString("NOMBRES"));
                persona.setApellidos(rs.getString("APELLIDOS"));
                persona.setEstado(rs.getString("ESTADO"));
                persona.setFechamodificacion(rs.getString("FECHA_MODIFICACION"));
                persona.setFecharegistro(rs.getString("FECHA_REGISTRO"));                
            }
        } catch (SQLException error) {
            System.out.println("Error en la consulta de usuario :"+error);
            JOptionPane.showMessageDialog(null,"Error en la consulta de usuario");
        }
        return persona;
    }
}
