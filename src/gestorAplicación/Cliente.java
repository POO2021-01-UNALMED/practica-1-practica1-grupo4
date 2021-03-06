package gestorAplicaci?n;

import baseDatos.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/// CLIENTE \\\ para nuestro caso ser? el usuario en cuesti?n, el que ordena el domicilio y escoge los productos

public class Cliente implements Serializable{
	
	//ATRIBUTOS de la clase 'Cliente'
	
	public ArrayList<String> historicoRecibos = new ArrayList<>();
	private String nombre; // nombre del cliente
	private String apellidos; // apellidos del cliente
	private int ID;  // n?mero de identificaci?n del cliente
	public static String direccion; // direcci?n del cliente
	private Picker picker; // Picker asignado al cliente para que escoja sus productos
	private static Conductor conductor; // Conductor que entregar? el pedido del cliente
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
	
	public void ingresarDireccion(int x ,int y) {
		Almacen.ciudad [x][y]= direccion;		
	}
	// el siguiente m?todo llamado generarDireccion(), genera una direcci?n aleatoria para el cliente en la ciudad.
	public static  void generarDireccion() {
		
		int x= (int)Math.floor(Math.random()*50);
		int y=(int)Math.floor(Math.random()*50);
		Almacen.ciudad [x][y]= direccion;
	}
	
	/*el siguiente m?todo llamar(), representa el instante en el que el usuario comienza a interactuar con el almacen,
	 la idea es asignarle un Picker y un pedido para que comience a escoger los productos que desea*/
	public void llamar() {
		this.picker = Almacen.randomPicker();
		this.picker.cliente=this;
		Almacen.asignarPedido();	
	}
	
	
	public void finalizarCompra() {
		this.picker.setStatus();	
	}
	
	// el siguiente m?todo le permite al cliente saber el estado de su pedido
	public static void ConsultarEstadoPedido() {
		getPedido().consultaPedido();
	}
	// el siguiente m?todo retornar? a trav?s de un getter los nombres y apellidos del cliente
	public String getNombreCompleto() {
		return this.nombre + " " + this.apellidos;
	}
	
	// el siguiente m?todo retornar? a trav?s de un getter el n?mero de identificaci?n del cliente
	public int getID() {
		return this.ID;
	}
	
	// el siguiente m?todo retornar? a trav?s de un getter el Picker asociado al cliente
	public Picker getPicker() {
		return this.picker;
	}
	
	// el siguiente m?todo retornar? a trav?s de un getter el Conductor asosciado al cliente
	public  Conductor getConductor() {
		return this.conductor;
	}
	
	// Los siguientes m?todos son un setter y getter respectivamente para el atributo de Pedido
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

	public static  void setConductor(Conductor c) {
		conductor = c;
	}
	
	
	
	public static int getTotalPrecio() {
		return pedido.total;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	//este metodo agrega un recibo a una lista. Se entra como parametro el recibo.
	public void agregarRecibo(String recibo) {
		this.historicoRecibos.add(recibo);
	}

	// este metodo retorna la informacion de un empleado. Si se ingresa 1 como parametro se retorna la informacion del picker y si se ingresa 2 se retorna la informacion del conductor
	public String infoEmpleado(int opcion) {
		String h= "";
		Empleados empleado;
		switch (opcion) {
		case 1:
			empleado = this.picker;
			h =  empleado.getRol().toUpperCase() + "\n\nNombre del picker : " + empleado.getNombre() + " "+ empleado.getApellidos()+"\nIdentificacion picker :"+ empleado.getID();
			break;
			
		case 2:
			empleado = this.conductor;
			h = empleado.getRol().toUpperCase() + "\n\nNombre del conductor : " + empleado.getNombre() + " "+ empleado.getApellidos()+"\nIdentificacion conductor :"+ empleado.getID();
			break;
		}
		return h;
	}
	// este metodo retorna los recibos del cliente
	public String consultarMisReciblos() {
		String r = "";
		for(String recibo : historicoRecibos) {
			r += recibo + "\n";
		}
		return r;
	}
}