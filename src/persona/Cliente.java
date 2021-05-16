package persona;
import almacen.*;
import java.util.*;

/// CLIENTE \\\ para nuestro caso será el usuario en cuestión, el que ordena el domicilio y escoge los productos

public class Cliente{
	
	//ATRIBUTOS de la clase 'Cliente'
	
	private String nombre; // nombre del cliente
	private String apellidos; // apellidos del cliente
	private int ID;  // número de identificación del cliente
	public static String direccion; // dirección del cliente
	private Picker picker; // Picker asignado al cliente para que escoja sus productos
	private Conductor conductor; // Conductor que entregará el pedido del cliente
	private static Pedido pedido; // Pedido realizado por el cliente
	
	// CONSTRUCTOR para la clase 'Cliente'
	
	public Cliente(String nombre, String apellidos, int ID) {
		this.nombre= nombre;
		this.apellidos=apellidos;
		this.ID=ID;
		
	}
	
	// el siguiente método llamado generarDireccion(), genera una dirección aleatoria para el cliente en la ciudad.
	public static int generarDireccion() {
		 int min = 1000000000;
		 int max = 2000000000;
		 return (int)Math.floor(Math.random()*(max - min + 1) + min);
	}
	
	/*el siguiente método llamar(), representa el instante en el que el usuario comienza a interactuar con el almacen,
	 la idea es asignarle un Picker y un pedido para que comience a escoger los productos que desea*/
	public void llamar() {
		this.picker = Almacen.randomPicker();
		this.picker.cliente=this;
		Almacen.asignarPedido();	
	}
	// el siguiente método le permite al cliente saber el estado de su pedido
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
	
	
}