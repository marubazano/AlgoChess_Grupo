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

    public BotonUnidad(String imagenRuta, Unidad unidad, Jugador jugador){
        super();
        this.setPrefSize(90,90);
        imagen = new Image(imagenRuta);
        ImageView imageView = new ImageView(imagen);
        this.setGraphic(imageView);
        if(!jugador.tieneSuficientesPuntos(unidad)){
            this.setDisable(true); //Si el jugador no tiene puntos suficientes no esta el boton
        }
        this.setAlignment(Pos.CENTER);
        this.setOnAction(new HandlerBotonUnidad(unidad, jugador));
    }
}
