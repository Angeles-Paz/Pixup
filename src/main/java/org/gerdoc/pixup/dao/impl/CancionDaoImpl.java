package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.CancionDao;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.model.Cancion;
import org.hibernate.Session;

import java.util.List;

public class CancionDaoImpl implements CancionDao {

    private static CancionDao cancionDao;

    private CancionDaoImpl() {

    }

    public static CancionDao getInstance(){
        if ( cancionDao == null )
        {
            cancionDao = new CancionDaoImpl( );
        }
        return cancionDao;
    }

    @Override
    public List<Cancion> findAll() {
        List<Cancion> canciones = null;
        Session session = HibernateUtil.getSession();
        canciones = session.createQuery("From Cancion", Cancion.class).getResultList();
        session.close();
        return canciones;
    }

    @Override
    public boolean save(Cancion cancion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( cancion );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Cancion cancion) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( cancion );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Cancion cancion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( cancion );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Cancion findById(int id) {
        Session session = HibernateUtil.getSession();
        Cancion cancion = session.get(Cancion.class, id);
        return cancion;
    }
}
