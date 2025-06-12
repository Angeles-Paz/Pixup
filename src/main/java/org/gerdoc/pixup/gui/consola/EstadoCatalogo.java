package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.dao.EstadoDao;
import org.gerdoc.pixup.dao.impl.EstadoDaoImpl;
import org.gerdoc.pixup.model.Estado;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class EstadoCatalogo extends Catalogos<Estado>
{
    private static EstadoDao estadoDao = EstadoDaoImpl.getInstance();

    public static EstadoCatalogo estadoCatalogo;

    private EstadoCatalogo( ) {
        super();
    }

    public static EstadoCatalogo getInstance( )
    {
        if(estadoCatalogo==null)
        {
            estadoCatalogo = new EstadoCatalogo();
        }
        return estadoCatalogo;
    }

    @Override
    protected String tcatalogo() {
        String menu = "Estado";
        return menu;
    }

    @Override
    public void addT()
    {
        boolean rs;
        Estado estado = new Estado();
        System.out.println("Ingrese el Nombre del Estado:");
        estado.setNombre( ReadUtil.read() );
        rs = estadoDao.save( estado );
        if (rs){
            System.out.println("--Estado Agregado--");
        } else {
            System.out.println("--Error al agregar Estado--");
        }
    }

    @Override
    public void removeT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Estado estado = estadoDao.findById( id );
        if (estado == null){
            System.out.println("--ID no encontrado--");
        } else {
            rs = estadoDao.delete( estado );
            if (rs){
                System.out.println("--Estado Eliminado--");
            } else {
                System.out.println("--Error al eliminar Estado--");
            }
        }
    }

    @Override
    public void editT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Estado estado = estadoDao.findById( id );
        if (estado == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( estado );
            System.out.println("Ingrese el nuevo Nombre del Estado:");
            estado.setNombre( ReadUtil.read() );
            rs = estadoDao.update( estado );
            if (rs){
                System.out.println("--Estado Actualizado--");
            } else {
                System.out.println("--Error al actualizar Estado--");
            }
        }
    }

    @Override
    public void findT() {
        Estado estado;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        estado = estadoDao.findById( id );
        if (estado == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println(estado);
        }
    }

    @Override
    public void printT() {
        List<Estado> estados = estadoDao.findAll();
        if (estados.isEmpty()){
            System.out.println("--No hay Estados registrados--");
        } else {
            estados.forEach(System.out::println);
        }
    }
}
