package almacen;
import java.util.ArrayList;
public class Pedido {
public enum estadoPedido{INICIADO,EN_PROCESO,FINALIZADO,EN_RUTA,ENTREGADO};
public estadoPedido estado;
public static ArrayList<String>carrito = new ArrayList<>();
	
	public static void agregarProducto(String producto) {
		carrito.add(producto);
	}
}
