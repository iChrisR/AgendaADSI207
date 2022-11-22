
package model;

public class Mdl_User extends Mdl_Persona{
    private int iduser;
    private String clave;
    private String tipouser;
    private String nombreuser;
    private String ufecharegistro;
    private String ufechamodificacion;
    private String uestado;

    public Mdl_User() {
    }

    public Mdl_User(int iduser, String clave, String tipouser, String nombreuser, String ufecharegistro, String ufechamodificacion, String uestado) {
        this.iduser = iduser;
        this.clave = clave;
        this.tipouser = tipouser;
        this.nombreuser = nombreuser;
        this.ufecharegistro = ufecharegistro;
        this.ufechamodificacion = ufechamodificacion;
        this.uestado = uestado;
    }

    public Mdl_User(int iduser, String clave, String tipouser, String nombreuser, String ufecharegistro, String ufechamodificacion, String uestado, int idpersona, String nombres, String apellidos, String fecharegistro, String fechamodificacion, String estado) {
        super(idpersona, nombres, apellidos, fecharegistro, fechamodificacion, estado);
        this.iduser = iduser;
        this.clave = clave;
        this.tipouser = tipouser;
        this.nombreuser = nombreuser;
        this.ufecharegistro = ufecharegistro;
        this.ufechamodificacion = ufechamodificacion;
        this.uestado = uestado;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipouser() {
        return tipouser;
    }

    public void setTipouser(String tipouser) {
        this.tipouser = tipouser;
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public String getUfecharegistro() {
        return ufecharegistro;
    }

    public void setUfecharegistro(String ufecharegistro) {
        this.ufecharegistro = ufecharegistro;
    }

    public String getUfechamodificacion() {
        return ufechamodificacion;
    }

    public void setUfechamodificacion(String ufechamodificacion) {
        this.ufechamodificacion = ufechamodificacion;
    }

    public String getUestado() {
        return uestado;
    }

    public void setUestado(String uestado) {
        this.uestado = uestado;
    }
    
    
}
