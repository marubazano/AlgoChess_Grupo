package Controlador;

import AlgoChess.Jugador;
import Excepciones.PuntosInsuficientesException;
import Unidades.Catapulta;
import Unidades.Curandero;
import Unidades.Jinete;
import Unidades.SoldadoDeInfanteria;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerBotonUnidad implements EventHandler<ActionEvent> {
    String tipo;
    Jugador jugador;
    public HandlerBotonUnidad(String tipo, Jugador jugador){
        this.tipo = tipo;
        this.jugador = jugador;
    }
    @Override
    public void handle(ActionEvent evento) {
        if (tipo == "soldado") {
            try {
                this.jugador.comprar(new SoldadoDeInfanteria());
            } catch (PuntosInsuficientesException e) {
                e.printStackTrace();
            }
        }
        if (tipo == "jinete") {
            try {
                this.jugador.comprar(new Jinete());
            } catch (PuntosInsuficientesException e) {
                e.printStackTrace();
            }
        }
        if (tipo == "curandero") {
            try {
                this.jugador.comprar(new Curandero());
            } catch (PuntosInsuficientesException e) {
                e.printStackTrace();
            }
        }
        if (tipo == "catapulta") {
            try {
                this.jugador.comprar(new Catapulta());
            } catch (PuntosInsuficientesException e) {
                e.printStackTrace();
            }
        }
    }
}
