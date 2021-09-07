package uiMain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import gestorAplicación.Cliente;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PanelFactura extends Pane {

	public PanelFactura(Cliente c) {

		BorderPane border = new BorderPane();
		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(8);
		Label labelFecha = new Label();
		Label labelPrecio = new Label("Precio");
		Label labelProducto = new Label("Producto");
		Label labelCantidad = new Label("cantidad");
		gridPane.setConstraints(labelProducto, 0, 1);
		gridPane.setConstraints(labelCantidad, 1, 1);
		gridPane.setConstraints(labelPrecio, 2, 1);
		gridPane.getChildren().addAll(labelProducto, labelCantidad, labelPrecio);

		if (c.historicoRecibos.size() > 0) {
			int cont = 0;
			for (int i = 0; i < c.historicoRecibos.size(); i++) {
				String[] cad = c.historicoRecibos.get(i).split("\n");
				for (int j = 0; j < cad.length; j++) {
					String[] cadena = cad[j].split("\n");
					cont=j;
					for (int k = 0; k < cadena.length; k++) {
						String cadena2[] = cadena[k].split(" ");
						gridPane.getChildren().add(new Label(cadena2[0]));
						gridPane.getChildren().add(new Label(cadena2[1]));
						gridPane.getChildren().add(new Label(cadena2[2]));

					}
					gridPane.setConstraints(gridPane.getChildren().get(gridPane.getChildren().size() - 3), 0,j + 3 + i);
					gridPane.setConstraints(gridPane.getChildren().get(gridPane.getChildren().size() - 2), 1,j + 3 + i);
					gridPane.setConstraints(gridPane.getChildren().get(gridPane.getChildren().size() - 1), 2,j + 3 + i);
				}
				gridPane.getChildren().add(new Label("-----------------------------------------------------------"));
				gridPane.setConstraints(gridPane.getChildren().get(gridPane.getChildren().size() - 1), 0,cont+4,3,1);
				gridPane.getChildren().add(new Label("Total"));
				gridPane.setConstraints(gridPane.getChildren().get(gridPane.getChildren().size() - 1), 0,cont+5,3,1);
				gridPane.getChildren().add(new Label(String.valueOf(c.getPedido().total)));
				gridPane.setConstraints(gridPane.getChildren().get(gridPane.getChildren().size() - 1), 2,cont+5);
			}
		} else {
			System.out.println("no hay recibos");
		}

		BorderPane.setMargin(gridPane, new Insets(70));
		border.setCenter(gridPane);
		this.getChildren().add(border);

	}

}
