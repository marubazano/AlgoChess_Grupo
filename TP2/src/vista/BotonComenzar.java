package vista;

import javafx.scene.control.Button;

public class BotonComenzar extends Button {
    public BotonComenzar(){
        super();
        this.setText("COMENZAR");
        this.setPrefSize(250,90);
        this.setStyle("-fx-font: 30 arial; -fx-base: #000000; -fx-border-color: #6d1fd8; -fx-text-fill: #f04ef5");
        this.setTranslateX(165);
        this.setTranslateY(400);
        //this.setOnAction(blablabal);
    }
}
