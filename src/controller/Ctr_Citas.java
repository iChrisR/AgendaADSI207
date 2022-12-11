package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Mdl_Citas;

public class Ctr_Citas {

    public void Guardar(Mdl_Citas Citas) {
        Conexion conectar = new Conexion();

        String sql = "INSERT INTO CITAS(IDCITA, TITULO, DESCRIPCION, FECHA_CITA, HORA_CITA, TIPO_CITA, ESTADO, FECHA_REGISTRO, FECHA_MODIFICACION, UBICACION, REPETICION, ZONA_HORARIA, VISIBILIDAD)VALUES(" + autoImcremento() + ",'" + Citas.getTituloCita() + "','" + Citas.getDescripcionCita() + "','"
                + Citas.getFecha_cita() + "','" + Citas.getHora_cita() + "','" + Citas.getTipo_cita() + "','" + Citas.getEstado_cita() + "','" + fechaRegistro() + "','" + Citas.getFecha_modificacionCita() + "','" + Citas.getUbicacion_cita() + "','" + Citas.getRepeticion_cita() + "','"
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

    public String fechaRegistro() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(date);
    }

    public void modificar(Mdl_Citas citas) {
        Conexion conectar = new Conexion();
        String sql = "UPDATE CITAS SET TITULO='" + citas.getTituloCita() + "',DESCRIPCION='" + citas.getDescripcionCita() + "', FECHA_CITA='" + citas.getFecha_cita() + "',HORA_CITA='" + citas.getHora_cita() + "',TIPO_CITA='"
                + citas.getTipo_cita() + "',UBICACION='" + citas.getUbicacion_cita() + "' WHERE IDCITAS=" + citas.getIdCitas() + "";
        try {
            conectar.ejecutar(sql);
            JOptionPane.showMessageDialog(null, "Cita modificada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La cita no ha sido modificada" + e);
        }

    }

    public void eliminar(Mdl_Citas cita) {
        Conexion conectar = new Conexion();
        String sql = "Delete from Notas where IDCITA=" + cita.getIdCitas() + "";
        conectar.ejecutar(sql);
        String sql2 = "SELECT * FROM CITAS";
        ResultSet result = conectar.consultar(sql2);

        try {
            int i = 1;
            String titulo;
            while (result.next()) {
                titulo = result.getString("TITULO");
                String sql3 = "UPDATE CITAS SET IDCITA" + i + " WHERE TITULO='" + titulo + "'";
                conectar.ejecutar(sql3);
                i++;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
