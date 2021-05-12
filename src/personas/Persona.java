package personas;

public abstract class Persona {
	
	private String nombre;
	private String apellidos;
	private int ID;
	
	public Persona(String nombre, String apellidos, int ID) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ID = ID;
	}
	public String getNombre() {
		return this.nombre;
	}

	public int getID() {
		return this.ID;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
}
