package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

public class HandlerBotonJugar implements EventHandler<ActionEvent> {
    StackPane stackPane;

    public HandlerBotonJugar(StackPane stackPane){
        this.stackPane = stackPane;
    }

    @Override
    public void handle(ActionEvent evento){

    }
}
