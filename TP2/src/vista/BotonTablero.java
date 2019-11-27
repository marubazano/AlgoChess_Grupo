package vista;

import Controlador.HandlerBotonTablero;
import Tablero.Casillero;
import Tablero.Coordenada;
import javafx.scene.control.Button;

public class BotonTablero extends Button {

    private CasilleroVista[][] casilleros;

    public BotonTablero(TableroVista tableroVista, CasilleroVista casilleroVista, Coordenada coordenada) {
        super();
        this.setPrefSize(33,33);
        this.setOnMouseClicked(new HandlerBotonTablero(tableroVista, casilleroVista, coordenada));

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
