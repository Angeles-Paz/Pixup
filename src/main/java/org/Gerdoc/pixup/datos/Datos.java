package org.Gerdoc.pixup.datos;

import org.Gerdoc.pixup.vista.SolicitaDatos;

public abstract class Datos implements SolicitaDatos {
    public Datos() {
    }
    public abstract void leerDatos();

}