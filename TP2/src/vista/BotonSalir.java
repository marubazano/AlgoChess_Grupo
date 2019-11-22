package vista;

import Controlador.HandlerBotonSalir;
import javafx.scene.control.Button;

public class BotonSalir extends Button {
    public BotonSalir(){
        super();
        this.setText("SALIR");
        this.setStyle("-fx-font: 23 arial; -fx-base: #000000; -fx-border-color: #ec443f; -fx-text-fill: #ec443f");
        this.setOnAction(new HandlerBotonSalir());
    }
}
