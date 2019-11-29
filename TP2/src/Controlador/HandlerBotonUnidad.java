package Controlador;

import AlgoChess.Jugador;
import Excepciones.PuntosInsuficientesException;
import Unidades.Unidad;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import vista.TableroVista;


public class HandlerBotonUnidad implements EventHandler<MouseEvent> {
    Unidad unidad;
    Jugador jugador;
    Jugador OtroJugador;
    Button boton;
    TableroVista tableroVista;

    public HandlerBotonUnidad(Unidad unidad, Jugador jugador, Jugador OtroJugador, Button boton, TableroVista tableroVista){
        this.unidad = unidad;
        this.jugador = jugador;
        this.OtroJugador = OtroJugador;
        this.boton = boton;
        this.tableroVista = tableroVista;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (jugador.esTurno()) {
            try {
                jugador.comprar(unidad);
                tableroVista.deshabilitarBotonesUnidadDeJugador(jugador.obtenerNumeroJugador()); // PARA QUE NO COMPRE OTRA UNIDAD ANTES DE UBICAR LA ACTUAL
                tableroVista.cambiarLabelDeAccionDelTurno("Compró la unidad " + unidad.getClass().getSimpleName());
                tableroVista.agregarUltimaUnidadComprada(unidad);

            } catch (PuntosInsuficientesException e) {
                e.getMensaje();
            }
        } else {
            tableroVista.cambiarLabelDeAccionDelTurno("No es su turno.");
        }
    }
}
