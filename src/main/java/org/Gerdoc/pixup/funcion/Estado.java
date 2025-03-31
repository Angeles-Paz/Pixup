package org.Gerdoc.pixup.funcion;
import org.Gerdoc.pixup.datos.Datos;
import org.Gerdoc.pixup.util.ReadUtil;
import org.Gerdoc.pixup.vista.Ejecutable;
import org.Gerdoc.pixup.vista.Menu;
import org.Gerdoc.pixup.vista.SolicitaDatos;
import java.util.ArrayList;

public class Estado implements Ejecutable {
    private static Estado estado;
    private final ArrayList<org.Gerdoc.pixup.datos.Estado> listaEstados = new ArrayList<>();
    public Estado() {
    }
    public static Estado getInstance() {
        if (estado == null){
            estado = new Estado();
        }
        return estado;
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
                    verEstado();
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
        org.Gerdoc.pixup.datos.Estado Estado = new org.Gerdoc.pixup.datos.Estado();
        ((SolicitaDatos) Estado).leerDatos();
        listaEstados.add(Estado);
        System.out.println("Estado agregado con éxito.");
    }

    private void baja() {
        Menu.Id();
        int id = ReadUtil.getInstance().leerInt();
        boolean encontrado = false;

        for (org.Gerdoc.pixup.datos.Estado estado : listaEstados) {
            if (estado.getId() != null && estado.getId().equals(id)) {
                listaEstados.remove(estado);
                System.out.println("Estado eliminado con éxito.");
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

        for (org.Gerdoc.pixup.datos.Estado estado : listaEstados) {
            if (estado.getId() != null && estado.getId().equals(id)) {
                System.out.println("--Nuevos datos--");
                ((SolicitaDatos) estado).leerDatos();
                System.out.println("Estado modificado con éxito.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("id no encontrado.");
        }
    }

    private void verEstado() {
        if (listaEstados.isEmpty()) {
            System.out.println("No hay estados registrados.");
        } else {
            System.out.println("Estados:");
            for (org.Gerdoc.pixup.datos.Estado estado : listaEstados) {
                System.out.println("id: " + estado.getId() + ", Nombre: " + estado.getNombre());
            }
        }
    }
}