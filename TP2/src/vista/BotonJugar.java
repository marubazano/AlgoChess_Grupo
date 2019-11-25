package vista;

import Controlador.HandlerBotonJugar;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class BotonJugar extends Button {

    public BotonJugar(HBox hbox, TextField nombreJugador1, TextField nombreJugador2) {
        super();
        this.setText("JUGAR");
        this.setPrefSize(250, 90);
        this.setStyle("-fx-font: 30 arial; -fx-base: #000000; -fx-border-color: #6d1fd8; -fx-text-fill: #f4ed15");
        //this.setOnAction(new HandlerBotonJugar(hbox, nombreJugador1, nombreJugador2));
    }
}
