package org.Gerdoc.pixup.vista;

import org.Gerdoc.pixup.util.ReadUtil;
import org.Gerdoc.pixup.funcion.*;

public class Catalogo implements Ejecutable {

    private static Catalogo catalogo;
    public Catalogo() {
    }
    public static Catalogo getInstance() {
        if (catalogo == null) {
            catalogo = new Catalogo();
        }
        return catalogo;
    }

    @Override
    public void run() {
        boolean flag = true;
        int opcion = 0;
        Ejecutable ejecutable = null;
        while (flag) {
            ejecutable = null;
            Menu.catalogo();
            opcion = ReadUtil.getInstance().leerInt();
            switch (opcion) {
                case 1:
                    ejecutable = Estado.getInstance();
                    break;
                case 2:
                    ejecutable = Municipio.getInstance();
                    break;
                case 3:
                    ejecutable = Colonia.getInstance();
                    break;
                case 4:
                    ejecutable = Domicilio.getInstance();
                    break;
                case 5:
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