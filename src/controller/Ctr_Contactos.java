package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Mdl_Contactos;
import model.Mdl_Persona;

public class Ctr_Contactos {

    ArrayList<Mdl_Contactos> lis = new ArrayList();

    public void ingresarContacto(Mdl_Contactos contacto) {
        Conexion conectar = new Conexion();
        CtrUtilitario util = new CtrUtilitario();
        Ctr_Personas per = new Ctr_Personas();
        lis = consultarContactos();
        String sql = "";
        if (lis.isEmpty())
        {
            sql = "INSERT INTO contactos(IDCONTACTO, TIPO_CONTACTO, PERSONA, EMAIL, ALIAS, ESTADO, FECHA_REGISTRO, FECHA_MODIFICACION, FECHA_IMPORTANTE, TIPO_FECHA, GRUPO, RELACION, SITIO_WEB, VISIBILIDAD) "
                    + "VALUES (" + 1 + ", '" + contacto.getTipo_contacto() + "', " + 1 + ",'" + contacto.getEmail() + "', '" + contacto.getAlias() + "', '" + contacto.getConEstado() + "', '" + util.fechaHoy() + "',"+null+",'" + contacto.getFecha_importante() + "', '" + contacto.getTipo_fecha() + "', '" + contacto.getGrupo() + "', '" + contacto.getRelacion() + "', '" + contacto.getSitio_web() + "', '" + contacto.getVisibilidad() + "')";
        } else
        {
            per.llenarPersona(contacto,autoImcremento());
             sql = "INSERT INTO contactos(IDCONTACTO, TIPO_CONTACTO, PERSONA, EMAIL, ALIAS, ESTADO, FECHA_REGISTRO, FECHA_MODIFICACION, FECHA_IMPORTANTE, TIPO_FECHA, GRUPO, RELACION, SITIO_WEB, VISIBILIDAD) "
                    + "VALUES (" + autoImcremento() + ", '" + contacto.getTipo_contacto() + "', " + autoImcremento()+ ",'" + contacto.getEmail() + "', '" + contacto.getAlias() + "', '" + contacto.getConEstado() + "', '" + util.fechaHoy() + "',"+null+",'" + contacto.getFecha_importante() + "', '" + contacto.getTipo_fecha() + "', '" + contacto.getGrupo() + "', '" + contacto.getRelacion() + "', '" + contacto.getSitio_web() + "', '" + contacto.getVisibilidad() + "')";
        }
        conectar.ejecutar(sql);
    }

    public void actualizarContacto(Mdl_Contactos contacto, int index) {
        Conexion conectar = new Conexion();
        CtrUtilitario util = new CtrUtilitario();
        String sql="";
        sql = "UPDATE Personas set Nombres ='" + contacto.getNombres()+"' where idPersona ="+index;
        conectar.ejecutar(sql);
        sql = "UPDATE Personas set apellidos ='" + contacto.getApellidos()+"' where idPersona = "+index;
        conectar.ejecutar(sql);
        sql = "UPDATE Personas set fecha_modificacion ='" +util.fechaHoy()+"' where idPersona = "+index;
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET TIPO_CONTACTO ='" + contacto.getTipo_contacto() + "' WHERE IDCONTACTO =" + index;    
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET EMAIL ='" + contacto.getEmail() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET ALIAS ='" + contacto.getAlias() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET ESTADO ='" + contacto.getEstado() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET FECHA_MODIFICACION ='" + util.fechaHoy() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
        sql = "update contactos set fecha_importante ='" + contacto.getFecha_importante() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET TIPO_FECHA ='" + contacto.getTipo_fecha() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET GRUPO ='" + contacto.getGrupo() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET RELACION ='" + contacto.getRelacion() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET SITIO_WEB ='" + contacto.getSitio_web() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
        sql = "UPDATE contactos SET VISIBILIDAD ='" + contacto.getVisibilidad() + "' WHERE IDCONTACTO =" + index;
        conectar.ejecutar(sql);
    }

    int autoImcremento(){
        Conexion conectar = new Conexion();
        int index = 0;
        String sql = "select * from contactos";
        ResultSet rs = conectar.consultar(sql);
        try
        {
            while (rs.next())
            {
                index = rs.getInt("IDCONTACTO");
            }
        } catch (SQLException error)
        {
            System.out.println("Error al incrementar");
        }
        index++;
        return index;
    }

    public ArrayList<Mdl_Contactos> consultarContactos() {
        ArrayList<Mdl_Contactos> listacontac = new ArrayList();
        Conexion conectar = new Conexion();
        Mdl_Persona persona = new Mdl_Persona();
        Ctr_Personas cp = new Ctr_Personas();
//        CtrUtilitario util = new CtrUtilitario();
        String sql = "SELECT * FROM contactos";
//        if (util.retornarUsuario == 2)
//        {
//            sql = "SELECT * FROM contactos where visibilidad = '2'";
//        }else{
//            sql = "SELECT * FROM contactos";
//        }
        ResultSet rs= conectar.consultar(sql);
        try
        {
            while (rs.next())
            {
                Mdl_Contactos cont = new Mdl_Contactos();
                cont.setIdcontacto(rs.getInt("IDCONTACTO"));
                cont.setTipo_contacto(rs.getString("TIPO_CONTACTO"));
                cont.setPersona(rs.getInt("PERSONA"));
                cont.setEmail(rs.getString("EMAIL"));
                cont.setAlias(rs.getString("ALIAS"));
                cont.setConEstado(rs.getString("ESTADO"));
                cont.setConFecha_registro(rs.getString("FECHA_REGISTRO"));
                cont.setConFecha_modificacion(rs.getString("FECHA_MODIFICACION"));
                cont.setFecha_importante(rs.getString("FECHA_IMPORTANTE"));
                cont.setTipo_fecha(rs.getString("TIPO_FECHA"));
                cont.setGrupo(rs.getString("GRUPO"));
                cont.setRelacion(rs.getString("RELACION"));
                cont.setSitio_web(rs.getString("SITIO_WEB"));
                cont.setVisibilidad(rs.getString("VISIBILIDAD"));
                persona = cp.consultar(rs.getInt("PERSONA"));
                cont.setIdpersona(persona.getIdpersona());
                cont.setNombres(persona.getNombres());
                cont.setApellidos(persona.getApellidos());
                cont.setEstado(persona.getEstado());
                cont.setFecharegistro(persona.getFecharegistro());
                cont.setFechamodificacion(persona.getFechamodificacion());
                listacontac.add(cont);
            }
        } catch (SQLException e)
        {
            System.out.println(e);
        }
        return listacontac;
    }
}
