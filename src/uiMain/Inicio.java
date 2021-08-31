package uiMain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Inicio {
	MenuItem menuSalir;
	MenuItem menuDes;
	Image imgSuper1;
	ImageView imvSuper1;
	Image img1;
	ImageView imv1;
	Image img2;
	ImageView imv2;
	Image img3;
	ImageView imv3;
	Image img4;
	ImageView imv4;
	Label l3;
	GridPane p6;
	ImageView l2;
	Button btnIniciar;
	Menu menuInicio;
	int contp3 = 0;
	int contador=0;
	Scene scene2 = new User().getScene();
	private Scene sceneI;

	private static Label createLabel(String text, String Style) {
		Label label = new Label(text);
		label.setStyle("-fx-Background-color:" + Style + ";" + "\n-fx-font-style: italic;");
		return label;
	}

	public Inicio() {
		
		VBox root0 = new VBox();

		Label l1 = createLabel("BIENVENIDO AL SISTEMA", "BLUE");
		l1.setPrefSize(200, 100);
		l1.setTextFill(Color.WHITE);

		LabelHandler manejador = new LabelHandler();
		menuHandler manejador2= new menuHandler();
		l3 = createLabel("wow", "GREEN");
		l3.setPrefSize(200, 100);
		l3.setTextFill(Color.WHITE);
		l3.setOnMouseClicked(manejador);

		img1 = new Image("./imagenes/unal.png");
		imv1 = new ImageView(img1);
		imv1.setFitHeight(150);
		imv1.setFitWidth(100);
		img2 = new Image("./imagenes/unal2.png");
		imv2 = new ImageView(img2);
		imv2.setFitHeight(150);
		imv2.setFitWidth(100);
		img3 = new Image("./imagenes/doggie.jpg");
		imv3 = new ImageView(img3);
		imv3.setFitHeight(150);
		imv3.setFitWidth(100);
		img4 = new Image("./imagenes/bicho.jpeg");
		imv4 = new ImageView(img4);
		imv4.setFitHeight(150);
		imv4.setFitWidth(100);

		p6 = new GridPane();
		p6.setVgap(5);
		p6.setHgap(5);
		GridPane.setConstraints(imv1, 0, 0);
		GridPane.setConstraints(imv2, 1, 0);
		GridPane.setConstraints(imv3, 0, 1);
		GridPane.setConstraints(imv4, 1, 1);
		p6.getChildren().addAll(imv1, imv2, imv3, imv4);

		VBox P2 = new VBox();
		P2.setSpacing(5);
		P2.getChildren().addAll(l3, p6);
		P2.setPadding(new Insets(10));

		btnIniciar = new Button("Iniciar");
		btnIniciar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				PrimaryStage.stage.setScene(scene2);
				
			}
			
		});
		VBox p4 = new VBox();
		imgSuper1 = new Image("./imagenes/super.jpg");
		imvSuper1 = new ImageView(imgSuper1);
		imvSuper1.setFitHeight(250);
		imvSuper1.setFitWidth(200);
		imvSuper1.setOnMouseEntered(manejador);
		p4.setSpacing(5);
		btnIniciar.setPrefSize(200, 50);
		p4.getChildren().addAll(imvSuper1, btnIniciar);

		VBox P1 = new VBox();
		P1.setPadding(new Insets(10));
		P1.setSpacing(5);
		P1.getChildren().addAll(l1, p4);

		HBox root = new HBox();
		root.getChildren().addAll(P1, P2);

		menuInicio = new Menu("Inicio");
		menuSalir = new MenuItem("Salir");
		menuSalir.setOnAction(manejador2);
		menuDes = new MenuItem("Descripción");
		menuDes.setOnAction(manejador2);
		menuInicio.getItems().addAll(menuSalir, menuDes);
		MenuBar menubar = new MenuBar();
		menubar.getMenus().add(menuInicio);

		root0.getChildren().addAll(menubar, root);

		sceneI = new Scene(root0, 500, 500);
	}
	public Scene getScene() {
		return this.sceneI;
	}
	class LabelHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			Object control = e.getSource();
			if (control instanceof Label) {
				if (control.equals(l3)) {
					if (contp3 == 0) {
						l3.setText("usuario 1");
						imv1.setImage(new Image("./imagenes/im1.jpeg"));
						imv2.setImage(new Image("./imagenes/im2.jpeg"));
						imv3.setImage(new Image("./imagenes/im3.jpeg"));
						imv4.setImage(new Image("./imagenes/im4.jpeg"));
						contp3++;
					} else if (contp3 == 1) {
						l3.setText("usuario 2");
						imv1.setImage(img1);
						imv2.setImage(img2);
						imv3.setImage(img3);
						imv4.setImage(img4);
						contp3++;
					} else if (contp3 == 2) {
						l3.setText("usuario 3");
						contp3 = 0;
					}
	
				}
			}
			if(control instanceof ImageView) {
				if(contador==0) {
					imvSuper1.setImage(new Image("./imagenes/mercado1.jpg"));
					contador ++;
				}
				else if(contador==1) {
					imvSuper1.setImage(new Image("./imagenes/mercado2.jpg"));
					contador ++;
				}
				else if(contador==2) {
					imvSuper1.setImage(new Image("./imagenes/mercado3.jpg"));
					contador ++;
				}
				else if(contador==3) {
					imvSuper1.setImage(new Image("./imagenes/mercado4.jpg"));
					contador ++;
				}
				else if(contador==4) {
					imvSuper1.setImage(new Image("./imagenes/super.jpg"));
					contador=0;
				}
			}
			

		}

	}
	class menuHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			Object control=e.getSource();
			if (control instanceof MenuItem) {
				if(control.equals(menuSalir)) {
					System.exit(0);
				
				}
				else if(control.equals(menuDes)){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Descripcion Programa");
					alert.setContentText("El programa permite hacer difrentes consultas en un supermercado");
					alert.showAndWait();
				}
				
			}
					
			
		}
		
	}

}
