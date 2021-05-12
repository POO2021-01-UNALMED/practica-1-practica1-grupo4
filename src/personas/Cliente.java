package personas;
import almacen.*;
public class Cliente extends Persona{
	
	private String direccion;
	public Picker picker;
	private Conductor conductor;
	private static Pedido pedido;
	
	public Cliente(String nombre, String apellidos, int ID, String direccion) {
		super(nombre, apellidos, ID);
		this.direccion = direccion;
	}
	
	public void llamar() {
		this.picker = Almacen.randomPicker();
		Almacen.asignarPedido();
		
	}
	public static void setPedido(Pedido p) {
		pedido = p;
	}
	public static Pedido getPedido() {
		return pedido;
	}
}
