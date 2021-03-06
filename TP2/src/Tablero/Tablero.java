package Tablero;

import Controlador.Observable;
import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import Unidades.Movible;
import Unidades.Unidad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Tablero extends Observable {
    private static final int CANT_FILAS = 20;
    private static final int CANT_COLUMNAS = 20;
    protected HashMap<Coordenada, Casillero> tablero;

    public Tablero() {
        this.tablero = new HashMap<Coordenada, Casillero>();
        for (int x = 1; x < CANT_FILAS + 1; x++) {
            for (int y = 1; y < CANT_COLUMNAS + 1; y++) {
                Coordenada coordenada = new Coordenada(x, y);
                Casillero casillero = new Casillero();
                this.tablero.put(coordenada, casillero);
            }
        }
    }

    public boolean tableroEstaVacio() {
        for(Casillero actual : tablero.values()) {
            if (actual.estaOcupado()) return false;
        }
        return true;
    }

    public Casillero obtenerCasillero(Coordenada coordenada) {
        return tablero.get(coordenada);
    }

    public void ubicarUnidad(Unidad unidad, Coordenada coordenada) throws CasilleroOcupadoException, CasilleroInvalidoException {
        try {
            obtenerCasillero(coordenada).ocuparCasilleroPorUnidad(unidad, coordenada);
        } catch (NullPointerException e) {
            throw new CasilleroInvalidoException(e);
        }
    }

    public String mover(Movible unidadMovible, Direccion direccion) {
        //calcular la nueva Tablero.Coordenada
        Coordenada coordenadaActual = unidadMovible.obtenerCoordenada();
        try {
            if(direccion == null) return "El casillero al que se movió no es contiguo.";
            Coordenada nuevaCoordenada = coordenadaActual.desplazar(direccion);
            ubicarUnidad(unidadMovible, nuevaCoordenada);
            Casillero casilleroActual = obtenerCasillero(coordenadaActual);
            casilleroActual.vaciarCasillero();
            unidadMovible.mover(nuevaCoordenada);
            notificarObservadores();
        }
        catch (CasilleroOcupadoException e) {
            return e.getMensaje();
        }
        catch (CasilleroInvalidoException e) {
            return e.getMensaje();
        }
        return ("La unidad " + unidadMovible.getClass().getSimpleName() + " se movió");
    }

    public ArrayList<Unidad> obtenerUnidadesContiguas(Unidad unidad) {
        Coordenada desplazada;
        ArrayList<Unidad> contiguas = new ArrayList<>();
        for (Direccion dir : Direccion.values()) { //itero por todas las dirs adyacentes a la unidad
            Coordenada actual = unidad.obtenerCoordenada();
            desplazada = actual.desplazar(dir);
            Casillero casillero = obtenerCasillero(desplazada);
            try {
                if (casillero.estaOcupado()) {
                    Unidad contigua = casillero.obtenerUnidad();
                    contiguas.add(contigua);
                }
            } catch (NullPointerException e) {
                continue;
            }
        }
        return contiguas;
    }

    public ArrayList<Unidad> obtenerUnidades() {
        Collection<Casillero> casilleros = tablero.values();
        ArrayList<Unidad> unidades = new ArrayList<>();
        for(Casillero actual : casilleros){
            if(actual.estaOcupado())
                unidades.add(actual.obtenerUnidad());
        }
        return unidades;
    }

    public Unidad obtenerContiguaEnDireccion(Unidad unidad, Direccion direccion) throws CasilleroInvalidoException {
        Coordenada desplazada;
        Coordenada actual = unidad.obtenerCoordenada();
        try{
            desplazada = actual.desplazar(direccion);
            Casillero casillero = obtenerCasillero(desplazada);
            if (casillero.estaOcupado()) {
                Unidad contigua = casillero.obtenerUnidad();
                return contigua;
            }
        }
        catch (NullPointerException e) {
            throw new CasilleroInvalidoException(e);
        }
        return null;
    }
}