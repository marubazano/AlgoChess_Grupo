package vista;

import Jugador.Jugador;
import Controlador.ControladorFlujoJuego;
import Tablero.Coordenada;
import Tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;


public class TableroVista extends Group {
    public static final int ancho = 20;
    public static final int alto = 20;

    public GridPane tableroGui;
    private CasilleroVista[][] casilleros;

    public TableroVista(Tablero tablero, Jugador jugador1, Jugador jugador2, ControladorFlujoJuego controlador){
        tableroGui = new GridPane();
        casilleros = new CasilleroVista[ancho][alto];
        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                Coordenada coordenada = new Coordenada(i+1, j+1);
                CasilleroVista nuevo = new CasilleroVista(tablero.obtenerCasillero(coordenada), jugador1, jugador2, coordenada, controlador);
                if (i < 10) {
                    nuevo.setStyle("    -fx-background-color: black, #fcd18b ;" +
                            "-fx-background-insets: 0, 0 1 1 0 ;");
                } else if (i >= 10) {
                    nuevo.setStyle("    -fx-background-color: black, #a3cbf8 ;" +
                            "-fx-background-insets: 0, 0 1 1 0 ;");
                }
                tablero.obtenerCasillero(coordenada).agregarObservador(nuevo);
                nuevo.setPrefSize(30,30);
                casilleros[i][j] = nuevo;
                tableroGui.add(nuevo, j, i);
            }
        }
        //tableroGui.setPrefSize(400,400);
        agregarVista(tableroGui);
    }

    private void agregarVista(GridPane tableroGui) {
        this.getChildren().add(tableroGui);
    }
}

