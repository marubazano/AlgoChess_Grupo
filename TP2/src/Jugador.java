import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import Excepciones.PuntosInsuficientesException;
import Tablero.Tablero;
import Unidades.Movible;
import Unidades.Unidad;

import java.util.ArrayList;
import Tablero.*;
import Unidades.*;

public class Jugador {
    private String nombre;
    private ArrayList<Unidad> unidades;
    private Tablero tablero;
    private int puntos;
    private int nroJugador; // Valdra 1 o 2, segun el numero del jugador
    private String estado;

    public Jugador(String nombre, Tablero tablero, int nroJugador) {
        this.nombre = nombre;
        this.unidades = new ArrayList<>(); //Se declara así para poner cualquier objeto hijo
        this.tablero = tablero;
        this.puntos = 20;
        this.nroJugador = nroJugador;
        this.estado="JUGANDO";
    }

    public void agregarUnidadAJugador(Unidad unidad) {
        this.unidades.add(unidad);
    }

    public void eliminarUnidadDelJugador(Unidad unidad) {
        this.unidades.remove(unidad);
        if (unidades.size() == 0) this.estado="PERDEDOR";
    }

    public int obtenerCantidadUnidades() {
        return this.unidades.size();
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerPuntos() {
        return this.puntos;
    }

    //Métodos para comprar

    public boolean tieneSuficientesPuntos(Unidad unidad) {
        if (unidad.obtenerCosto() <= obtenerPuntos()) {
            return true;
        }
        return false;
    }

    public void comprar(Unidad unidad) throws PuntosInsuficientesException {
        if (tieneSuficientesPuntos(unidad)) {
            agregarUnidadAJugador(unidad);
            this.puntos -= unidad.obtenerCosto();
        }
        else {
            throw new PuntosInsuficientesException();
        }
    }

    public boolean ubicarUnidad(Unidad unidad, Coordenada coordenada) {
        try {
            if (!estaEnLadoDelTableroCorrespondiente(coordenada)) return false;
            tablero.ubicarUnidad(unidad, coordenada);
            agregarUnidadAJugador(unidad);
        }
        catch (CasilleroOcupadoException e) {
            e.getMensaje();
        }
        catch (CasilleroInvalidoException e) {
            e.getMensaje();
        }
        return true;
    }

    public void mover(Movible unidadMovible, Direccion direccion) {
        tablero.mover(unidadMovible, direccion);
    }

    public boolean estaEnLadoDelTableroCorrespondiente(Coordenada coordenada) {
        if (this.nroJugador == 1) {
            if (coordenada.obtenerVertical() <= 10) return true;
            return false;
        }
        if (coordenada.obtenerVertical() > 10) return true;
        return false;
    }

    public String obtenerEstado() {
        return this.estado;
    }

    public void realizarAccionDeUnidad(Unidad unaUnidad, Unidad otraUnidad){
        //Dos posibilidades:
        //1) Recibe un aliado y un enemigo, el aliado ataca al enemigo.
        //2) Recibe un Curandero (aliado) y un aliado, el curandero cura al aliado.
        if (esCurandero(unaUnidad)) realizarAccionDeCurandero(unaUnidad,otraUnidad);
        else realizarAccionDeUnidadDeAtaque(unaUnidad, otraUnidad);
    }

    public void realizarAccionDeUnidadDeAtaque (Unidad unaUnidad, Unidad otraUnidad){
        if (this.unidades.contains(otraUnidad)) return; //trató de atacar A una unidad aliada
        if (!this.unidades.contains(unaUnidad)) return; //trató de atacar CON una unidad enemiga
        unaUnidad.realizarAccion(otraUnidad, this.tablero, this.unidades);
    }

    public void realizarAccionDeCurandero (Unidad curandero, Unidad unidadACurar){
        if (!this.unidades.contains(unidadACurar)) return; //trató de curar A unidad enemiga
        if (!this.unidades.contains(curandero)) return; // trato de curar CON un curandero enemigo
        curandero.realizarAccion(unidadACurar,tablero,unidades);
    }

    public boolean esCurandero (Unidad unidad){
        Curandero esCurandero = new Curandero();
        if(unidad.getClass() == esCurandero.getClass()) return true;
        return false;
    }

}

