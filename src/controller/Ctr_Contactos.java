package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Mdl_Contactos;

public class Ctr_Contactos {
  public Mdl_Contactos consultar(int id){
    Mdl_Contactos contacto = new Mdl_Contactos();
    Conexion conectar = new Conexion();
    String sql = "SELECT * FROM contactos WHERE IDCONTACTO = " + id;
    ResultSet rs;
    
    try {
      rs = conectar.consultar(sql);
      if (rs.next()){
        contacto.setIdContacto(rs.getInt("IDCONTACTO"));
        contacto.setTipo_Contacto(rs.getString("TIPO_CONTACTO"));
        contacto.setPersona(rs.getInt("PERSONA"));
        contacto.setEmail(rs.getString("EMAIL"));
        contacto.setAlias(rs.getString("ALIAS"));
        contacto.setEstado(rs.getString("ESTADO"));
        contacto.setFecha_Registro(rs.getString("FECHA_REGISTRO"));
        contacto.setFecha_Modificacion(rs.getString("FECHA_MODIFICACION"));
        contacto.setFecha_Importante(rs.getString("FECHA_IMPORTANTE"));
        contacto.setTipo_Fecha(rs.getString("TIPO_FECHA"));
        contacto.setGrupo(rs.getString("GRUPO"));
        contacto.setRelacion(rs.getString("RELACION"));
        contacto.setSitio_Web(rs.getString("SITIO_WEB"));
        contacto.setVisibilidad(rs.getString("VISIBILIDAD"));
      }
    } catch (SQLException error){
      System.out.println("Error en la consulta de contacto :" + error);
      JOptionPane.showMessageDialog(null, "Error en la consulta de contacto");
    } 
    return contacto;
  }
}
