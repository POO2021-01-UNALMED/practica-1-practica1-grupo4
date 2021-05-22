package persona;
import java.time.LocalTime;
public class Conductor extends Empleados {
	
	public Picker picker;
	
	// CONSTRUCTOR para la clase "Conductor"
	
	public Conductor(String nombre, String apellidos, int ID, int numeroVehiculo, boolean viaje, LocalTime comienzoTurno,LocalTime finTurno) {
		super(nombre,apellidos,ID,numeroVehiculo,viaje, comienzoTurno,finTurno);
		this.setStatus();
		
	}
	public boolean withinRange() {
		return (LocalTime.now().isBefore(finTurno) && LocalTime.now().isAfter(comienzoTurno));
		
	}
	
	
	
<<<<<<< HEAD
	// cambia el estado del conductor a "ACTIVO" o "INACTIVO" según sea el caso. Está función se usa en el constructor
=======
	// cambia el estado del conductor a "ACTIVO" o "INACTIVO" segÃºn sea el caso. EstÃ¡ funciÃ³n se usa en el constructor
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
	public void setStatus() {
		if (!this.withinRange()) {
			this.estado = "INACTIVO";
		}
		else {
			this.estado = "ACTIVO";
		}
	}
	
	public boolean disponibleParaAtender() {
		if (!this.accion && this.estado.equals("ACTIVO")) {
			return true;
		}
		return false;
	}
}
