package Controlador;

import AlgoChess.Jugador;
import Excepciones.PuntosInsuficientesException;
import Unidades.Unidad;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import vista.TableroVista;


public class HandlerBotonUnidad implements EventHandler<MouseEvent> {
    Unidad unidad;
    Jugador jugador;
    Jugador OtroJugador;
    Button boton;
    TableroVista tableroVista;

    public HandlerBotonUnidad(Unidad unidad, Jugador jugador, Jugador OtroJugador, Button boton, TableroVista tableroVista){
        this.unidad = unidad;
        this.jugador = jugador;
        this.OtroJugador = OtroJugador;
        this.boton = boton;
        this.tableroVista = tableroVista;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (jugador.esTurno()) {
            try {
                //System.out.println("Puntos antes de comprar: " + jugador.obtenerPuntos());
                jugador.comprar(unidad);
                tableroVista.deshabilitarBotonesUnidadDeJugador(jugador.obtenerNumeroJugador()); // PARA QUE NO COMPRE OTRA UNIDAD ANTES DE UBICAR LA ACTUAL
                System.out.println("COMPRÓ LA UNIDAD!!!");
                tableroVista.cambiarLabelDeAccionDelTurno("Compró la unidad"/* + unidad.getClass().getName()*/);
                //System.out.println("Puntos después de comprar: " + jugador.obtenerPuntos());
              //  System.out.print(jugador.obtenerPuntos() + " hola");
                tableroVista.agregarUltimaUnidadComprada(unidad);
                // UBICAR UNIDAD
               /* if (!jugador.tieneSuficientesPuntos(unidad)) {
                    this.boton.setDisable(true);
                }*/
               /* if (OtroJugador.obtenerPuntos() > 0) {//Si el otro jugador todavia tiene puntos -> puede comprar -> sino sigue comprando el que tenga
                    jugador.asignarTurno(false);
                    OtroJugador.asignarTurno(true);
                  //  System.out.println(OtroJugador.obtenerPuntos());
                }*/
            } catch (PuntosInsuficientesException e) {
                System.out.println("ENTRA A LA EXCEPCIÓN DE PUNTOS INSUFICIENTES!!!");
                //this.boton.setDisable(true);
                e.getMensaje();
            }
        } else {
            System.out.println("No es tu turno!");
        }
    }
}
