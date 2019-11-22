package Controlador;

import Tablero.Tablero;
import Tablero.Direccion;
import Unidades.Movible;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class ControladorTeclado implements EventHandler<KeyEvent> {

    /*
     * ControladorTeclado implementa un event handler, interfaz que tiene el metodo
     * handle. Handle reconoce un evento, en este caso un key event del teclado
     * y en base al codigo de ese evento realiza una accion. Aca si tocamos w
     * el controlador, que guarda una ref a una unidad movible y al tablero (ambos del modelo)
     * mueve a la unidad en la direccion de w (arriba). Idem con las otras teclas
     * Esto es mas a modo de test de la funcionalidad del tablero que de como tendria que ser
     * para la prox entrega, pero sirve para ver como funcionan los eventos.
     */

    private Movible unidadMovible;
    private Tablero tablero;



    public ControladorTeclado(Movible unidadMovible, Tablero tablero){
        this.unidadMovible = unidadMovible;
        this.tablero = tablero;
    }

    @Override
    public void handle(KeyEvent evento){
        try{
            if(evento.getCode() == KeyCode.W){
                tablero.mover(unidadMovible, Direccion.ARRIBA);
            }
            if(evento.getCode() == KeyCode.A){
                tablero.mover(unidadMovible, Direccion.IZQUIERDA);

            }
            if(evento.getCode() == KeyCode.D){
                tablero.mover(unidadMovible, Direccion.DERECHA);

            }
            if(evento.getCode() == KeyCode.S){
                tablero.mover(unidadMovible, Direccion.ABAJO);
            }
            evento.consume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
