package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.MunicipioDao;
import org.gerdoc.pixup.model.Municipio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MunicipioDaoImplTest {

    @Test
    void getInstance() {

        assertNotNull(MunicipioDaoImpl.getInstance());

    }

    @Test
    void findAll() {

        List<Municipio> list = null;
        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        list = municipioDao.findAll();
        assertNotNull( list );
        assertFalse( list.isEmpty() );
        list.forEach(System.out::println);

    }

    @Test
    void save() {

        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        Municipio municipio = null;
        boolean res = false;
        municipio = new Municipio();
        municipio.setNombre( "AGUASCALIENTES" );
        municipio.setIdEstado( 2 );
        res = municipioDao.save( municipio );
        assertTrue( res );

    }

    @Test
    void update() {

        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        Municipio municipio = null;
        boolean res = false;
        municipio = municipioDao.findById( 2 );
        assertNotNull( municipio );
        municipio.setNombre( "PACHUCA" );
        municipio.setIdEstado( 1 );
        res = municipioDao.update( municipio );
        assertTrue( res );

    }

    @Test
    void delete() {

        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        Municipio municipio = null;
        boolean res = false;
        municipio = municipioDao.findById( 5 );
        assertNotNull( municipio );
        res = municipioDao.delete( municipio );
        assertTrue( res );

    }

    @Test
    void findById() {

        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        Municipio municipio = null;
        municipio = municipioDao.findById( 2 );
        assertNotNull( municipio );
        assertEquals(2, municipio.getId());
        assertEquals("PACHUCA", municipio.getNombre());
        assertEquals(1, municipio.getIdEstado());
        System.out.println( municipio );

    }
}