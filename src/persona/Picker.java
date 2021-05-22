package persona;
import java.time.*;
import java.util.ArrayList;


public class Picker extends Empleados {

	 public Cliente cliente;
	
	// CONSTRUCTOR para la clase "Picker"
	
	public Picker(String nombre, String apellidos, int ID, int numeroDispositivo, boolean llamada, LocalTime comienzoTurno,LocalTime finTurno){
		super(nombre, apellidos, ID,numeroDispositivo,llamada,comienzoTurno,finTurno);
		this.setStatus();
		
	}
	// esta función determina si el Picker se encuentra o no en su horario de trabajo.
	public boolean withinRange() {
		return (LocalTime.now().isBefore(finTurno) && LocalTime.now().isAfter(comienzoTurno));
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
<<<<<<< HEAD
	// determina si el picker est� o no disponible para atender a un cliente dependiendo de si se encuentra en una llamada y de si se encuentra "ACTIVO"
=======
	// determina si el picker está o no disponible para atender a un cliente dependiendo de si se encuentra en una llamada y de si se encuentra "ACTIVO"
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
	public boolean disponibleParaAtender() {
		if (!this.accion && this.estado.equals("ACTIVO")) {
			return true;
		}
		return false;
	}
	
	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
