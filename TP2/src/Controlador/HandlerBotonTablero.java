package Controlador;

import AlgoChess.Jugador;
import Excepciones.AccionInvalidaException;
import Tablero.Coordenada;
import Tablero.Direccion;
import Tablero.Tablero;
import Unidades.*;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import vista.BotonTablero;
import vista.CasilleroVista;
import vista.TableroVista;

public class HandlerBotonTablero implements EventHandler<MouseEvent> {

    private CasilleroVista casilleroVista;
    private Coordenada coordenada;
    private TableroVista tableroVista;
    private Tablero tablero;
    private BotonTablero botonTablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Label labelPuntajeJugador1;
    private Label labelPuntajeJugador2;

    public HandlerBotonTablero(TableroVista tableroVista, Coordenada coordenada, BotonTablero botonTablero, Jugador jugador1, Jugador jugador2, Label labelPuntajeJugador1, Label labelPuntajeJugador2){
        super();
        this.tableroVista = tableroVista;
        this.coordenada = coordenada;
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
            handleJuego();
        }
    }


    public void handleSeleccionarUnidad(){
        System.out.println("Jugador 1 tiene: " + jugador1.obtenerListaUnidades());
        System.out.println("Jugador 2 tiene: " + jugador2.obtenerListaUnidades());
        Unidad unidad = tableroVista.obtenerUltimaComprada();
        if (jugador1.esTurno()) {
            System.out.println("Es turno de JUGADOR 1.");
            if (jugador1.ubicarUnidad(unidad, coordenada)){
                labelPuntajeJugador1.setText("Puntaje jugador 1: " + jugador1.obtenerPuntos());
                tableroVista.agregarUltimaUnidadComprada(null);
                //System.out.print(jugador1.obtenerPuntos());
                this.mostrarCasillero(unidad);
                if (jugador1.obtenerPuntos() == 0 && jugador2.obtenerPuntos() == 0){
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    tableroVista.cambiarEstado();
                    System.out.println("Arranca con turno TRUE el JUGADOR 2.");
                    tableroVista.pantallaDeJuego(jugador2.obtenerNombre());
                }
                else if (jugador2.obtenerPuntos() == 0 || jugador1.obtenerPuntos() == 0) {
                    if (jugador1.obtenerPuntos() == 0) {
                        System.out.println("Jugador 1 (perros) tiene 0 puntos y Jugador 2 (gatos) todavía tiene puntos.");
                        jugador1.asignarTurno(false);
                        jugador2.asignarTurno(true);
                    }
                    else {
                        System.out.println("Jugador 2 (gatos) tiene 0 puntos y Jugador 1 (perros) todavía tiene puntos.");
                        jugador1.asignarTurno(true);
                        jugador2.asignarTurno(false);
                    }
                } else {
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                }
            }
            else System.out.println("no la puede ubicar");
        } else {
            System.out.println("Es turno de JUGADOR 2.");
            if (jugador2.ubicarUnidad(unidad, coordenada)){
                labelPuntajeJugador2.setText("Puntaje jugador 2: " + jugador2.obtenerPuntos());
                tableroVista.agregarUltimaUnidadComprada(null);
                this.mostrarCasillero(unidad);
                if (jugador1.obtenerPuntos() == 0 && jugador2.obtenerPuntos() == 0){
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    tableroVista.cambiarEstado();
                    tableroVista.pantallaDeJuego(jugador2.obtenerNombre());

                }
                else if (jugador2.obtenerPuntos() == 0 || jugador1.obtenerPuntos() == 0) {
                    if (jugador1.obtenerPuntos() == 0){
                        jugador1.asignarTurno(false);
                        jugador2.asignarTurno(true);
                    }
                    else {
                        jugador1.asignarTurno(true);
                        jugador2.asignarTurno(false);
                    }
                }else {
                    jugador1.asignarTurno(true);
                    jugador2.asignarTurno(false);
                }
            }
        }
        System.out.println("coord vertical: " + coordenada.obtenerVertical() + " coord horizontal: " + coordenada.obtenerHorizontal());
    }


    public void handleJuego() {
        if(jugador1.obtenerEstado() == "PERDEDOR") {
            System.out.println("GANO EL JUGADOR 2");
            System.exit(0);
        }
        else if(jugador2.obtenerEstado() == "PERDEDOR"){
            System.out.println("GANO EL JUGADOR 1");
            System.exit(0);
        }
        Unidad unidadActual = tablero.obtenerCasillero(coordenada).obtenerUnidad();
        if (jugador1.esTurno()) {
            if (tableroVista.obtenerUnidadEsperando() == null) {
                // PRIMER CLIC JUGADOR 1
                if (!jugador1.obtenerListaUnidades().contains(unidadActual)) {
                    System.out.println("Estás tratando de mover una pieza que no es tuya.");
                    return;
                } else if (unidadActual != null) {
                    tableroVista.cambiarUnidadEsperando(unidadActual, botonTablero);
                    //mostrarCasillero(null);
                    System.out.println("Guardé la unidad: " + unidadActual);
                    return;
                    /*botonTablero.setGraphic(null);
                    tablero.obtenerCasillero(coordenada).vaciarCasillero();*/
                } else if (unidadActual == null) {
                    System.out.println("Apreté un casillero vacío y quería guardar algo.");
                    //NO HACE NADA
                    return;
                }
            }
            //System.out.println("la unidad guardada es " + unidad);
            //System.out.println("EL jugador es número " + jugador1.obtenerNombre());

            if (tableroVista.obtenerUnidadEsperando() != null) {
                // SEGUNDO CLIC JUGADOR 1
                if (unidadActual == null) {
                    // SI ENTRA ACÁ ES PORQUE VA A MOVER
                    if (tableroVista.obtenerUnidadEsperando() instanceof Catapulta) {
                        // NO HACE NADA, NO SE MUEVE
                        tableroVista.cambiarUnidadEsperando(null, null);
                        System.out.println("Estoy queriendo mover una catapulta");
                        return;
                    } else {
                        System.out.println("Entro a mover una unidad (no catapulta)");
                        jugador1.mover((Movible) tableroVista.obtenerUnidadEsperando(), Direccion.obtenerDireccionSegunCoordenadas(tableroVista.obtenerUnidadEsperando().obtenerCoordenada(), this.coordenada));
                        jugador1.asignarTurno(false);
                        jugador2.asignarTurno(true);
                        tableroVista.obtenerBotonTableroEsperando().setGraphic(null);
                        System.out.println("La unidad esperando, que es la que voy a mostrar en el nuevo casillero, es: " + tableroVista.obtenerUnidadEsperando());
                        this.mostrarCasillero(tableroVista.obtenerUnidadEsperando());
                        tableroVista.cambiarUnidadEsperando(null, null);
                        tableroVista.cambiarLabelTurno(jugador2.obtenerNombre());
                        return;
                    }
                }
                else{
                    // Si entro aca es porque va a realizar accion (unidad actual != null)
                    try {
                        System.out.println("Voy a realizar una accion sobre la unidad con vida: " + unidadActual.obtenerVida());
                        jugador1.realizarAccionDeUnidad(tableroVista.obtenerUnidadEsperando(), unidadActual,jugador2);
                        if (unidadActual.obtenerVida()<=0){ //la unidad realizo la morision y ser DEFETEADA
                            System.out.println("La unidad ha muerto");
                            this.botonTablero.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/vista/imagenes/muerte.jpg"), 33, 33, false, false)));
                            this.botonTablero.setDisable(true);

                            //    tablero.obtenerCasillero(coordenada).vaciarCasillero();
                        }
                        jugador1.asignarTurno(false);
                        jugador2.asignarTurno(true);
                        tableroVista.cambiarUnidadEsperando(null, null);
                        System.out.println("Realice una accion sobre la unidad y su vida es: " +  unidadActual.obtenerVida());
                        tableroVista.cambiarLabelTurno(jugador2.obtenerNombre());
                    } catch (AccionInvalidaException e) {
                        e.getMensaje();
                    }
                }
            }
        } else {
            if (tableroVista.obtenerUnidadEsperando() == null) {
                // PRIMER CLIC JUGADOR 2
                if (!jugador2.obtenerListaUnidades().contains(unidadActual)) {
                    System.out.println("Estás tratando de mover una pieza que no es tuya (jug2).");
                    return;
                } else if (unidadActual != null) {
                    tableroVista.cambiarUnidadEsperando(unidadActual, botonTablero);
                    //mostrarCasillero(null);
                    System.out.println("Guardé la unidad: " + unidadActual + " (jug2).");
                    return;
                /*botonTablero.setGraphic(null);
                tablero.obtenerCasillero(coordenada).vaciarCasillero();*/
                } else if (unidadActual == null) {
                    System.out.println("Apreté un casillero vacío y quería guardar algo (jug2).");
                    //NO HACE NADA
                    return;
                }
            }
            //System.out.println("la unidad guardada es " + unidad);
            //System.out.println("EL jugador es número " + jugador1.obtenerNombre());

            if (tableroVista.obtenerUnidadEsperando() != null) {
                // SEGUNDO CLIC JUGADOR 2
                if (unidadActual == null) {
                    // SI ENTRA ACÁ ES PORQUE VA A MOVER
                    if (tableroVista.obtenerUnidadEsperando() instanceof Catapulta) {
                        // NO HACE NADA, NO SE MUEVE
                        tableroVista.cambiarUnidadEsperando(null, null);
                        System.out.println("Estoy queriendo mover una catapulta (jug2).");
                        return;
                    } else {
                        System.out.println("Entro a mover una unidad (no catapulta) (jug2)");
                        System.out.println("Coordenada direccion esperando: "+tableroVista.obtenerUnidadEsperando().obtenerCoordenada());
                        System.out.println("this.coordenada: "+this.coordenada);
                        System.out.println("Direccion: "+Direccion.obtenerDireccionSegunCoordenadas(tableroVista.obtenerUnidadEsperando().obtenerCoordenada(), this.coordenada));
                        jugador2.mover((Movible) tableroVista.obtenerUnidadEsperando(), Direccion.obtenerDireccionSegunCoordenadas(tableroVista.obtenerUnidadEsperando().obtenerCoordenada(), this.coordenada));
                        jugador1.asignarTurno(true);
                        jugador2.asignarTurno(false);
                        tableroVista.obtenerBotonTableroEsperando().setGraphic(null);
                        System.out.println("La unidad esperando, que es la que voy a mostrar en el nuevo casillero, es: " + tableroVista.obtenerUnidadEsperando() + " (jug2).");
                        this.mostrarCasillero(tableroVista.obtenerUnidadEsperando());
                        tableroVista.cambiarUnidadEsperando(null, null);
                        tableroVista.cambiarLabelTurno(jugador1.obtenerNombre());
                        return;
                    }
                }
                else{
                    // Si entro aca es porque va a realizar accion (unidad actual != null)
                    try {
                        System.out.println("Voy a realizar una accion sobre la unidad con vida: " + unidadActual.obtenerVida());
                        jugador2.realizarAccionDeUnidad(tableroVista.obtenerUnidadEsperando(), unidadActual,jugador1);
                        System.out.println("Ahora la unidad tiene vida: " + unidadActual.obtenerVida());
                        if (unidadActual.obtenerVida()<=0){ //la unidad realizo la morision y ser DEFETEADA
                            System.out.println("La unidad ha muerto");
                            this.botonTablero.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/vista/imagenes/muerte.jpg"), 33, 33, false, false)));
                            this.botonTablero.setDisable(true);
                            //   tablero.obtenerCasillero(coordenada).vaciarCasillero();
                        }
                        jugador1.asignarTurno(true);
                        jugador2.asignarTurno(false);
//                        System.out.println("Realice una accion sobre la unidad y su vida es: " +  unidadActual.obtenerVida());
                        tableroVista.cambiarUnidadEsperando(null, null);
                        tableroVista.cambiarLabelTurno(jugador1.obtenerNombre());
                    } catch (AccionInvalidaException e) {
                        e.getMensaje();
                    }
                }
            }
        //   this.mostrarCasillero(unidad);
        }
    }


    public void mostrarCasillero(Unidad miUnidad) {
        Image unidad;
        if(miUnidad != null) {
            if (miUnidad instanceof SoldadoDeInfanteria) {
                if (jugador2.obtenerListaUnidades().contains(miUnidad)) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_soldado.jpg"), 33, 33, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_soldado.jpg"), 33, 33, false, false);
                }
            } else if (miUnidad instanceof Curandero) {
                if (jugador2.obtenerListaUnidades().contains(miUnidad)) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_curandero.jpg"), 33, 33, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_curandero.jpg"), 33, 33, false, false);
                }
            } else if (miUnidad instanceof Jinete) {
                if (jugador2.obtenerListaUnidades().contains(miUnidad)) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_jinete.jpg"), 33, 33, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_jinete.jpg"), 33, 33, false, false);
                }
            } else {
                if (jugador2.obtenerListaUnidades().contains(miUnidad)) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_catapulta.jpg"), 33, 33, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_catapulta.jpg"), 33, 33, false, false);
                }
            }

            ImageView imageView = new ImageView(unidad);
            botonTablero.setGraphic(imageView);
        }
        else{
            //botonTablero.setGraphic(null);
            System.out.print("Es null");
        }
    }

}
