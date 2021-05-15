package almacen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.*;

import almacen.Almacen.Productos;
import persona.*;



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
	public Productos productos;
	public static List<Productos> productosl = Arrays.asList(Productos.values());

	
	public static int randomID() {
		 int min = 1000000000;
		 int max = 2000000000;
		 return (int)Math.floor(Math.random()*(max - min + 1) + min);
	}
	
	public Almacen() {
		Picker p1 = new Picker("Reinaldo", "Garcia", randomID(), 16, false,LocalTime.of(8,0,0),LocalTime.of(23,0,0));
		Picker p2 = new Picker("Sofia", "Arango", randomID(),20, true,LocalTime.of(9,0,0),LocalTime.of(23,0,0));
		Picker p3 = new Picker("Santiago", "Restrepo", randomID(),22, false,LocalTime.of(12,0,0),LocalTime.of(23,0,0));
		Picker p4 = new Picker("Valentina", "Velez", randomID(),22, false,LocalTime.of(13,0,0),LocalTime.of(23,0,0));
		Picker p5 = new Picker("Jorge", "Castaño", randomID(),22, true,LocalTime.of(13,0,0),LocalTime.of(23,0,0));
		pickers.add(p1);
		pickers.add(p2);
		pickers.add(p3);
		pickers.add(p4);
		pickers.add(p5);
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
		frutas.add("Piña");
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
	
	public static Picker randomPicker() {
		
		int index = (int)(Math.random()*pickers.size());
		do {
			index = (int)(Math.random()*pickers.size());
		}
		while(!pickers.get(index).disponibleParaAtender());
		pickers.get(index).accion = true;
		
		return pickers.get(index);
		
	}
	
	public static void asignarPedido() {
		Cliente.setPedido(pedido);
	}
}
