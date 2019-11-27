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
                tableroVista.agregarUltimaUnidadComprada(unidad);
                // UBICAR UNIDAD
                if (!jugador.tieneSuficientesPuntos(unidad)) {
                    this.boton.setDisable(true);
                }
                System.out.println("Cantidad de unidades de jugador: "+jugador.obtenerCantidadUnidades());
                System.out.println("Cantidad de unidades de OtroJugador: "+OtroJugador.obtenerCantidadUnidades());
                if (OtroJugador.obtenerPuntos() != 0) {//Si el otro jugador todavia tiene puntos -> puede comprar -> sino sigue comprando el que tenga
                    jugador.asignarTurno(false);
                    OtroJugador.asignarTurno(true);
                }
            } catch (PuntosInsuficientesException e) {
                e.getMensaje();
            }
        } else {
            System.out.println("No es tu turno!");
        }
    }
}
