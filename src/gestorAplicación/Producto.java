package gestorAplicación;

public class Producto {

	public String nombre;
	public int precio;
	public int cantidad;
	
	public Producto(String nombre, int cantidad) {
		this(nombre, 1000, cantidad);
	}
	public Producto(String nombre, int precio, int cantidad) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}	
}
