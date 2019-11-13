package Unidades;
import Tablero.*;
import java.util.ArrayList;

public abstract class Unidad {
    private float vida;
    private int costo;
    private Coordenada coordenada;

    public Unidad(float vida, int costo) {
        this.vida = vida;
        this.costo = costo;
        this.coordenada = null; //Poner las coordenadas para cuando atacamos, calcular las coordenadas a las que hace daño desde el lugar en que está la unidad
    }

    public float obtenerVida() {
        return this.vida;
    }

    public void recibirDaño(float daño) {
        this.vida -= daño;
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

    public abstract void realizarAccion(Unidad unidad, Tablero tablero, ArrayList<Unidad> unidades);

}

