package gestorAplicación;

import javafx.scene.image.Image;

public class Producto {
	// Son los elementos que están en el supermercado
	public String nombre;
	public int precio;
	public int cantidad;
	public String image;
	
	public Producto(String nombre, int cantidad) {
		this(nombre, 1000, cantidad);
	}
	public Producto(String nombre, int precio, int cantidad, String image) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.image = image;
	}
	public Producto(String nombre, int precio, int cantidad) {
		this(nombre,precio,cantidad,null);
	}

}
