package almacen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.*;


import persona.Picker;
import persona.Conductor;
import persona.Cliente;

<<<<<<< HEAD
///ALMACEN\\\ establecimiento comercial en cuestión.


public class Almacen {
	
	public String[][] ciudad = new String[50][50]; /* ciudad donde se encuentra el almacen consiste
	en una matriz de tamaño 50 x 50, donde cada entrada representa un bloque de una ciudad ficticia*/
	
	public String direccionAlmacen = "Almacen"; /*La dirección será representada por un String que eventualmente será puesto
	 en uno de los bloques de la matriz*/
	
	public enum Productos{lACTEOS, CARNES, VEGETALES, FRUTAS, GRANOS} // Tipos de productos ofrecidos por el almacén
	public static Pedido pedido; //Pedido perteneciente al cliente en cuestión.
	public static ArrayList<String> lacteos = new ArrayList<>();// lista de lacteos
	public static ArrayList<String> carnes = new ArrayList<>();// lista de carnes
	public static ArrayList<String> vegetales = new ArrayList<>();// lista de vegetales
	public static ArrayList<String> frutas = new ArrayList<>();// lista de frutas
	public static ArrayList<String> granos = new ArrayList<>();// lista de granos
	public static ArrayList<Picker>pickers = new ArrayList<>();// lista de los Pickers del almacén
	public static ArrayList<Conductor>conductores = new ArrayList<>();// lista de los conductores del almacén 
=======


public class Almacen {

	public enum Productos{lACTEOS, CARNES, VEGETALES, FRUTAS, GRANOS}
	public static Pedido pedido;
	public static ArrayList<String> lacteos = new ArrayList<>();
	public static ArrayList<String> carnes = new ArrayList<>();
	public static ArrayList<String> vegetales = new ArrayList<>();
	public static ArrayList<String> frutas = new ArrayList<>();
	public static ArrayList<String> granos = new ArrayList<>();
	public static ArrayList<Picker>pickers = new ArrayList<>();
	public static ArrayList<Conductor>conductores = new ArrayList<>();
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
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
<<<<<<< HEAD
		
		this.ciudad[29][36] = this.direccionAlmacen;
		
=======
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
		Picker p1 = new Picker("Reinaldo","Ramirez",randomID(),19,false,LocalTime.of(8,0,0),LocalTime.of(23,59,0));
		Picker p2 = new Picker("Sofia", "Arango", randomID(),20, true,LocalTime.of(9,0,0),LocalTime.of(23,0,0));
		Picker p3 = new Picker("Santiago", "Restrepo", randomID(),22, false,LocalTime.of(8,0,0),LocalTime.of(23,0,0));
		Picker p4 = new Picker("Valentina", "Velez", randomID(),22, false,LocalTime.of(18,0,0),LocalTime.of(23,0,0));
<<<<<<< HEAD
		Picker p5 = new Picker("Jorge", "Castaño", randomID(),22, true,LocalTime.of(8,0,0),LocalTime.of(23,0,0));
		
		Conductor c1 = new Conductor("Sebastian", "Ososrio", randomID(), 1, false, LocalTime.of(8, 0,0), LocalTime.of(11, 0, 0));
		Conductor c2 = new Conductor("Sonia", "Ardila", randomID(), 11, false, LocalTime.of(10, 0,0), LocalTime.of(14, 0, 0));
		Conductor c3 = new Conductor("Valentin", "Moscada", randomID(), 2, false, LocalTime.of(8, 0, 0), LocalTime.of(16, 0, 0));
		Conductor c4 = new Conductor("Juan Jose", "Betancur", randomID(), 4, false, LocalTime.of(2, 0,0), LocalTime.of(17, 0, 0));
		
=======
		Picker p5 = new Picker("Jorge", "CastaÃ±o", randomID(),22, true,LocalTime.of(8,0,0),LocalTime.of(23,0,0));
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
		pickers.add(p1);
		pickers.add(p2);
		pickers.add(p3);
		pickers.add(p4);
		pickers.add(p5);
<<<<<<< HEAD
		conductores.add(c1);
		conductores.add(c2);
		conductores.add(c3);
		conductores.add(c4);
		
=======
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
		lacteos.add("Leche");
		lacteos.add("Queso");
		lacteos.add("Mantequilla");
		lacteos.add("Yogurt");
		lacteos.add("Helado");
		carnes.add("Res");
		carnes.add("Pescado");
		carnes.add("Pollo");
		carnes.add("Cerdo");
		vegetales.add("Zanahorias");
		vegetales.add("Repollo");
		vegetales.add("Cebolla");
		vegetales.add("Tomate");
		vegetales.add("Papa");
		vegetales.add("Brocoli");
		vegetales.add("Cilantro");
		frutas.add("Manzana");
		frutas.add("Uvas");
		frutas.add("PiÃ±a");
		frutas.add("Naranja");
		frutas.add("Pera");
		frutas.add("Coco");
		frutas.add("Banana");
		granos.add("Arroz");
		granos.add("Arveja");
		granos.add("Lentejas");
		granos.add("Garbanzos");
		granos.add("Maiz");
		
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
<<<<<<< HEAD
	}
	
	//El siguiente método verifica si la dirección del cliente se encuentra en el rango de entrega del Almacen
	public Boolean RangoCliente() {
		Boolean domicilio = false;
		for(int i = 0; 14 <= i && i <= 40; i++) {
			for(int j = 0; j >= 10; j++ ) {
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
=======
	}
}
>>>>>>> edb663e196d2f0bd5e4b7fff9b843b536b3a42e8
