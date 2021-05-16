package almacen;
import persona.*;
import java.util.*;

import almacen.Almacen.Productos;

import java.time.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Almacen a1 = new Almacen();
		Cliente c = new Cliente("Mateo", "Arias Arias", 1000871372);
		Pedido p1 = new Pedido();
		Almacen.pedido = p1;
		c.llamar();
		System.out.println(c.getPicker().getNombre());
		System.out.println(c.getPicker().accion);
		
		System.out.println("Escoja una opcion: \n" +"A. Hacer domicilio\n"+"B. Consultar estado de mi domicilio\n" + "C. salir");
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
							while(true) {
								for (String l : Almacen.lacteos) {
									System.out.println("Presione " + (Almacen.lacteos.indexOf(l) + 1 )+ "   para seleccionar: " + l);
									
								}
								System.out.println("Presione 0 para continuar");
								int seleccion = input.nextInt();
								switch(seleccion) {
								case 1:
								case 2:
								case 3:
								case 4:
								case 5:
								Pedido.agregarProducto(Almacen.lacteos.get(seleccion - 1));
								continue;
								default:
									break;
								}
								break;
							}
							continue;
						case "CARNES":
							while(true) {
								for (String ca : Almacen.carnes) {
									System.out.println("Presione " + (Almacen.carnes.indexOf(ca) + 1 )+ "   para seleccionar: " + ca);
									
								}
								System.out.println("Presione 0 para continuar");
								int seleccion = input.nextInt();
								switch(seleccion) {
								case 1:
								case 2:
								case 3:
								case 4:
								Pedido.agregarProducto(Almacen.carnes.get(seleccion - 1));
								continue;
								default:
									break;
								}
								break;
							}
							continue;
						case "VEGETALES":
							while(true) {
								for (String v : Almacen.vegetales) {
									System.out.println("Presione " + (Almacen.vegetales.indexOf(v) + 1 )+ "   para seleccionar: " + v);
									
								}
								System.out.println("Presione 0 para continuar");
								int seleccion = input.nextInt();
								switch(seleccion) {
								case 1:
								case 2:
								case 3:
								case 4:
								case 5:
								case 6:
								case 7:
								Pedido.agregarProducto(Almacen.vegetales.get(seleccion - 1));
								continue;
								default:
									break;
								}
								break;
							}
							continue;
						case "FRUTAS":
							while(true) {
								for (String f : Almacen.frutas) {
									System.out.println("Presione " + (Almacen.frutas.indexOf(f) + 1 )+ "   para seleccionar: " + f);
									
								}
								System.out.println("Presione 0 para continuar");
								int seleccion = input.nextInt();
								switch(seleccion) {
								case 1:
								case 2:
								case 3:
								case 4:
								case 5:
								case 6:
								case 7:
								Pedido.agregarProducto(Almacen.frutas.get(seleccion - 1));
								continue;
								default:
									break;
								}
								break;
							}
							continue;
						case "GRANOS":
							while(true) {
								for (String g : Almacen.granos) {
									System.out.println("Presione " + (Almacen.granos.indexOf(g) + 1 )+ "   para seleccionar: " + g);
									
								}
								System.out.println("Presione 0 para continuar");
								int seleccion = input.nextInt();
								switch(seleccion) {
								case 1:
								case 2:
								case 3:
								case 4:
								case 5:
								Pedido.agregarProducto(Almacen.granos.get(seleccion - 1));
								continue;
								default:
									break;
								}
								break;
							}
							continue;
					}
					break;
					}

					break;
			case "B":
				Cliente.ConsultarEstadoPedido();
				break;
				
			case "C":
				System.out.println("Salir");
				Cliente.getPedido().estado= Cliente.getPedido().estado.EN_PROCESO;
				break;
			}
			break;
		}
		
		System.out.println(Cliente.getPedido().carrito);
		
	}

}