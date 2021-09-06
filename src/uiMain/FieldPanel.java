package uiMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import gestorAplicación.Almacen;
import gestorAplicación.Cliente;
import gestorAplicación.Pedido;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	public ArrayList<TextField> values = new ArrayList<>();
	Cliente c;

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
		
		Button boton = new Button("Añadir al carrito");
		boton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (User.cadenaCategoria.equals("LACTEOS")) {
					for (int i = 0; i < 4; i++) {
						if(values.get(i).getText().length() != 0) {
							Pedido.agregarProducto(almacen.lacteos.get(i), Integer.valueOf(values.get(i).getText()));
						}					
					} 
				}else if(User.cadenaCategoria.equals("CARNES")) {
					for (int i = 0; i < 4; i++) {
						if(values.get(i).getText().length() != 0) {
							Pedido.agregarProducto(almacen.carnes.get(i), Integer.valueOf(values.get(i).getText()));
						}
						
					} 
				}else if(User.cadenaCategoria.equals("VEGETALES")) {
					for (int i = 0; i < 4; i++) {
						if(values.get(i).getText().length() != 0) {
							Pedido.agregarProducto(almacen.vegetales.get(i), Integer.valueOf(values.get(i).getText()));
						}
						
					}
				}else if(User.cadenaCategoria.equals("FRUTAS")) {
					for (int i = 0; i < 4; i++) {
						if(values.get(i).getText().length() != 0) {
							Pedido.agregarProducto(almacen.frutas.get(i), Integer.valueOf(values.get(i).getText()));
						}
						
					}
				}
				System.out.println(Pedido.carrito);			
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
