package Controlador;

import AlgoChess.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandlerBotonComenzar extends Button {
    Jugador jugador_1;
    Jugador jugador_2;


    public HandlerBotonComenzar(Jugador jugador_1, Jugador jugador_2){
        this.jugador_1 = jugador_1;
        this.jugador_2 = jugador_2;
    }

}
