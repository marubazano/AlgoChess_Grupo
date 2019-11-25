package Controlador;

import AlgoChess.Jugador;
import Excepciones.PuntosInsuficientesException;
import Unidades.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerBotonUnidad implements EventHandler<ActionEvent> {
    Unidad unidad;
    Jugador jugador;

    public HandlerBotonUnidad(Unidad unidad, Jugador jugador){
        this.unidad = unidad;
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent evento) {
        try {
            jugador.comprar(unidad);
        } catch (PuntosInsuficientesException e) {
            e.getMensaje();
        }
        evento.consume();
    }
}
