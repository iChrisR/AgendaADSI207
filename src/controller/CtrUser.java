ackage Controller;

import conexion.Conexion;
import Model.MdlUser;

public class CtrUser {

    int id = 1;

    public void guardarPersona(MdlUser user) {
        user.setNumerador(user.getNumerador() + 1);
        CtrUtilitario1 fh = new CtrUtilitario1();
        Conexion co = new Conexion();
        String sql = "INSERT INTO personas(id_persona,nombres,apellidos,estado,fecha_registro,fecha_modificacion)"
                + "VALUES(" + id + ",'" + user.getNombre_user() + "', '" + user.getApellidos() + "',"
                + "'" + user.getEstado_user() + "', '" + fh.fechaHoy() + "'," + null + ")";
        co.ejecutar(sql);
        id++;
    }

    public void guardarUsuario(MdlUser user) {
        CtrUtilitario1 util = new CtrUtilitario1();
        Conexion co = new Conexion();
        String sql = "INSERT INTO users(id_user,clave,tipo_user,nombre_user,id_persona,fecha_registro,fecha_modificacion,estado)"
                + "VALUES(" + id + ",'" + user.getClave() + "','" + user.getTipo_user() + "','" + user.getNombre_user() + "'," + id + ",'" + util.fechaHoy() + "','" + null + "','" + user.getEstado_user() + "')";
        co.ejecutar(sql);
    }
}
