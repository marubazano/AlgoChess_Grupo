package vista;

import AlgoChess.Jugador;
import Excepciones.PuntosInsuficientesException;
import Unidades.Catapulta;
import Unidades.Curandero;
import Unidades.Jinete;
import Unidades.SoldadoDeInfanteria;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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

        // acá tenemos que hacer un while o algo así
        // que vaya turno por turno hasta que algún
        // jugador pierda.

        // ESTO ES IMPORTANTE LEO, LO HACEMOS CON EVENTOS O Q??? U.U
    }
}
