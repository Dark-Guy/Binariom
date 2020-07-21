package modelo;

import java.sql.*;

public class ConexaoDAO {
    Connection con;
    
    public void conectar() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/binariom","root","");
    }
    
    public void desconectar() throws Exception{
        if (!con.isClosed()){
            con.close();
        }
    }
}
