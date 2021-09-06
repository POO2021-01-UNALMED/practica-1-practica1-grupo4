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
import javafx.scene.layout.VBox;
import uiMain.PrimaryStage;

import java.io.IOException;
import java.util.ArrayList;

import baseDatos.Serializer;
import gestorAplicación.*;
//import gestorAplicación.Almacen;

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

	public User() {

		

		String[] criteria = { "Nombre", "Apellido", "Número de Identificación", "Dirección residencial" };
		String[] valores = { "nombre", "apellido", null, null };

		Cliente c = new Cliente();
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

				label2 = new Label("Descripcion");
				label2.setPrefHeight(77);
				label2.setPrefWidth(Double.MAX_VALUE);
				label2.setAlignment(Pos.CENTER);
				root3.getChildren().addAll(label1, label2);
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
		sceneU = new Scene(root, 500, 500);

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
					;
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
					String[] tiposProducto = { "LACTEOS", "CARNES", "VEGETALES", "FRUTAS"};
					cbxTiposProducto = new ComboBox<>(FXCollections.observableArrayList(tiposProducto));
					Label txtProducto = new Label("Producto");
					Label txtCantidad = new Label("Cantidad");
					Label precio = new Label("Precio");

					GridPane.setConstraints(tipoProducto, 0, 0);
					GridPane.setConstraints(cbxTiposProducto, 1, 0);
					GridPane.setConstraints(txtProducto, 0, 1);
					GridPane.setConstraints(txtCantidad, 1, 1);
					GridPane.setConstraints(precio, 2, 1);

					//btnHacerDomicilio = new Button("Hacer Domicilio");
					//GridPane.setConstraints(btnHacerDomicilio, 1, 6, 1, 3);
					Label relleno = new Label("relleno");

					hacerDomicilio.getChildren().addAll(tipoProducto, cbxTiposProducto);
					intento.getChildren().addAll(hacerDomicilio, relleno);

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
								String[] valores = { "1", "2", null, null };
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
								String[] valores = { "1", "2", null, null };
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
								String[] valores = { "1", "2", null, null };
								FieldPanel rootVegetales = new FieldPanel("Producto", lista, precios, "cantidad", valores,
										"precio");
								
								
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
								String[] valores = { "1", "2", null, null };
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
				} else if (control.equals(consultaEmpleados)) {
					root.getChildren().clear();
					root.getChildren().add(menuBar);
				} else if (control.equals(consultaRecibos)) {
					root.getChildren().clear();
					root.getChildren().add(menuBar);
				}

			}

		}

	}
}
