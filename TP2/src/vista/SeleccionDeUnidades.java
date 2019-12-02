package vista;

import Controlador.ControladorFlujoJuego;
import Controlador.ControladorPrincipal;
import Jugador.Jugador;
import Unidades.Unidad;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class SeleccionDeUnidades {
    Jugador jugador1;
    Jugador jugador2;
    ControladorPrincipal controladorPrincipal;
    ControladorFlujoJuego controladorFlujoJuego;
    Label puntajeJugador1;
    Label puntajeJugador2;

    BotonUnidad gatoSoldado;
    BotonUnidad gatoJinete;
    BotonUnidad gatoCurandero;
    BotonUnidad gatoCatapulta;
    BotonUnidad perroSoldado;
    BotonUnidad perroJinete;
    BotonUnidad perroCurandero;
    BotonUnidad perroCatapulta;

    public SeleccionDeUnidades(Jugador jugador1, Jugador jugador2, ControladorPrincipal controladorPrincipal, Label puntajeJugador1, Label puntajeJugador2, ControladorFlujoJuego controladorFlujoJuego) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.controladorPrincipal = controladorPrincipal;
        this.controladorFlujoJuego = controladorFlujoJuego;
        this.puntajeJugador1 = puntajeJugador1;
        this.puntajeJugador2 = puntajeJugador2;
        jugador1.asignarTurno(true);
        jugador2.asignarTurno(false);
        this.gatoSoldado = new BotonUnidad("imagenes/gato_soldado_precio.png", "soldado", jugador1, jugador2, this);
        this.gatoJinete = new BotonUnidad("imagenes/gato_jinete_precio.png", "jinete", jugador1, jugador2, this);
        this.gatoCurandero = new BotonUnidad("imagenes/gato_curandero_precio.png", "curandero", jugador1, jugador2, this);
        this.gatoCatapulta = new BotonUnidad("imagenes/gato_catapulta_precio.png", "catapulta", jugador1, jugador2, this);
        this.perroSoldado = new BotonUnidad("imagenes/perro_soldado_precio.png", "soldado", jugador2, jugador1, this);
        this.perroJinete = new BotonUnidad("imagenes/perro_jinete_precio.png", "jinete", jugador2, jugador1, this);
        this.perroCurandero = new BotonUnidad("imagenes/perro_curandero_precio.png", "curandero", jugador2, jugador1, this);
        this.perroCatapulta = new BotonUnidad("imagenes/perro_catapulta_precio.png", "catapulta", jugador2, jugador1, this);
    }

    public ArrayList<BotonUnidad> unidadesPosiblesJugador1() { //VER SI ESTOY INSTANCIANDO UNIDAD O EN ALGÚN LUGAR TIENE QUE APARECER new();
        ArrayList<BotonUnidad> listaBotones1 = new ArrayList<>();
        listaBotones1.add(gatoSoldado);
        listaBotones1.add(gatoCurandero);
        listaBotones1.add(gatoJinete);
        listaBotones1.add(gatoCatapulta);
        return listaBotones1;
    }

    public ArrayList<BotonUnidad> unidadesPosiblesJugador2() {
        ArrayList<BotonUnidad> listaBotones2 = new ArrayList<>();
        listaBotones2.add(perroSoldado);
        listaBotones2.add(perroCurandero);
        listaBotones2.add(perroJinete);
        listaBotones2.add(perroCatapulta);
        return listaBotones2;
    }

    public void cambiarUltimaUnidadComprada(Unidad ultimaUnidadComprada) {
        this.controladorFlujoJuego.cambiarUltimaUnidadComprada(ultimaUnidadComprada);
    }

    public void cambiarLabelEstadoDeJuego(String mensaje) {
        this.controladorPrincipal.cambiarLabelEstadoDeJuego(mensaje);
    }

    public void cambiarLabelPuntajeJugador(Jugador jugador) {
        if (jugador == jugador1) {
            this.puntajeJugador1.setText("Puntaje " + jugador.obtenerNombre() + ": " + jugador.obtenerPuntos());
        } else {
            this.puntajeJugador2.setText("Puntaje " + jugador.obtenerNombre() + ": " + jugador.obtenerPuntos());
        }
    }

    public void deshabilitarBotonesUnidadDeJugador(Jugador jugador) {
        if (jugador.obtenerNumeroJugador() == 1) {
            for (BotonUnidad boton : unidadesPosiblesJugador1()){
                boton.setDisable(true);
            }
        } else {
            for (BotonUnidad boton : unidadesPosiblesJugador2()){
                boton.setDisable(true);
            }
        }
    }

    public void habilitarBotonesUnidadDeJugador(Jugador jugador) {
        if (jugador.obtenerNumeroJugador() == 1) {
            int puntosJugador1 = jugador1.obtenerPuntos();
            for (BotonUnidad boton : unidadesPosiblesJugador1()){
                if (boton.obtenerUnidad().obtenerCosto() <= puntosJugador1) {
                    boton.setDisable(false);
                } else {
                    boton.setDisable(true);
                }
            }
        } else {
            int puntosJugador2 = jugador2.obtenerPuntos();
            for (BotonUnidad boton : unidadesPosiblesJugador2()){
                if (boton.obtenerUnidad().obtenerCosto() <= puntosJugador2) {
                    boton.setDisable(false);
                } else {
                    boton.setDisable(true);
                }
            }
        }
    }
}
