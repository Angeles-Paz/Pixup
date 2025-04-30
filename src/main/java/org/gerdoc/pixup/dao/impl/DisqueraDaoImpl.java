package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.DisqueraDao;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.model.Disquera;
import org.hibernate.Session;

import java.util.List;

public class DisqueraDaoImpl implements DisqueraDao {

    private static DisqueraDao disqueraDao;

    private DisqueraDaoImpl() {

    }

    public static DisqueraDao getInstance(){
        if ( disqueraDao == null )
        {
            disqueraDao = new DisqueraDaoImpl( );
        }
        return disqueraDao;
    }

    @Override
    public List<Disquera> findAll() {
        List<Disquera> disqueras = null;
        Session session = HibernateUtil.getSession();
        disqueras = session.createQuery("From Disquera", Disquera.class).getResultList();
        session.close();
        return disqueras;
    }

    @Override
    public boolean save(Disquera disquera) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( disquera );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Disquera disquera) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( disquera );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Disquera disquera) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( disquera );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Disquera findById(int id) {
        Session session = HibernateUtil.getSession();
        Disquera disquera = session.get(Disquera.class, id);
        return disquera;
    }
}
