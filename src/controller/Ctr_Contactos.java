package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
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
  
  public void IngresarContacto(Mdl_Contactos contacto){
    Conexion conectar = new Conexion();
    CtrUtilitario util = new CtrUtilitario();
    String sql = "INSERT INTO contactos(IDCONTACTO, TIPO_CONTACTO, PERSONA, EMAIL, ALIAS, ESTADO, FECHA_REGISTRO, FECHA_MODIFICACION, FECHA_IMPORTANTE, TIPO_FECHA, GRUPO, RELACION, SITIO_WEB, VISIBILIDAD) "
            + "VALUES ("+contacto.getIdContacto()+", '"+contacto.getTipo_Contacto()+"', "+contacto.getPersona()+",'"+contacto.getEmail()+"', '"+contacto.getAlias()+"', '"+contacto.getEstado()+"', '"+util.fechaHoy()+"', NULL, '"+contacto.getFecha_Importante()+"', '"+contacto.getTipo_Fecha()+"', '"+contacto.getGrupo()+"', '"+contacto.getRelacion()+"', '"+contacto.getSitio_Web()+"', '"+contacto.getVisibilidad()+"')";
    conectar.ejecutar(sql);
  }
  
  public void actualizarContacto(Mdl_Contactos contacto){
    Conexion conectar = new Conexion();
    CtrUtilitario util = new CtrUtilitario();
    String sql = "UPDATE contactos SET TIPO_CONTACTO ='"+contacto.getTipo_Contacto()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET PERSONA ="+contacto.getPersona()+" WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET EMAIL ='"+contacto.getEmail()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET ALIAS ='"+contacto.getAlias()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET ESTADO ='"+contacto.getEstado()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET FECHA_MODIFICACION ='"+util.fechaHoy()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET FECHA_IMPORTANTE ='"+contacto.getFecha_Importante()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET TIPO_FECHA ='"+contacto.getTipo_Fecha()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET GRUPO ='"+contacto.getGrupo()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET RELACION ='"+contacto.getRelacion()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET SITIO_WEB ='"+contacto.getSitio_Web()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
    sql = "UPDATE contactos SET VISIBILIDAD ='"+contacto.getVisibilidad()+"' WHERE IDCONTACTO ="+contacto.getIdContacto();
    conectar.ejecutar(sql);
  }
  
  int autoImcremento() {
    Conexion conectar = new Conexion();
    int index = 0;
    String sql = "select iduser from users";
    ResultSet rs = conectar.consultar(sql);
    try {
      while (rs.next()) {
        index = rs.getInt("IDUSER");
      }
    } catch (SQLException error) {
      System.out.println("Error al incrementar");
    }
    index++;
    return index;
    }
}
