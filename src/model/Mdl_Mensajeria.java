package model;

public class Mdl_Mensajeria extends Mdl_Contactos {
  
  private String asunto;
  private String mensaje;

  public Mdl_Mensajeria(String asunto, String mensaje) {
    this.asunto = asunto;
    this.mensaje = mensaje;
  }
  
  public Mdl_Mensajeria(String asunto, String mensaje, int idcontacto, String email, String nombres, String apellidos) {
    super(idcontacto, email, nombres, apellidos);
    this.asunto = asunto;
    this.mensaje = mensaje;
  }
  
  public Mdl_Mensajeria() {
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
