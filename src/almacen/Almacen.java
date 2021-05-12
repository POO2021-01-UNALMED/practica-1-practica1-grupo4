package almacen;
import java.util.ArrayList;
import personas.*;

public class Almacen {
	
	public enum Productos{PAPA, TOMATE, CEBOLLA, PIMIENTOS}
	public static ArrayList<Picker>pickers = new ArrayList<>();
	public static ArrayList<Conductor>conductores = new ArrayList<>();
	public Productos productos;
	p
	
	public static int randomID() {
		 int min = 1000000000;
		 int max = 2000000000;
		 return (int)Math.floor(Math.random()*(max - min + 1) + min);
	}
	
	public Almacen() {
		Picker p1 = new Picker("Reinaldo", "Garcia", randomID(), 16, false);
		Picker p2 = new Picker("Sofia", "Arango", randomID(),20, false);
		Picker p3 = new Picker("Santiago", "Restrepo", randomID(),22, false);
		pickers.add(p1);
		pickers.add(p2);
		pickers.add(p3);
		
	}
	
	public static Picker randomPicker() {
		
		int index = (int)(Math.random()*pickers.size());
		do {
			index = (int)(Math.random()*pickers.size());
		}
		while(!pickers.get(index).disponibleParaAtender());
		pickers.get(index).llamada = true;
		
		return pickers.get(index);
		
	}
	
	
}
