package org.gerdoc.pixup.gui.consola;

import org.gerdoc.pixup.gui.LecturaAccion;
import org.gerdoc.pixup.negocio.Ejecutable;

public class ListaCatalogos extends LecturaAccion
{
    public static ListaCatalogos listaCatalogos;
    private ListaCatalogos()
    {
    }
    public static ListaCatalogos getInstance( )
    {
        if(listaCatalogos==null)
        {
            listaCatalogos = new ListaCatalogos();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu()
    {
        System.out.println( "[---Selecciona un catalogo---]" );
        System.out.println( "1.-Disco");
        System.out.println( "2.-Cancion");
        System.out.println( "3.-Artista");
        System.out.println( "4.-Disquera");
        System.out.println( "5.-Genero Musical");
        System.out.println( "6.-Salir");
    }
    @Override
    public int valorMinMenu()
    {
        return 1;
    }

    @Override
    public int valorMaxMenu()
    {
        return 6;
    }

    @Override
    public void procesaOpcion()
    {
        Ejecutable ejecutable = null;
        switch (opcion)
        {
            case 1:
                ejecutable = DiscoCatalogo.getInstance( );
                break;
            case 2:
                ejecutable = CancionCatalogo.getInstance( );
                break;
            case 3:
                ejecutable =ArtistaCatalogo.getInstance( );
                break;
            case 4:
                ejecutable = DisqueraCatalogo.getInstance( );
                break;
            case 5:
                ejecutable = GeneroCatalogo.getInstance( );
                break;
        }
        ejecutable.setFlag( true );
        ejecutable.run( );

    }
}
