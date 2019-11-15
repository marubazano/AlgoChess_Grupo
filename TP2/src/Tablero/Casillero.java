package Tablero;

import Excepciones.CasilleroOcupadoException;
import Unidades.Unidad;

public class Casillero {

    private Unidad unidadQueOcupa;
    private boolean estaOcupado;

    public Casillero() {
        this.unidadQueOcupa = null;
        this.estaOcupado = false;
    }

    public boolean estaOcupado() {
        return (estaOcupado);
    }

    public void ocuparCasilleroPorUnidad(Unidad unidad, Coordenada coordenada) throws CasilleroOcupadoException {
        if (this.estaOcupado()) { throw new CasilleroOcupadoException(); }
        this.unidadQueOcupa = unidad;
        unidad.ubicarEnCoodenada(coordenada);
        this.estaOcupado = true;
    }

    public void vaciarCasillero() {
        this.unidadQueOcupa = null;
        this.estaOcupado = false;
    }

    public Unidad obtenerUnidad(){
        return unidadQueOcupa;
    }
}