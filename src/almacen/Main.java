package almacen;
import personas.*;
import java.util.*;

import almacen.Almacen.Productos;

import java.time.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Almacen a = new Almacen();
		Cliente c = new Cliente("Mateo", "Arias Arias", 1000871372, "Cra80-45sur");
		c.llamar();
		System.out.println(c.picker.getNombre());
		System.out.println(c.picker.llamada);
		
		System.out.println("Escoja una opcion: \n" +"A. Hacer domicilio\n"+"B. Salir");
		String opcion;
		opcion= input.next().toUpperCase();
		while(true) {
			switch(opcion) {
			case "A":
				while(true) {
					System.out.println("Seleccionar Categoría");
					for (Productos pro : Almacen.productosl) {
						System.out.println(pro);
					}
					String categoria = input.next().toUpperCase();
					switch(categoria) {
					case "LACTEOS":
						for (String l : Almacen.lacteos) {
							System.out.println("Presione " + Almacen.lacteos.indexOf(l)+ "   para seleccionar: " + l);
						}
						break;
					case "CARNES":
						for (String ca : Almacen.carnes) {
							System.out.println("Presione " + Almacen.carnes.indexOf(ca)+ "   para seleccionar: " + ca);
						}
						break;
					case "VEGETALES":
						for (String v : Almacen.vegetales) {
							System.out.println("Presione " + Almacen.vegetales.indexOf(v)+ "   para seleccionar: " + v);
						}
						break;
					case "FRUTAS":
						for (String f : Almacen.frutas) {
							System.out.println("Presione " + Almacen.frutas.indexOf(f)+ "   para seleccionar: " + f);
						}
						break;
					case "GRANOS":
						for (String g : Almacen.granos) {
							System.out.println("Presione " + Almacen.granos.indexOf(g)+ "   para seleccionar: " + g);
						}
						break;
					}
					break;
				}
					break;
				
			case "B":
				System.out.println("Salir");
				break;
			}
			break;
		}
		
	}

}
