package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.dao.GeneroDao;
import org.gerdoc.pixup.dao.impl.GeneroDaoImpl;
import org.gerdoc.pixup.model.Genero;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class GeneroCatalogo extends Catalogos<Genero>
{
    private static GeneroDao generoDao = GeneroDaoImpl.getInstance();

    public static GeneroCatalogo generoCatalogo;

    private GeneroCatalogo( ) {
        super();
    }

    public static GeneroCatalogo getInstance( )
    {
        if(generoCatalogo==null)
        {
            generoCatalogo = new GeneroCatalogo();
        }
        return generoCatalogo;
    }

    @Override
    protected String tcatalogo() {
        String menu = "Genero Musical";
        return menu;
    }

    @Override
    public void addT()
    {
        boolean rs;
        Genero genero = new Genero();
        System.out.println("Ingrese el Genero Musical:");
        genero.setDescripcion( ReadUtil.read() );
        rs = generoDao.save( genero );
        if (rs){
            System.out.println("--Genero Musical Agregado--");
        } else {
            System.out.println("--Error al agregar Genero Musical--");
        }
    }

    @Override
    public void removeT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Genero genero = generoDao.findById( id );
        if (genero == null){
            System.out.println("--ID no encontrado--");
        } else {
            rs = generoDao.delete( genero );
            if (rs){
                System.out.println("--Genero musical Eliminado--");
            } else {
                System.out.println("--Error al eliminar Genero Musical--");
            }
        }
    }

    @Override
    public void editT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Genero genero = generoDao.findById( id );
        if (genero == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( genero );
            System.out.println("Ingrese el Nuevo Genero Musical:");
            genero.setDescripcion( ReadUtil.read() );
            rs = generoDao.update( genero );
            if (rs){
                System.out.println("--Genero Musical Actualizado--");
            } else {
                System.out.println("--Error al actualizar Genero Musical--");
            }
        }
    }

    @Override
    public void findT() {
        Genero genero;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        genero = generoDao.findById( id );
        if (genero == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( genero );
        }
    }

    @Override
    public void printT() {
        List<Genero> generos = generoDao.findAll();
        if (generos.isEmpty()){
            System.out.println("--No hay Generos Musicales registrados--");
        } else {
            generos.forEach(System.out::println);
        }
    }
}
