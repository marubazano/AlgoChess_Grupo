package Controlador;

import Jugador.Jugador;
import Tablero.Casillero;
import Tablero.Coordenada;
import Unidades.SoldadoDeInfanteria;
import Unidades.Unidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class HandlerCasilleroJugar implements EventHandler<MouseEvent> {
    private Jugador jugador1;
    private Jugador jugador2;
    private ControladorFlujoJuego controlador;
    private Casillero casillero;
    private Coordenada coordenada;

    public HandlerCasilleroJugar(Jugador jugador1, Jugador jugador2, ControladorFlujoJuego controlador, Casillero casillero, Coordenada coordenada){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.controlador = controlador;
        this.casillero = casillero;
        this.coordenada = coordenada;
    }

    public void handleJugar(MouseEvent mouseEvent){
        if(jugador1.esTurno()) {
            if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
                if(casillero.obtenerUnidad() instanceof SoldadoDeInfanteria && jugador1.obtenerListaUnidades().contains(casillero.obtenerUnidad())){
                    controlador.guardarABatallon(casillero.obtenerUnidad());
                    this.controlador.cambiarLabelEstadoDeJuego("Se agregó el SoldadoDeInfantería al batallón.");
                    return;
                }
                else if(controlador.obtenerListaBatallon().size() == 3){
                    controlador.moverBatallon(coordenada, jugador1);
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    this.controlador.cambiarLabelTurno(jugador2);
                    this.controlador.cambiarLabelEstadoDeJuego("Se movió el batallón.");
                    return;
                }
            }
            else{
                if (controlador.obtenerSeleccionada() == null && jugador1.obtenerListaUnidades().contains(casillero.obtenerUnidad())) {
                    controlador.seleccionarUnidad(casillero.obtenerUnidad());
                    controlador.cambiarLabelEstadoDeJuego("Se seleccionó la unidad " + casillero.obtenerUnidad().getClass().getSimpleName() + ".");
                }
                else if(jugador1.obtenerListaUnidades().contains(controlador.obtenerSeleccionada())){
                    controlador.accionUnidad(coordenada, jugador1);
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    this.controlador.cambiarLabelTurno(jugador2);
                }
            }
        }
        else if(jugador2.esTurno()) {
            if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
                if(casillero.obtenerUnidad() instanceof SoldadoDeInfanteria && jugador2.obtenerListaUnidades().contains(casillero.obtenerUnidad())){
                    controlador.guardarABatallon(casillero.obtenerUnidad());
                    this.controlador.cambiarLabelEstadoDeJuego("Se agregó el SoldadoDeInfantería al batallón.");
                    return;
                }
                else if(controlador.obtenerListaBatallon().size() == 3){
                    controlador.moverBatallon(coordenada, jugador2);
                    jugador1.asignarTurno(true);
                    jugador2.asignarTurno(false);
                    this.controlador.cambiarLabelTurno(jugador1);
                    this.controlador.cambiarLabelEstadoDeJuego("Se movió el batallón.");
                    return;
                }
            }
            if (controlador.obtenerSeleccionada() == null && jugador2.obtenerListaUnidades().contains(casillero.obtenerUnidad())) {
                controlador.seleccionarUnidad(casillero.obtenerUnidad());
                controlador.cambiarLabelEstadoDeJuego("Se seleccionó la unidad " + casillero.obtenerUnidad().getClass().getSimpleName() + ".");
            }
            else if(jugador2.obtenerListaUnidades().contains(controlador.obtenerSeleccionada())){
                controlador.accionUnidad(coordenada, jugador2);
                jugador1.asignarTurno(true);
                jugador2.asignarTurno(false);
                this.controlador.cambiarLabelTurno(jugador1);
            }
        }
    }

    public void handleUbicar(Jugador jugador1, Jugador jugador2){
        Unidad ultimaComprada = controlador.obtenerUltimaUnidadComprada();
        if (jugador1.esTurno()){
            if (jugador1.ubicarUnidad(ultimaComprada, coordenada)) {
                controlador.cambiarUltimaUnidadComprada(null);
                if (jugador2.obtenerPuntos() > 0) {
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    controlador.cambiarLabelTurno(jugador2);
                    controlador.cambiarLabelEstadoDeJuego("Seleccione unidad.");
                    controlador.habilitarBotonesUnidadDeJugador(jugador2);
                    return;
                }
                else {
                    controlador.cambiarLabelEstadoDeJuego("Seleccione unidad.");
                    controlador.habilitarBotonesUnidadDeJugador(jugador1);
                }
                if (jugador1.obtenerPuntos() == 0 && jugador2.obtenerPuntos() == 0) {
                    controlador.cambiarAPantallaDeJuego();
                    controlador.cambiarEstadoDeJuego(true);
                }
            } else {
                this.controlador.cambiarLabelEstadoDeJuego("Está ubicando la unidad en un casillero ocupado o del lado incorrecto del tablero. Pruebe en otro!");
            }
        }
        else {
            if (jugador2.ubicarUnidad(ultimaComprada, coordenada)) {
                controlador.cambiarUltimaUnidadComprada(null);
                if (jugador1.obtenerPuntos() > 0) {
                    jugador1.asignarTurno(true);
                    jugador2.asignarTurno(false);
                    controlador.cambiarLabelTurno(jugador1);
                    controlador.cambiarLabelEstadoDeJuego("Seleccione unidad.");
                    controlador.habilitarBotonesUnidadDeJugador(jugador1);
                    return;
                }
                controlador.cambiarLabelEstadoDeJuego("Seleccione unidad.");
                controlador.habilitarBotonesUnidadDeJugador(jugador2);
                if (jugador1.obtenerPuntos() == 0 && jugador2.obtenerPuntos() == 0) {
                    controlador.cambiarAPantallaDeJuego();
                    controlador.cambiarEstadoDeJuego(true);
                }
            } else {
                this.controlador.cambiarLabelEstadoDeJuego("Está ubicando la unidad en un casillero ocupado o del lado incorrecto del tablero. Pruebe en otro!");
            }
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(controlador.obtenerEstadoJuego()){ //Si todavia no estamos jugando, estamos en la seleccion de unidades
            handleJugar(mouseEvent);
        }
        else{
            handleUbicar(jugador1, jugador2);
        }
    }
}