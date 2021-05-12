package personas;

import java.time.LocalTime;

/*
 ///CONDUCTOR\\\
  
  Un conductor se encarga de llevar la compra que se le fue entregada por el picker al cliente.
  
 */

public class Conductor extends Persona{
	
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
