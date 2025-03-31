package org.Gerdoc.pixup.funcion;
import org.Gerdoc.pixup.datos.Datos;
import org.Gerdoc.pixup.util.ReadUtil;
import org.Gerdoc.pixup.vista.Ejecutable;
import org.Gerdoc.pixup.vista.Menu;
import org.Gerdoc.pixup.vista.SolicitaDatos;

import java.util.ArrayList;

public class Colonia implements Ejecutable {
    private static Colonia colonia;
    private final ArrayList<org.Gerdoc.pixup.datos.Colonia> listaColonias = new ArrayList<>();
    public Colonia() {
    }
    public static Colonia getInstance() {
        if (colonia == null) {
            colonia = new Colonia();
        }
        return colonia;
    }

    @Override
    public void run() {
        boolean flag = true;
        int opcion = 0;
        Datos datos = null;
        while (flag) {
            datos = null;
            Menu.datos();
            opcion = ReadUtil.getInstance().leerInt();
            switch (opcion) {
                case 1:
                    alta();
                    break;
                case 2:
                    baja();
                    break;
                case 3:
                    cambio();
                    break;
                case 4:
                    consulta();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    Menu.opcionInvalida();
            }
            if (datos != null) {
                ((SolicitaDatos) datos).leerDatos();

            }
        }
    }

    private void alta() {
        org.Gerdoc.pixup.datos.Colonia nColonia = new org.Gerdoc.pixup.datos.Colonia();
        ((SolicitaDatos) nColonia).leerDatos();
        listaColonias.add(nColonia);
        System.out.println("Colonia agregada con éxito.");
    }

    private void baja() {
        Menu.Id();
        int id = ReadUtil.getInstance().leerInt();
        boolean encontrado = false;

        for (org.Gerdoc.pixup.datos.Colonia colonia : listaColonias) {
            if (colonia.getId() != null && colonia.getId().equals(id)) {
                listaColonias.remove(colonia);
                System.out.println("Colonia eliminada con éxito.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("id no encontrado.");
        }
    }

    private void cambio() {
        Menu.Id();
        int id = ReadUtil.getInstance().leerInt();
        boolean encontrado = false;

        for (org.Gerdoc.pixup.datos.Colonia colonia : listaColonias) {
            if (colonia.getId() != null && colonia.getId().equals(id)) {
                System.out.println("--Nuevos datos--");
                ((SolicitaDatos) colonia).leerDatos();
                System.out.println("Colonia modificada con éxito.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("id no encontrado.");
        }
    }

    private void consulta() {
        if (listaColonias.isEmpty()) {
            System.out.println("No hay colonias registradas.");
        } else {
            System.out.println("Colonias:");
            for (org.Gerdoc.pixup.datos.Colonia colonia : listaColonias) {
                System.out.println("id: " + colonia.getId() +
                        ", Nombre: " + colonia.getNombre() +
                        ", CP: " + colonia.getCp() +
                        ", id Municipio: " + colonia.getId_municipio());
            }
        }
    }
}