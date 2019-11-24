package vista;

import AlgoChess.Jugador;
import Unidades.Catapulta;
import Unidades.SoldadoDeInfanteria;
import Unidades.Curandero;
import Unidades.Jinete;
import Unidades.Unidad;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import Tablero.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;

public class CasilleroVista extends Pane {
    Casillero casillero;
    Image unidad;
    Jugador jugador1;
    Jugador jugador2;

    public CasilleroVista (Casillero casillero, Jugador jugador1, Jugador jugador2) {
        this.casillero = casillero;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    private void mostrarCasillero() {
        if (!this.casillero.estaOcupado()) {
            if ((this.casillero.obtenerUnidad()) instanceof SoldadoDeInfanteria) {
                if (jugador1.obtenerListaUnidades().contains(this.casillero.obtenerUnidad())) {
                    unidad = new Image(getClass().getResourceAsStream("imagenes/gato_soldado.jpg"));
                } else {
                    unidad = new Image(getClass().getResourceAsStream("imagenes/perro_soldado.jpg"));
                }
            }
            if ((this.casillero.obtenerUnidad()) instanceof Curandero) {
                if (jugador1.obtenerListaUnidades().contains(this.casillero.obtenerUnidad())) {
                    unidad = new Image(getClass().getResourceAsStream("imagenes/gato_curandero.jpg"));
                } else {
                    unidad = new Image(getClass().getResourceAsStream("imagenes/perro_curandero.jpg"));
                }
            }
            if ((this.casillero.obtenerUnidad()) instanceof Jinete) {
                if (jugador1.obtenerListaUnidades().contains(this.casillero.obtenerUnidad())) {
                    unidad = new Image(getClass().getResourceAsStream("imagenes/gato_jinete.jpg"));
                } else {
                    unidad = new Image(getClass().getResourceAsStream("imagenes/perro_jinete.jpg"));
                }
            }
            if ((this.casillero.obtenerUnidad()) instanceof Catapulta) {
                if (jugador1.obtenerListaUnidades().contains(this.casillero.obtenerUnidad())) {
                    unidad = new Image(getClass().getResourceAsStream("imagenes/gato_catapulta.jpg"));
                } else {
                    unidad = new Image(getClass().getResourceAsStream("imagenes/perro_catapulta.jpg"));
                }
            }
        }
    }
}
