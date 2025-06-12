package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.dao.CancionDao;
import org.gerdoc.pixup.dao.impl.CancionDaoImpl;
import org.gerdoc.pixup.model.Cancion;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class CancionCatalogo extends Catalogos<Cancion>
{
    private static CancionDao cancionDao = CancionDaoImpl.getInstance();

    public static CancionCatalogo cancionCatalogo;

    private CancionCatalogo( ) {
        super();
    }

    public static CancionCatalogo getInstance( )
    {
        if(cancionCatalogo==null)
        {
            cancionCatalogo = new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    @Override
    protected String tcatalogo() {
        String menu = "Cancion";
        return menu;
    }

    @Override
    public void addT()
    {
        boolean rs;
        Cancion cancion = new Cancion();
        System.out.println("Ingrese el Titulo de la Canción:");
        cancion.setTitulo( ReadUtil.read() );
        System.out.println("Ingrese la Duración de la Canción (HH:MM:SS):");
        cancion.setDuracion( ReadUtil.readLocalTime() );
        rs = cancionDao.save( cancion );
        if (rs){
            System.out.println("--Canción Agregada--");
        } else {
            System.out.println("--Error al agregar Canción--");
        }
    }

    @Override
    public void removeT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Cancion cancion = cancionDao.findById( id );
        if (cancion == null){
            System.out.println("--ID no encontrado--");
        } else {
        rs = cancionDao.delete( cancion );
            if (rs){
                System.out.println("--Canción Eliminada--");
            } else {
                System.out.println("--Error al eliminar Canción--");
            }
        }
    }

    @Override
    public void editT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Cancion cancion = cancionDao.findById( id );
        if (cancion == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( cancion );
            System.out.println("Ingrese el Nuevo Titulo de la Canción:");
            cancion.setTitulo( ReadUtil.read() );
            System.out.println("Ingrese la Nueva Duración de la Canción (HH:MM:SS):");
            cancion.setDuracion( ReadUtil.readLocalTime() );
            rs = cancionDao.update( cancion );
            if (rs){
                System.out.println("--Canción Actualizada--");
            } else {
                System.out.println("--Error al actualizar Canción--");
            }
        }
    }

    @Override
    public void findT() {
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Cancion cancion = cancionDao.findById( id );
        if (cancion == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println(cancion );
        }
    }

    @Override
    public void printT() {
        List<Cancion> canciones = cancionDao.findAll();
        if (canciones.isEmpty()){
            System.out.println("--No hay Canciones registradas--");
        } else {
            canciones.forEach(System.out::println);
        }
    }
}
