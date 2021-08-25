package gestorAplicación;

import java.io.Serializable;
import java.time.LocalTime;

public abstract class Empleados implements Serializable{
	// Es la plantilla para Picker y Conductor
	protected String nombre;
	protected String rol;
	protected String apellidos;
	protected int ID;
	protected int artefacto;
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
	public abstract String getRol();
	public abstract void setStatus();
	public abstract boolean withinRange();
	public abstract boolean disponibleParaAtender();

	
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