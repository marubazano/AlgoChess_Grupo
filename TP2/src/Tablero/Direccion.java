package Tablero;

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

    public static Direccion obtenerDireccionSegunCoordenadas (Coordenada coordenadaOrigen, Coordenada coordenadaDestino){
        Coordenada diferencia = coordenadaDestino.restarCoordenada(coordenadaDestino);
        if (diferencia==(new Coordenada(1,0))) return ABAJO;
        if (diferencia==(new Coordenada(-1,0))) return ARRIBA;
        if (diferencia==(new Coordenada(0,1))) return DERECHA;
        if (diferencia==(new Coordenada(0,-1))) return IZQUIERDA;
        if (diferencia==(new Coordenada(-1, -1))) return DIAGONALSUPERIORIZQUIERDA;
        if (diferencia==(new Coordenada(-1,1))) return DIAGONALSUPERIORDERECHA;
        if (diferencia==(new Coordenada(1,-1))) return DIAGONALINFERIORIZQUIERDA;
        else return DIAGONALINFERIORDERECHA;
    }

}
