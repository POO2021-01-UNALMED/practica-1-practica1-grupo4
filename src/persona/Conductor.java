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
	
	// cambia el estado del picker a "ACTIVO" o "INACTIVO" según sea el caso. Está función se usa en el constructor
	public void setStatus() {
		if (!this.withinRange()) {
			this.estado = "INACTIVO";
		}
		else {
			this.estado = "ACTIVO";
		}
	}
	
	
}
