package Controlador;

import Jugador.Jugador;
import Excepciones.BatallonInvalidoException;
import Tablero.Coordenada;
import Tablero.Direccion;
import Tablero.Tablero;
import Unidades.*;

import java.util.ArrayList;

public class ControladorFlujoJuego {
    private boolean jugando;
    private Unidad seleccionada;
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private ArrayList<Movible> batallon;
    private Unidad ultimaUnidadComprada;
    private ControladorPrincipal controladorPrincipal;

    public ControladorFlujoJuego(Jugador jugador1, Jugador jugador2, Tablero tablero, ControladorPrincipal controladorPrincipal){
        seleccionada = null;
        jugando = false;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        this.controladorPrincipal = controladorPrincipal;
        batallon = new ArrayList<>();
    }

    public void seleccionarUnidad(Unidad unidad){
        this.seleccionada = unidad;
    }

    public Unidad obtenerSeleccionada(){
        return seleccionada;
    }

    public void accionUnidad(Coordenada coordenada, Jugador jugador){
        if(jugador.esTurno()) {
            if (tablero.obtenerCasillero(coordenada).estaOcupado()) {
                System.out.println("Se esta realizando una accion");
                String mensaje = jugador.realizarAccionDeUnidad(seleccionada, tablero.obtenerCasillero(coordenada).obtenerUnidad());
                controladorPrincipal.cambiarLabelsInfoJugador();
                ArrayList<Unidad> muertasJugador1 = jugador1.checkearUnidadesMuertas();
                controladorPrincipal.borrarLabelsUnidad(jugador1, muertasJugador1);
                ArrayList<Unidad> muertasJugador2 = jugador2.checkearUnidadesMuertas();
                controladorPrincipal.borrarLabelsUnidad(jugador2, muertasJugador2);
                jugador1.actualizarEstadoJugador();
                jugador2.actualizarEstadoJugador();
                updateEstadoDeJuego(jugador1, jugador2);
                seleccionarUnidad(null);
                cambiarLabelEstadoDeJuego(mensaje);
                return;
            }
            if(jugador.obtenerListaUnidades().contains(seleccionada)) {
                if (seleccionada instanceof Catapulta) {
                    System.out.println("No podes mover una catapulta!");
                    cambiarLabelEstadoDeJuego("No puede mover una catapulta. Perdió el turno.");
                    seleccionarUnidad(null);
                    return;
                }
                String mensaje = jugador.mover((Movible) seleccionada, Direccion.obtenerDireccionSegunCoordenadas(seleccionada.obtenerCoordenada(), coordenada));
                cambiarLabelEstadoDeJuego(mensaje);
                controladorPrincipal.cambiarLabelsInfoJugador();
            }
            else{
                cambiarLabelEstadoDeJuego("No puede mover una unidad enemiga. Perdió el turno.");
                System.out.println("No podes mover una unidad enemiga");
            }
            seleccionarUnidad(null);
            return;
        }
    }

    public void guardarABatallon(Unidad soldado){
        batallon.add(((Movible) soldado));
    }

    public ArrayList<Movible> obtenerListaBatallon(){
        return batallon;
    }

    public void moverBatallon(Coordenada coordenada, Jugador jugador) {
        Batallon nuevo = null;
        try {
            nuevo = new Batallon(batallon.get(0),batallon.get(1), batallon.get(2));
            nuevo.mover(tablero,Direccion.obtenerDireccionSegunCoordenadas(batallon.get(1).obtenerCoordenada(), coordenada));
            controladorPrincipal.cambiarLabelsInfoJugador();
        } catch (BatallonInvalidoException e) {
            e.getMessage();
        }
        batallon.clear();
    }

    public void updateEstadoDeJuego(Jugador jugador1, Jugador jugador2){
        /*
          Negativity is my passion
         */
        if(jugador1.obtenerEstado() == "PERDEDOR"){
            controladorPrincipal.PantallaFinal(jugador2);
        }
        if(jugador2.obtenerEstado() == "PERDEDOR"){
            controladorPrincipal.PantallaFinal(jugador1);
        }
    }

    public void cambiarUltimaUnidadComprada(Unidad ultimaUnidadComprada) {
        this.ultimaUnidadComprada = ultimaUnidadComprada;
    }

    public Unidad obtenerUltimaUnidadComprada() {
        return this.ultimaUnidadComprada;
    }

    public void cambiarEstadoDeJuego(boolean jugando) {
        this.jugando = jugando;
    }

    public boolean obtenerEstadoJuego() {
        return this.jugando;
    }

    public void habilitarBotonesUnidadDeJugador(Jugador jugador) {
        this.controladorPrincipal.habilitarBotonesUnidadDeJugador(jugador);
    }

    public void cambiarAPantallaDeJuego() {
        this.controladorPrincipal.PantallaDeJuego();
    }

    public void cambiarLabelEstadoDeJuego(String mensaje) {
        this.controladorPrincipal.cambiarLabelEstadoDeJuego(mensaje);
    }

    public void cambiarLabelTurno(Jugador jugador) {
        this.controladorPrincipal.cambiarLabelTurno(jugador);
    }
}
