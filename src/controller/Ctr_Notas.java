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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author SENA
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
            }
        } catch (Exception e) {
            System.out.println("error al buscar el int");
        }

        id2++;
        return id2;
    }
public int tipo_user(){
       int tipo =0;
     Conexion conectar = new Conexion();
     String sql = "Select TIPO_USER from USERS where IDUSER=1";
      ResultSet rs =null;
      
      rs = conectar.consultar(sql);
    
        try {
            while(rs.next()){
               tipo = rs.getInt("TIPO_USER");
            }
        } catch (Exception e) {
            System.out.println("error al buscar el tipo de usuario "+ e);
        }
       
       return tipo;
    }
    public void Guardar(Mdl_Notas Notas) {

        Conexion conectar = new Conexion();
        String sql = "INSERT INTO NOTAS(IDNOTA,TITULO,NOTA,HORA,EVENTO,TIPO_NOTA,VISIBILIDAD,ESTADO,FECHA_REGISTRO,FECHA_MODIFICACION)VALUES(" + Notas.getId_nota() + ",'" + Notas.getTitulo() + "','" + Notas.getNota() + "','" + Notas.getHora() + "',"
                + null + ",'" + Notas.getTipo_nota() + "','" + Notas.getVisibilidad() + "','" + Notas.getEstado() + "','" + Notas.getFecha_registro() + "'," + null + " )";
        conectar.ejecutar(sql);
    }

    public String SacarCorreo() {

        Conexion conectar = new Conexion();
        String sql = "SELECT EMAIL FROM CONTACTOS";
        ResultSet rs = conectar.consultar(sql);
        String Correo = "";

        try {
            while (rs.next()) {
                Correo = rs.getString("EMAIL");
            }

        } catch (Exception e) {
            System.out.println("Error al sacar el email " + e);
        }

        return Correo;
    }

    public ArrayList<Mdl_Notas> llenarTabla() {
        ArrayList<Mdl_Notas> listaNotas = new ArrayList<Mdl_Notas>();
        Conexion conectar = new Conexion();
        ResultSet rs;
        int id = 1;
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

    public void modificar(Mdl_Notas nota) {
        Conexion conectar = new Conexion();
        String sql = "UPDATE NOTAS SET TITULO='" + nota.getTitulo() + "',NOTA='" + nota.getNota() + "', FECHA_MODIFICACION='" + nota.getFecha_modificacion() + "', TIPO_NOTA='" + nota.getTipo_nota() + "' WHERE IDNOTA=" + nota.getId_nota() + "";
        try {
            conectar.ejecutar(sql);
            JOptionPane.showMessageDialog(null, "Nota modificada con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nota no ha sido modificada" + e);
        }

    }

    public void eliminar(Mdl_Notas modelo) {
        Conexion conectar = new Conexion();
        String sql = "Delete from Notas where TITULO='" + modelo.getTitulo()+ "'";
        conectar.ejecutar(sql);
        //aqui voy a traer todos los id para reiniciarlos
        String sql2 = "SELECT * FROM NOTAS";
        ResultSet result = conectar.consultar(sql2);

        try {
            int i = 1;
            String titulo;
            while (result.next()) {
                titulo = result.getString("TITULO");
                String sql3 = "UPDATE NOTAS SET IDNOTA=" + i + " WHERE TITULO='" + titulo + "'";
                conectar.ejecutar(sql3);
                i++;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

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

    public ArrayList<Mdl_Notas> BuscarNotas(Mdl_Notas titulo) {
        ArrayList<Mdl_Notas> listaNotas = new ArrayList();
        Conexion conectar = new Conexion();
        Mdl_Notas modelo = new Mdl_Notas();
        ResultSet rs;
        String sql = "SELECT * FROM NOTAS  WHERE TITULO ='" + titulo.getTitulo() + "'";
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                modelo.setTitulo(rs.getString("TITULO"));
                modelo.setId_nota(rs.getInt("IDNOTA"));
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

    public int BuscarTitulo(Mdl_Notas titulo) {

        Conexion conectar = new Conexion();
        ResultSet rs = null;
        String sql = "SELECT TITULO FROM NOTAS";
        //variable para ver si funciono el if
        int works = 0;
        try {
            rs = conectar.consultar(sql);

            while (rs.next()) {
                String title = rs.getString("TITULO");
                if (title.equals(titulo.getTitulo())) {
                    JOptionPane.showMessageDialog(null, "Ese titulo ya esta en la base de datos por favor ingrese otro");
                    works = 1;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al consultar tabla " + e);
        }
        return works;
    }

    public int CountNotas() {
        int cantidad = 0;
        Conexion conectar = new Conexion();
        String sql = "Select IDNOTA from Notas";
        ResultSet rs = null;
        rs = conectar.consultar(sql);

        try {
            while (rs.next()) {
                cantidad++;
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex);
        }

        return cantidad;
    }
    
}
