package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.GeneroDao;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.model.Genero;
import org.hibernate.Session;

import java.util.List;

public class GeneroDaoImpl implements GeneroDao {

    private static GeneroDao generoDao;

    private GeneroDaoImpl() {

    }

    public static GeneroDao getInstance(){
        if ( generoDao == null )
        {
            generoDao = new GeneroDaoImpl( );
        }
        return generoDao;
    }

    @Override
    public List<Genero> findAll() {
        List<Genero> generos = null;
        Session session = HibernateUtil.getSession();
        generos = session.createQuery("From Genero", Genero.class).getResultList();
        session.close();
        return generos;
    }

    @Override
    public boolean save(Genero genero) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( genero );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Genero genero) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( genero );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Genero genero) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( genero );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Genero findById(int id) {
        Session session = HibernateUtil.getSession();
        Genero genero = session.get(Genero.class, id);
        return genero;
    }
}
