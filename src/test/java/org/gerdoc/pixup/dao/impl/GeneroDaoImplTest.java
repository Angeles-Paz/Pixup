package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.GeneroDao;
import org.gerdoc.pixup.model.Genero;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneroDaoImplTest {

    @Test
    void getInstance() {

        assertNotNull(GeneroDaoImpl.getInstance());

    }

    @Test
    void findAll() {

        List<Genero> list = null;
        GeneroDao generoDao = GeneroDaoImpl.getInstance();
        list = generoDao.findAll();
        assertNotNull( list );
        assertFalse( list.isEmpty() );
        list.forEach(System.out::println);

    }

    @Test
    void save() {

        GeneroDao generoDao = GeneroDaoImpl.getInstance();
        Genero genero = null;
        boolean res = false;
        genero = new Genero();
        genero.setDescripcion( "POP" );
        res = generoDao.save( genero );
        assertTrue( res );

    }
    @Test
    void update() {

        GeneroDao generoDao = GeneroDaoImpl.getInstance();
        Genero genero = null;
        boolean res = false;
        genero = generoDao.findById( 1 );
        assertNotNull( genero );
        genero.setDescripcion( "BOLEROS" );
        res = generoDao.update( genero );
        assertTrue( res );

    }
    @Test
    void delete() {

        GeneroDao generoDao = GeneroDaoImpl.getInstance();
        Genero genero = null;
        boolean res = false;
        genero = generoDao.findById( 2 );
        assertNotNull( genero );
        res = generoDao.delete( genero );
        assertTrue( res );

    }
    @Test
    void findById() {

        GeneroDao generoDao = GeneroDaoImpl.getInstance();
        Genero genero = null;
        genero = generoDao.findById( 2 );
        assertNotNull( genero );
        assertEquals("ROCK", genero.getDescripcion());
        System.out.println( genero );
    }
}