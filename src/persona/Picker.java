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
<<<<<<< HEAD
	// esta función determina si el Picker se encuentra o no en su horario de trabajo.
=======
	// esta funciÃ³n determina si el Picker se encuentra o no en su horario de trabajo.
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
	public boolean withinRange() {
		return (LocalTime.now().isBefore(finTurno) && LocalTime.now().isAfter(comienzoTurno));
	}
	
<<<<<<< HEAD
	// cambia el estado del picker a "ACTIVO" o "INACTIVO" según sea el caso. Está función se usa en el constructor
=======
	// cambia el estado del picker a "ACTIVO" o "INACTIVO" segÃºn sea el caso. EstÃ¡ funciÃ³n se usa en el constructor
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
	public void setStatus() {
		if (!this.withinRange()) {
			this.estado = "INACTIVO";
		}
		else {
			this.estado = "ACTIVO";
		}
	}
<<<<<<< HEAD
	
	// determina si el picker está o no disponible para atender a un cliente dependiendo de si se encuentra en una llamada y de si se encuentra "ACTIVO"
=======
	// determina si el picker estÃ¡ o no disponible para atender a un cliente dependiendo de si se encuentra en una llamada y de si se encuentra "ACTIVO"
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
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
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
