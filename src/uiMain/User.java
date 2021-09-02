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
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import uiMain.PrimaryStage;

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
	TextField txtProducto1;
	TextField txtProducto2;
	TextField txtProducto3;
	TextField txtProducto4;
	ImageView imvProducto1;
	ImageView imvProducto2;
	ImageView imvProducto3;
	ImageView imvProducto4;
	Button btnHacerDomicilio;

	public User() {
		String[] criteria = {"Nombre","Apellido","Número de Identificación", "Dirección residencial"};
		String[] valores = {"nombre","apellido",null, null};
		FieldPanel root4 = new FieldPanel("CRITERIO", criteria, "Valor", valores, null);
		root = new VBox();
		VBox root2 = new VBox();
		VBox root3 = new VBox();
		root3.setPadding(new Insets(5));

		Label label1 = new Label("Nombre del proceso o consulta");
		label1.setPrefHeight(25);
		label1.setPrefWidth(Double.MAX_VALUE);
		label1.setAlignment(Pos.CENTER);

		Label label2 = new Label("Descripcion");
		label2.setPrefHeight(77);
		label2.setPrefWidth(Double.MAX_VALUE);
		label2.setAlignment(Pos.CENTER);
		root3.getChildren().addAll(label1, label2,root4);

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
					hacerDomicilio = new GridPane();
					hacerDomicilio.setVgap(5);
					hacerDomicilio.setHgap(5);
					Label tipoProducto = new Label("Escoja el tipo de producto");
					String[] tiposProducto = { "LACTEOS", "CARNES", "VEGETALES", "FRUTAS", "GRANOS", "LIMPIEZA",
							"BEBIDAS", "TODOMIL" };
					cbxTiposProducto = new ComboBox<>(FXCollections.observableArrayList(tiposProducto));
					Label txtProducto = new Label("Producto");
					Label txtCantidad = new Label("Cantidad");

					GridPane.setConstraints(tipoProducto, 0, 0);
					GridPane.setConstraints(cbxTiposProducto, 1, 0);
					GridPane.setConstraints(txtProducto, 0, 1);
					
					
					btnHacerDomicilio = new Button("Hacer Domicilio");
					GridPane.setConstraints(btnHacerDomicilio, 1, 6,1,3);
					
					hacerDomicilio.getChildren().addAll(tipoProducto, cbxTiposProducto);
					cbxTiposProducto.valueProperty().addListener(new ChangeListener<String>() {

						
						
						@Override
						public void changed(ObservableValue arg0, String arg1, String arg2) {
							if (arg2.equals("LACTEOS")) {
								imvProducto1 = new ImageView("./imagenes/iconMilk.png");
								txtProducto1 = new TextField();
								imvProducto2 = new ImageView("./imagenes/iconCheese.png");
								txtProducto2 = new TextField();
								imvProducto3 = new ImageView("./imagenes/iconYogurt.png");
								txtProducto3 = new TextField();
								imvProducto4 = new ImageView("./imagenes/iconButter.png");
								txtProducto4 = new TextField();

								GridPane.setConstraints(imvProducto1, 0, 2);
								GridPane.setConstraints(txtProducto1, 1, 2);
								GridPane.setConstraints(imvProducto2, 0, 3);
								GridPane.setConstraints(txtProducto2, 1, 3);
								GridPane.setConstraints(imvProducto3, 0, 4);
								GridPane.setConstraints(txtProducto3, 1, 4);
								GridPane.setConstraints(imvProducto4, 0, 5);
								GridPane.setConstraints(txtProducto4, 1, 5);
								hacerDomicilio.getChildren().addAll(imvProducto1, txtProducto1, imvProducto2,
										txtProducto2, imvProducto3, txtProducto3, imvProducto4, txtProducto4,
										txtProducto, txtCantidad,btnHacerDomicilio);
							}

						}

					});
					
					btnHacerDomicilio.setOnAction( new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							System.out.println(txtProducto1.getText());
							
						}});
					
					root.getChildren().addAll(menuBar, hacerDomicilio);

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
