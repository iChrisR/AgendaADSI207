package model;

public class Mdl_Persona {
    private int idpersona;
    private String nombres;
    private String apellidos;
    private String fecharegistro;
    private String fechamodificacion;
    private String estado;

    public Mdl_Persona() {
    }

    public Mdl_Persona(int idpersona, String nombres, String apellidos, String fecharegistro, String fechamodificacion, String estado) {
        this.idpersona = idpersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecharegistro = fecharegistro;
        this.fechamodificacion = fechamodificacion;
        this.estado = estado;
    }
    
    public Mdl_Persona(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(String fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
