package Unidades;

import Excepciones.AccionInvalidaException;
import Tablero.*;
import java.util.ArrayList;

public abstract class Unidad {
    private float vida;
    private int costo;
    private Coordenada coordenada;

    public Unidad(float vida, int costo) {
        this.vida = vida;
        this.costo = costo;
        this.coordenada = null;
    }

    public float obtenerVida() {
        return this.vida;
    }

    public void recibirDanio(float danio) {
        this.vida -= danio;
        if(vida < 0) vida = 0;
    }

    public void recibirCura(float cura) {
        this.vida += cura;
    }

    public void ubicarEnCoodenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Coordenada obtenerCoordenada() {
        return this.coordenada;
    }

    public int obtenerCosto() {
        return this.costo;
    }

    public abstract void realizarAccion(Unidad unidad, Tablero tablero, ArrayList<Unidad> unidades) throws AccionInvalidaException;

    public static Unidad factoryUnidad(String tipo){
        if(tipo == "soldado") return new SoldadoDeInfanteria();
        if(tipo == "jinete") return new Jinete();
        if(tipo == "curandero") return new Curandero();
        if(tipo == "catapulta") return new Catapulta();
        return null;
    }
}

