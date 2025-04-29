package org.gerdoc.pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Estado;
import org.gerdoc.pixup.model.Municipio;
import org.gerdoc.pixup.repository.jdbc.Conexion;
import org.gerdoc.pixup.repository.jdbc.MunicipioJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MunicipioJdbcImpl extends Conexion<Municipio> implements MunicipioJdbc
{
    private static MunicipioJdbc municipioJdbc;

    private MunicipioJdbcImpl( )
    {
    }


    public static MunicipioJdbc getInstance( )
    {
        if( municipioJdbc == null )
        {
            municipioJdbc = new MunicipioJdbcImpl();
        }
        return municipioJdbc;
    }

    @Override
    public List<Municipio> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Municipio> municipios = null;
        Municipio municipio = null;
        String query ="Select * from TBL_MUNICIPIO";


        try
        {
            if( openConnection() )
            {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery( query );
            municipios = new ArrayList<>();
            while( resultSet.next( ) )
            {
                municipio = new Municipio();
                municipio.setId( resultSet.getInt( 1 ) );
                municipio.setNombre( resultSet.getString( 2 ) );
                municipio.setIdEstado( resultSet.getInt( 3) );
                municipios.add( municipio );
            }
            resultSet.close( );
            statement.close();
            closeConnection( );
            return municipios;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Municipio municipio) {
        PreparedStatement preparedStatement = null;
        String query = "insert into tbl_municipio (municipio, tbl_estado_id) values (?, ?)";
        int res = 0;
        try {
            if (openConnection()){
                System.out.println("Error en conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, municipio.getNombre());
            preparedStatement.setInt(2, municipio.getIdEstado());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override //---No sirve---
    public boolean update(Municipio municipio) {
        PreparedStatement preparedStatement = null;
        String query = "update tbl_municipio set municipio=? where id=?";
        int res = 0;
        try {
            if (openConnection()){
                System.out.println("Error en conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, municipio.getNombre());
            preparedStatement.setInt(2, municipio.getId());
            //preparedStatement.executeUpdate();
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Municipio findById( Integer id ) {
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;
        Municipio municipio = null;
        String query ="Select * from TBL_MUNICIPIO where id=?";

        try
        {
            if( openConnection() )
            {
                System.out.println("Error en conexión");
                return null;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                System.out.println("El id ingresado no existe");
                return null;
            }
            municipio = new Municipio();
            municipio.setId( resultSet.getInt( 1 ) );
            municipio.setNombre( resultSet.getString( 2 ) );
            municipio.setIdEstado( resultSet.getInt(3));
            resultSet.close( );
            preparedStatement.close();
            closeConnection( );
            return municipio;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override //---No sirve---
    public boolean delete(Municipio municipio) {
        PreparedStatement preparedStatement = null;
        String query = "delete from tbl_municipio where id=?";
        int res = 0;
        try {
            if (openConnection()){
                System.out.println("Error en conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, municipio.getId());
            res = preparedStatement.executeUpdate();
            query = "alter table tbl_municipio auto_increment=0;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String a[]) {
        MunicipioJdbcImpl.getInstance().findAll().stream().forEach(System.out::println);
    }
}
