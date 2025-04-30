package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.EstadoDao;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.model.Estado;
import org.hibernate.Session;

import java.util.List;

public class EstadoDaoImpl implements EstadoDao {

    private static EstadoDao estadoDao;

    private EstadoDaoImpl() {

    }

    public static EstadoDao getInstance(){
        if ( estadoDao == null )
        {
            estadoDao = new EstadoDaoImpl( );
        }
        return estadoDao;
    }

    @Override
    public List<Estado> findAll() {
        List<Estado> estados = null;
        Session session = HibernateUtil.getSession();
        estados = session.createQuery("From Estado", Estado.class).getResultList();
        session.close();
        return estados;
    }

    @Override
    public boolean save(Estado estado) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( estado );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Estado estado) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( estado );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Estado estado) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( estado );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Estado findById(int id) {
        Session session = HibernateUtil.getSession();
        Estado estado = session.get(Estado.class, id);
        return estado;
    }
}
