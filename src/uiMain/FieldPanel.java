package uiMain;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class FieldPanel extends Pane{
	
	//FieldPanel area = new FieldPanel();
	String tituloCriterios;
	String[] criterios;
	String tituloValores;
	String[] valores;
	boolean[] habilitado;
	
	public FieldPanel(String tituloCriterios, String[] criterios, String tituloValores, String[] valores, boolean[] habilitado) {
		
		BorderPane border = new BorderPane();
		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(8);
		
		BorderPane.setMargin(gridPane, new Insets(70));
		
		Label labelTitle = new Label(tituloCriterios);
		labelTitle.setPrefSize(100,25);
		Label labelValue = new Label(tituloValores);
		
		GridPane.setConstraints(labelTitle, 0, 0);
		GridPane.setConstraints(labelValue, 1, 0);
		
		for (int c = 0; c < criterios.length; c++){
			Label label = new Label(criterios[c]);
			
			GridPane.setConstraints(label,0,c+1);
			TextField input;
			if (valores[c] != null) {
				input = new TextField(valores[c]);
				GridPane.setConstraints(input,1,c+1);
			}
			else {
				input = new TextField();
				GridPane.setConstraints(input,1,c+1);
			}
			
			gridPane.getChildren().addAll(label, input);
		}
		
		
		gridPane.getChildren().addAll(labelTitle, labelValue);
		border.setCenter(gridPane);
		
		this.getChildren().add(border);
	}
	public FieldPanel() {
		
	}
}
