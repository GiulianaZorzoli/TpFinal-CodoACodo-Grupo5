package misClases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class OradorDAO {
	
	Connection conexion = null;
	
	public OradorDAO() throws ClassNotFoundException 
	{
		Conexion con = new Conexion();
		conexion = con.getConecction();
	}
	
	//listar
	public List<Orador> listarOradores()
	{
		PreparedStatement ps; 
		ResultSet rs;
		List<Orador> lista = new ArrayList<>();
		
		try
		{
			ps = conexion.prepareStatement("SELECT * FROM orador");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id_orador");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String tematica = rs.getString("tematica");
				String fecha = rs.getString("fecha");
				
				Orador orador = new Orador(id, nombre, apellido, tematica, fecha);
				
				lista.add(orador);
			}
			return lista;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	//insertar
	
	public boolean insertarOrador(Orador orador)
	{
		PreparedStatement ps;
		try 
		{
			ps = conexion.prepareStatement("insert into orador(nombre, apellido, tematica, fecha)"
		+ "values (?, ?, ?, ?)");
			
			ps.setString(1, orador.getNombre());
			ps.setString(2, orador.getApellido());
			ps.setString(3, orador.getTematica());
			ps.setString(4, orador.getFecha());
			
			ps.execute();
			
			return true;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	//eliminar
	
	public boolean eliminarOrador(int _id)
	{
		PreparedStatement ps;
		try
		{
			ps = conexion.prepareStatement("DELETE FROM ORADOR where id=?");
			ps.setInt(1, _id);
			return true;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}
	}


}
