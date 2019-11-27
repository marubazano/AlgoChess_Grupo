package vista;

import AlgoChess.Jugador;
import Controlador.HandlerBotonTablero;
import Tablero.Coordenada;
import javafx.scene.control.Button;

public class BotonTablero extends Button {

    //private CasilleroVista[][] casilleros;
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean estado = false;

    public BotonTablero(TableroVista tableroVista, Coordenada coordenada, Jugador jugador1, Jugador jugador2) {
        super();
        this.setPrefSize(33,33);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.setOnMouseClicked(new HandlerBotonTablero(tableroVista, coordenada, this, jugador1, jugador2));
//        this.setOnMouseClicked(new HandlerBotonTablero(casilleros, tablero, jugador1, jugador2, coordenada));
        /*this.setOnMouseDragReleased(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                System.out.println("hola");
            }
        });*/
        /*this.setOnAction(MouseEvent ->{if (!(tablero.obtenerCasillero(coordenada).estaOcupado())) {
            this.setImage()
        }});*/
    }

}
