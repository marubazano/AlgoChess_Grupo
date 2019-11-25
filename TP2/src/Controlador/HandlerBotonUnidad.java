package Controlador;

import AlgoChess.Jugador;
import Excepciones.PuntosInsuficientesException;
import Unidades.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;


public class HandlerBotonUnidad implements EventHandler<MouseEvent> {
    Unidad unidad;
    Jugador jugador;
    Jugador OtroJugador;
    Button boton;

    public HandlerBotonUnidad(Unidad unidad, Jugador jugador, Jugador OtroJugador, Button boton){
        this.unidad = unidad;
        this.jugador = jugador;
        this.OtroJugador = OtroJugador;
        this.boton = boton;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (jugador.esTurno()) {
            try {
                jugador.comprar(unidad);
                if (OtroJugador.obtenerPuntos() != 0) {//Si el otro jugador todavia tiene puntos -> puede comprar -> sino sigue comprando el que tenga
                    jugador.asignarTurno(false);
                    OtroJugador.asignarTurno(true);
                }
            } catch (PuntosInsuficientesException e) {
                e.getMensaje();
            }
            mouseEvent.consume();
        } else {
            System.out.println("No es tu turno!");
        }

    }
}
