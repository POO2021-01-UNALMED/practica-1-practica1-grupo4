package gestorAplicación;
import java.io.Serializable;
import java.time.LocalTime;
public class Conductor extends Empleados implements Serializable {
	
	// El conductor es el que se encarga de llevar el domicilio al cliente siempre y cuando este en horario laboral y no esté en otro servicio
	
	
	public Picker picker;
	
	// CONSTRUCTOR para la clase "Conductor"
	
	public Conductor(String nombre, String apellidos, int ID, int numeroVehiculo, boolean viaje, LocalTime comienzoTurno,LocalTime finTurno) {
		super(nombre,apellidos,ID,numeroVehiculo,viaje, comienzoTurno,finTurno);
		this.setStatus();
		
	}
	
	// retorna true si el conductor esta dentro de su horario laboral
	public boolean withinRange() {
		return (LocalTime.now().isBefore(finTurno) && LocalTime.now().isAfter(comienzoTurno));
		
	}
	
	
	
	// cambia el estado del conductor a "ACTIVO" o "INACTIVO" según sea el caso. Está función se usa en el constructor
	public void setStatus() {
		if (!this.withinRange()) {
			this.estado = "INACTIVO";
		}
		else {
			this.estado = "ACTIVO";
		}
	}
	// retorna true si el conductor edta disponible para atender
	public boolean disponibleParaAtender() {
		if (!this.accion && this.estado.equals("ACTIVO")) {
			return true;
		}
		return false;
	}
	@Override
	public String getRol() {
		return "Conductor";
	}
}