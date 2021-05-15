package persona;

import java.time.LocalTime;

public abstract class Empleados {
	private String nombre;
	private String apellidos;
	private int ID;
	private int artefacto;
	public boolean accion;
	public String estado;
	public LocalTime comienzoTurno;
	public LocalTime finTurno;
	
	
	public Empleados(String nombre, String apellidos, int ID, int artefacto, boolean accion, LocalTime comienzoTurno,LocalTime finTurno){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.ID= ID;
		this.artefacto = artefacto;
		this.accion = accion;
		this.comienzoTurno= comienzoTurno;
		this.finTurno=finTurno;
	}
	public abstract void setStatus();
	public abstract boolean withinRange();
	
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



