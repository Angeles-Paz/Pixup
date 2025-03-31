package org.Gerdoc.pixup.datos;

import org.Gerdoc.pixup.util.ReadUtil;
import org.Gerdoc.pixup.vista.Menu;

public class Colonia extends Datos
{
    private Integer id;
    private String nombre;
    private String cp;
    private Integer id_municipio;

    public Colonia() {
    }

    public Colonia(Integer id, String nombre, String cp, Integer municipio) {
        this.id = id;
        this.nombre = nombre;
        this.cp = cp;
        this.id_municipio = municipio;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public Integer getId_municipio() {
        return id_municipio;
    }
    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }
    @Override
    public void leerDatos() {

        Menu.Id();
        id = ReadUtil.getInstance().leerInt();
        Menu.nombre();
        nombre = ReadUtil.getInstance().leer();
        Menu.cp();
        cp = ReadUtil.getInstance().leer();
        Menu.Id();
        id_municipio = ReadUtil.getInstance().leerInt();

    }

}