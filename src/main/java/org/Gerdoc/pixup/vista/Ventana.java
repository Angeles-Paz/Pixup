package org.Gerdoc.pixup.vista;

public class Ventana implements Ejecutable {

    private static Ventana ventana;
    public static Ventana getInstance() {
        if (ventana == null) {
            ventana = new Ventana();
        }
        return ventana;
    }

    @Override
    public void run() {
        Menu.Ventana();
    }
}