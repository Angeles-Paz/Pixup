package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.DomicilioDao;
import org.gerdoc.pixup.model.Domicilio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioDaoImplTest {

    @Test
    void getInstance() {

        assertNotNull(DomicilioDaoImpl.getInstance());

    }

    @Test
    void findAll() {

        List<Domicilio> list = null;
        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        list = domicilioDao.findAll();
        assertNotNull( list );
        assertFalse( list.isEmpty() );
        list.forEach(System.out::println);

    }

    @Test
    void save() {

        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        Domicilio domicilio = null;
        boolean res = false;
        domicilio = new Domicilio();
        domicilio.setCalle( "JADE" );
        domicilio.setNumExterior( "#33" );
        domicilio.setNumInterior( null );
        domicilio.setIdColonia( 1 );
        domicilio.setIdUsuario( 1 );
        res = domicilioDao.save( domicilio );
        assertTrue( res );

    }

    @Test
    void update() {

        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        Domicilio domicilio = null;
        boolean res = false;
        domicilio = domicilioDao.findById( 2 );
        domicilio.setCalle( "REPÚBLICA DE VENEZUELA" );
        domicilio.setNumExterior( "#237" );
        domicilio.setNumInterior( null );
        domicilio.setIdColonia( 2 );
        domicilio.setIdUsuario( 2 );
        res = domicilioDao.update( domicilio );
        assertTrue( res );

    }

    @Test
    void delete() {

        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        Domicilio domicilio = null;
        boolean res = false;
        domicilio = domicilioDao.findById( 2 );
        assertNotNull( domicilio );
        res = domicilioDao.delete( domicilio );
        assertTrue( res );

    }

    @Test
    void findById() {

        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        Domicilio domicilio = null;
        domicilio = domicilioDao.findById( 2 );
        assertNotNull( domicilio );
        assertEquals(2, domicilio.getId());
        assertEquals("REPÚBLICA DE VENEZUELA", domicilio.getCalle());
        assertEquals("#237", domicilio.getNumExterior());
        assertNull(domicilio.getNumInterior());
        assertEquals(2, domicilio.getIdColonia());
        assertEquals(2, domicilio.getIdUsuario());
        System.out.println( domicilio );

    }
}