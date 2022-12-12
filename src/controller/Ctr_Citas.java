package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Mdl_Citas;
import model.Mdl_Notas;

public class Ctr_Citas {

    public void Guardar(Mdl_Citas Citas) {
        Conexion conectar = new Conexion();

        String sql = "INSERT INTO CITAS(IDCITA, TITULO, DESCRIPCION, FECHA_CITA, HORA_CITA, TIPO_CITA, ESTADO, FECHA_REGISTRO, FECHA_MODIFICACION, UBICACION, REPETICION, ZONA_HORARIA, VISIBILIDAD)VALUES(" + Citas.getIdCitas() + ",'" + Citas.getTituloCita() + "','" + Citas.getDescripcionCita() + "','"
                + Citas.getFecha_cita() + "','" + Citas.getHora_cita() + "','" + Citas.getTipo_cita() + "','" + Citas.getEstado_cita() + "','" + Citas.getFecha_registroCita()+ "','" + Citas.getFecha_modificacionCita() + "','" + Citas.getUbicacion_cita() + "','" + Citas.getRepeticion_cita() + "','"
                + Citas.getZona_horariaCita() + "','" + Citas.getVisibilidad_cita() + "')";
        conectar.ejecutar(sql);
    }

    public int autoImcremento() {
        Conexion conectar = new Conexion();
        int index = 0;
        String sql = "select IDCITA from citas";
        ResultSet rs = conectar.consultar(sql);
        try {
            while (rs.next()) {
                index = rs.getInt("IDCITA");
            }
        } catch (SQLException error) {
            System.out.println("Error al incrementar");
        }
        index++;
        return index;
    }

    public String fechaHoy() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public void modificar(Mdl_Citas citas) {
        Conexion conectar = new Conexion();
        String sql = "UPDATE CITAS SET TITULO='" + citas.getTituloCita() + "',DESCRIPCION='" + citas.getDescripcionCita() + "', FECHA_CITA='" + citas.getFecha_cita() + "',HORA_CITA='" + citas.getHora_cita() + "',TIPO_CITA='"
                + citas.getTipo_cita() + "',UBICACION='" + citas.getUbicacion_cita() + "' WHERE IDCITA=" + citas.getIdCitas() + "";
        try {
            conectar.ejecutar(sql);
            JOptionPane.showMessageDialog(null, "Cita modificada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La cita no ha sido modificada" + e);
        }

    }

    public void eliminar(Mdl_Citas cita) {
        Conexion conectar = new Conexion();
        String sql = "DELETE FROM CITAS WHERE TITULO='" + cita.getTituloCita() + "'";
        conectar.ejecutar(sql);
        String sql2 = "SELECT * FROM CITAS";
        ResultSet result = conectar.consultar(sql2);

        try {
            int i = 1;
            String titulo;
            while (result.next()) {
                titulo = result.getString("TITULO");
                String sql3 = "UPDATE CITAS SET IDCITA=" + i + " WHERE TITULO='" + titulo + "'";
                conectar.ejecutar(sql3);
                i++;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Mdl_Citas> llenarTabla() {
        ArrayList<Mdl_Citas> listaCitas = new ArrayList<Mdl_Citas>();
        Conexion conectar = new Conexion();
        ResultSet rs;
        int id = 1;
        String sql = "SELECT * FROM CITAS WHERE VISIBILIDAD = '0' ";
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {

                Mdl_Citas modelo = new Mdl_Citas();
                modelo.setIdCitas(rs.getInt("IDCITA"));
//                if (modelo.getId_nota() > id) {
//                    modelo.setId_nota(id);
//                    id++;
//                } else {
//                    id++;
//                }
                modelo.setTituloCita(rs.getString("TITULO"));
                modelo.setDescripcionCita(rs.getString("DESCRIPCION"));
                modelo.setFecha_cita(rs.getString("FECHA_CITA"));
                modelo.setHora_cita(rs.getString("HORA_CITA"));
                modelo.setTipo_cita(rs.getString("TIPO_CITA"));
                modelo.setFecha_registroCita(rs.getString("FECHA_REGISTRO"));
                modelo.setUbicacion_cita(rs.getString("UBICACION"));
                listaCitas.add(modelo);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar tabla " + e);
        }
        return listaCitas;
    }

    public ArrayList<Mdl_Citas> CitasPrivadas() {
        ArrayList<Mdl_Citas> listaCitas = new ArrayList<Mdl_Citas>();
        Conexion conectar = new Conexion();
        ResultSet rs;
        int id = 1;
        String sql = "SELECT * FROM CITAS WHERE VISIBILIDAD = '1' ";
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {

                Mdl_Citas modelo = new Mdl_Citas();
                modelo.setIdCitas(rs.getInt("IDCITA"));
//                if (modelo.getId_nota() > id) {
//                    modelo.setId_nota(id);
//                    id++;
//                } else {
//                    id++;
//                }
                modelo.setTituloCita(rs.getString("TITULO"));
                modelo.setDescripcionCita(rs.getString("DESCRIPCION"));
                modelo.setFecha_cita(rs.getString("FECHA_CITA"));
                modelo.setHora_cita(rs.getString("HORA_CITA"));
                modelo.setTipo_cita(rs.getString("TIPO_CITA"));
                modelo.setFecha_registroCita(rs.getString("FECHA_REGISTRO"));
                modelo.setUbicacion_cita(rs.getString("UBICACION"));
                listaCitas.add(modelo);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar tabla " + e);
        }
        return listaCitas;
    }

    public ArrayList<Mdl_Citas> buscarCitas(Mdl_Citas titulo) {
        ArrayList<Mdl_Citas> listaCitas = new ArrayList<Mdl_Citas>();
        Conexion conectar = new Conexion();
        Mdl_Citas modelo = new Mdl_Citas();
        ResultSet rs;
        String sql = "SELECT * FROM CITAS WHERE TITULO ='" + titulo.getTituloCita() + "'";
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                
                modelo.setIdCitas(rs.getInt("IDCITA"));
                modelo.setTituloCita(rs.getString("TITULO"));
                modelo.setDescripcionCita(rs.getString("DESCRIPCION"));
                modelo.setFecha_cita(rs.getString("FECHA_CITA"));
                modelo.setHora_cita(rs.getString("HORA_CITA"));
                modelo.setTipo_cita(rs.getString("TIPO_CITA"));
                modelo.setFecha_registroCita(rs.getString("FECHA_REGISTRO"));
                modelo.setUbicacion_cita(rs.getString("UBICACION"));
                listaCitas.add(modelo);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar tabla " + e);
        }
        return listaCitas;
    }

    public int buscarTitulo(Mdl_Citas titulo) {

        Conexion conectarse = new Conexion();
        ResultSet rs = null;
        String sql = "SELECT TITULO FROM CITAS";

        int works = 0;
        try {
            rs = conectarse.consultar(sql);

            while (rs.next()) {
                String tituloo = rs.getString("TITULO");
                if (tituloo.equals(titulo.getTituloCita())) {
                    JOptionPane.showMessageDialog(null, "Este titulo ya se encuentra en la Base de datos por favor digite otro");
                    works = 1;
                    break;

                }

            }
        } catch (Exception e) {
            System.out.println("Error al consultar la tabla" + e);
        }

        return works;
    }

    public int CuentaCitas() {
        int cantidad = 0;

        Conexion conectar = new Conexion();
        String sql = "SELECT IDCITA FROM CITAS";
        ResultSet rs = null;
        rs = conectar.consultar(sql);

        try {
            while (rs.next()) {
                cantidad++;
            }
        } catch (Exception ex) {
            System.out.println("Error en la Consulta" + ex);
        }
        return cantidad;
    }

}
