package org.Gerdoc.pixup.inicio;

import org.Gerdoc.pixup.util.ReadUtil;
import org.Gerdoc.pixup.vista.Consola;
import org.Gerdoc.pixup.vista.Ejecutable;
import org.Gerdoc.pixup.vista.Menu;
import org.Gerdoc.pixup.vista.Ventana;

public class Principal {

    public Principal() {
    }

    public static void main(String[] args) {

        boolean flag = true;
        int opcion = 0;
        Ejecutable ejecutable = null;
        while (flag) {
            ejecutable = null;
            Menu.principal();
            opcion = ReadUtil.getInstance().leerInt();
            switch (opcion) {
                case 1:
                    ejecutable = Consola.getInstance();
                    break;
                case 2:
                    ejecutable = Ventana.getInstance();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    Menu.opcionInvalida();
            }
            if (ejecutable != null) {
                ejecutable.run();
            }
        }
    }
}