package Controlador;

import AlgoChess.Jugador;
import Excepciones.AccionInvalidaException;
import Tablero.Direccion;
import Tablero.Tablero;
import Unidades.Catapulta;
import Unidades.Movible;
import Unidades.Unidad;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import vista.BotonTablero;
import vista.TableroVista;

public class HandlerBotonTablero implements EventHandler<MouseEvent> {

    private TableroVista tableroVista;
    private Tablero tablero;
    private BotonTablero botonTablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Label labelPuntajeJugador1;
    private Label labelPuntajeJugador2;

    public HandlerBotonTablero(TableroVista tableroVista, BotonTablero botonTablero, Jugador jugador1, Jugador jugador2, Label labelPuntajeJugador1, Label labelPuntajeJugador2){
        super();
        this.tableroVista = tableroVista;
        this.tablero = tableroVista.obtenerTablero();
        this.botonTablero = botonTablero;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.labelPuntajeJugador1 = labelPuntajeJugador1;
        this.labelPuntajeJugador2 = labelPuntajeJugador2;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(!tableroVista.estaJugando()){
            handleSeleccionarUnidad();
        } else {
            if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
                //handleBatallon();
            }
            else{
                if (jugador1.esTurno()) {
                    handleJuego(mouseEvent, jugador1, jugador2);
                } else {
                    handleJuego(mouseEvent, jugador2, jugador1);
                }

            }
        }
    }

    public void handleSeleccionarUnidad(){
        Unidad unidad = tableroVista.obtenerUltimaComprada();
        tableroVista.agregarUltimaUnidadComprada(null);
        if (jugador1.esTurno()) {
            tableroVista.deshabilitarLadoTablero(2);
            tableroVista.deshabilitarBotonesUnidadDeJugador(2);
            if (jugador1.ubicarUnidad(unidad, botonTablero.obtenerCoordenada())){
                labelPuntajeJugador1.setText("Puntaje " + jugador1.obtenerNombre() + ": " + jugador1.obtenerPuntos());
                tableroVista.agregarUltimaUnidadComprada(null);
                botonTablero.mostrarCasillero(unidad);
                if (jugador1.obtenerPuntos() == 0 && jugador2.obtenerPuntos() == 0){
                    // PASA A PANTALLA DE JUGAR PORQUE AMBOS SE QUEDAN SIN PUNTOS
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    tableroVista.cambiarEstado();
                    tableroVista.cambiarLabelTurno(jugador2.obtenerNombre());
                    tableroVista.habilitarLadoTablero(1);
                    tableroVista.habilitarLadoTablero(2);
                    tableroVista.pantallaDeJuego(jugador2.obtenerNombre());
                }
                else if (jugador2.obtenerPuntos() == 0 || jugador1.obtenerPuntos() == 0) {
                    if (jugador1.obtenerPuntos() == 0) {
                        // PASA TURNO A JUGADOR 2 Y NO VUELVE PORQUE JUGADOR 1 NO TIENE MÁS PUNTOS
                        jugador1.asignarTurno(false);
                        jugador2.asignarTurno(true);
                        tableroVista.cambiarLabelTurno(jugador2.obtenerNombre());
                        tableroVista.deshabilitarLadoTablero(1);
                        tableroVista.habilitarLadoTablero(2);
                        tableroVista.deshabilitarBotonesUnidadDeJugador(1);
                        tableroVista.habilitarBotonesUnidadDeJugador(2);
                    }
                    else {
                        // SE QUEDA SELECCIONANDO EN JUGADOR 1 PORQUE JUGADOR 2 NO TIENE PUNTOS

                        jugador1.asignarTurno(true);
                        jugador2.asignarTurno(false);
                        tableroVista.cambiarLabelTurno(jugador1.obtenerNombre());
                        tableroVista.habilitarLadoTablero(1);
                        tableroVista.deshabilitarLadoTablero(2);
                        tableroVista.habilitarBotonesUnidadDeJugador(1);
                        tableroVista.deshabilitarBotonesUnidadDeJugador(2);
                    }
                } else {
                    // PASA EL TURNO A JUGADOR 2 (AMBOS SIGUEN CON PUNTOS)
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    tableroVista.cambiarLabelTurno(jugador2.obtenerNombre());
                    tableroVista.deshabilitarLadoTablero(1);
                    tableroVista.habilitarLadoTablero(2);
                    tableroVista.deshabilitarBotonesUnidadDeJugador(1);
                    tableroVista.habilitarBotonesUnidadDeJugador(2);
                }
                tableroVista.cambiarLabelDeAccionDelTurno("");
            }
            else {
                tableroVista.cambiarLabelDeAccionDelTurno("El casillero está ocupado. Pruebe en otro!");
            }
        } else {
            tableroVista.deshabilitarLadoTablero(1);
            tableroVista.deshabilitarBotonesUnidadDeJugador(1);
            if (jugador2.ubicarUnidad(unidad,  botonTablero.obtenerCoordenada())){
                labelPuntajeJugador2.setText("Puntaje " + jugador2.obtenerNombre() + ": " + jugador2.obtenerPuntos());
                tableroVista.agregarUltimaUnidadComprada(null);
                botonTablero.mostrarCasillero(unidad);
                if (jugador1.obtenerPuntos() == 0 && jugador2.obtenerPuntos() == 0){
                    // PASA A PANTALLA DE JUGAR PORQUE AMBOS SE QUEDAN SIN PUNTOS
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    tableroVista.cambiarEstado();
                    tableroVista.cambiarLabelTurno(jugador2.obtenerNombre());
                    tableroVista.habilitarLadoTablero(1);
                    tableroVista.habilitarLadoTablero(2);
                    tableroVista.pantallaDeJuego(jugador2.obtenerNombre());
                }
                else if (jugador2.obtenerPuntos() == 0 || jugador1.obtenerPuntos() == 0) {
                    if (jugador1.obtenerPuntos() == 0){
                        // SE QUEDA SELECCIONANDO EN JUGADOR 2 PORQUE JUGADOR 1 NO TIENE PUNTOS
                        jugador1.asignarTurno(false);
                        jugador2.asignarTurno(true);
                        tableroVista.cambiarLabelTurno(jugador2.obtenerNombre());
                        tableroVista.deshabilitarLadoTablero(1);
                        tableroVista.habilitarLadoTablero(2);
                        tableroVista.deshabilitarBotonesUnidadDeJugador(1);
                        tableroVista.habilitarBotonesUnidadDeJugador(2);
                    }
                    else {
                        // PASA TURNO A JUGADOR 1 Y NO VUELVE PORQUE JUGADOR 2 NO TIENE MÁS PUNTOS
                        jugador1.asignarTurno(true);
                        jugador2.asignarTurno(false);
                        tableroVista.cambiarLabelTurno(jugador1.obtenerNombre());
                        tableroVista.habilitarLadoTablero(1);
                        tableroVista.deshabilitarLadoTablero(2);
                        tableroVista.habilitarBotonesUnidadDeJugador(1);
                        tableroVista.deshabilitarBotonesUnidadDeJugador(2);
                    }
                }else {
                    // PASA EL TURNO A JUGADOR 2 (AMBOS SIGUEN CON PUNTOS)
                    jugador1.asignarTurno(true);
                    jugador2.asignarTurno(false);
                    tableroVista.cambiarLabelTurno(jugador1.obtenerNombre());
                    tableroVista.habilitarLadoTablero(1);
                    tableroVista.deshabilitarLadoTablero(2);
                    tableroVista.habilitarBotonesUnidadDeJugador(1);
                    tableroVista.deshabilitarBotonesUnidadDeJugador(2);
                }
                tableroVista.cambiarLabelDeAccionDelTurno("");
            } else {
                tableroVista.cambiarLabelDeAccionDelTurno("El casillero está ocupado. Pruebe en otro!");
            }
        }
        System.out.println("coord vertical: " +  botonTablero.obtenerCoordenada().obtenerVertical() + " coord horizontal: " +  botonTablero.obtenerCoordenada().obtenerHorizontal());
    }


    public void handleJuego(MouseEvent mouseEvent, Jugador jugadorDeTurno, Jugador jugadorSiguiente) {
        Unidad unidadActual = tablero.obtenerCasillero(botonTablero.obtenerCoordenada()).obtenerUnidad();
        if (tableroVista.obtenerUnidadEsperando() == null) {
            // PRIMER CLIC JUGADOR
            if (!jugadorDeTurno.obtenerListaUnidades().contains(unidadActual) && unidadActual != null) {
                tableroVista.cambiarLabelDeAccionDelTurno("Está tratando de mover una pieza que no es tuya. Pruebe con otra!");
                return;
            } else if (unidadActual != null) {
                tableroVista.cambiarUnidadEsperando(unidadActual, botonTablero);
                tableroVista.cambiarLabelDeAccionDelTurno("Seleccionó la unidad: " + unidadActual.getClass().getSimpleName());
                return;
            } else if (unidadActual == null) {
                //NO HACE NADA
                tableroVista.cambiarLabelDeAccionDelTurno("Apretó un casillero vacío y eso no hace nada. Pruebe con otro!");
                return;
            }
        }
        if (tableroVista.obtenerUnidadEsperando() != null) {
            // SEGUNDO CLIC JUGADOR
            if (unidadActual == null) {
                // SI ENTRA ACÁ ES PORQUE VA A MOVER
                if (tableroVista.obtenerUnidadEsperando() instanceof Catapulta) {
                    // NO HACE NADA, NO SE MUEVE
                    tableroVista.cambiarUnidadEsperando(null, null);
                    tableroVista.cambiarLabelDeAccionDelTurno("No se puede mover la catapulta. Pruebe con otra acción!");
                    return;
                } else {
                    jugadorDeTurno.mover((Movible) tableroVista.obtenerUnidadEsperando(), Direccion.obtenerDireccionSegunCoordenadas(tableroVista.obtenerBotonTableroEsperando().obtenerCoordenada(), this.botonTablero.obtenerCoordenada()));
                    tableroVista.cambiarLabelDeAccionDelTurno("Movió la unidad " + tableroVista.obtenerUnidadEsperando().getClass().getSimpleName());
                    jugadorDeTurno.asignarTurno(false);
                    jugadorSiguiente.asignarTurno(true);
                    tableroVista.obtenerBotonTableroEsperando().setGraphic(null);
                    botonTablero.mostrarCasillero(tableroVista.obtenerUnidadEsperando());
                    tableroVista.cambiarUnidadEsperando(null, null);
                    tableroVista.cambiarLabelTurno(jugadorSiguiente.obtenerNombre());
                    return;
                }
            }
            else{
                // SI ENTRA ACÁ ES PORQUE VA A REALIZAR ACCIÓN SOBRE unidadActual (!= null)
                try {
                    jugadorDeTurno.realizarAccionDeUnidad(tableroVista.obtenerUnidadEsperando(), unidadActual,jugadorSiguiente);
                    tableroVista.cambiarLabelDeAccionDelTurno("Atacó a la unidad " + unidadActual.getClass().getSimpleName());
                    if (unidadActual.obtenerVida() <= 0){
                        Image imagen =  new Image(getClass().getResourceAsStream("/vista/imagenes/muerte.jpg"), 33, 33, false, false);
                        this.botonTablero.setGraphic(new ImageView(imagen));
                        this.botonTablero.setDisable(true);
                    }
                    jugadorDeTurno.asignarTurno(false);
                    jugadorSiguiente.asignarTurno(true);
                    tableroVista.cambiarUnidadEsperando(null, null);
                    tableroVista.cambiarLabelTurno(jugadorSiguiente.obtenerNombre());
                } catch (AccionInvalidaException e) {
                    e.getMensaje();
                }
            }
        }

        if (this.jugador1.obtenerCantidadUnidades() == 0){
            Alert cartel = new Alert(Alert.AlertType.INFORMATION);
            cartel.setTitle("Fin del juego");
            cartel.setContentText("SE ACABO EL JUEGO! EL GANADOR ES: "+jugador1.obtenerNombre());
            cartel.initStyle(StageStyle.UNDECORATED);
            cartel.showAndWait();
            System.exit(0);
        }
        else if (this.jugador2.obtenerCantidadUnidades() == 0){
            Alert cartel = new Alert(Alert.AlertType.INFORMATION);
            cartel.setTitle("Fin del juego");
            cartel.setContentText("SE ACABO EL JUEGO! EL GANADOR ES: "+jugador2.obtenerNombre());
            cartel.initStyle(StageStyle.UNDECORATED);
            cartel.showAndWait();
            System.exit(0);
        }


    }

    /*private void handleBatallon()  {
        Unidad unidadActual = tablero.obtenerCasillero(botonTablero.obtenerCoordenada()).obtenerUnidad();
        if(unidadActual instanceof SoldadoDeInfanteria){
            if(this.tableroVista.obtenerListaBatallon().size() <= 2)
                this.tableroVista.obtenerListaBatallon().add((Movible) unidadActual);
            else{
                System.out.println("Se creara el batallon");
                try {
                    Batallon batallon = new Batallon(this.tableroVista.obtenerListaBatallon().get(0),
                        this.tableroVista.obtenerListaBatallon().get(1),
                        this.tableroVista.obtenerListaBatallon().get(2));
                    batallon.mover(tableroVista.obtenerTablero(),
                            Direccion.obtenerDireccionSegunCoordenadas(this.tableroVista.obtenerListaBatallon().get(1).obtenerCoordenada(),
                                    this.botonTablero.obtenerCoordenada()));
                    System.out.println("El batallon se movio, supuestamente");
                    this.botonTablero.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/vista/imagenes/gato_soldado.jpg"), 33, 33, false, false)));
                } catch (BatallonInvalidoException e) {
                    e.getMessage();
                }
                this.tableroVista.obtenerListaBatallon().clear();
            }
        }
    }*/




}
