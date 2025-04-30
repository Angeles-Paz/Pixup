package org.gerdoc.pixup.dao;

import org.gerdoc.pixup.model.Colonia;

import java.util.List;

public interface ColoniaDao
{
    List<Colonia> findAll( );
    boolean save( Colonia colonia );
    boolean update( Colonia colonia );
    boolean delete( Colonia colonia );
    Colonia findById( int id );
}
