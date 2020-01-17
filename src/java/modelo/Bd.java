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

/**
 *
 * @author Alumno_2DAW
 */
public class Bd {
    private final static String drv="com.mysql.jdbc.Driver";
    private final static String db="jdbc:mysql://localhost:3306/usuarios?useSSL=false";
    private final static String user="root";
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement pst;

    public Bd() throws ClassNotFoundException, SQLException {
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
    
        public Boolean compruebaNombre(String usuario){
        
        
        String sql="select * from usuarios where usuario like '"+usuario+"'";
        try {
            pst=cn.prepareStatement(sql);
            rs=pst.executeQuery();
            rs.next();
            if (rs.getString(2)!=null) {
                return false;
            }
        } catch (SQLException ex) {
            return true;
        }
        return true;
        
    }
}