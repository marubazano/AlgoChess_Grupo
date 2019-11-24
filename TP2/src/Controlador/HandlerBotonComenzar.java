package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vista.BotonJugar;

public class HandlerBotonComenzar implements EventHandler<ActionEvent> {
    HBox hbox;

    public HandlerBotonComenzar(HBox hbox){
        this.hbox = hbox;
    }

    @Override
    public void handle(ActionEvent evento){
        BotonJugar jugar = new BotonJugar(hbox);

        TextField jugador1 = new TextField("Ingrese nombre jugador 1");
        TextField jugador2 = new TextField("Ingrese nombre jugador 2");
        jugador1.setMaxWidth(220);
        jugador2.setMaxWidth(220);

        VBox panelNombreJugadores = new VBox(40);
        panelNombreJugadores.setAlignment(Pos.CENTER);
        panelNombreJugadores.getChildren().addAll(jugador1, jugador2, jugar);

        hbox.getChildren().add(panelNombreJugadores);
        hbox.getChildren().remove(0);
        evento.consume();
    }

}
