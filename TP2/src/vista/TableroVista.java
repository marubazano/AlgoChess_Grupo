package vista;

import Tablero.Coordenada;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashMap;

public class TableroVista {

    private GridPane tableroVista;
    private HashMap<Button, Coordenada> hashBotones;

    public TableroVista(){
        tableroVista = new GridPane();
        hashBotones = new HashMap<>();
        tableroVista.setPrefSize(50,50);
        tableroVista.setHgap(0);
        tableroVista.setVgap(0);

        for (int x = 1; x<=20; x++){
            for (int y = 1; y<=20; y++ ) {
                Button casillero = new Button();
                Text numero = new Text();
                numero.setFont(Font.font(10));
                numero.setText("("+x+","+y+")");
                tableroVista.add(new StackPane(casillero, numero), y, x);
                Coordenada coordenada = new Coordenada(x,y);
                hashBotones.put(casillero,coordenada);
                //casillero.setOnMouseClicked(event ->  );
            }
        }
    }

    public GridPane getTablero (){return this.tableroVista;}

    public HashMap getHashTablero(){return this.hashBotones;}
}
