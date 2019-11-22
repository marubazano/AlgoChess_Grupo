package vista;

import Tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;


public class TableroVista extends Group {
    public static final double casilleroSize = 2;
    public static final int ancho = 20;
    public static final int alto = 20;

    private GridPane tableroGui;

    private Pane[][] panes;

    public TableroVista(Tablero tablero){
        tableroGui = new GridPane();
        panes = new Pane[ancho][alto];
        for(int i = 0; i < alto; i++ ){
            for(int j = 0; j < ancho; j++){
                Pane actual = new Pane();
                actual.setStyle("-fx-border-color: black");
                actual.setMinWidth(this.ancho * casilleroSize);
                actual.setMinHeight(this.alto * casilleroSize);
                panes[i][j] = actual;
                tableroGui.add(actual, i, j);
            }
        }
        this.agregarVista(tableroGui);
    }

    public void agregarVistaAlMapa(Node vista, int x, int y){
        //Primero saco todas las vistas actuales
        //Luego agrego la(s) deseada(s)
        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                try{
                    panes[j][i].getChildren().remove(vista); //Col/fila
                } catch(Exception e) {
                    //handle
                }
            }
        }
        panes[y][x].getChildren().add(0, vista);
    }

    public void agregarVista(Node vista){
        this.getChildren().add(vista);
    }

    public void updateVista(Node vista){
        this.getChildren().remove(vista);
        this.getChildren().add(vista);
    }
}
