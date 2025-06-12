package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.gui.LecturaAccion;
import org.gerdoc.pixup.model.Catalogo;

import java.util.ArrayList;
import java.util.List;

public abstract class Catalogos<T extends Catalogo> extends LecturaAccion
{
    protected List<T>list;

    public Catalogos()
    {
        list = new ArrayList<>( );
    }

    public boolean isListEmpty()
    {
        return list.isEmpty();
    }

    protected abstract String tcatalogo();
    public abstract void addT( );
    public abstract void editT( );
    public abstract void removeT( );
    public abstract void findT( );
    public abstract void printT( );

    public void add( )
    {
        System.out.println("{{- Agregar " + tcatalogo() + " -}}");
        addT();
        System.out.println("-----------------------------------------------------------");
    }

    public void edit( )
    {
        System.out.println("{{- Editar " + tcatalogo() + " -}}");
        editT();
        System.out.println("-----------------------------------------------------------");
    }

    public void remove( )
    {
        System.out.println("{{- Eliminar " + tcatalogo() + " -}}");
        removeT();
        System.out.println("-----------------------------------------------------------");
    }

    public void find( )
    {
        System.out.println("{{- Buscar " + tcatalogo() + " -}}");
        findT();
        System.out.println("-----------------------------------------------------------");
    }

    public void print( )
    {
        System.out.println("{{- Desplegar " + tcatalogo() + " -}}");
        printT();
        System.out.println("-----------------------------------------------------------");
    }

    @Override
    public void procesaOpcion()
    {
        switch (opcion)
        {
            case 1:
                add( );
                break;
            case 2:
                edit( );
                break;
            case 3:
                remove( );
                break;
            case 4:
                find( );
                break;
            case 5:
                print( );
                break;
        }
    }

    @Override
    public void despliegaMenu()
    {
        System.out.println("///----" + tcatalogo() + "---///)");
        System.out.println("[---Selecciona una accion---]");
        System.out.println("1.- Crear");
        System.out.println("2.- Editar");
        System.out.println("3.- Eliminar");
        System.out.println("4.- Buscar por ID");
        System.out.println("5.- Mostrar registros");
        System.out.println("6.- Salir");
    }

    @Override
    public int valorMinMenu( )
    {
        return 1;
    }

    @Override
    public int valorMaxMenu()
    {
        return 6;
    }

}