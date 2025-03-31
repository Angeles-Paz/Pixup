package org.Gerdoc.pixup.datos;

import org.Gerdoc.pixup.util.ReadUtil;
import org.Gerdoc.pixup.vista.Menu;

public class Municipio extends Datos
{
    private Integer id;
    private String nombre;
    private Integer id_estado;

    public Municipio() {
    }
    public Municipio(Integer id, String nombre, Integer estado) {
        this.id = id;
        this.nombre = nombre;
        this.id_estado = estado;
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
    public Integer getId_estado() {
        return id_estado;
    }
    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    @Override
    public void leerDatos() {
        Menu.Id();
        id = ReadUtil.getInstance().leerInt();
        Menu.nombre();
        nombre = ReadUtil.getInstance().leer();
        Menu.Id();
        id_estado = ReadUtil.getInstance().leerInt();
    }
}