package Controlador;

import AlgoChess.Jugador;
import Tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HandlerBotonJugar implements EventHandler<ActionEvent> {
    /*
     * Aca empieza el juego
     */
    HBox hbox;
    String nombreJugador1;
    String nombreJugador2;

    public HandlerBotonJugar(HBox hbox, TextField nombreJugador1, TextField nombreJugador2){
        this.hbox = hbox;
        this.nombreJugador1 = nombreJugador1.getText();
        this.nombreJugador2 = nombreJugador2.getText();
    }

    @Override
    public void handle(ActionEvent evento){
        //creo jugadores y paso a pantalla de selección de unidades
        //Instancia tablero, jugadores, tableroVista
        //Jugador jugador1 = new Jugador(nombreJugador1, )
        Tablero tablero = new Tablero();
        Jugador jugador_1 = new Jugador(nombreJugador1, tablero, 1);
        Jugador jugador_2 = new Jugador(nombreJugador2, tablero, 2);
        VBox unidadesJugador1 = new VBox(); //CORREGIR ESPACIAMIENTO
        VBox unidadesJugador2 = new VBox(); //CORREGIR ESPACIAMIENTO
        System.out.println(jugador_1.obtenerNombre());
        System.out.println(jugador_2.obtenerNombre());
    }
}
