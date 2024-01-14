package misClases;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FrontController() 
    {
        super();
        
    }
//Para visualizar la página tienen que abrirlo en la ruta de FrontController ej: http://localhost:8080/proyectofinalGrupal/FrontController
    //Hay que fijarse que no se rompan los linkeos porque eso no chequeé sino hay que ir retocando eso.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		String accion=null;
		
		OradorDAO oradorDAO=null;
		
		try
		{
			oradorDAO= new OradorDAO();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		
		
		RequestDispatcher dispatcher=null;
		
		accion=request.getParameter("accion");
		
		if(accion==null||accion.isEmpty())
		{
			dispatcher= request.getRequestDispatcher("vistas/index.jsp");
		}else if(accion.equals("insert"))
		{
			String nombre=request.getParameter("nombre");
			String apellido=request.getParameter("apellido");
			String tematica=request.getParameter("tematica");
			String fecha=request.getParameter("fecha");
			
			Orador orador = new Orador(0,nombre, apellido, fecha, tematica);
			oradorDAO.insertarOrador(orador);
			dispatcher = request.getRequestDispatcher("vistas/index.jsp");
		}
		else if(accion.equals("oradores"))
		{
			dispatcher = request.getRequestDispatcher("vistas/oradores.jsp");
		}
		else if (accion.equals("comprarticket")) {
			dispatcher = request.getRequestDispatcher("vistas/comprarticket.jsp");
		}
		else if (accion.equals("index")) {
			dispatcher = request.getRequestDispatcher("vistas/index.jsp");
		}
		
		dispatcher.forward(request,response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		doGet(request, response);
	}
	
}


