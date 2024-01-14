package misClases;

public class Orador {
	private int id;
	private String nombre;
    private String apellido;
    private String tematica;
    private String fecha;

    public Orador(int newid, String newNombre, String newApellido, String newTematica, String newFecha){
    	super();
    	this.id = newid; 
        this.nombre = newNombre;
        this.apellido = newApellido;
        this.tematica = newTematica;
        this.fecha = newFecha;
        }
    
    public int getId() {
    	return this.id;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getTematica() {
        return this.tematica;
    }

    public String getFecha() {
        return this.fecha;
    }
    
    public void setId(int id) 
    {
    	this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String tematica) {
        this.tematica = tematica;
    }

    public void setantiguedad(String fecha) {
        this.fecha = fecha;
    }

}
