package vista;

import AlgoChess.Jugador;
import Tablero.Tablero;
import Tablero.Casillero;
import Tablero.Coordenada;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;


public class TableroVista extends Group {
    public static final double casilleroSize = 2;
    public static final int ancho = 20;
    public static final int alto = 20;
    Tablero tablero;

    Jugador jugador1;
    Jugador jugador2;

    private GridPane tableroGui;

    private CasilleroVista[][] casillero;

    public TableroVista(Tablero tablero, Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        tableroGui = new GridPane();
        for(int i = 1; i <= alto; i++) {
            for(int j = 1; j <= ancho; j++) {
                Coordenada coordenada = new Coordenada(i, j);
                Casillero casillero = tablero.obtenerCasillero(coordenada);
                CasilleroVista casilleroVista = new CasilleroVista(casillero, jugador1, jugador2);
                tableroGui.add(casilleroVista,i,j);
            }
        }

        this.agregarVista(tableroGui);
    }

    public void agregarVista(Node vista){
        this.getChildren().add(vista);
    }

    public void updateVista(Node vista){
        this.getChildren().remove(vista);
        this.getChildren().add(vista);
    }
}
