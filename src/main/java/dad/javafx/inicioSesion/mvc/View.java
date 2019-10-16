package dad.javafx.inicioSesion.mvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class View extends GridPane {
	private Label usuarioLabel;
	private TextField usuarioText;
	private Label passwordLabel;
	private PasswordField passwordPass;
	
	private Button accederButton;
	private Button cancelarButton;
	
	public View() {
		
		super();
		
		usuarioLabel = new Label("Usuario:");
		usuarioLabel.setPrefWidth(80);
		usuarioText = new TextField();
		usuarioText.setPromptText("Usuario");
		passwordLabel = new Label("Contraseña:");
		passwordLabel.setPrefWidth(80);
		passwordPass = new PasswordField();
		passwordPass.setPromptText("Contraseña");
		
		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);
		cancelarButton = new Button("Cancelar");
		
		setAlignment(Pos.CENTER);
		setVgap(10);
//		setGridLinesVisible(true);
		setPadding(new Insets(20));
		add(usuarioLabel, 0, 0);
		add(usuarioText, 1, 0);
		add(passwordLabel, 0, 2);
		add(passwordPass, 1, 2);
		setFillWidth(usuarioText, true);
		HBox botonesBox = new HBox(20, accederButton, cancelarButton);
		botonesBox.setAlignment(Pos.CENTER);
		add(botonesBox, 0, 3);
		setColumnSpan(botonesBox, 2);
		
		
	}
	
	public Label getUsuarioLabel() {
		return usuarioLabel;
	}
	
	public TextField getUsuarioText() {
		return usuarioText;
	}
	
	public Label getPasswordLabel() {
		return passwordLabel;
	}
	
	public PasswordField getPasswordPass() {
		return passwordPass;
	}
	
	public Button getAccederButton() {
		return accederButton;
	}
	
	public Button getCalcelarButton() {
		return cancelarButton;
	}
	
}
