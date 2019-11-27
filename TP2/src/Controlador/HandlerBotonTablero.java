package Controlador;

import AlgoChess.Jugador;
import Tablero.Coordenada;
import Tablero.Tablero;
import Tablero.Direccion;
import Unidades.*;
import javafx.event.EventHandler;
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

    public HandlerBotonTablero(TableroVista tableroVista, Coordenada coordenada, BotonTablero botonTablero, Jugador jugador1, Jugador jugador2){
        super();
        this.tableroVista = tableroVista;
        this.coordenada = coordenada;
        this.tablero = tableroVista.obtenerTablero();
        this.botonTablero = botonTablero;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(!tableroVista.obtenerEstado()){
            handleSeleccionarUnidad();
        } else {
            handleJuego();
        }
    }

    public void handleJuego(){
        Unidad unidad = tablero.obtenerCasillero(coordenada).obtenerUnidad(); System.out.println("1 \n");
        if(tableroVista.obtenerUnidadEsperando() == null && unidad != null) {
            System.out.println("2 \n");
            tableroVista.cambiarUnidadEsperando(unidad);
            botonTablero.setGraphic(null);
            tablero.obtenerCasillero(coordenada).vaciarCasillero();
             System.out.println("3 \n");
        }
        else if(tableroVista.obtenerUnidadEsperando() != null && unidad == null) { //HAY QUE MOVER
            System.out.println("4 \n");
            if(jugador2.obtenerListaUnidades().contains(tableroVista.obtenerUnidadEsperando())){
                System.out.println("5 \n");
                jugador1.mover((Movible) tableroVista.obtenerUnidadEsperando(), Direccion.obtenerDireccionSegunCoordenadas(tableroVista.obtenerUnidadEsperando().obtenerCoordenada(),this.coordenada));
                jugador1.asignarTurno(false);
                jugador2.asignarTurno(true);
                this.mostrarCasillero(tableroVista.obtenerUnidadEsperando());
                tableroVista.cambiarUnidadEsperando(null);
                System.out.println("6 \n");
            }
            else{
                System.out.println("7 \n");
                jugador2.mover((Movible) tableroVista.obtenerUnidadEsperando(), Direccion.obtenerDireccionSegunCoordenadas(tableroVista.obtenerUnidadEsperando().obtenerCoordenada(),this.coordenada));
                jugador1.asignarTurno(true);
                jugador2.asignarTurno(false);
                this.mostrarCasillero(tableroVista.obtenerUnidadEsperando());
                tableroVista.cambiarUnidadEsperando(null);
                System.out.println("8 \n");
            }
            System.out.println("9 \n");
            tableroVista.cambiarUnidadEsperando(null);
        }
     //   this.mostrarCasillero(unidad);
    }

    public void handleSeleccionarUnidad(){
        Unidad unidad = tableroVista.obtenerUltimaComprada();
        if (jugador1.esTurno()) {
            if (jugador1.ubicarUnidad(unidad, coordenada)){
                tableroVista.agregarUltimaUnidadComprada(null);
                //System.out.print(jugador1.obtenerPuntos());
                this.mostrarCasillero(unidad);
                if (jugador1.obtenerPuntos() == 0 && jugador2.obtenerPuntos() == 0){
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    tableroVista.cambiarEstado();
                    tableroVista.pantallaDeJuego();
                }
                else if (jugador2.obtenerPuntos() == 0 || jugador1.obtenerPuntos() == 0) {
                    if (jugador1.obtenerPuntos() == 0) {
                        jugador1.asignarTurno(false);
                        jugador2.asignarTurno(true);
                    }
                    else {
                        jugador1.asignarTurno(true);
                        jugador2.asignarTurno(false);
                    }
                } else {
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                }
            }
        }else{
            if (jugador2.ubicarUnidad(unidad, coordenada)){
                tableroVista.agregarUltimaUnidadComprada(null);
                this.mostrarCasillero(unidad);
                if (jugador1.obtenerPuntos() == 0 && jugador2.obtenerPuntos() == 0){
                    jugador1.asignarTurno(false);
                    jugador2.asignarTurno(true);
                    tableroVista.cambiarEstado();
                    tableroVista.pantallaDeJuego();

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
        System.out.println(coordenada.obtenerVertical() + " " + coordenada.obtenerHorizontal());
    }

    public void mostrarCasillero(Unidad miUnidad) {
        Image unidad;
        if(miUnidad != null) {
            if (miUnidad instanceof SoldadoDeInfanteria) {
                if (!jugador1.esTurno()) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_soldado.jpg"), 33, 33, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_soldado.jpg"), 33, 33, false, false);
                }
            } else if (miUnidad instanceof Curandero) {
                if (!jugador1.esTurno()) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_curandero.jpg"), 33, 33, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_curandero.jpg"), 33, 33, false, false);
                }
            } else if (miUnidad instanceof Jinete) {
                if (!jugador1.esTurno()) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_jinete.jpg"), 33, 33, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_jinete.jpg"), 33, 33, false, false);
                }
            } else {
                if (!jugador1.esTurno()) {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/gato_catapulta.jpg"), 33, 33, false, false);
                } else {
                    unidad = new Image(getClass().getResourceAsStream("/vista/imagenes/perro_catapulta.jpg"), 33, 33, false, false);
                }
            }

            ImageView imageView = new ImageView(unidad);
            botonTablero.setGraphic(imageView);
        }
        else{
            System.out.print("Es null");
        }
    }

}
