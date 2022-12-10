package model;

public class Mdl_Mensajeria {

  private String contacto;
  private String asunto;
  private String mensaje;

  public Mdl_Mensajeria(String contacto, String asunto, String mensaje) {
    this.contacto = contacto;
    this.asunto = asunto;
    this.mensaje = mensaje;
  }

  public Mdl_Mensajeria() {
  }

  public String getContacto() {
    return contacto;
  }

  public void setContacto(String contacto) {
    this.contacto = contacto;
  }

  public String getAsunto() {
    return asunto;
  }

  public void setAsunto(String asunto) {
    this.asunto = asunto;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

}
