package uiMain;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uiMain.PrimaryStage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import baseDatos.Serializer;
import errors.CarritoVacio;
import errors.ErrorConductor;
import gestorAplicación.*;
//import gestorAplicación.Almacen;
import gestorAplicación.Pedido.estadoPedido;

//import gestorAplicación.Producto;

public class User {
	private Scene sceneU;
	GridPane hacerDomicilio;
	Menu archivo;
	Menu procesos;
	Menu ayuda;
	MenuBar menuBar;
	menuHandler handlerU;
	MenuItem aplicacion;
	MenuItem salir;
	MenuItem hacerDomi;
	MenuItem estadoDomi;
	MenuItem consultaEmpleados;
	MenuItem consultaRecibos;
	VBox root;
	ComboBox<String> cbxTiposProducto;
	static TextField txtProducto1;
	static TextField txtProducto2;
	static TextField txtProducto3;
	static TextField txtProducto4;
	ImageView imvProducto1;
	ImageView imvProducto2;
	ImageView imvProducto3;
	ImageView imvProducto4;
	Button btnHacerDomicilio;
	static Almacen almacen = new Almacen();
	VBox root3;
	Label label1;
	Label label2;
	static String cadenaCategoria = "";
	static Cliente c;
	
	void CheckConductor() throws ErrorConductor {
		if (c.getConductor() == null) {
			throw new ErrorConductor();
		}
	}

	public User() {

		String[] criteria = { "Nombre", "Apellido", "Número de Identificación", "Dirección residencial" };
		String[] valores = { null, null, null, null };

		// Cliente c = new Cliente();
		root = new VBox();
		VBox root2 = new VBox();
		root3 = new VBox();
		root3.setPadding(new Insets(5));

		FieldPanel root4;

		try {
			if (Serializer.archivoEsVacio()) {
				label1 = new Label("REGISTRO");
				label1.setPrefHeight(25);
				label1.setPrefWidth(Double.MAX_VALUE);
				label1.setAlignment(Pos.CENTER);

				label2 = new Label("Porfavor ingresar los siguientes datos:");
				label2.setPrefHeight(77);
				label2.setPrefWidth(Double.MAX_VALUE);
				label2.setAlignment(Pos.CENTER);

				root4 = new FieldPanel("CRITERIO", criteria, "Valor", valores, null);
				root3.getChildren().addAll(label1, label2, root4);
			} else {
				label1 = new Label("Nombre de la funcionalidad");
				label1.setPrefHeight(25);
				label1.setPrefWidth(Double.MAX_VALUE);
				label1.setAlignment(Pos.CENTER);
				root3.getChildren().addAll(label1);

				try {
					c = new Cliente();
					c = c.deserializarCliente();
					Pedido p1 = new Pedido();
					Almacen.pedido = p1;
					c.llamar();
					label1.setText("Bienvenido " + c.getNombreCompleto());
				} catch (Exception e) {

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		handlerU = new menuHandler();
		menuBar = new MenuBar();
		archivo = new Menu("Archivo");
		aplicacion = new MenuItem("Aplicación");
		aplicacion.setOnAction(handlerU);
		salir = new MenuItem("Salir");
		salir.setOnAction(handlerU);
		archivo.getItems().addAll(aplicacion, salir);

		procesos = new Menu("Procesos y Consultas");
		hacerDomi = new MenuItem("Hacer Domicilio");
		hacerDomi.setOnAction(handlerU);
		estadoDomi = new MenuItem("Estado Domicilio");
		estadoDomi.setOnAction(handlerU);
		consultaEmpleados = new MenuItem("Consulta Empleados");
		consultaEmpleados.setOnAction(handlerU);
		consultaRecibos = new MenuItem("Consulta Recibos");
		consultaRecibos.setOnAction(handlerU);
		procesos.getItems().addAll(hacerDomi, estadoDomi, consultaEmpleados, consultaRecibos);
		ayuda = new Menu("Ayuda");

		menuBar.getMenus().addAll(archivo, procesos, ayuda);
		root2.getChildren().addAll(menuBar, root3);

		root2.setPadding(new Insets(10));
		root.getChildren().addAll(new Label("Nombre de la Aplicación"), root2);
		sceneU = new Scene(root, 530, 520);

	}

	public Scene getScene() {
		return this.sceneU;
	}

	class menuHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			Object control = e.getSource();
			if (control instanceof MenuItem) {
				if (control.equals(salir)) {
					// InicioFX.stage.setScene(InicioFX.scene);
					PrimaryStage.stage.setScene(PrimaryStage.scene);
					
				} else if (control.equals(aplicacion)) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Descripcion Aplicación");
					alert.setContentText("El programa permite hacer difrentes consultas en un supermercado");
					alert.showAndWait();
				} else if (control.equals(hacerDomi)) {

					root.getChildren().clear();
					VBox intento = new VBox();
					hacerDomicilio = new GridPane();
					hacerDomicilio.setVgap(5);
					hacerDomicilio.setHgap(5);
					Label tipoProducto = new Label("Escoja el tipo de producto");
					String[] tiposProducto = { "LACTEOS", "CARNES", "VEGETALES", "FRUTAS" };
					cbxTiposProducto = new ComboBox<>(FXCollections.observableArrayList(tiposProducto));
					Label txtProducto = new Label("Producto");
					Label txtCantidad = new Label("Cantidad");
					Label precio = new Label("Precio");

					GridPane.setConstraints(tipoProducto, 0, 0);
					GridPane.setConstraints(cbxTiposProducto, 1, 0);
					GridPane.setConstraints(txtProducto, 0, 1);
					GridPane.setConstraints(txtCantidad, 1, 1);
					GridPane.setConstraints(precio, 2, 1);

					
					Button finalizar = new Button("Finalizar Domicilio");
					finalizar.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							try {
								if (Cliente.getPedido().carrito.size() == 0) {
									throw new CarritoVacio();
								}
							} catch (CarritoVacio cart) {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Carrito Vacío");
								alert.setContentText(cart.getMessage());
								alert.showAndWait();
								return;
							}

							c.agregarRecibo(c.getPedido().mostrarFactura2());
							c.finalizarCompra();
							c.getPedido().carrito.clear();
							
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

					});

					VBox realizandoPedido = new VBox();

					GridPane.setConstraints(tipoProducto, 0, 0);
					GridPane.setConstraints(cbxTiposProducto, 1, 0);
					GridPane.setConstraints(finalizar, 1, 1,4,1);
					GridPane.setConstraints(txtProducto, 0, 2);
					GridPane.setConstraints(txtCantidad, 1, 2);
					GridPane.setConstraints(precio, 2, 2);
					hacerDomicilio.getChildren().addAll(tipoProducto, cbxTiposProducto, finalizar);
					
					GridPane imagenesSuper = new GridPane();
					imagenesSuper.setVgap(5);
					imagenesSuper.setHgap(5);
					imagenesSuper.setPadding(new Insets(40));
					ImageView imvSuper1 = new ImageView(new Image("./imagenes/carnes.jpg"));
					imvSuper1.setFitHeight(150);
					imvSuper1.setFitWidth(100);
					ImageView imvSuper2 = new ImageView(new Image("./imagenes/verduras.jpg"));
					imvSuper2.setFitHeight(150);
					imvSuper2.setFitWidth(100);
					ImageView imvSuper3 = new ImageView(new Image("./imagenes/lacteos.jpg"));
					imvSuper3.setFitHeight(150);
					imvSuper3.setFitWidth(100);
					ImageView imvSuper4 = new ImageView(new Image("./imagenes/frutas.jpeg"));
					imvSuper4.setFitHeight(150);
					imvSuper4.setFitWidth(100);
					imagenesSuper.setConstraints(imvSuper1, 0, 0);
					imagenesSuper.setConstraints(imvSuper2, 1, 0);
					imagenesSuper.setConstraints(imvSuper3, 0, 1);
					imagenesSuper.setConstraints(imvSuper4, 1, 1);
					imagenesSuper.getChildren().addAll(imvSuper1,imvSuper2,imvSuper3,imvSuper4);
					imagenesSuper.setAlignment(Pos.CENTER);
					realizandoPedido.setAlignment(Pos.CENTER);
					realizandoPedido.getChildren().addAll(imagenesSuper);
					
					intento.getChildren().addAll(hacerDomicilio, realizandoPedido);

					cbxTiposProducto.valueProperty().addListener(new ChangeListener<String>() {

						@Override
						public void changed(ObservableValue arg0, String arg1, String arg2) {

							if (arg2.equals("LACTEOS")) {
								cadenaCategoria = "LACTEOS";
								intento.getChildren().remove(1);
								ArrayList<Image> lista = new ArrayList<>();
								ArrayList<Integer> precios = new ArrayList<>();
								for (Producto pi : almacen.lacteos) {
									lista.add(new Image(pi.image));
									precios.add(pi.precio);
								}
								String[] valores = { null, null, null, null };
								FieldPanel rootLacteos = new FieldPanel("Producto", lista, precios, "cantidad", valores,
										"precio");

								intento.getChildren().add(rootLacteos);

							} else if (arg2.equals("CARNES")) {
								cadenaCategoria = "CARNES";
								intento.getChildren().remove(1);
								ArrayList<Image> lista = new ArrayList<>();
								ArrayList<Integer> precios = new ArrayList<>();
								for (Producto pi : almacen.carnes) {
									lista.add(new Image(pi.image));
									precios.add(pi.precio);
								}
								String[] valores = { null, null, null, null };
								FieldPanel rootCarnes = new FieldPanel("Producto", lista, precios, "cantidad", valores,
										"precio");

								intento.getChildren().add(rootCarnes);

							} else if (arg2.equals("VEGETALES")) {
								cadenaCategoria = "VEGETALES";
								intento.getChildren().remove(1);
								ArrayList<Image> lista = new ArrayList<>();
								ArrayList<Integer> precios = new ArrayList<>();
								for (Producto pi : almacen.vegetales) {
									lista.add(new Image(pi.image));
									precios.add(pi.precio);
								}
								String[] valores = { null,null, null, null };
								FieldPanel rootVegetales = new FieldPanel("Producto", lista, precios, "cantidad",
										valores, "precio");

								intento.getChildren().add(rootVegetales);

							} else if (arg2.equals("FRUTAS")) {
								cadenaCategoria = "FRUTAS";
								intento.getChildren().remove(1);
								ArrayList<Image> lista = new ArrayList<>();
								ArrayList<Integer> precios = new ArrayList<>();
								for (Producto pi : almacen.frutas) {
									lista.add(new Image(pi.image));
									precios.add(pi.precio);
								}
								String[] valores = { null, null, null, null };
								FieldPanel rootFrutas = new FieldPanel("Producto", lista, precios, "cantidad", valores,
										"precio");

								intento.getChildren().add(rootFrutas);

							}

						}

					});

					root.getChildren().addAll(menuBar, intento);

				} else if (control.equals(estadoDomi)) {
					root.getChildren().clear();
					root.getChildren().add(menuBar);
					VBox consultaPedido = new VBox();
					consultaPedido.setAlignment(Pos.CENTER);
					consultaPedido.getChildren().addAll(new Label("Aquí hará su consulta"));
					consultaPedido.setPadding(new Insets(20));
					Label message;

					ImageView status;
					switch (Cliente.getPedido().estado) {
					case INICIADO:
						message = new Label("Su pedido se encuentra iniciado");
						message.setPadding(new Insets(10));
						consultaPedido.getChildren().clear();
						status = new ImageView(new Image("./imagenes/Iniciado.jpg"));
						status.setFitHeight(300);
						status.setFitWidth(300);
						consultaPedido.getChildren().addAll(message, status);
						break;
					case EN_PROCESO:

						message = new Label("El Picker se encuentra escogiendo sus productos");
						message.setPadding(new Insets(10));
						consultaPedido.getChildren().clear();
						status = new ImageView(new Image("./imagenes/EnProceso.jpg"));
						status.setFitHeight(300);
						status.setFitWidth(300);
						consultaPedido.getChildren().addAll(message, status);
						break;
					case FINALIZADO:
						message = new Label("Su pedido se le fue entregado al conductor");
						message.setPadding(new Insets(10));
						consultaPedido.getChildren().clear();
						status = new ImageView(new Image("./imagenes/Finalizado.jpg"));
						status.setFitHeight(300);
						status.setFitWidth(300);
						consultaPedido.getChildren().addAll(message, status);

						break;
					case EN_RUTA:

						message = new Label("Su pedido se encuentra en ruta");
						message.setPadding(new Insets(10));
						consultaPedido.getChildren().clear();
						status = new ImageView(new Image("./imagenes/En_Ruta.jpg"));
						status.setFitHeight(300);
						status.setFitWidth(300);
						consultaPedido.getChildren().addAll(message, status);

						break;
					case ENTREGADO:

						message = new Label("Su pedido ya se le fue entregado");
						message.setPadding(new Insets(10));
						consultaPedido.getChildren().clear();
						status = new ImageView(new Image("./imagenes/Entregado.jpg"));
						status.setFitHeight(300);
						status.setFitWidth(300);
						consultaPedido.getChildren().addAll(message, status);
						break;
					default:

						message = new Label("Su pedido no ha sido iniciado");
						message.setPadding(new Insets(10));
						consultaPedido.getChildren().clear();
						status = new ImageView(new Image("./imagenes/Error.png"));
						status.setFitHeight(300);
						status.setFitWidth(300);
						consultaPedido.getChildren().addAll(message, status);
						break;
					}
					root.getChildren().add(consultaPedido);
				} else if (control.equals(consultaEmpleados)) {
					root.getChildren().clear();
					root.getChildren().add(menuBar);
					
					HBox Empleados = new HBox();
					Empleados.setAlignment(Pos.CENTER);
					
					VBox PickerI = new VBox();
					PickerI.setAlignment(Pos.CENTER);
					PickerI.setSpacing(20);
					Button PickerB = new Button("CONSULTAR");
					PickerB.setAlignment(Pos.CENTER);
					PickerB.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							PickerI.getChildren().remove(2);
							PickerI.getChildren().add(new Label(c.infoEmpleado(1)));
							
						}
						
					});
					PickerI.getChildren().addAll(new Label("Consultar información \n del Picker"), PickerB, new Label("Relleno"));
					PickerI.setPadding(new Insets(20));
					
					VBox ConductorI = new VBox();
					ConductorI.setSpacing(20);
					ConductorI.setAlignment(Pos.CENTER);
					Button ConductorB = new Button("CONSULTAR");
					ConductorB.setAlignment(Pos.CENTER);
					ConductorB.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							
							try {
								CheckConductor();
							}
							catch(ErrorConductor driver) {
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Error Conductor");
								alert.setContentText(driver.getMessage());
								alert.showAndWait();
								return;
							}
							//ConductorI.getChildren().remove(2);
							ConductorI.getChildren().add(new Label(c.infoEmpleado(2)));
							
						}
						
					});
					ConductorI.getChildren().addAll(new Label("Consultar información \n del Conductor"), ConductorB);
					ConductorI.setPadding(new Insets(20));
					
					Empleados.getChildren().addAll(PickerI, ConductorI);
					Empleados.setPadding(new Insets(35));
					root.getChildren().add(Empleados);
					
				} else if (control.equals(consultaRecibos)) {
					root.getChildren().clear();
					PanelFactura p1 = new PanelFactura(c);
					root.getChildren().addAll(menuBar, p1);
				}

			}

		}

	}
}
