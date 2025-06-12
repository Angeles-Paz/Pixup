package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.dao.DiscoDao;
import org.gerdoc.pixup.dao.impl.DiscoDaoImpl;
import org.gerdoc.pixup.model.Disco;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class DiscoCatalogo extends Catalogos<Disco>
{
    private static DiscoDao discoDao = DiscoDaoImpl.getInstance();

    public static DiscoCatalogo discoCatalogo;

    private DiscoCatalogo( ) {
        super();
    }

    public static DiscoCatalogo getInstance( )
    {
        if(discoCatalogo==null)
        {
            discoCatalogo = new DiscoCatalogo();
        }
        return discoCatalogo;
    }

    @Override
    protected String tcatalogo() {
        String menu = "Disco";
        return menu;
    }

    @Override
    public void addT()
    {
        boolean rs;
        Disco disco = new Disco();
        System.out.println("Ingrese el Titulo del Disco:");
        disco.setTitulo( ReadUtil.read() );
        System.out.println("Ingrese el Precio del Disco:");
        disco.setPrecio( ReadUtil.readFloat() );
        System.out.println("Ingrese las Copias del Disco:");
        disco.setExistencia( ReadUtil.readInt() );
        System.out.println("Ingrese el Descuento del Disco:");
        disco.setDescuento( ReadUtil.readFloat() );
        System.out.println("Ingrese la Fecha de Lanzamiento del Disco (AAAA-MM-DD):");
        disco.setFechaLanzamiento( ReadUtil.readLocalDate() );
        System.out.println("Ingrese la descripcion de la Imagen del Disco:");
        disco.setImagen( ReadUtil.read() );
        System.out.println("Ingrese el ID de la Canción del Disco:");
        disco.setIdCancion( ReadUtil.readInt() );
        System.out.println("Ingrese el ID del Artista del Disco:");
        disco.setIdArtista( ReadUtil.readInt() );
        System.out.println("Ingrese el ID de la Disquera del Disco:");
        disco.setIdDisquera( ReadUtil.readInt() );
        System.out.println("Ingrese el ID del Genero Musical del Disco:");
        disco.setIdGenero( ReadUtil.readInt() );
        rs = discoDao.save( disco );
        if (rs){
            System.out.println("--Disco Agregado--");
        } else {
            System.out.println("--Error al agregar Disco--");
        }
    }

    @Override
    public void removeT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Disco disco = discoDao.findById( id );
        if (disco == null){
            System.out.println("--ID no encontrado--");
        } else {
            rs = discoDao.delete( disco );
            if (rs){
                System.out.println("--Disco Eliminado--");
            } else {
                System.out.println("--Error al eliminar Disco--");
            }
        }
    }

    @Override
    public void editT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Disco disco = discoDao.findById( id );
        if (disco == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( disco );
            System.out.println("Ingrese el Nuevo Titulo del Disco:");
            disco.setTitulo( ReadUtil.read() );
            System.out.println("Ingrese el Nuevo Precio del Disco:");
            disco.setPrecio( ReadUtil.readFloat() );
            System.out.println("Ingrese las Nuevas Copias del Disco:");
            disco.setExistencia( ReadUtil.readInt() );
            System.out.println("Ingrese el Nuevo Descuento del Disco:");
            disco.setDescuento( ReadUtil.readFloat() );
            System.out.println("Ingrese la Nueva Fecha de Lanzamiento del Disco (AAAA-MM-DD):");
            disco.setFechaLanzamiento( ReadUtil.readLocalDate() );
            System.out.println("Ingrese la Nueva descripcion de la Imagen del Disco:");
            disco.setImagen( ReadUtil.read() );
            System.out.println("Ingrese el Nuevo ID de la Canción del Disco:");
            disco.setIdCancion( ReadUtil.readInt() );
            System.out.println("Ingrese el Nuevo ID del Artista del Disco:");
            disco.setIdArtista( ReadUtil.readInt() );
            System.out.println("Ingrese el Nuevo ID de la Disquera del Disco:");
            disco.setIdDisquera( ReadUtil.readInt() );
            System.out.println("Ingrese el Nuevo ID del Genero Musical del Disco:");
            disco.setIdGenero( ReadUtil.readInt() );
            rs = discoDao.update( disco );
            if (rs){
                System.out.println("--Disco Actualizado--");
            } else {
                System.out.println("--Error al actualizar Disco--");
            }
        }
    }

    @Override
    public void findT() {
        Disco disco;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        disco = discoDao.findById( id );
        if (disco == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( disco );
        }
    }

    @Override
    public void printT() {
        List<Disco> discos = discoDao.findAll();
        if (discos.isEmpty()){
            System.out.println("--No hay Discos registrados--");
        } else {
            discos.forEach(System.out::println);
        }
    }
}
