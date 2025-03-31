package org.Gerdoc.pixup.funcion;
import org.Gerdoc.pixup.datos.Datos;
import org.Gerdoc.pixup.util.ReadUtil;
import org.Gerdoc.pixup.vista.Ejecutable;
import org.Gerdoc.pixup.vista.Menu;
import org.Gerdoc.pixup.vista.SolicitaDatos;

import java.util.ArrayList;

public class Domicilio implements Ejecutable
{
    private static Domicilio domicilio;
    private final ArrayList<org.Gerdoc.pixup.datos.Domicilio> listaDomicilio = new ArrayList<>();
    public Domicilio() {
    }
    public static Domicilio getInstance() {
        if (domicilio == null){
            domicilio = new Domicilio();
        }
        return domicilio;
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
        org.Gerdoc.pixup.datos.Domicilio Domicilio = new org.Gerdoc.pixup.datos.Domicilio();
        ((SolicitaDatos) Domicilio).leerDatos();
        listaDomicilio.add(Domicilio);
        System.out.println("Domicilio agregado con éxito.");
    }

    private void baja() {
        Menu.Id();
        int id = ReadUtil.getInstance().leerInt();
        boolean encontrado = false;

        for (org.Gerdoc.pixup.datos.Domicilio domicilio: listaDomicilio) {
            if (domicilio.getId() != null && domicilio.getId().equals(id)) {
                listaDomicilio.remove(domicilio);
                System.out.println("Domicilio eliminado con éxito.");
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

        for (org.Gerdoc.pixup.datos.Domicilio domicilio: listaDomicilio) {
            if (domicilio.getId() != null && domicilio.getId().equals(id)) {
                System.out.println("--Nuevos datos--");
                ((SolicitaDatos) domicilio).leerDatos();
                System.out.println("Domicilio modificado.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("id no encontrado.");
        }
    }

    private void consulta() {
        if (listaDomicilio.isEmpty()) {
            System.out.println("No hay domicilios registrados.");
        } else {
            System.out.println("Domicilios:");
            for (org.Gerdoc.pixup.datos.Domicilio domicilio : listaDomicilio) {
                System.out.println("id: " + domicilio.getId() +
                        ", Calle: " + domicilio.getCalle() +
                        ", Numero Exterior: " + domicilio.getNum_exterior() +
                        ", Numero Interior: " + domicilio.getNum_interior() +
                        ", id Usuario: " + domicilio.getId_usuario() +
                        ", id Colonia: " + domicilio.getId_colonia() +
                        ", id Tipo domicilio: " + domicilio.getId_tipo_domicilio());
            }
        }
    }
}