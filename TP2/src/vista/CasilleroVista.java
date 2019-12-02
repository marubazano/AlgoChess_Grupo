package vista;

import Jugador.Jugador;
import Controlador.ControladorFlujoJuego;
import Controlador.HandlerCasilleroJugar;
import Controlador.Observador;
import Tablero.Casillero;
import Tablero.Coordenada;
import Unidades.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CasilleroVista extends Pane implements Observador {
    Casillero casillero;
    Coordenada coordenada;
    Jugador jugador1;
    Jugador jugador2;
    ImageView unidad;

    public CasilleroVista (Casillero casillero, Jugador jugador1, Jugador jugador2, Coordenada coordenada, ControladorFlujoJuego controlador) {
        this.casillero = casillero;
        this.coordenada = coordenada;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.setOnMouseClicked(new HandlerCasilleroJugar(jugador1, jugador2, controlador, casillero, coordenada));
    }

    public void change() {
        if (this.casillero.estaOcupado()) {
            if ((this.casillero.obtenerUnidad()) instanceof SoldadoDeInfanteria) {
                if (jugador1.obtenerListaUnidades().contains(this.casillero.obtenerUnidad())) {
                    unidad = new ImageView(new Image(getClass().getResourceAsStream("imagenes/gato_soldado.jpg"), 29, 29, false ,false));
                } else {
                    unidad = new ImageView(new Image(getClass().getResourceAsStream("imagenes/perro_soldado.jpg"), 29, 29, false ,false));
                }
            }
            if ((this.casillero.obtenerUnidad()) instanceof Curandero) {
                if (jugador1.obtenerListaUnidades().contains(this.casillero.obtenerUnidad())) {
                    unidad = new ImageView(new Image(getClass().getResourceAsStream("imagenes/gato_curandero.jpg"), 29, 29, false ,false));
                } else {
                    unidad = new ImageView(new Image(getClass().getResourceAsStream("imagenes/perro_curandero.jpg"), 29, 29, false ,false));
                }
            }
            if ((this.casillero.obtenerUnidad()) instanceof Jinete) {
                if (jugador1.obtenerListaUnidades().contains(this.casillero.obtenerUnidad())) {
                    unidad = new ImageView(new Image(getClass().getResourceAsStream("imagenes/gato_jinete.jpg"), 29, 29, false ,false));
                } else {
                    unidad = new ImageView(new Image(getClass().getResourceAsStream("imagenes/perro_jinete.jpg"), 29, 29, false ,false));
                }
            }
            if ((this.casillero.obtenerUnidad()) instanceof Catapulta) {
                if (jugador1.obtenerListaUnidades().contains(this.casillero.obtenerUnidad())) {
                    unidad = new ImageView(new Image(getClass().getResourceAsStream("imagenes/gato_catapulta.jpg"), 29, 29, false ,false));
                } else {
                    unidad = new ImageView(new Image(getClass().getResourceAsStream("imagenes/perro_catapulta.jpg"), 29, 29, false ,false));
                }
            }
            unidad.maxHeight(1);
            unidad.maxWidth(1);
            this.getChildren().add(unidad);
        }
        else{
            unidad.setImage(null);
        }
    }
}
