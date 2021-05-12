package personas;
import java.time.*;
import java.util.ArrayList;

/* 
 
 ///PICKER\\\
  
  Un picker se encarga de escoger los productos que el cliente ordene, los empaca en bolsas
  y posteriormente se los entrega al conductor asignado.

 */

public class Picker extends Persona{
	
	private int numeroDispositivo; // numero del dispositivo que usa el picker.
	public LocalTime comienzoTurno = LocalTime.of(9, 0, 0);  // comienzo del turno del Picker
	public LocalTime FinTurno = LocalTime.of(23, 0, 0);  // fin del turno del Picker
	public String estado;  // "ACTIVO" o "INACTIVO", el estado del Picker lo determina su horario de trabajo
	public boolean llamada; // determina si el Picker está o no atendiendo un cliente
	
	
	// CONSTRUCTOR para la clase "Picker"
	
	public Picker(String nombre, String apellidos, int ID, int numeroDispositivo, boolean llamada){
		super(nombre, apellidos, ID);
		this.numeroDispositivo = numeroDispositivo;
		this.llamada = llamada;
		this.setStatus();
	}
	// esta función determina si el Picker se encuentra o no en su horario de trabajo.
	public boolean withinRange() {
		return (LocalTime.now().isBefore(FinTurno) && LocalTime.now().isAfter(comienzoTurno));
	}
	
	// cambia el estado del picker a "ACTIVO" o "INACTIVO" según sea el caso. Está función se usa en el constructor
	public void setStatus() {
		if (!this.withinRange()) {
			this.estado = "INACTIVO";
		}
		else {
			this.estado = "ACTIVO";
		}
	}
	// determina si el picker está o no disponible para atender a un cliente dependiendo de si se encuentra en una llamada y de si se encuentra "ACTIVO"
	public boolean disponibleParaAtender() {
		if (!this.llamada && this.estado.equals("ACTIVO")) {
			return true;
		}
		return false;
	}
	
	
}
