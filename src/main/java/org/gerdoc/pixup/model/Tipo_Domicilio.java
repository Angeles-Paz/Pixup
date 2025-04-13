package org.gerdoc.pixup.model;

public class Tipo_Domicilio extends Catalogo {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tipo_Domicilio{" +
                "tipo='" + tipo + '\'' +
                ", id=" + id +
                '}';
    }
}
