package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.UsuarioDao;
import org.gerdoc.pixup.model.Usuario;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDaoImplTest {

    @Test
    void getInstance() {

        assertNotNull(UsuarioDaoImpl.getInstance());

    }

    @Test
    void findAll() {

        List<Usuario> list = null;
        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        list = usuarioDao.findAll();
        assertNotNull( list );
        assertFalse( list.isEmpty() );
        list.forEach(System.out::println);

    }

    @Test
    void save() {

        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        Usuario usuario = null;
        boolean res = false;
        usuario = new Usuario();
        usuario.setNombre( "ANGEL" );
        usuario.setPrimerApellido("ANGELES");
        usuario.setSegundoApellido("PAZ");
        usuario.setPassword("123456");
        usuario.setEmail("angelespazangelemiliano@gmail.com");
        res = usuarioDao.save( usuario );
        assertTrue( res );

    }

    @Test
    void update() {

        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        Usuario usuario = null;
        boolean res = false;
        usuario = usuarioDao.findById( 2 );
        assertNotNull( usuario );
        usuario.setNombre( "AMAURY" );
        usuario.setPrimerApellido("TORRES");
        usuario.setSegundoApellido("GRANADOS");
        usuario.setPassword("000000");
        usuario.setEmail("torres.granados.amaury@gmail.com");
        res = usuarioDao.update( usuario );
        assertTrue( res );

    }

    @Test
    void delete() {

        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        Usuario usuario = null;
        boolean res = false;
        usuario = usuarioDao.findById( 3 );
        assertNotNull( usuario );
        res = usuarioDao.delete( usuario );
        assertTrue( res );

    }

    @Test
    void findById() {

        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        Usuario usuario = null;
        usuario = usuarioDao.findById( 2 );
        assertNotNull( usuario );
        assertEquals(2, usuario.getId());
        assertEquals("AMAURY", usuario.getNombre());
        assertEquals("TORRES", usuario.getPrimerApellido());
        assertEquals("GRANADOS", usuario.getSegundoApellido());
        assertEquals("000000", usuario.getPassword());
        assertEquals("torres.granados.amaury@gmail.com", usuario.getEmail());
        System.out.println( usuario );

    }
}