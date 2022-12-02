package model;
public class Mdl_Contactos extends Mdl_Persona{
    private int idcontacto;
    private String tipo_contacto;
    private int persona;
    private String email;
    private String alias;
    private String conEstado;
    private String conFecha_registro;
    private String conFecha_modificacion;
    private String fecha_importante;
    private String tipo_fecha;
    private String grupo;
    private String relacion;
    private String sitio_web;
    private String visibilidad;

    
    public Mdl_Contactos(int idcontacto, String tipo_contacto, int persona, String email, String alias, String conEstado, String conFecha_registro, String conFecha_modificacion, String fecha_importante, String tipo_fecha, String grupo, String relacion, String sitio_web, String visibilidad) {
        this.idcontacto = idcontacto;
        this.tipo_contacto = tipo_contacto;
        this.persona = persona;
        this.email = email;
        this.alias = alias;
        this.conEstado = conEstado;
        this.conFecha_registro = conFecha_registro;
        this.conFecha_modificacion = conFecha_modificacion;
        this.fecha_importante = fecha_importante;
        this.tipo_fecha = tipo_fecha;
        this.grupo = grupo;
        this.relacion = relacion;
        this.sitio_web = sitio_web;
        this.visibilidad = visibilidad;
    }

    public Mdl_Contactos(int idcontacto, String tipo_contacto, int persona, String email, String alias, String conEstado, String conFecha_registro, String conFecha_modificacion, String fecha_importante, String tipo_fecha, String grupo, String relacion, String sitio_web, String visibilidad, int idpersona, String nombres, String apellidos, String fecharegistro, String fechamodificacion, String estado) {
        super(idpersona, nombres, apellidos, fecharegistro, fechamodificacion, estado);
        this.idcontacto = idcontacto;
        this.tipo_contacto = tipo_contacto;
        this.persona = persona;
        this.email = email;
        this.alias = alias;
        this.conEstado = conEstado;
        this.conFecha_registro = conFecha_registro;
        this.conFecha_modificacion = conFecha_modificacion;
        this.fecha_importante = fecha_importante;
        this.tipo_fecha = tipo_fecha;
        this.grupo = grupo;
        this.relacion = relacion;
        this.sitio_web = sitio_web;
        this.visibilidad = visibilidad;
    }

    public Mdl_Contactos() {
    }

    public int getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(int idcontacto) {
        this.idcontacto = idcontacto;
    }

    public String getTipo_contacto() {
        return tipo_contacto;
    }

    public void setTipo_contacto(String tipo_contacto) {
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

    public String getConEstado() {
        return conEstado;
    }

    public void setConEstado(String conEstado) {
        this.conEstado = conEstado;
    }

    public String getConFecha_registro() {
        return conFecha_registro;
    }

    public void setConFecha_registro(String conFecha_registro) {
        this.conFecha_registro = conFecha_registro;
    }

    public String getConFecha_modificacion() {
        return conFecha_modificacion;
    }

    public void setConFecha_modificacion(String conFecha_modificacion) {
        this.conFecha_modificacion = conFecha_modificacion;
    }

    public String getFecha_importante() {
        return fecha_importante;
    }

    public void setFecha_importante(String fecha_importante) {
        this.fecha_importante = fecha_importante;
    }

    public String getTipo_fecha() {
        return tipo_fecha;
    }

    public void setTipo_fecha(String tipo_fecha) {
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

    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

  
}
