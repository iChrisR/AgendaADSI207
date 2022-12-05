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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
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

     public ArrayList<Mdl_Notas> llenarTabla() {
        ArrayList<Mdl_Notas> listaNotas = new ArrayList<Mdl_Notas>();
        Conexion conectar = new Conexion();
        ResultSet rs;
        //int id = 1;
        String sql = "SELECT * FROM NOTAS WHERE VISIBILIDAD = '0' ";
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {

                Mdl_Notas modelo = new Mdl_Notas();
                modelo.setId_nota(rs.getInt("IDNOTA"));
//                if (modelo.getId_nota() > id) {
//                    modelo.setId_nota(id);
//                    id++;
//                } else {
//                    id++;
//                }
                modelo.setTitulo(rs.getString("TITULO"));
                modelo.setNota(rs.getString("NOTA"));
                modelo.setFecha_registro(rs.getString("FECHA_REGISTRO"));
                modelo.setTipo_nota(rs.getString("TIPO_NOTA"));
                listaNotas.add(modelo);

            }
        } catch (Exception e) {
            System.out.println("Error al consultar tabla " + e);
        }
        return listaNotas;
    }
    
    public void modificar(Mdl_Notas nota){
        Conexion conectar = new Conexion();
        String sql = "UPDATE NOTAS SET TITULO='"+nota.getTitulo()+"',NOTA='"+nota.getNota()+"', FECHA_MODIFICACION='"+nota.getFecha_modificacion()+"' WHERE IDNOTA="+nota.getId_nota()+"";
        try {
            conectar.ejecutar(sql);
            JOptionPane.showMessageDialog(null,"Nota modificada con exito");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Nota no ha sido modificada"+ e);
        }
        
    }
    
    public void eliminar(Mdl_Notas modelo){
        Conexion conectar = new Conexion();
        String sql ="Delete from Notas where IDNOTA="+modelo.getId_nota()+"";
       conectar.ejecutar(sql);
    }
    
    
    
       public ArrayList<Mdl_Notas> NotasPrivadas() {
        ArrayList<Mdl_Notas> listaNotas = new ArrayList<Mdl_Notas>();
        Conexion conectar = new Conexion();
        ResultSet rs;
        int id = 1;
        String sql = "SELECT * FROM NOTAS  WHERE VISIBILIDAD ='1'";
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {

                Mdl_Notas modelo = new Mdl_Notas();
                modelo.setId_nota(rs.getInt("IDNOTA"));
                if (modelo.getId_nota() > id) {
                    modelo.setId_nota(id);
                    id++;
                } else {
                    id++;
                }
                modelo.setTitulo(rs.getString("TITULO"));
                modelo.setNota(rs.getString("NOTA"));
                modelo.setFecha_registro(rs.getString("FECHA_REGISTRO"));
                modelo.setTipo_nota(rs.getString("TIPO_NOTA"));
                listaNotas.add(modelo);

            }
        } catch (Exception e) {
            System.out.println("Error al consultar tabla " + e);
        }
        return listaNotas;
    }
}
