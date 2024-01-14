package misClases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	
	public String driver="com.mysql.cj.jdbc.Driver";
	
	public Connection getConecction () throws ClassNotFoundException
	{
		Connection conexion = null; 
		try 
		{
			Class.forName(driver);
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_oradores", "root", "Max_mysql07");
		}
		catch(SQLException e)
		{
			System.out.println(e);		}
		return conexion;
		
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Connection conexion = null;
		Conexion con = new Conexion();
		conexion = con.getConecction();
		
		PreparedStatement ps;
		ResultSet rs;
		
		ps = conexion.prepareStatement("SELECT * from orador");
		rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			int id = rs.getInt("id_orador");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			String tematica = rs.getString("tematica");
			String fecha = rs.getString("fecha");
			
			System.out.println("Id: " + id + " Nombre: " + nombre + " Apellido: " + apellido + " Tematica: " + tematica + " Fecha: " + fecha);
		}
		
		
	}

}
