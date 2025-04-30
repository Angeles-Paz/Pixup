package org.gerdoc.pixup.dao.impl;

import org.gerdoc.pixup.dao.ArtistaDao;
import org.gerdoc.pixup.hibernate.HibernateUtil;
import org.gerdoc.pixup.model.Artista;
import org.hibernate.Session;

import java.util.List;

public class ArtistaDaoImpl implements ArtistaDao {

    private static ArtistaDao artistaDao;

    private ArtistaDaoImpl() {

    }

    public static ArtistaDao getInstance(){
        if ( artistaDao == null )
        {
            artistaDao = new ArtistaDaoImpl( );
        }
        return artistaDao;
    }

    @Override
    public List<Artista> findAll() {
        List<Artista> artistas = null;
        Session session = HibernateUtil.getSession();
        artistas = session.createQuery("From Artista", Artista.class).getResultList();
        session.close();
        return artistas;
    }

    @Override
    public boolean save(Artista artista) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( artista );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Artista artista) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( artista );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Artista artista) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( artista );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Artista findById(int id) {
        Session session = HibernateUtil.getSession();
        Artista artista = session.get(Artista.class, id);
        return artista;
    }
}
