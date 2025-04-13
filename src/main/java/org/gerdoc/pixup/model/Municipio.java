package org.gerdoc.pixup.model;

public class Municipio extends Catalogo
{
    private String nombre;
    private Integer idEstado;

    public Municipio()
    {
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString()
    {
        return "Municipio{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id + ", idEstado=" + idEstado +
                '}';
    }
}
