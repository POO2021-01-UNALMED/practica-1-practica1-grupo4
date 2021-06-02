package almacen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.*;


import persona.Picker;
import persona.Conductor;
import persona.Cliente;

///ALMACEN\\\ establecimiento comercial en cuestión.


public class Almacen {
	
	public static String[][] ciudad = new String[50][50]; /* ciudad donde se encuentra el almacen consiste
	en una matriz de tamaño 50 x 50, donde cada entrada representa un bloque de una ciudad ficticia*/
	
	public String direccionAlmacen = "Almacen"; /*La dirección será representada por un String que eventualmente será puesto
	 en uno de los bloques de la matriz*/
	
	public enum Productos{lACTEOS, CARNES, VEGETALES, FRUTAS, GRANOS} // Tipos de productos ofrecidos por el almacén
	public static Pedido pedido; //Pedido perteneciente al cliente en cuestión.
	public static ArrayList<Producto> lacteos = new ArrayList<>();// lista de lacteos
	public static ArrayList<Producto> carnes = new ArrayList<>();// lista de carnes
	public static ArrayList<Producto> vegetales = new ArrayList<>();// lista de vegetales
	public static ArrayList<Producto> frutas = new ArrayList<>();// lista de frutas
	public static ArrayList<Producto> granos = new ArrayList<>();// lista de granos
	public static ArrayList<Picker>pickers = new ArrayList<>();// lista de los Pickers del almacén
	public static ArrayList<Conductor>conductores = new ArrayList<>();// lista de los conductores del almacén 
	public Productos productos;
	public static List<Productos> productosl = Arrays.asList(Productos.values()); // lista de los tipos de productos

	//el siguiente método genera un número de identificación aleatorio para el empleado
	public static int randomID() {
		 int min = 1000000000;
		 int max = 2000000000;
		 return (int)Math.floor(Math.random()*(max - min + 1) + min);
	}
	
	//CONSTRUCTOR de la clase 'Almacen'
	public Almacen() {
		
		this.ciudad[29][36] = this.direccionAlmacen;
		
		Picker p1 = new Picker("Reinaldo","Ramirez",randomID(),19,false,LocalTime.of(8,0,0),LocalTime.of(23,59,0));
		Picker p2 = new Picker("Sofia", "Arango", randomID(),20, true,LocalTime.of(9,0,0),LocalTime.of(23,0,0));
		Picker p3 = new Picker("Santiago", "Restrepo", randomID(),22, false,LocalTime.of(8,0,0),LocalTime.of(23,0,0));
		Picker p4 = new Picker("Valentina", "Velez", randomID(),22, false,LocalTime.of(18,0,0),LocalTime.of(23,0,0));
		Picker p5 = new Picker("Jorge", "Castaño", randomID(),22, true,LocalTime.of(8,0,0),LocalTime.of(23,0,0));
		
		Conductor c1 = new Conductor("Sebastian", "Ososrio", randomID(), 1, false, LocalTime.of(8, 0,0), LocalTime.of(23, 0, 0));
		Conductor c2 = new Conductor("Sonia", "Ardila", randomID(), 11, false, LocalTime.of(10, 0,0), LocalTime.of(23, 0, 0));
		Conductor c3 = new Conductor("Valentin", "Moscada", randomID(), 2, false, LocalTime.of(8, 0, 0), LocalTime.of(23, 0, 0));
		Conductor c4 = new Conductor("Juan Jose", "Betancur", randomID(), 4, false, LocalTime.of(2, 0,0), LocalTime.of(23, 0, 0));
		
		pickers.add(p1);
		pickers.add(p2);
		pickers.add(p3);
		pickers.add(p4);
		pickers.add(p5);
		conductores.add(c1);
		conductores.add(c2);
		conductores.add(c3);
		conductores.add(c4);
		
		lacteos.add( new Producto("leche", 1700, 51) );
		lacteos.add(new Producto("Queso", 1500, 34));
		lacteos.add(new Producto("Mantequilla", 2200, 22));
		lacteos.add(new Producto("Yogurt", 1850, 46));
		lacteos.add(new Producto("Helado", 2000, 38));
		carnes.add(new Producto("Res", 4500, 40));
		carnes.add(new Producto("Pescado", 3750, 67));
		carnes.add(new Producto("Pollo", 4100, 55));
		carnes.add(new Producto("Cerdo", 3950, 49));
		vegetales.add(new Producto("Zanahorias", 2000, 51));
		vegetales.add(new Producto("Repollo", 1500, 39));
		vegetales.add(new Producto("Cebolla", 2000, 42));
		vegetales.add(new Producto("Tomate", 1500, 41));
		vegetales.add(new Producto("Papa", 2300, 80));
		vegetales.add(new Producto("Brocoli", 1700, 33));
		vegetales.add(new Producto("Cilantro", 1050, 38));
		frutas.add(new Producto("Manzana", 1400, 62));
		frutas.add(new Producto("Uvas", 1800, 54));
		frutas.add(new Producto("Piña", 2400, 49));
		frutas.add(new Producto("Naranja", 1600, 67));
		frutas.add(new Producto("Pera", 1200, 51));
		frutas.add(new Producto("Coco", 2100, 40));
		frutas.add(new Producto("Banana", 1300, 79));
		granos.add(new Producto("Arroz", 1850, 81));
		granos.add(new Producto("Arveja", 1700, 50));
		granos.add(new Producto("Lentejas", 1250, 56));
		granos.add(new Producto("Garbanzos", 1700, 47));
		granos.add(new Producto("Maiz", 2300, 56));
		
	}
	
	//El siguiente método asigna un Picker disponible al cliente
	public static Picker randomPicker() {
		
		int index = (int)(Math.random()*pickers.size());
		do {
			index = (int)(Math.random()*pickers.size());
		}
		while(!pickers.get(index).disponibleParaAtender());
		pickers.get(index).accion = true;
		
		return pickers.get(index);
	}
	
	public static Conductor randomConductor() {
		
		int index = (int)(Math.random()*conductores.size());
		do {
			index = (int)(Math.random()*conductores.size());
		}
		while(!conductores.get(index).disponibleParaAtender());
		pickers.get(index).accion = true;
		
		return conductores.get(index);
		
	}
	
	//El siguiente método asigna el pedido al cliente
	public static void asignarPedido() {
		Cliente.setPedido(pedido);
		Cliente.getPedido().estado= Cliente.getPedido().estado.INICIADO;
	}
	
	//El siguiente método verifica si la dirección del cliente se encuentra en el rango de entrega del Almacen
	public Boolean RangoCliente() {
		Boolean domicilio = false;
		for(int i = 4; 4 <= i && i < 44; i++) {
			for(int j = 3; 3 <= j && j < 50; j++ ) {
				if (ciudad[i][j] == Cliente.direccion) {
					domicilio = true;
					break;
				}
				else {
					continue;
				}
			}
		}
		return domicilio;
	}
	
}