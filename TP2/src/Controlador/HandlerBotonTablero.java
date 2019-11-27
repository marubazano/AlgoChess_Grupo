package Controlador;

import AlgoChess.Jugador;
import Tablero.Coordenada;
import Tablero.Tablero;
import Unidades.Curandero;
import Unidades.Jinete;
import Unidades.SoldadoDeInfanteria;
import Unidades.Unidad;
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
        Unidad unidad = tableroVista.obtenerUltimaComprada();
        if (!jugador1.esTurno()) {
            if (jugador1.ubicarUnidad(unidad, coordenada)){
                System.out.print(tablero.tableroEstaVacio());
                tableroVista.agregarUltimaUnidadComprada(null);
                this.mostrarCasillero(unidad);

            }
        }else{
            if (jugador2.ubicarUnidad(unidad, coordenada)){
                System.out.print(tablero.tableroEstaVacio());
                tableroVista.agregarUltimaUnidadComprada(null);
                this.mostrarCasillero(unidad);
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
