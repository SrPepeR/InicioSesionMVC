package dad.javafx.inicioSesion.mvc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	
	private Model model = new Model();
	private View view = new View();
	
	private String vacio = "";
	
	public Controller() {
		
		model.usuarioProperty().bindBidirectional(view.getUsuarioText().textProperty());
		
		model.passwordProperty().bindBidirectional(view.getPasswordPass().textProperty());
		
		view.getAccederButton().setOnAction(e -> onAccederAction(e));
		view.getCalcelarButton().setOnAction(e1 -> onCancelarAction(e1));
		
	}

	private void onAccederAction(ActionEvent e) {
		
		String usuario = model.getUsuario();
		String sinCodificar = model.getPassword();
		boolean encontrado = false;
		
		String codificado = DigestUtils.md5Hex(sinCodificar).toUpperCase();
		String linea = "";
		String[] lineaAr;
		
		FileReader lector;
		BufferedReader buffer;
		
		try {
			lector = new FileReader("users.csv");
			buffer = new BufferedReader(lector);
			
			while( (linea = buffer.readLine()) != null ) {
				lineaAr = linea.split(",");
				if( lineaAr[0].equals(usuario) && lineaAr[1].equals(codificado) ) {
					encontrado = true;
					encontrado(usuario);
				}
			}
			
			if( !encontrado ) {
				noEncontrado(usuario);
			}

			lector.close();
			buffer.close();
			
		} catch (IOException e1) {
			System.out.println("No se pudo abrir users.csv");
		}
		
	}
	
	private void encontrado(String user) {
		
		Alert todoBien = new Alert(AlertType.INFORMATION);
		todoBien.setTitle("Iniciar sesión");
		todoBien.setHeaderText("Acceso permitido");
		todoBien.setContentText("Las credenciales de acceso son válidas.");

		todoBien.showAndWait();
		
		Platform.exit();
		
	}
	
	private void noEncontrado(String user) {
		
		Alert todoMal = new Alert(AlertType.ERROR);
		todoMal.setTitle("Iniciar sesión");
		todoMal.setHeaderText("Acceso denegado");
		todoMal.setContentText("El usuario y/o la contraseña no son válidos.");

		todoMal.showAndWait();
		
		model.setUsuario(vacio);
		model.setPassword(vacio);
		
	}
	
	private void onCancelarAction(ActionEvent e1) {
		Platform.exit();
	}
	
	public View getRoot() {
		return view;
	}
	
}
