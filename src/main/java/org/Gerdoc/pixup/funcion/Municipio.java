package org.Gerdoc.pixup.funcion;
import org.Gerdoc.pixup.datos.Datos;
import org.Gerdoc.pixup.util.ReadUtil;
import org.Gerdoc.pixup.vista.Ejecutable;
import org.Gerdoc.pixup.vista.Menu;
import org.Gerdoc.pixup.vista.SolicitaDatos;

import java.util.ArrayList;

public class Municipio implements Ejecutable
{
    private static Municipio municipio;
    private final ArrayList<org.Gerdoc.pixup.datos.Municipio> listaMunicipos = new ArrayList<>();
    public Municipio() {
    }
    public static Municipio getInstance() {
        if (municipio == null) {
            municipio = new Municipio();
        }
        return municipio;
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
                    verMunicipio();
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
        org.Gerdoc.pixup.datos.Municipio nMunicipio = new org.Gerdoc.pixup.datos.Municipio();
        ((SolicitaDatos) nMunicipio).leerDatos();
        listaMunicipos.add(nMunicipio);
        System.out.println("Municipio agregado con éxito.");
    }

    private void baja() {
        Menu.Id();
        int id = ReadUtil.getInstance().leerInt();
        boolean encontrado = false;

        for (org.Gerdoc.pixup.datos.Municipio municipio : listaMunicipos) {
            if (municipio.getId() != null && municipio.getId().equals(id)) {
                listaMunicipos.remove(municipio);
                System.out.println("Municipio eliminado con éxito.");
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

        for (org.Gerdoc.pixup.datos.Municipio municipio : listaMunicipos) {
            if (municipio.getId() != null && municipio.getId().equals(id)) {
                System.out.println("--Nuevos datos--");
                ((SolicitaDatos) municipio).leerDatos();
                System.out.println("Municipio modificado con éxito.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("id no encontrado.");
        }
    }

    private void verMunicipio() {
        if (listaMunicipos.isEmpty()) {
            System.out.println("No hay municipios.");
        } else {
            System.out.println("Municipios:");
            for (org.Gerdoc.pixup.datos.Municipio municipio : listaMunicipos) {
                System.out.println("id: " + municipio.getId() +
                        ", Nombre: " + municipio.getNombre() +
                        ", id Estado: " + municipio.getId_estado());
            }
        }
    }
}