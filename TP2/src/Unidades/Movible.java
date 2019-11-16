package Unidades;
import Tablero.*;

public abstract class Movible extends Unidad {

    protected Movible(float vida, int costo) {
        super(vida, costo);
    }

    public void mover(Coordenada coordenada) {
        ubicarEnCoodenada(coordenada);
    }
}
