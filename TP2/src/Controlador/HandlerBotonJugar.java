package Controlador;

import AlgoChess.Jugador;
import Tablero.Coordenada;
import Tablero.Tablero;
import Unidades.Curandero;
import Unidades.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vista.TableroVista;

public class HandlerBotonJugar implements EventHandler<ActionEvent> {
    /*
     * Aca empieza el juego
     */
    HBox hbox;
    TextField nombreJugador1;
    TextField nombreJugador2;

    public HandlerBotonJugar(HBox hbox, TextField nombreJugador1, TextField nombreJugador2){
        this.hbox = hbox;
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
    }

    @Override
    public void handle(ActionEvent evento){
        //creo jugadores y paso a pantalla de selección de unidades
        //Instancia tablero, jugadores, tableroVista
        //Jugador jugador1 = new Jugador(nombreJugador1, )
        nombreJugador1.textProperty().addListener((observableValue, s, t1) ->{});
        nombreJugador2.textProperty().addListener((observableValue, s, t1) ->{});
        Unidad unidad = new Curandero();
        Coordenada coordenada = new Coordenada(1,2);
        Tablero tablero = new Tablero();
        Jugador jugador_1 = new Jugador(nombreJugador1.getText(), tablero, 1);
        Jugador jugador_2 = new Jugador(nombreJugador2.getText(), tablero, 2);
        TableroVista tablerovista = new TableroVista(tablero, jugador_1, jugador_2, null, null, null, null);
        VBox unidadesJugador1 = new VBox(); //CORREGIR ESPACIAMIENTO
        VBox unidadesJugador2 = new VBox(); //CORREGIR ESPACIAMIENTO

        System.out.println(jugador_1.obtenerNombre());
        System.out.println(jugador_2.obtenerNombre());
    }
}
