package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.dao.DisqueraDao;
import org.gerdoc.pixup.dao.impl.DisqueraDaoImpl;
import org.gerdoc.pixup.model.Disquera;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class DisqueraCatalogo extends Catalogos<Disquera>
{
    private static DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();

    public static DisqueraCatalogo disqueraCatalogo;

    private DisqueraCatalogo( ) {
        super();
    }

    public static DisqueraCatalogo getInstance( )
    {
        if(disqueraCatalogo==null)
        {
            disqueraCatalogo = new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
    protected String tcatalogo() {
        String menu = "Disquera";
        return menu;
    }

    @Override
    public void addT()
    {
        boolean rs;
        Disquera disquera = new Disquera();
        System.out.println("Ingrese la Disquera:");
        disquera.setNombre( ReadUtil.read() );
        rs = disqueraDao.save( disquera );
        if (rs){
            System.out.println("--Disquera Agregada--");
        } else {
            System.out.println("--Error al agregar Disquera--");
        }
    }

    @Override
    public void removeT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Disquera disquera = disqueraDao.findById( id );
        if (disquera == null){
            System.out.println("--ID no encontrado--");
        } else {
            rs = disqueraDao.delete( disquera );
            if (rs){
                System.out.println("--Disquera Eliminada--");
            } else {
                System.out.println("--Error al eliminar Disquera--");
            }
        }
    }

    @Override
    public void editT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Disquera disquera = disqueraDao.findById( id );
        if (disquera == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( disquera );
            System.out.println("Ingrese la Nueva Disquera:");
            disquera.setNombre( ReadUtil.read() );
            rs = disqueraDao.update( disquera );
            if (rs){
                System.out.println("--Disquera Actualizada--");
            } else {
                System.out.println("--Error al actualizar Disquera--");
            }
        }
    }

    @Override
    public void findT() {
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Disquera disquera = disqueraDao.findById( id );
        if (disquera == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( disquera );
        }
    }

    @Override
    public void printT() {
        List<Disquera> disqueras = disqueraDao.findAll();
        if (disqueras.isEmpty()){
            System.out.println("--No hay Disqueras registradas--");
        } else {
            disqueras.forEach(System.out::println);
        }
    }
}
