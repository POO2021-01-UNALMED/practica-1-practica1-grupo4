package uiMain;

import gestorAplicación.*;
import gestorAplicación.Almacen.Productos;
import gestorAplicación.Pedido.estadoPedido;

import java.util.*;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.*;

import baseDatos.*;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Scanner input = new Scanner(System.in);
		
	    Almacen a1 = new Almacen();
		Cliente c = new Cliente();

		if (Serializer.archivoEsVacio()) {
			
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
			
			if (!a1.RangoCliente()) {
				System.out.println("lastimosamente no podemos hacer el domicilio por falta de cobertura.");
				System.exit(0);
			}
			
			System.out.println("Tu informacion ha sido guardada!");
			
			Pedido p1 = new Pedido();
			Almacen.pedido = p1;
			c.llamar();

		} else {
			
			c = c.deserializarCliente();
			Pedido p1 = new Pedido();
			Almacen.pedido = p1;
			c.llamar();
			System.out.println("\n\nBIENVENIDO " + c.getNombreCompleto() + "\n");

		}

		String opcion;

		
		while (true) {
			System.out.println("Escoja una opcion: \n\n" + "A. Hacer domicilio\n"
					+ "B. Consultas\n" + "C. finalizar compra\n" + "D. salir ");
			opcion = input.next().toUpperCase();
			switch (opcion) {
			case "A":
				while (true) {
					System.out.println("Seleccionar Categoría\n");
					for (Productos pro : Almacen.productosl) {
						System.out.println(pro);
					}
					System.out.println("presione V para volver");
					String categoria = input.next().toUpperCase();
					switch (categoria) {
					case "LACTEOS":
						for (Producto l : Almacen.lacteos) {
							System.out.println("Presione " + (Almacen.lacteos.indexOf(l) + 1) + "   para seleccionar: "
									+ l.nombre + " $" + l.precio);
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
								System.out
										.println("escriba la cantidad de " + Almacen.lacteos.get(seleccion - 1).nombre);
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.lacteos.get(seleccion - 1), cantidad);

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
						for (Producto ca : a1.carnes) {
							System.out.println("Presione " + (a1.carnes.indexOf(ca) + 1) + "   para seleccionar: "
									+ ca.nombre + " $" + ca.precio);

						}
						ArrayList<String>lista = new ArrayList<>();
						for (Producto p : a1.carnes) {
							lista.add(p.image);
						}
						System.out.println(lista);
						System.out.println("Presione 0 para continuar");
						while (true) {

							int seleccion = input.nextInt();
							switch (seleccion) {
							case 1:
							case 2:
							case 3:
							case 4:
							case 5:
								System.out.println("escriba la cantidad de " + a1.carnes.get(seleccion - 1).nombre);
								int cantidad = input.nextInt();
								Pedido.agregarProducto(a1.carnes.get(seleccion - 1), cantidad);
								System.out.println("Por favor continue con la seleccion");
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
							System.out.println("Presione " + (Almacen.vegetales.indexOf(v) + 1)
									+ "   para seleccionar: " + v.nombre + " $" + v.precio);

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
								System.out.println("escriba la cantidad de " + Almacen.vegetales.get(seleccion - 1).nombre);
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.vegetales.get(seleccion - 1), cantidad);
								System.out.println("Por favor continue con la seleccion");
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
							System.out.println("Presione " + (Almacen.frutas.indexOf(f) + 1) + "   para seleccionar: "
									+ f.nombre + " $" + f.precio);

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
								System.out.println("escriba la cantidad de " + Almacen.frutas.get(seleccion - 1).nombre);
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.frutas.get(seleccion - 1), cantidad);
								System.out.println("Por favor continue con la seleccion");
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
							System.out.println("Presione " + (Almacen.granos.indexOf(g) + 1) + "   para seleccionar: "
									+ g.nombre + " $" + g.precio);

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
								System.out
										.println("escriba la cantidad de " + Almacen.granos.get(seleccion - 1).nombre);
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.granos.get(seleccion - 1), cantidad);
								System.out.println("Por favor continue con la seleccion");
								continue;
							default:
								break;
							}
							break;
						}
						continue;
					case "LIMPIEZA":
						System.out.println("seleccione productos y escriba la cantidad");
						for (Producto li : Almacen.limpieza) {
							System.out.println("Presione " + (Almacen.limpieza.indexOf(li) + 1) + "  para seleccionar: "
									+ li.nombre + " $" + li.precio);

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
							System.out.println("escriba la cantidad de " + Almacen.limpieza.get(seleccion - 1).nombre);
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.limpieza.get(seleccion - 1), cantidad);
								System.out.println("Por favor continue con la seleccion");
								continue;
							default:
								break;
							}
							break;
						}
						continue;
					case "BEBIDAS":
						System.out.println("seleccione productos y escriba la cantidad");
						for (Producto b : Almacen.bebidas) {
							System.out.println("Presione " + (Almacen.bebidas.indexOf(b) + 1) + "  para seleccionar: "
									+ b.nombre + " $" + b.precio);

						}
						System.out.println("Presione 0 para continuar");
						while (true) {

							int seleccion = input.nextInt();
							switch (seleccion) {
							case 1:
							case 2:
							case 3:
							case 4:
							System.out.println("escriba la cantidad de " + Almacen.bebidas.get(seleccion - 1).nombre);
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.bebidas.get(seleccion - 1), cantidad);
								System.out.println("Por favor continue con la seleccion");
								continue;
							default:
								break;
							}
							break;
						}
						continue;
					case "TODOMIL":
						System.out.println("seleccione productos y escriba la cantidad");
						for (Producto t : Almacen.todoMil) {
							System.out.println("Presione " + (Almacen.todoMil.indexOf(t) + 1) + "  para seleccionar: "
									+ t.nombre + " $" + t.precio);

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
							System.out.println("escriba la cantidad de " + Almacen.todoMil.get(seleccion - 1).nombre);
								int cantidad = input.nextInt();
								Pedido.agregarProducto(Almacen.todoMil.get(seleccion - 1), cantidad);
								System.out.println("Por favor continue con la seleccion");
								continue;
							default:
								break;
							}
							break;
						}
						continue;
					default:
						System.out.println("No he entendido eso, por favor escribir de manera correcta el nombre de la categoría\n");
						continue;
					case "V":
						break;
					}
					break;
					
				}

				continue;
			case "B":
				while (true) {
					System.out.println("¿qué tipo de consulta desea realizar?\n\nA. Consultar estado de mi domicilio\nB. Consultar informacion de mis asistentes"
							+ "\nC. Consultar mis recibos\nD. volver");
					String seleccion = input.next().toLowerCase();
					switch (seleccion) {
					case "a":
						Cliente.ConsultarEstadoPedido();
						continue;
					case "b":
						System.out.println("¿Sobre quién desea consultar?");
						while (true) {
							System.out.println("1) Informacion del Picker\n2) Informacion del Conductor\npresione 0 para regresar");
							int empleado = input.nextInt();
							if (empleado == 0) {
								break;
							}
							System.out.println(c.infoEmpleado(empleado));;
						}
						continue;
					case "c":
						System.out.println(c.consultarMisReciblos());
					case "d":
						break;
					}
					break;
				}
	
				continue;

			case "C":
				if (Cliente.getPedido().carrito.size() != 0) {
					System.out.println(Cliente.getPedido().mostrarFactura2());
					c.finalizarCompra();
					Cliente.getPedido().estado = estadoPedido.EN_PROCESO;
					
					Timer timer = new Timer();

					TimerTask task = new TimerTask() {
						public void run() {
							Cliente.getPedido().estado = estadoPedido.ENTREGADO;

						}
					};
					timer.schedule(task, 60000);

					TimerTask task2 = new TimerTask() {
						public void run() {
							Cliente.getPedido().estado = estadoPedido.FINALIZADO;
							Cliente.setConductor(Almacen.randomConductor());
						}
					};
					timer.schedule(task2, 15000);

					TimerTask task3 = new TimerTask() {
						public void run() {
							Cliente.getPedido().estado = estadoPedido.EN_RUTA;
						}
					};
					timer.schedule(task3, 24000);
				}
				else {
					System.out.println("Aun no ha hecho una compra");
				}
				

				continue;
			case "D":
				System.out.println("Gracias por su compra!");
				if (Cliente.getPedido().carrito.size() != 0) {
					c.agregarRecibo(Cliente.getPedido().mostrarFactura2());
				}
				c.serializarCliente();
				break;
				
			default:
				System.out.println("Por favor seleccione una de las opciones para continuar");
				continue;
			}
			break;
		}
		input.close();
		System.exit(0);
	}

}