package vista;

import AlgoChess.Jugador;
import Controlador.HandlerBotonTablero;
import Tablero.Casillero;
import Tablero.Coordenada;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class BotonTablero extends Button {

    //private CasilleroVista[][] casilleros;
    private Jugador jugador1;
    private Jugador jugador2;
    private Casillero casillero;
    private Image unidad;
    private boolean estado = false;

    public BotonTablero(TableroVista tableroVista, Coordenada coordenada, Jugador jugador1, Jugador jugador2, Label labelPuntajeJugador1, Label labelPuntajeJugador2) {
        super();
        this.setPrefSize(33,33);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.setOnMouseClicked(new HandlerBotonTablero(tableroVista, coordenada, this, jugador1, jugador2, labelPuntajeJugador1, labelPuntajeJugador2));
//        this.setOnMouseClicked(new HandlerBotonTablero(casilleros, tablero, jugador1, jugador2, coordenada));
        /*this.setOnMouseDragReleased(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                System.out.println("hola");
            }//
        });*/
        /*this.setOnAction(MouseEvent ->{if (!(tablero.obtenerCasillero(coordenada).estaOcupado())) {
            this.setImage()
        }});*/
    }


}
