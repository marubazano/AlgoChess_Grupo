package vista;

import AlgoChess.Jugador;
import javafx.application.Application;
import javafx.stage.Stage;

public class JuegoPorTurnos {

    private Jugador jugador1;
    private Jugador jugador2;

    public JuegoPorTurnos(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void turnoJugar(Jugador jugador) { } //LEO ENCARGATE DE LOS MOVIMIENTOS

    public void jugar() {
        while(this.jugador1.obtenerCantidadUnidades() > 0 || this.jugador2.obtenerCantidadUnidades() > 0) {
            turnoJugar(this.jugador1);
            turnoJugar(this.jugador2);
            // update del layout, del tablero, de las unidades y del jugador
        }
    }
}
