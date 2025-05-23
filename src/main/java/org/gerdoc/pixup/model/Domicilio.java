package org.gerdoc.pixup.model;

public class Domicilio extends Catalogo
{

    private String calle;
    private String numExterior;
    private String numInterior;
    private Integer colonia_id;
    private Integer tipoDomicilio_id;
    private Integer usuario_id;

    public Domicilio() {}

    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }
    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }
    public void setColonia_id(Integer colonia_id) {
        this.colonia_id = colonia_id;
    }
    public void setTipoDomicilio_id(Integer tipoDomicilio_id) {
        this.tipoDomicilio_id = tipoDomicilio_id;
    }
    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "calle='" + calle + '\'' +
                ", numExterior='" + numExterior + '\'' +
                ", numInterior='" + numInterior + '\'' +
                ", colonia_id=" + colonia_id +
                ", tipoDomicilio_id=" + tipoDomicilio_id +
                ", usuario_id=" + usuario_id +
                ", id=" + id +
                '}';
    }
}