package org.gerdoc.pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Estado;
import org.gerdoc.pixup.repository.jdbc.EstadoJdbc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class EstadoJdbcImplTest {

    @org.junit.jupiter.api.Test
    void getInstance() {
        assertNotNull(EstadoJdbcImpl.getInstance());
    }

    @org.junit.jupiter.api.Test
    void findAll() {
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        List<Estado> list = estadoJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        assertEquals(3, list.size());
        list.stream().forEach(System.out::println);
    }

    @org.junit.jupiter.api.Test
    void save() {
        Estado estado = new Estado();
        boolean res = false;
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        estado.setNombre("HIDALGO");
        res = estadoJdbc.save( estado );
        assertEquals(true, res);
    }
    @org.junit.jupiter.api.Test
    void update() {
        Estado estado =new Estado();
        boolean res = false;
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        estado.setNombre("CDMX");
        estado.setId(1);
        res = estadoJdbc.update(estado);
        assertEquals(true, res);
    }
    @org.junit.jupiter.api.Test
    void delete() {
        Estado estado =new Estado();
        boolean res = false;
        estado.setId(4);
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        res = estadoJdbc.delete(estado);
        assertEquals(true, res);
    }
    @org.junit.jupiter.api.Test
    void findById() {
        Estado estado;
        Integer id = 1;
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        estado = estadoJdbc.findById( id );
        System.out.println(estado);
    }

}