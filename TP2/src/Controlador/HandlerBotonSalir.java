package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerBotonSalir implements EventHandler<ActionEvent> {
    public HandlerBotonSalir(){}

    @Override
    public void handle(ActionEvent evento){
        System.exit(0);
    }
}
