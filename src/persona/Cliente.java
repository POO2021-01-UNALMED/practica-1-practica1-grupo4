package persona;
import almacen.*;
import baseDatos.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/// CLIENTE \\\ para nuestro caso será el usuario en cuestión, el que ordena el domicilio y escoge los productos

public class Cliente implements Serializable{
	
	//ATRIBUTOS de la clase 'Cliente'
	
	private String nombre; // nombre del cliente
	private String apellidos; // apellidos del cliente
	private int ID;  // número de identificación del cliente
	public static String direccion; // dirección del cliente
	private Picker picker; // Picker asignado al cliente para que escoja sus productos
<<<<<<< HEAD
	private static Conductor conductor; // Conductor que entregar� el pedido del cliente
=======
	private Conductor conductor; // Conductor que entregará el pedido del cliente
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
	private static Pedido pedido; // Pedido realizado por el cliente
	

	
	// CONSTRUCTOR para la clase 'Cliente'
	
	public Cliente() {}
	
	public Cliente(String nombre, String apellidos, int ID, String d) {
		this.nombre= nombre;
		this.apellidos=apellidos;
		this.ID=ID;
		direccion = d;
		generarDireccion();
		
	}
<<<<<<< HEAD
	// el siguiente m�todo llamado generarDireccion(), genera una direcci�n aleatoria para el cliente en la ciudad.
=======
	// el siguiente método llamado generarDireccion(), genera una dirección aleatoria para el cliente en la ciudad.
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
	public static  void generarDireccion() {
		
		int x= (int)Math.floor(Math.random()*50);
		int y=(int)Math.floor(Math.random()*50);
		Almacen.ciudad [x][y]= direccion;
	}
	
	/*el siguiente método llamar(), representa el instante en el que el usuario comienza a interactuar con el almacen,
	 la idea es asignarle un Picker y un pedido para que comience a escoger los productos que desea*/
	public void llamar() {
		this.picker = Almacen.randomPicker();
		this.picker.cliente=this;
		Almacen.asignarPedido();	
	}
	
	
	public void finalizarCompra() {
		this.picker.setStatus();	
	}
	
<<<<<<< HEAD
	// el siguiente m�todo le permite al cliente saber el estado de su pedido
=======
	// el siguiente método le permite al cliente saber el estado de su pedido
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
	public static void ConsultarEstadoPedido() {
		getPedido().consultaPedido();
	}
	// el siguiente método retornará a través de un getter los nombres y apellidos del cliente
	public String getNombreCompleto() {
		return this.nombre + " " + this.apellidos;
	}
	
	// el siguiente método retornará a través de un getter el número de identificación del cliente
	public int getID() {
		return this.ID;
	}
	
	// el siguiente método retornará a través de un getter el Picker asociado al cliente
	public Picker getPicker() {
		return this.picker;
	}
	
	// el siguiente método retornará a través de un getter el Conductor asosciado al cliente
	public Conductor getConductor() {
		return this.conductor;
	}
	
	// Los siguientes métodos son un setter y getter respectivamente para el atributo de Pedido
	public static void setPedido(Pedido p) {
		pedido = p;
	}
	public static Pedido getPedido() {
		return pedido;
	}
	public void serializarCliente() throws IOException {
		Serializer.serializar(this);
	}
	public Cliente deserializarCliente() throws ClassNotFoundException, IOException {
		return Deserializer.deserializar(this);
	}
	
	
	public static String getDireccion() {
		return direccion;
	}

	public static void setDireccion(String direccion) {
		Cliente.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setID(int iD) {
		ID = iD;
	}

<<<<<<< HEAD
	public static void setConductor(Conductor c) {
		conductor = c;
=======
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	


	
<<<<<<< HEAD
}
=======
}
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
