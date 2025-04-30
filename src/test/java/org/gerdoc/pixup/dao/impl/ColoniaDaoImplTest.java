package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.ColoniaDao;
import org.gerdoc.pixup.model.Colonia;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColoniaDaoImplTest {

    @Test
    void getInstance() {

        assertNotNull(ColoniaDaoImpl.getInstance());

    }

    @Test
    void findAll() {

        List<Colonia> list = null;
        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        list = coloniaDao.findAll();
        assertNotNull( list );
        assertFalse( list.isEmpty() );
        list.forEach(System.out::println);

    }

    @Test
    void save() {

        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        Colonia colonia = null;
        boolean res = false;
        colonia = new Colonia();
        colonia.setNombre( "GEOVILLAS" );
        colonia.setCodigoPostal( "43806" );
        colonia.setIdMunicipio( 1 );
        res = coloniaDao.save( colonia );
        assertTrue( res );

    }

    @Test
    void update() {

        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        Colonia colonia = null;
        boolean res = false;
        colonia = coloniaDao.findById( 2 );
        assertNotNull( colonia );
        colonia.setNombre( "EL DORADO" );
        colonia.setCodigoPostal( "20235" );
        colonia.setIdMunicipio( 3 );
        res = coloniaDao.update( colonia );
        assertTrue( res );

    }

    @Test
    void delete() {

        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        Colonia colonia = null;
        boolean res = false;
        colonia = coloniaDao.findById( 2 );
        assertNotNull( colonia );
        res = coloniaDao.delete( colonia );
        assertTrue( res );

    }

    @Test
    void findById() {

        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        Colonia colonia = null;
        colonia = coloniaDao.findById( 2 );
        assertNotNull( colonia );
        assertEquals(2, colonia.getId());
        assertEquals("EL DORADO", colonia.getNombre());
        assertEquals("20235", colonia.getCodigoPostal());
        assertEquals(3, colonia.getIdMunicipio());
        System.out.println( colonia );

    }
}