package persona;
import java.time.LocalTime;
public class Conductor extends Empleados {
	
	private int numeroVehiculo;
	public LocalTime comienzoTurno = LocalTime.of(9, 0, 0);  // comienzo del turno del Conductor
	public LocalTime FinTurno = LocalTime.of(18, 0, 0);  // fin del turno del Conductor
	private Picker picker;
	public String estado;
	public boolean viaje;
	
	// CONSTRUCTOR para la clase "Conductor"
	
	public Conductor(String nombre, String apellidos, int ID, boolean viaje) {
		super(nombre, apellidos, ID);
		this.viaje = viaje;
	}
	
	
}
