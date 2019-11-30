package vista;

import AlgoChess.Jugador;
import Controlador.HandlerBotonTablero;
import Tablero.Casillero;
import Tablero.Coordenada;
import Unidades.Curandero;
import Unidades.Jinete;
import Unidades.SoldadoDeInfanteria;
import Unidades.Unidad;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonTablero extends Button {

    //private CasilleroVista[][] casilleros;
    private Jugador jugador1;
    private Jugador jugador2;
    private Casillero casillero;
    private Coordenada coordenada;
    private Image unidad;


    public BotonTablero(TableroVista tableroVista, Coordenada coordenada, Jugador jugador1, Jugador jugador2, Label labelPuntajeJugador1, Label labelPuntajeJugador2) {
        super();
        this.setPrefSize(33,33);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.coordenada = coordenada;
        this.setOnMouseClicked(new HandlerBotonTablero(tableroVista,this, jugador1, jugador2, labelPuntajeJugador1, labelPuntajeJugador2));
    }

    public Coordenada obtenerCoordenada(){
        return this.coordenada;
    }

    public void mostrarCasillero(Unidad miUnidad) {
        if(miUnidad != null) {
            if (miUnidad instanceof SoldadoDeInfanteria) {
                if (jugador2.obtenerListaUnidades().contains(miUnidad)) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_soldado.jpg"), 70, 70, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_soldado.jpg"), 70, 70, false, false);
                }
            } else if (miUnidad instanceof Curandero) {
                if (jugador2.obtenerListaUnidades().contains(miUnidad)) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_curandero.jpg"), 70, 70, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_curandero.jpg"), 70, 70, false, false);
                }
            } else if (miUnidad instanceof Jinete) {
                if (jugador2.obtenerListaUnidades().contains(miUnidad)) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_jinete.jpg"), 70, 70, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_jinete.jpg"), 70, 70, false, false);
                }
            } else {
                if (jugador2.obtenerListaUnidades().contains(miUnidad)) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_catapulta.jpg"), 70, 70, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_catapulta.jpg"), 70, 70, false, false);
                }
            }
            ImageView imageView = new ImageView(unidad);
            this.setGraphic(imageView);
        }
        else{
            System.out.print("Es null");
        }
    }



}
