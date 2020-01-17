/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno_2DAW
 */
public class Bd_Busqueda {
    private final static String drv="com.mysql.jdbc.Driver";
    private final static String db="jdbc:mysql://localhost:3306/books?useSSL=false";
    private final static String user="root";
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement pst;

    public Bd_Busqueda() throws ClassNotFoundException, SQLException {
        abrirConexion();

    }

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName(drv);
        cn=DriverManager.getConnection(db,user,"");
        System.out.println("La conexion se realizo con exito");
    }
    
    public void cerrarConexion() throws SQLException{
        if(rs!=null){
            rs.close();
        }
        if (pst!=null) {
            pst.close();
        }
        if (cn!=null) {
            cn.close();
        }
        
        System.out.println("Conexion cerrada");
    }

    public List<Libro> getLibros(String tituloLibro) throws SQLException {
        List<Libro>lista=new ArrayList<>();
        
        String sql="SELECT t.Titulo , a.Nombre FROM titulos t, autor a WHERE (t.IDautor=a.IDAutor) AND t.Titulo like '%"+tituloLibro+"%'";
        pst=cn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while (rs.next()) {            
            String titulo=rs.getString(1);
            String autor=rs.getString(2);
            Libro lib=new Libro(titulo, autor);
            lista.add(lib);
        }
        
        return lista;
    }
}
