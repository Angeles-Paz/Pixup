package org.gerdoc.pixup.repository.jdbc.impl;
import org.gerdoc.pixup.model.Municipio;
import org.gerdoc.pixup.repository.jdbc.MunicipioJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MunicipioJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(MunicipioJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        List<Municipio> list = municipioJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        assertEquals(1, list.size());
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        Municipio municipio = new Municipio();
        boolean res = false;
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        municipio.setNombre("PACHUCA");
        municipio.setIdEstado(1);
        res = municipioJdbc.save( municipio );
        assertEquals(true, res);
    }

    @Test
    void update() {
        Municipio municipio = new Municipio();
        boolean res = false;
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        municipio.setNombre("HUITZILA");
        municipio.setIdEstado(1);
        municipio.setId(2);
        res = municipioJdbc.update(municipio);
        assertEquals(true, res);
    }

    @Test
    void findById() {
        Municipio municipio;
        Integer id = 1;
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        municipio = municipioJdbc.findById( id );
        System.out.println(municipio);
    }

    @Test
    void delete() {
        Municipio municipio = new Municipio();
        boolean res = false;
        municipio.setId(1);
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        res = municipioJdbc.delete(municipio);
        assertEquals(true, res);
    }

}