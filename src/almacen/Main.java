package almacen;

import persona.*;
import java.util.*;

import almacen.Almacen.Productos;

import java.io.IOException;
import java.io.Serializable;
import java.time.*;

import baseDatos.*;

public class Main {
	

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner input = new Scanner(System.in);
		Almacen a1 = new Almacen();
		Cliente c = new Cliente();
		
		
		if(Serializer.archivoEsVacio()) {
			System.out.println("BIENVENIDO(A)\n\n\nPor favor ingresar los siguientes datos: ");
			System.out.print("nombre: ");
			String nombre = input.next().toUpperCase();
			System.out.print("apellido: ");
			String apellido = input.next().toUpperCase();
			System.out.print("numero de identificacion: ");
			int identificacion = input.nextInt();
			System.out.print("direccion residencial: ");
			String direccion = input.next().toUpperCase();
			c = new Cliente(nombre, apellido, identificacion, direccion);
			c.serializarCliente();
			System.out.println("Tu informacion ha sido guardada!");
			Pedido p1 = new Pedido();
			Almacen.pedido = p1;
			c.llamar();
						
		}else {
			c = c.deserializarCliente();		
			Pedido p1 = new Pedido();
			Almacen.pedido = p1;
			c.llamar();
			System.out.println(c.getNombre());
			System.out.println(c.getApellidos());			
		}
		
		String opcion;

		while (true) {
			System.out.println("Escoja una opcion: \n" + "A. Hacer domicilio\n"
					+ "B. Consultar estado de mi domicilio\n" + "C. finalizar compra\n"
							+ "D. salir ");
			opcion = input.next().toUpperCase();
			switch (opcion) {
			case "A":
				while (true) {
					System.out.println("Seleccionar Categoría");
					for (Productos pro : Almacen.productosl) {
						System.out.println(pro);
					}
					System.out.println("presione V para volver");
					String categoria = input.next().toUpperCase();
					switch (categoria) {
					case "LACTEOS":
						for (Producto l : Almacen.lacteos) {
							System.out.println(
									"Presione " + (Almacen.lacteos.indexOf(l) + 1) + "   para seleccionar: " + l.nombre);
						}
						System.out.println("Presione 0 para continuar");
						while (true) {
							int seleccion = input.nextInt();						
							switch (seleccion) {
							case 1:
							case 2:
							case 3:
							case 4:
							case 5:
								System.out.println("escriba la cantidad de " + Almacen.lacteos.get(seleccion - 1).nombre);
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.lacteos.get(seleccion - 1),cantidad);
								System.out.println("Por favor continue con la seleccion");
								continue;
							default:
								break;
							}
							break;
						}
						continue;
					case "CARNES":
						System.out.println("seleccione productos y escriba la cantidad");
						for (Producto ca : Almacen.carnes) {
							System.out.println(
									"Presione " + (Almacen.carnes.indexOf(ca) + 1) + "   para seleccionar: " + ca.nombre);

						}
						System.out.println("Presione 0 para continuar");
						while (true) {

							int seleccion = input.nextInt();
							switch (seleccion) {
							case 1:
							case 2:
							case 3:
							case 4:
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.carnes.get(seleccion - 1),cantidad);
								continue;
							default:
								break;
							}
							break;
						}
						continue;
					case "VEGETALES":
						System.out.println("seleccione productos y escriba la cantidad");
						for (Producto v : Almacen.vegetales) {
							System.out.println(
									"Presione " + (Almacen.vegetales.indexOf(v) + 1) + "   para seleccionar: " + v.nombre);

						}
						System.out.println("Presione 0 para continuar");
						while (true) {

							int seleccion = input.nextInt();
							switch (seleccion) {
							case 1:
							case 2:
							case 3:
							case 4:
							case 5:
							case 6:
							case 7:
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.vegetales.get(seleccion - 1),cantidad);
								continue;
							default:
								break;
							}
							break;
						}
						continue;
					case "FRUTAS":
						System.out.println("seleccione productos y escriba la cantidad");
						for (Producto f : Almacen.frutas) {
							System.out.println(
									"Presione " + (Almacen.frutas.indexOf(f) + 1) + "   para seleccionar: " + f.nombre);

						}
						System.out.println("Presione 0 para continuar");
						while (true) {

							int seleccion = input.nextInt();
							switch (seleccion) {
							case 1:
							case 2:
							case 3:
							case 4:
							case 5:
							case 6:
							case 7:
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.frutas.get(seleccion - 1),cantidad);
								continue;
							default:
								break;
							}
							break;
						}
						continue;
					case "GRANOS":
						System.out.println("seleccione productos y escriba la cantidad");
						for (Producto g : Almacen.granos) {
							System.out.println(
									"Presione " + (Almacen.granos.indexOf(g) + 1) + "   para seleccionar: " + g.nombre);

						}
						System.out.println("Presione 0 para continuar");
						while (true) {

							int seleccion = input.nextInt();
							switch (seleccion) {
							case 1:
							case 2:
							case 3:
							case 4:
							case 5:
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.granos.get(seleccion - 1),cantidad);
								continue;
							default:
								break;
							}
							break;
						}
						continue;
					case "V":
						break;
					}
					break;
				}

				continue;
			case "B":
				Cliente.ConsultarEstadoPedido();
				continue;

			case "C":
				c.finalizarCompra();
				Cliente.getPedido().estado = Cliente.getPedido().estado.EN_PROCESO;
				// agregar timer para estado en proceso
				Timer timer = new Timer();
				
				TimerTask task = new TimerTask() {
					public void run() {
						Cliente.getPedido().estado = Cliente.getPedido().estado.ENTREGADO;
						Cliente.setConductor(Almacen.randomConductor());
						
					}
				};
				timer.schedule(task, 60000);
				
				TimerTask task2 = new TimerTask() {
					public void run() {
						Cliente.getPedido().estado = Cliente.getPedido().estado.FINALIZADO;
					}
				};
				timer.schedule(task2, 15000);
				
				TimerTask task3 = new TimerTask() {
					public void run() {
						Cliente.getPedido().estado = Cliente.getPedido().estado.EN_RUTA;
					}
				};
				timer.schedule(task3, 24000);
				
				// luego del timer se asigna un conductor aleatorio 
				continue;
			case "D":
				System.out.println("Salir");
				break;
				
			}
			break;
		}
		
		
		
		c.deserializarCliente();
		System.out.println(Cliente.getPedido().carrito);
		System.exit(0);
	}

}