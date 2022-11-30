/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import model.Mdl_Notas;

/**
 *
 * @author joan
 */
public class Ctr_Notas {
    Calendar calendarios = Calendar.getInstance();
    Calendar calendario = new GregorianCalendar();

    public String hora() {
        int hora, minutos, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        String Fecha_hoy;
        Fecha_hoy = hora + ":" + minutos + ":" + segundos;

        return Fecha_hoy;

    }

    public String fechaHoy() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(date);
    }
    //metodo para tener un ID auto incrementable

    public int Auto_increment() {
        Conexion conectar = new Conexion();
        String sql = "SELECT IDNOTA  from NOTAS";

        ResultSet rs = conectar.consultar(sql);
        int id2 = 0;
        try {
            if (rs.equals(null) || rs.equals("")) {
                id2 = 1;
            } else {
                while (rs.next()) {
                    id2 = rs.getInt("IDNOTA");
                }
                  id2++;
            }
        } catch (Exception e) {
            System.out.println("error al buscar el int");
        }

      
        return id2;
    }

    public void Guardar(Mdl_Notas Notas) {

        Conexion conectar = new Conexion();
        String sql = "INSERT INTO NOTAS(IDNOTA,TITULO,NOTA,HORA,EVENTO,TIPO_NOTA,VISIBILIDAD,ESTADO,FECHA_REGISTRO,FECHA_MODIFICACION)VALUES(" + Notas.getId_nota() + ",'" + Notas.getTitulo() + "','" + Notas.getNota() + "','" + Notas.getHora() + "',"
                + null + ",'" + Notas.getTipo_nota() + "','" + Notas.getVisibilidad() + "','" + Notas.getEstado() + "','" + Notas.getFecha_registro() + "'," + null + " )";
        conectar.ejecutar(sql);
    }

    public String SacarCorreo() {

        Conexion conectar = new Conexion();
        String sql = "SELECT EMAIL FROM contactos WHERE  IDCONTACTO = 1";
        ResultSet rs = conectar.consultar(sql);
        String Correo = "";

        try {
            while (rs.next()) {
                Correo = rs.getString("EMAIL");
            }

        } catch (Exception e) {
        }

        return Correo;
    }

    
}
