package uiMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import errors.ErrorCantidaProducto;
import errors.ErrorTexto;
import gestorAplicación.Almacen;
import gestorAplicación.Cliente;
import gestorAplicación.Pedido;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FieldPanel extends Pane {
	Almacen almacen = User.almacen;
	// FieldPanel area = new FieldPanel();
	String tituloCriterios;
	String[] criterios;
	String tituloValores;
	String[] valores;
	boolean[] habilitado;
	public static ArrayList<TextField> values = new ArrayList<>();
	static Cliente c;
	
	
	static void checking() throws ErrorTexto{
		if (values.get(0).getText() == "" || values.get(1).getText() == "" || values.get(2).getText() == "" || values.get(3).getText() == "") {
			throw new ErrorTexto();
		}
	}
	
	public FieldPanel getPanel() {
		return this;
	}
	
	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado) {

		BorderPane border = new BorderPane();
		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(8);
		Button boton = new Button("Registrar");
		boton.setAlignment(Pos.CENTER);

		boton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					checking();
				}
				catch(ErrorTexto e) {
					String toAlert = "";
					for (int i = 0;i < criterios.length; i++) {
						if (values.get(i).getText() == "") {
							toAlert += criterios[i] + "\n";
						}
					}
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Error Texto");
					alert.setContentText(e.getMessage() + "\n\n" + toAlert);
					alert.showAndWait();
					return;
				}
				c = new Cliente(values.get(0).getText(), values.get(1).getText(),
						Integer.valueOf(values.get(2).getText()), values.get(3).getText());
				try {
					c.serializarCliente();
					Label label = new Label("Tu información ha sido guardada de forma exitosa");

					border.setBottom(null);
					border.setCenter(label);
					label.setAlignment(Pos.CENTER);
					ImageView bienvenidaImagen = new ImageView(new Image("./imagenes/cart.png"));
					bienvenidaImagen.setFitHeight(200);
					bienvenidaImagen.setFitWidth(200);
					border.setBottom(bienvenidaImagen);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		BorderPane.setMargin(gridPane, new Insets(70));

		Label labelTitle = new Label(tituloCriterios);
		labelTitle.setPrefSize(100, 25);
		Label labelValue = new Label(tituloValores);

		GridPane.setConstraints(labelTitle, 0, 0);
		GridPane.setConstraints(labelValue, 1, 0);

		for (int c = 0; c < criterios.length; c++) {
			Label label = new Label(criterios[c]);

			GridPane.setConstraints(label, 0, c + 1);
			TextField input;
			if (valores[c] != null) {
				input = new TextField(valores[c]);
				GridPane.setConstraints(input, 1, c + 1);

			} else {
				input = new TextField();
				GridPane.setConstraints(input, 1, c + 1);

			}
			values.add(input);

			gridPane.getChildren().addAll(label, input);
		}

		gridPane.getChildren().addAll(labelTitle, labelValue);
		border.setCenter(gridPane);
		border.setBottom(boton);

		this.getChildren().add(border);
	}

	public FieldPanel() {

	}

	public FieldPanel(String tituloCriterios, ArrayList<Image> images, ArrayList<Integer> precios, String tituloValores,
			String[] valores, String tituloPrecio) {
		
		BorderPane border = new BorderPane();
		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(8);

		BorderPane.setMargin(gridPane, new Insets(70));

		Label labelTitle = new Label(tituloCriterios);
		labelTitle.setPrefSize(100, 25);
		Label labelValue = new Label(tituloValores);
		Label labelPrecio = new Label(tituloPrecio);

		GridPane.setConstraints(labelTitle, 0, 0);
		GridPane.setConstraints(labelValue, 1, 0);
		GridPane.setConstraints(labelPrecio, 2, 0);

		for (int c = 0; c < images.size(); c++) {
			ImageView imageProduct = new ImageView(images.get(c));

			GridPane.setConstraints(imageProduct, 0, c + 1);
			TextField input;
			Label price;
			if (valores[c] != null) {
				input = new TextField(valores[c]);
				GridPane.setConstraints(input, 1, c + 1);
				price = new Label(precios.get(c).toString());
				GridPane.setConstraints(price, 2, c + 1);
			} else {
				input = new TextField();
				GridPane.setConstraints(input, 1, c + 1);
				price = new Label(precios.get(c).toString());
				GridPane.setConstraints(price, 2, c + 1);
			}
			values.add(input);
			

			gridPane.getChildren().addAll(imageProduct, input, price);

			
		}
		
		Button boton = new Button("Ańadir al carrito");
		boton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (User.cadenaCategoria.equals("LACTEOS")) {
					for (int i = 0; i < 4; i++) {
						if(values.get(i).getText().length() != 0) {
							try {
								User.c.getPedido().agregarProducto(almacen.lacteos.get(i), Integer.valueOf(values.get(i).getText()));
							} catch (ErrorCantidaProducto e) {
								// TODO Auto-generated catch block
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Error Cantidad producto");
								alert.setContentText(e.getMessage());
								alert.showAndWait();
								return;
							}
						}					
					} 
				}else if(User.cadenaCategoria.equals("CARNES")) {
					for (int i = 0; i < 4; i++) {
						if(values.get(i).getText().length() != 0) {
							try {
								User.c.getPedido().agregarProducto(almacen.carnes.get(i), Integer.valueOf(values.get(i).getText()));
							} catch (ErrorCantidaProducto e) {
								// TODO Auto-generated catch block
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Error Cantidad producto");
								alert.setContentText(e.getMessage());
								alert.showAndWait();
								return;
							}
						}
						
					} 
				}else if(User.cadenaCategoria.equals("VEGETALES")) {
					for (int i = 0; i < 4; i++) {
						if(values.get(i).getText().length() != 0) {
							try {
								User.c.getPedido().agregarProducto(almacen.vegetales.get(i), Integer.valueOf(values.get(i).getText()));
							} catch ( ErrorCantidaProducto e) {
								// TODO Auto-generated catch block
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Error Cantidad producto");
								alert.setContentText(e.getMessage());
								alert.showAndWait();
								return;
							}
						}
						
					}
				}else if(User.cadenaCategoria.equals("FRUTAS")) {
					for (int i = 0; i < 4; i++) {
						if(values.get(i).getText().length() != 0) {
							try {
								User.c.getPedido().agregarProducto(almacen.frutas.get(i), Integer.valueOf(values.get(i).getText()));
							} catch (ErrorCantidaProducto e) {
								// TODO Auto-generated catch block
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Error Cantidad producto");
								alert.setContentText(e.getMessage());
								alert.showAndWait();
								return;
							}
						}
						
					}
				}
				
				getPanel().getChildren().clear();	
			}});
		
		
		GridPane.setConstraints(boton, 1, 5, 4, 1);
		gridPane.getChildren().addAll(labelTitle, labelValue, labelPrecio,boton);
		border.setCenter(gridPane);

		this.getChildren().add(border);

		/*
		 * public String getValue() { return }
		 */
	}
}
