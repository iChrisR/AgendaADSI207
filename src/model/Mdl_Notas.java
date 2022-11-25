/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author joan
 */
public class Mdl_Notas {
    
    private int id_nota;
   private String titulo;
  private String nota;
  private String fecha;
  private String hora;
  private String evento;
  private String tipo_nota;
  private int id_sesion;
  private int id_cita;
   private String estado;
  private String fecha_registro;
  private String fecha_modificacion;
  private String Visibilidad;

    public Mdl_Notas() {
    }

    public Mdl_Notas(int id_nota, String titulo, String nota, String fecha, String hora, String evento, String tipo_nota, int id_sesion, int id_cita, String estado, String fecha_registro, String fecha_modificacion, String Visibilidad) {
        this.id_nota = id_nota;
        this.titulo = titulo;
        this.nota = nota;
        this.fecha = fecha;
        this.hora = hora;
        this.evento = evento;
        this.tipo_nota = tipo_nota;
        this.id_sesion = id_sesion;
        this.id_cita = id_cita;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
        this.fecha_modificacion = fecha_modificacion;
        this.Visibilidad = Visibilidad;
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getTipo_nota() {
        return tipo_nota;
    }

    public void setTipo_nota(String tipo_nota) {
        this.tipo_nota = tipo_nota;
    }

    public int getId_sesion() {
        return id_sesion;
    }

    public void setId_sesion(int id_sesion) {
        this.id_sesion = id_sesion;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getVisibilidad() {
        return Visibilidad;
    }

    public void setVisibilidad(String Visibilidad) {
        this.Visibilidad = Visibilidad;
    }

    
}
