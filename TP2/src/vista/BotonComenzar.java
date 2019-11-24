package vista;

import Controlador.HandlerBotonComenzar;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class BotonComenzar extends Button {

    public BotonComenzar(StackPane stackPane){
        super();
        this.setText("COMENZAR");
        this.setPrefSize(250,90);
        this.setStyle("-fx-font: 30 arial; -fx-base: #000000; -fx-border-color: #6d1fd8; -fx-text-fill: #f4ed15");
        this.setOnAction(new HandlerBotonComenzar(stackPane));
        //stackPane.getChildren().remove(this);
    }
}
