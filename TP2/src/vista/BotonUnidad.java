package vista;

import AlgoChess.Jugador;
import Controlador.HandlerBotonComenzar;
import Controlador.HandlerBotonUnidad;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BotonUnidad extends Button{

    Image imagen;

    public BotonUnidad(String imagenRuta, String tipo, Jugador jugador){
        super();
        //this.setText("COMENZAR");
        this.setPrefSize(90,90);
        Image imagen = new Image(imagenRuta);
        ImageView imageView = new ImageView(imagen);
        this.setGraphic(imageView);
        //this.setAlignment(Pos.CENTER);
        this.setOnAction(new HandlerBotonUnidad(tipo, jugador));
        //stackPane.getChildren().remove(this);
    }
}
