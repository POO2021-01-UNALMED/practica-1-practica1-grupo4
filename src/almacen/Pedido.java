package almacen;
import java.util.ArrayList;

///PEDIDO\\\ Se trata de las compras que realiza el cliente en el Almacen

public class Pedido {


	public enum estadoPedido{INICIADO,EN_PROCESO,FINALIZADO,EN_RUTA,ENTREGADO}; 
	public estadoPedido estado; //describe el estado del Pedido de la siguiente forma:

/* INICIADO: El pedido entra en este estado tan pronto como el cliente empiece a escoger sus prodcuctos.
<<<<<<< HEAD
EN_PROCESO: El pedido entra en este estado cuando el cliente termina de escoger sus productos y mientras el Picker esté en su labor
=======
EN_PROCESO: El pedido entra en este estado cuando el cliente termina de escoger sus productos y mientras el Picker estÃ© en su labor
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
de escoger los productos seleccionados por el cliente.
FINALIZADO: El pedido entra en este estado cuando el Picker termina de empacar los productos, y sale de este estado tan pronto como
el producto se le es entregado al conductor.
EN_RUTA: El pedido entra en este estado tan pronto como el Conductor empieza su viaje hacia la residencia del Cliente.
ENTREGADO: El pedido entra en este estado cuando finalmente llega a la casa del Cliente. 
*/
	public static ArrayList<String>carrito = new ArrayList<>(); //carrito que acomula los productos seleccionados por el cliente
	
<<<<<<< HEAD
	// El siguiente método agrega un nuevo producto al carrito
=======
	// El siguiente mÃ©todo agrega un nuevo producto al carrito
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
	public static void agregarProducto(Producto producto, int numeroVeces ) {
		carrito.add(producto.nombre +" "+numeroVeces);
		producto.cantidad-=numeroVeces;
	}
	
	
	public void consultaPedido() {
		switch(estado) {
		case INICIADO:
			System.out.println("Su pedido se encuentra iniciado");
			break;
		case EN_PROCESO:
			System.out.println("El Picker se encuentra pidiendo sus productos");
			break;
		case FINALIZADO:
			System.out.println("Su pedido se le fue entregado al conductor");
			break;
		case EN_RUTA:
			System.out.println("Su pedido se encuentra en ruta");
			break;
		case ENTREGADO:
			System.out.println("Su pedido ya se le fue entregado");
			break;
		default:
			System.out.println("Su pedido no ha sido iniciado");
			break;
		}
	}
	
}