package org.gerdoc.pixup.repository.jdbc;

import org.gerdoc.pixup.model.Estado;
import org.gerdoc.pixup.model.Municipio;

import java.util.List;

public interface MunicipioJdbc
{
    List<Municipio> findAll( );
    boolean save(Municipio municipio);
    boolean update(Municipio municipio);
    boolean delete(Municipio municipio);
    Municipio findById( Integer id );
}
