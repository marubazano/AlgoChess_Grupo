package Tablero;

import Tablero.Coordenada;

public enum Direccion {
    ABAJO(new Coordenada(1,0)),
    ARRIBA(new Coordenada(-1,0)),
    DERECHA(new Coordenada(0, 1)),
    IZQUIERDA(new Coordenada(0,-1)),
    DIAGONALSUPERIORIZQUIERDA(new Coordenada(-1, -1)),
    DIAGONALSUPERIORDERECHA(new Coordenada(-1,1)),
    DIAGONALINFERIORIZQUIERDA(new Coordenada(1,-1)),
    DIAGONALINFERIORDERECHA(new Coordenada(1,1));


    Coordenada direccion;

    private Direccion(Coordenada coordenada) {
        this.direccion = coordenada;
    }

    public Coordenada obtenerDireccion() {
        return direccion;
    }
}
