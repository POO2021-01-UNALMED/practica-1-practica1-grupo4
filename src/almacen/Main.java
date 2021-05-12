package almacen;
import personas.*;
import java.util.Scanner;
import java.time.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Almacen a = new Almacen();
		Cliente c = new Cliente("Mateo", "Arias Arias", 1000871372, "Cra80-45sur");
		c.llamar();
		System.out.println(c.picker.getNombre());
		System.out.println(c.picker.llamada);
		
		System.out.println("Escoja una opcion: \n" +"1. Hacer domicilio\n"+"0. Salir");
		int opcion;
		opcion= input.nextInt();
		switch(opcion) {
		case 1:
			System.out.println("Escoger productos");
			System.out.println(java.util.Arrays.asList(Almacen.Productos.values()));
			break;
		case 0:
			System.out.println("Salir");
			break;
		}
		


	}

}
