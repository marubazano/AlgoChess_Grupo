package Tablero;

import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import Unidades.Movible;
import Unidades.SoldadoDeInfanteria;
import Unidades.Unidad;

import java.util.HashMap;
import java.util.ArrayList;

public class Tablero {
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
        }
        catch (NullPointerException e) {
            throw new CasilleroInvalidoException(e);
        }
    }

    public void mover(Movible unidadMovible, Direccion direccion) {
        //reviso si hay batallon
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        ArrayList<Unidad> batallon;
        if (unidadMovible.getClass() == soldado.getClass()){
            batallon=armarBatallon(soldado);
            if (batallon.size()==3);//HAY BATALLON GENTE EEEEEE
        }

        //calcular la nueva Tablero.Coordenada
        Coordenada coordenadaActual = unidadMovible.obtenerCoordenada();
        try {
            Coordenada nuevaCoordenada = coordenadaActual.desplazar(direccion);
            ubicarUnidad(unidadMovible, nuevaCoordenada);
            Casillero casilleroActual = obtenerCasillero(coordenadaActual);
            casilleroActual.vaciarCasillero();
            unidadMovible.mover(nuevaCoordenada);
        }
        catch (CasilleroOcupadoException e) {
            e.getMensaje();
        }
        catch (CasilleroInvalidoException e) {
            e.getMensaje();
        }
    }

    public ArrayList<Unidad> obtenerUnidadesContiguas(Unidad unidad) {
        Coordenada desplazada;
        ArrayList<Unidad> contiguas = new ArrayList<>();
        for (Direccion dir : Direccion.values()) { //itero por todas las dirs adyacentes a la unidad
            Coordenada actual = unidad.obtenerCoordenada();
            desplazada = actual.desplazar(dir);
            //try {
                Casillero casillero = obtenerCasillero(desplazada);
                if (casillero.estaOcupado()) {
                    Unidad contigua = casillero.obtenerUnidad();
                    contiguas.add(contigua);
                }
            }
            //catch (Excepciones.CasilleroInvalidoException e) {
                //continue; //feito feito
            //}
        return contiguas;
    }

    public ArrayList<Unidad> armarBatallon(Movible soldado){
        ArrayList<Unidad> contiguas = obtenerUnidadesContiguas(soldado);
        ArrayList<Unidad> batallon = new ArrayList<Unidad>();
        batallon.add(soldado);
        int cantBatallon = 2;
        for (int i = 0 ; i < contiguas.size() ; i++) {
            if (contiguas.get(i).getClass() == soldado.getClass()){
                batallon.add(contiguas.get(i));
                cantBatallon--;
                if (cantBatallon==0) break;
            }
        }
        return batallon;
    }
}