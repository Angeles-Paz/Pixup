package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.OrdenDao;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.model.Orden;
import org.hibernate.Session;

import java.util.List;

public class OrdenDaoImpl implements OrdenDao {

    private static OrdenDao ordenDao;

    private OrdenDaoImpl() {

    }

    public static OrdenDao getInstance(){
        if ( ordenDao == null )
        {
            ordenDao = new OrdenDaoImpl( );
        }
        return ordenDao;
    }

    @Override
    public List<Orden> findAll() {
        List<Orden> ordenes = null;
        Session session = HibernateUtil.getSession();
        ordenes = session.createQuery("From Orden", Orden.class).getResultList();
        session.close();
        return ordenes;
    }

    @Override
    public boolean save(Orden orden) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( orden );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Orden orden) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( orden );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Orden orden) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( orden );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Orden findById(int id) {
        Session session = HibernateUtil.getSession();
        Orden orden = session.get(Orden.class, id);
        return orden;
    }
}
