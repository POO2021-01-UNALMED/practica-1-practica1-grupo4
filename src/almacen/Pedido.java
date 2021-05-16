package almacen;
import java.util.ArrayList;
<<<<<<< HEAD

///PEDIDO\\\ Se trata de las compras que realiza el cliente en el Almacen

public class Pedido {


	public enum estadoPedido{INICIADO,EN_PROCESO,FINALIZADO,EN_RUTA,ENTREGADO}; 
	public estadoPedido estado; //describe el estado del Pedido de la siguiente forma:

/* INICIADO: El pedido entra en este estado tan pronto como el cliente empiece a escoger sus prodcuctos.

EN_PROCESO: El pedido entra en este estado cuando el cliente termina de escoger sus productos y mientras el Picker esté en su labor
de escoger los productos seleccionados por el cliente.

FINALIZADO: El pedido entra en este estado cuando el Picker termina de empacar los productos, y sale de este estado tan pronto como
el producto se le es entregado al conductor.

EN_RUTA: El pedido entra en este estado tan pronto como el Conductor empieza su viaje hacia la residencia del Cliente.

ENTREGADO: El pedido entra en este estado cuando finalmente llega a la casa del Cliente. 
*/
	public static ArrayList<String>carrito = new ArrayList<>(); //carrito que acomula los productos seleccionados por el cliente
=======
public class Pedido {
public enum estadoPedido{INICIADO,EN_PROCESO,FINALIZADO,EN_RUTA,ENTREGADO};
public estadoPedido estado;
public static ArrayList<String>carrito = new ArrayList<>();
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
	
	// El siguiente método agrega un nuevo producto al carrito
	public static void agregarProducto(String producto) {
		carrito.add(producto);
	}
	
	
	public void consultaPedido() {
		switch(estado) {
		case INICIADO:
			System.out.println("Su pedido se encuentra iniciado");
		case EN_PROCESO:
			System.out.println("El Picker se encuentra pidiendo sus productos");
		case FINALIZADO:
			System.out.println("Su pedido se le fue entregado al conductor");
		case EN_RUTA:
			System.out.println("Su pedido se encuentra en ruta");
		case ENTREGADO:
			System.out.println("Su pedido ya se le fue entregado");
		default:
			System.out.println("Su pedido no ha sido iniciado");
		}
	}
	
}