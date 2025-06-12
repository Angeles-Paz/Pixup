package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.dao.ArtistaDao;
import org.gerdoc.pixup.dao.impl.ArtistaDaoImpl;
import org.gerdoc.pixup.model.Artista;
import org.gerdoc.pixup.util.ReadUtil;

import java.util.List;

public class ArtistaCatalogo extends Catalogos<Artista>
{
    private static ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();

    public static ArtistaCatalogo artistaCatalogo;

    private ArtistaCatalogo( ) {
        super();
    }

    public static ArtistaCatalogo getInstance( )
    {
        if(artistaCatalogo==null)
        {
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    protected String tcatalogo() {
        String menu = "Artista";
        return menu;
    }

    @Override
    public void addT()
    {
        boolean rs;
        Artista artista = new Artista();
        System.out.println("Ingrese en Nombre del Artista:");
        artista.setNombre( ReadUtil.read() );
        rs = artistaDao.save( artista );
        if (rs){
            System.out.println("--Artista Agregado--");
        } else {
            System.out.println("--Error al agregar Artista--");
        }
    }

    @Override
    public void removeT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Artista artista = artistaDao.findById( id );
        if (artista == null){
            System.out.println("--ID no encontrado--");
        } else {
        rs = artistaDao.delete( artista );
            if (rs){
                System.out.println("--Artista Eliminado--");
            } else {
                System.out.println("--Error al eliminar Artista--");
            }
        }
    }

    @Override
    public void editT( )
    {
        boolean rs;
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Artista artista = artistaDao.findById( id );
        if (artista == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( artista );
            System.out.println("Ingrese el Nuevo Nombre del Artista:");
            artista.setNombre( ReadUtil.read() );
            rs = artistaDao.update( artista );
            if (rs){
                System.out.println("--Artista Actualizado--");
            } else {
                System.out.println("--Error al actualizar Artista--");
            }
        }
    }

    @Override
    public void findT() {
        System.out.println("Ingrese el ID:");
        int id = ReadUtil.readInt();
        Artista artista = artistaDao.findById( id );
        if (artista == null){
            System.out.println("--ID no encontrado--");
        } else {
            System.out.println( artista );
        }
    }

    @Override
    public void printT() {
        List<Artista> artistas = artistaDao.findAll();
        if (artistas.isEmpty()){
            System.out.println("--No hay Artistas registrados--");
        } else {
            artistas.forEach(System.out::println);
        }
    }
}
