package almacen;
import java.util.ArrayList;

public class Pedido {
	public static ArrayList<String>carrito = new ArrayList<>();
	
	public static void agregarProducto(String producto) {
		carrito.add(producto);
	}
}
