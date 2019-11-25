package vista;

import AlgoChess.Jugador;
import Controlador.HandlerBotonUnidad;
import Unidades.Unidad;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class BotonUnidad extends Button{

    Image imagen;

    public BotonUnidad(String imagenRuta, Unidad unidad, Jugador jugador, Jugador OtroJugador){
        super();
        this.setPrefSize(100,100);
        imagen = new Image(getClass().getResourceAsStream(imagenRuta), 100, 100, false, false);
        ImageView imageView = new ImageView(imagen);
        this.setGraphic(imageView);
        this.setAlignment(Pos.CENTER);
        this.setOnMouseClicked(new HandlerBotonUnidad(unidad, jugador, OtroJugador, this));
        this.setOnAction(MouseEvent ->{if (!jugador.tieneSuficientesPuntos(unidad)) {
            this.setDisable(true); //Si el jugador no tiene puntos suficientes no esta el boton
        }});
    }
}
