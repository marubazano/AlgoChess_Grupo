package vista;

import javafx.scene.control.Button;

public class BotonJugar extends Button {

    public BotonJugar() {
        super();
        this.setText("JUGAR");
        this.setPrefSize(250, 90);
        this.setStyle("-fx-font: 30 arial; -fx-base: #000000; -fx-border-color: #6d1fd8; -fx-text-fill: #f4ed15");
        //this.setOnAction(new HandlerBotonComenzar(stackPane));
    }
}
