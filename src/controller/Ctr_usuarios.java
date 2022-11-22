package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Mdl_Persona;
import model.Mdl_User;

public class Ctr_usuarios {

    int i;
    public ArrayList<Mdl_User> consultar() {
        ArrayList<Mdl_User> listauser = new ArrayList();
        Conexion conectar = new Conexion();
        Ctr_Personas cp = new Ctr_Personas();
        Mdl_Persona persona = new Mdl_Persona();
        String sql = "SELECT * FROM users WHERE estado = '1'";
        ResultSet rs;
        try
        {
            rs = conectar.consultar(sql);
            while (rs.next())
            {
                Mdl_User user = new Mdl_User();
                user.setIduser(rs.getInt("IDUSER"));
                user.setClave(rs.getString("CLAVE"));
                user.setTipouser(rs.getString("TIPO_USER"));
                user.setNombreuser(rs.getString("NOMBRE_USER"));
                user.setUestado(rs.getString("ESTADO"));
                user.setUfechamodificacion(rs.getString("FECHA_MODIFICACION"));
                user.setUfecharegistro(rs.getString("FECHA_REGISTRO"));
                persona = cp.consultar(rs.getInt("PERSONA"));
                user.setApellidos(persona.getApellidos());
                user.setNombres(persona.getNombres());
                user.setEstado(persona.getEstado());
                user.setFechamodificacion(persona.getFechamodificacion());
                user.setFecharegistro(persona.getFecharegistro());
                user.setIdpersona(persona.getIdpersona());
                listauser.add(user);
            }
        } catch (SQLException error)
        {
            System.out.println("Error en la consulta de usuario :" + error);
            JOptionPane.showMessageDialog(null, "Error en la consulta de usuario");
        }
        return listauser;
    }

    public void GuardarUsuario(Mdl_User user) {
        Conexion conectar = new Conexion();
        CtrUtilitario fh = new CtrUtilitario();
        Ctr_Personas persona = new Ctr_Personas();
        if (ValidarNombreUser(user))
        {
            JOptionPane.showMessageDialog(null, "Nombre de usuario existente", "Error", JOptionPane.WARNING_MESSAGE);
        } else
        {
            persona.llenarPersona(user);
            String sql = "INSERT INTO users(iduser,clave,tipo_user,nombre_user,fecha_registro,fecha_modificacion,estado,persona)VALUES(" + autoImcremento() + ",'" + user.getClave() + "', '" + user.getTipouser() + "','" + user.getNombreuser() + "','" + fh.fechaHoy() + "'," + null + "," + "'1'" + "," + 1 + ")";
            conectar.ejecutar(sql);   
        }
    }

    boolean ValidarNombreUser(Mdl_User user) {
        boolean sw = false;
        Conexion conectar = new Conexion();
        String validarUser = "select * from users";
        ResultSet rs = conectar.consultar(validarUser);
        String usuario;
        try
        {
            while (rs.next())
            {
                usuario = rs.getString("NOMBRE_USER");
                if (user.getNombreuser().equalsIgnoreCase(usuario))
                {
                    sw = true;
                }
            }

        } catch (Exception e)
        {
        }
        return sw;
    }

    int autoImcremento() {
        Conexion conectar = new Conexion();
        int index = 0;
        String sql = "select iduser from users";
        ResultSet rs = conectar.consultar(sql);
        try
        {
            while (rs.next())
            {
                index = rs.getInt("IDUSER");
            }
        } catch (SQLException error)
        {
            System.out.println("Error al incrementar");
        }
        index++;
        return index;
    }
    public void modificarUsuario(Mdl_User user, int id){
        Conexion conectar = new Conexion();
        CtrUtilitario fh = new CtrUtilitario();
        String sql="UPDATE PERSONAS SET NOMBRES ='"+user.getNombres()+"' WHERE IDPERSONA ="+id;
        conectar.ejecutar(sql);
        sql="UPDATE PERSONAS SET APELLIDOS ='"+user.getApellidos()+"' WHERE IDPERSONA ="+id;
        conectar.ejecutar(sql);
        sql="UPDATE PERSONAS SET FECHA_MODIFICACION ='"+fh.fechaHoy()+"' WHERE IDPERSONA ="+id;
        conectar.ejecutar(sql);
        sql="UPDATE USERS SET CLAVE ='"+user.getClave()+"' WHERE IDUSER ="+id;
        conectar.ejecutar(sql);
        sql="UPDATE USERS SET NOMBRE_USER ='"+user.getNombreuser()+"' WHERE IDUSER ="+id;
        conectar.ejecutar(sql);
        sql="UPDATE USERS SET FECHA_MODIFICACION ='"+fh.fechaHoy()+"' WHERE IDUSER ="+id;
        conectar.ejecutar(sql);
        consultar();
    }

}
