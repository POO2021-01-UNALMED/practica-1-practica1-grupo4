package persona;
import almacen.*;
import java.util.*;

public class Cliente{
	
	public String nombre;
	public String apellidos;
	public int ID;
	public Picker picker;
	private Conductor conductor;
	private static Pedido pedido;
	
	public Cliente(String nombre, String apellidos, int ID) {
		this.nombre= nombre;
		this.apellidos=apellidos;
		this.ID=ID;
		
	}
	public static int generarDireccion() {
		 int min = 1000000000;
		 int max = 2000000000;
		 return (int)Math.floor(Math.random()*(max - min + 1) + min);
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
