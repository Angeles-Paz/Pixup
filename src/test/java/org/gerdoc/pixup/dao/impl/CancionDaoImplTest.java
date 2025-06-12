package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.model.Cancion;
import org.junit.jupiter.api.Test;
import org.gerdoc.pixup.dao.*;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CancionDaoImplTest {

    @Test
    void getInstance() {

        assertNotNull(ColoniaDaoImpl.getInstance());

    }

    @Test
    void findAll() {

        List<Cancion> list = null;
        CancionDao cancionDao = CancionDaoImpl.getInstance();
        list = cancionDao.findAll();
        assertNotNull( list );
        assertFalse( list.isEmpty() );
        list.forEach(System.out::println);

    }

    @Test
    void save() {

        CancionDao cancionDao = CancionDaoImpl.getInstance();
        Cancion cancion = null;
        boolean res = false;
        cancion = new Cancion();
        cancion.setTitulo( "ESSPRESSO" );
        cancion.setDuracion( LocalTime.of(0,2,55) );
        res = cancionDao.save( cancion );
        assertTrue( res );
    }
    @Test
    void update() {

        CancionDao cancionDao = CancionDaoImpl.getInstance();
        Cancion cancion = null;
        boolean res = false;
        cancion = cancionDao.findById( 1 );
        assertNotNull( cancion );
        cancion.setTitulo( "THE WAY YOU MAKE ME FEEL" );
        cancion.setDuracion( LocalTime.of(0,4,58) );
        res = cancionDao.update( cancion );
        assertTrue( res );

    }
    @Test
    void delete() {

        CancionDao cancionDao = CancionDaoImpl.getInstance();
        Cancion cancion = null;
        boolean res = false;
        cancion = cancionDao.findById( 1 );
        assertNotNull( cancion );
        res = cancionDao.delete( cancion );
        assertTrue( res );

    }
    @Test
    void findById() {

        CancionDao cancionDao = CancionDaoImpl.getInstance();
        Cancion cancion = null;
        cancion = cancionDao.findById( 2 );
        assertNotNull( cancion );
        assertEquals("BOOGIE WONDERLAND", cancion.getTitulo());
        assertEquals(LocalTime.of(0,4,48), cancion.getDuracion());
        System.out.println( cancion );

    }
}