package vista;

import AlgoChess.Jugador;
import javafx.application.Application;
import javafx.stage.Stage;

public class JuegoPorTurnos extends Application {

    Stage window;
    private Jugador jugador1;
    private Jugador jugador2;

    public JuegoPorTurnos(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.window = stage;
    }
}
