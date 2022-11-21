package model;
public class Mdl_Contactos {
    private int idcontacto;
    private int tipo_contacto;
    private int persona;
    private String email;
    private String alias;
    private char estado;
    private String fecha_registro;
    private String fecha_modificacion;
    private String fecha_importante;
    private String tipo_fecha;
    private String grupo;
    private String relacion;
    private String sitio_web;
    private String visibilidad;

    public Mdl_Contactos(int idcontacto, int tipo_contacto, int persona, String email, String alias, char estado, String fecha_registro, String fecha_modificacion, String fecha_importante, String tipo_fecha, String grupo, String relacion, String sitio_web, String visibilidad) {
        this.idcontacto = idcontacto;
        this.tipo_contacto = tipo_contacto;
        this.persona = persona;
        this.email = email;
        this.alias = alias;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
        this.fecha_modificacion = fecha_modificacion;
        this.fecha_importante = fecha_importante;
        this.tipo_fecha = tipo_fecha;
        this.grupo = grupo;
        this.relacion = relacion;
        this.sitio_web = sitio_web;
        this.visibilidad = visibilidad;
    }

    public Mdl_Contactos() {
    }

    public int getIdContacto() {
        return idcontacto;
    }
    public void setIdContacto(int idcontacto) {
        this.idcontacto = idcontacto;
    }

    public int getTipo_Contacto() {
        return tipo_contacto;
    }
    public void setTipo_Contacto(int tipo_contacto) {
        this.tipo_contacto = tipo_contacto;
    }

    public int getPersona() {
        return persona;
    }
    public void setPersona(int persona) {
        this.persona = persona;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public char getEstado() {
        return estado;
    }
    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getFecha_Registro() {
        return fecha_registro;
    }
    public void setFecha_Registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_Modificacion() {
        return fecha_modificacion;
    }
    public void setFecha_Modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getFecha_Importante() {
        return fecha_importante;
    }
    public void setFecha_Importante(String fecha_importante) {
        this.fecha_importante = fecha_importante;
    }

    public String getTipo_Fecha() {
        return tipo_fecha;
    }
    public void setTipo_Fecha(String tipo_fecha) {
        this.tipo_fecha = tipo_fecha;
    }

    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getRelacion() {
        return relacion;
    }
    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getSitio_Web() {
        return sitio_web;
    }
    public void setSitio_Web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    public String getVisibilidad() {
        return visibilidad;
    }
    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }
}
