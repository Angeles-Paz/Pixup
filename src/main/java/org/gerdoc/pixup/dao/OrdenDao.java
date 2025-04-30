package org.gerdoc.pixup.dao;

import org.gerdoc.pixup.model.Orden;

import java.util.List;

public interface OrdenDao
{
    List<Orden> findAll( );
    boolean save( Orden orden );
    boolean update( Orden orden );
    boolean delete( Orden orden );
    Orden findById( int id );
}
