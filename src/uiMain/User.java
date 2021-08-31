package uiMain;


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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import uiMain.InicioFX;


public class User{
	private Scene sceneU;
	MenuItem aplicacion;
	MenuItem salir;
	
	public User() {
		VBox root = new VBox();
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
		root3.getChildren().addAll(label1,label2);
		
		menuHandler handlerU = new menuHandler();
		MenuBar menuBar = new MenuBar();
		Menu archivo = new Menu("Archivo");
		aplicacion = new MenuItem("Aplicación");
		aplicacion.setOnAction(handlerU);
		salir = new MenuItem("Salir");
		salir.setOnAction(handlerU);
		archivo.getItems().addAll(aplicacion, salir);
		
		Menu procesos = new Menu("Procesos y Consultas");
		Menu ayuda = new Menu("Ayuda");
		
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
			Object control=e.getSource();
			if (control instanceof MenuItem) {
				if(control.equals(salir)) {
					//InicioFX.stage.setScene(InicioFX.scene);
					InicioFX.stage.setScene(InicioFX.scene);;
				}
				else if(control.equals(aplicacion)){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Descripcion Aplicación");
					alert.setContentText("El programa permite hacer difrentes consultas en un supermercado");
					alert.showAndWait();
				}
				
			}
					
			
		}
		
	}
}
	
	
