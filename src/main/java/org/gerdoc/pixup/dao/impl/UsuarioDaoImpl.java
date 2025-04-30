package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.UsuarioDao;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.model.Usuario;
import org.hibernate.Session;

import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {

    private static UsuarioDao usuarioDao;

    private UsuarioDaoImpl() {

    }

    public static UsuarioDao getInstance(){
        if ( usuarioDao == null )
        {
            usuarioDao = new UsuarioDaoImpl( );
        }
        return usuarioDao;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = null;
        Session session = HibernateUtil.getSession();
        usuarios = session.createQuery("From Usuario", Usuario.class).getResultList();
        session.close();
        return usuarios;
    }

    @Override
    public boolean save(Usuario usuario) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( usuario );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Usuario usuario) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( usuario );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Usuario usuario) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(usuario );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Usuario findById(int id) {
        Session session = HibernateUtil.getSession();
        Usuario usuario = session.get(Usuario.class, id);
        return usuario;
    }
}
