package model;

public class Mdl_Citas {

    int idCitas;
    String tituloCita, descripcionCita, fecha_cita, hora_cita, tipo_cita, estado_cita, fecha_registroCita, fecha_modificacionCita, ubicacion_cita, repeticion_cita, zona_horariaCita, visibilidad_cita;

    public Mdl_Citas() {
    }

    public Mdl_Citas(int idCitas, String tituloCita, String descripcionCita, String fecha_cita, String hora_cita, String tipo_cita, String estado_cita, String fecha_registroCita, String fecha_modificacionCita, String ubicacion_cita, String repeticion_cita, String zona_horariaCita, String visibilidad_cita) {
        this.idCitas = idCitas;
        this.tituloCita = tituloCita;
        this.descripcionCita = descripcionCita;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.tipo_cita = tipo_cita;
        this.estado_cita = estado_cita;
        this.fecha_registroCita = fecha_registroCita;
        this.fecha_modificacionCita = fecha_modificacionCita;
        this.ubicacion_cita = ubicacion_cita;
        this.repeticion_cita = repeticion_cita;
        this.zona_horariaCita = zona_horariaCita;
        this.visibilidad_cita = visibilidad_cita;
    }

    public int getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(int idCitas) {
        this.idCitas = idCitas;
    }

    public String getTituloCita() {
        return tituloCita;
    }

    public void setTituloCita(String tituloCita) {
        this.tituloCita = tituloCita;
    }

    public String getDescripcionCita() {
        return descripcionCita;
    }

    public void setDescripcionCita(String descripcionCita) {
        this.descripcionCita = descripcionCita;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(String hora_cita) {
        this.hora_cita = hora_cita;
    }

    public String getTipo_cita() {
        return tipo_cita;
    }

    public void setTipo_cita(String tipo_cita) {
        this.tipo_cita = tipo_cita;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }

    public String getFecha_registroCita() {
        return fecha_registroCita;
    }

    public void setFecha_registroCita(String fecha_registroCita) {
        this.fecha_registroCita = fecha_registroCita;
    }

    public String getFecha_modificacionCita() {
        return fecha_modificacionCita;
    }

    public void setFecha_modificacionCita(String fecha_modificacionCita) {
        this.fecha_modificacionCita = fecha_modificacionCita;
    }

    public String getUbicacion_cita() {
        return ubicacion_cita;
    }

    public void setUbicacion_cita(String ubicacion_cita) {
        this.ubicacion_cita = ubicacion_cita;
    }

    public String getRepeticion_cita() {
        return repeticion_cita;
    }

    public void setRepeticion_cita(String repeticion_cita) {
        this.repeticion_cita = repeticion_cita;
    }

    public String getZona_horariaCita() {
        return zona_horariaCita;
    }

    public void setZona_horariaCita(String zona_horariaCita) {
        this.zona_horariaCita = zona_horariaCita;
    }

    public String getVisibilidad_cita() {
        return visibilidad_cita;
    }

    public void setVisibilidad_cita(String visibilidad_cita) {
        this.visibilidad_cita = visibilidad_cita;
    }

}
