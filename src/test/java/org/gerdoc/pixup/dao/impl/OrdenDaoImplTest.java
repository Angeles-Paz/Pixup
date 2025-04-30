package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.OrdenDao;
import org.gerdoc.pixup.model.Orden;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdenDaoImplTest {

    @Test
    void getInstance() {

        assertNotNull(OrdenDaoImpl.getInstance());

    }

    @Test
    void findAll() {

        List<Orden> list = null;
        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        list = ordenDao.findAll();
        assertNotNull( list );
        assertFalse( list.isEmpty() );
        list.forEach(System.out::println);

    }

    @Test
    void save() {

        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        Orden orden = null;
        boolean res = false;
        orden = new Orden();
        orden.setCostoTotal( 1250.00f );
        orden.setFecha(LocalDateTime.of(2025, 4, 21, 16, 23));
        orden.setCantidadTotal( 1 );
        orden.setEstatusEnvio( true );
        orden.setCostoMax( 150.00f );
        orden.setIdUsuario( 1 );
        orden.setIdDisco( 2 );
        res = ordenDao.save( orden );
        assertTrue( res );

    }

    @Test
    void update() {

        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        Orden orden = null;
        boolean res = false;
        orden = ordenDao.findById( 2 );
        assertNotNull( orden );
        orden.setCostoTotal( 390.00f );
        orden.setFecha(LocalDateTime.of(2024, 6, 28, 22, 54));
        orden.setCantidadTotal( 1 );
        orden.setEstatusEnvio( false );
        orden.setCostoMax( 90.00f );
        orden.setIdUsuario( 2 );
        orden.setIdDisco( 1 );
        res = ordenDao.update( orden );
        assertTrue( res );

    }

    @Test
    void delete() {

        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        Orden orden = null;
        boolean res = false;
        orden = ordenDao.findById( 3 );
        assertNotNull( orden );
        res = ordenDao.delete( orden );
        assertTrue( res );

    }

    @Test
    void findById() {

        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        Orden orden = null;
        orden = ordenDao.findById( 2 );
        assertNotNull( orden );
        assertEquals(2, orden.getId());
        assertEquals(390.00f, orden.getCostoTotal());
        assertEquals(LocalDateTime.of(2024, 6, 28, 22, 54), orden.getFecha());
        assertEquals(1, orden.getCantidadTotal());
        assertEquals(false, orden.getEstatusEnvio());
        assertEquals(90.00f, orden.getCostoMax());
        assertEquals(2, orden.getIdUsuario());
        assertEquals(1, orden.getIdDisco());
        System.out.println( orden );

    }
}