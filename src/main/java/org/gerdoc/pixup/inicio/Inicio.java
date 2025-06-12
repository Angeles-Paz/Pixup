package org.gerdoc.pixup.inicio;

import org.gerdoc.pixup.gui.ConsolaVentana;

public class Inicio
{
    public static void main( String[] args )
    {
        System.out.println( "Inicio PixUp" );
        System.out.println( "----------------------------------------" );
        ConsolaVentana.getInstance( ).run( );
        System.out.println( "----------------------------------------" );
        System.out.println( "Termino PixUp" );
    }

}
