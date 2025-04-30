package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.DiscoDao;
import org.gerdoc.pixup.model.Disco;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoDaoImplTest {

    @Test
    void getInstance() {

        assertNotNull(DiscoDaoImpl.getInstance());

    }

    @Test
    void findAll() {

        List<Disco> list = null;
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        list = discoDao.findAll();
        assertNotNull( list );
        assertFalse( list.isEmpty() );
        list.forEach(System.out::println);

    }

    @Test
    void save() {

        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = null;
        boolean res = false;
        disco = new Disco();
        disco.setTitulo( "ANHELOS y AÑORANZAS" );
        disco.setPrecio( 300.00f );
        disco.setExistencia(50000);
        disco.setDescuento(120.00f);
        disco.setFechaLanzamiento(LocalDate.of(1979, 1, 1));
        disco.setImagen("Julio jaramillo tocando la guitarra");
        disco.setIdArtista(1);
        disco.setIdDisquera(1);
        res = discoDao.save( disco );
        assertTrue( res );

    }

    @Test
    void update() {

        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = null;
        boolean res = false;
        disco = discoDao.findById( 2 );
        assertNotNull( disco );
        disco.setTitulo( "SHORT N' SWEET" );
        disco.setPrecio( 1100.00f );
        disco.setExistencia(6000000);
        disco.setDescuento(320.00f);
        disco.setFechaLanzamiento(LocalDate.of(2024, 8, 23));
        disco.setImagen("Una foto muy coqueta de Sabrina Carpenter");
        disco.setIdArtista(2);
        disco.setIdDisquera(2);
        res = discoDao.update( disco );
        assertTrue( res );

    }

    @Test
    void delete() {

        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = null;
        boolean res = false;
        disco = discoDao.findById( 2 );
        assertNotNull( disco );
        res = discoDao.delete( disco );
        assertTrue( res );

    }

    @Test
    void findById() {

        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = null;
        disco = discoDao.findById( 2 );
        assertNotNull( disco );
        assertEquals(2, disco.getId());
        assertEquals("SHORT N' SWEET", disco.getTitulo());
        assertEquals(1100.00f, disco.getPrecio());
        assertEquals(6000000, disco.getExistencia());
        assertEquals(320.00f, disco.getDescuento());
        assertEquals(LocalDate.of(2024, 8, 23), disco.getFechaLanzamiento());
        assertEquals("Una foto muy coqueta de Sabrina Carpenter", disco.getImagen());
        assertEquals(2, disco.getIdArtista());
        assertEquals(2, disco.getIdDisquera());
        System.out.println( disco );

    }
}