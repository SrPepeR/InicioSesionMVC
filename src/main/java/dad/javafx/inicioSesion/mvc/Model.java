package dad.javafx.inicioSesion.mvc;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	
	public final StringProperty usuarioProperty() {
		return this.usuario;
	}
	
	public final String getUsuario() {
		return this.usuarioProperty().get();
	}
	
	public final void setUsuario(String usuario) {
		this.usuarioProperty().set(usuario);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	
	public final void setPassword(String password) {
		this.passwordProperty().set(password);
	}
	
}
