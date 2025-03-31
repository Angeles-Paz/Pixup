package org.Gerdoc.pixup.datos;

public class Tipo_Domicilio
{
    private Integer id;
    private String descripcion;

    public Tipo_Domicilio() {
    }

    public Tipo_Domicilio(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}