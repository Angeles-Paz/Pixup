package org.Gerdoc.pixup.datos;

import org.Gerdoc.pixup.util.ReadUtil;
import org.Gerdoc.pixup.vista.Menu;

public class Domicilio extends Datos
{
    private Integer id;
    private String calle;
    private String num_interior;
    private String num_exterior;
    private Integer id_usuario;
    private Integer id_colonia;
    private Integer id_tipo_domicilio;

    public Domicilio() {
    }

    public Domicilio(Integer id, String nombre, String num_interior, String num_exterior, Integer id_usuario, Integer id_colonia, Integer id_tipo_domicilio) {
        this.id = id;
        this.calle = nombre;
        this.num_interior = num_interior;
        this.num_exterior = num_exterior;
        this.id_usuario = id_usuario;
        this.id_colonia = id_colonia;
        this.id_tipo_domicilio = id_tipo_domicilio;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getNum_interior() {
        return num_interior;
    }
    public void setNum_interior(String num_interior) {
        this.num_interior = num_interior;
    }
    public String getNum_exterior() {
        return num_exterior;
    }
    public void setNum_exterior(String num_exterior) {
        this.num_exterior = num_exterior;
    }
    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Integer getId_colonia() {
        return id_colonia;
    }
    public void setId_colonia(Integer id_colonia) {
        this.id_colonia = id_colonia;
    }
    public Integer getId_tipo_domicilio() {
        return id_tipo_domicilio;
    }
    public void setId_tipo_domicilio(Integer id_tipo_domicilio) {
        this.id_tipo_domicilio = id_tipo_domicilio;
    }

    @Override
    public void leerDatos() {
        Menu.Id();
        id = ReadUtil.getInstance().leerInt();
        Menu.calle();
        calle = ReadUtil.getInstance().leer();
        Menu.numExterior();
        ReadUtil.getInstance();
        num_exterior = ReadUtil.getInstance().leer();
        Menu.numInterior();

        num_interior = ReadUtil.getInstance().leer();
        Menu.IDUsuario();
        id_usuario = ReadUtil.getInstance().leerInt();
        Menu.IDColonia();
        id_colonia = ReadUtil.getInstance().leerInt();
        Menu.IDTipoDomicilio();
        id_tipo_domicilio = ReadUtil.getInstance().leerInt();

    }
}