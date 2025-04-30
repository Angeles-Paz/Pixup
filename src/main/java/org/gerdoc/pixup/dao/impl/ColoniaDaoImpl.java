package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.ColoniaDao;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.model.Colonia;
import org.hibernate.Session;

import java.util.List;

public class ColoniaDaoImpl implements ColoniaDao {

    private static ColoniaDao coloniaDao;

    private ColoniaDaoImpl() {

    }

    public static ColoniaDao getInstance(){
        if ( coloniaDao == null )
        {
            coloniaDao = new ColoniaDaoImpl( );
        }
        return coloniaDao;
    }

    @Override
    public List<Colonia> findAll() {
        List<Colonia> colonias = null;
        Session session = HibernateUtil.getSession();
        colonias = session.createQuery("From Colonia", Colonia.class).getResultList();
        session.close();
        return colonias;
    }

    @Override
    public boolean save(Colonia colonia) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( colonia );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Colonia colonia) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( colonia );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Colonia colonia) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( colonia );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Colonia findById(int id) {
        Session session = HibernateUtil.getSession();
        Colonia colonia = session.get(Colonia.class, id);
        return colonia;
    }
}
