package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Mdl_Persona;
import model.Mdl_User;

public class Ctr_Personas {

    public Mdl_Persona consultar(int id) {
        Conexion conectar = new Conexion();
        Mdl_Persona persona = new Mdl_Persona();
        String sql = "SELECT * FROM personas WHERE idpersona = " + id;
        ResultSet rs;
        try
        {
            rs = conectar.consultar(sql);
            if (rs.next())
            {
                persona.setIdpersona(rs.getInt("IDPERSONA"));
                persona.setNombres(rs.getString("NOMBRES"));
                persona.setApellidos(rs.getString("APELLIDOS"));
                persona.setEstado(rs.getString("ESTADO"));
                persona.setFechamodificacion(rs.getString("FECHA_MODIFICACION"));
                persona.setFecharegistro(rs.getString("FECHA_REGISTRO"));
            }
        } catch (SQLException error)
        {
            System.out.println("Error en la consulta de usuario :" + error);
            JOptionPane.showMessageDialog(null, "Error en la consulta de usuario");
        }
        return persona;
    }

    public void llenarPersona(Mdl_User user) {
        Conexion conectar = new Conexion();
        CtrUtilitario fh = new CtrUtilitario();
        if (unAdministrador() == 1)
        {
            String sql = "INSERT INTO personas(idpersona,nombres,apellidos,Estado,fecha_registro,fecha_modificacion)Values(" + 1 + ",'" + user.getNombres() + "','" + user.getApellidos() + "','" + user.getEstado() + "','" + fh.fechaHoy() + "'," + null + ")";
            conectar.ejecutar(sql);
        }
    }

    int unAdministrador() {
        Conexion conectar = new Conexion();
        int index = 0;
        String sql = "select idpersona from personas";
        ResultSet rs = conectar.consultar(sql);
        try
        {
            while (rs.next())
            {
                index = rs.getInt("IDPERSONA");
            }
        } catch (SQLException e)
        {
        }
        index++;
        return index;
    }
}
