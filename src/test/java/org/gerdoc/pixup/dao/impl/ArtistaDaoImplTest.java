package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.ArtistaDao;
import org.gerdoc.pixup.model.Artista;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaDaoImplTest {

    @Test
    void getInstance() {

        assertNotNull(ArtistaDaoImpl.getInstance());

    }

    @Test
    void findAll() {

        List<Artista> list = null;
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        list = artistaDao.findAll();
        assertNotNull( list );
        assertFalse( list.isEmpty() );
        list.forEach(System.out::println);

    }

    @Test
    void save() {

        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = null;
        boolean res = false;
        artista = new Artista();
        artista.setNombre( "SABRINA CARPENTER" );
        res = artistaDao.save( artista );
        assertTrue( res );

    }

    @Test
    void update() {

        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = null;
        boolean res = false;
        artista = artistaDao.findById( 1 );
        assertNotNull( artista );
        artista.setNombre( "JULIO JARAMILLO" );
        res = artistaDao.update( artista );
        assertTrue( res );

    }

    @Test
    void delete() {

        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = null;
        boolean res = false;
        artista = artistaDao.findById( 2 );
        assertNotNull( artista );
        res = artistaDao.delete( artista );
        assertTrue( res );

    }

    @Test
    void findById() {

        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = null;
        artista = artistaDao.findById( 1 );
        assertNotNull( artista );
        assertEquals(1, artista.getId());
        assertEquals("JULIO JARAMILLO", artista.getNombre());
        System.out.println( artista );

    }
}