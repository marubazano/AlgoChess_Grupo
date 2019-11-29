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
        //System.out.println("ESTOY EN OBTENERDIRECCIONSEGUNCOORDENADAS");
        //System.out.println("coordenadaOrigenEnVertical: "+coordenadaOrigen.obtenerVertical() + " coordenadaOrigenEnHorizontal: "+coordenadaOrigen.obtenerHorizontal());
        //System.out.println("coordenadaDestinoEnVertical: "+coordenadaDestino.obtenerVertical() + " coordenadaDestinoEnHorizontal: "+coordenadaDestino.obtenerHorizontal());
        Coordenada diferencia = coordenadaDestino.restarCoordenada(coordenadaOrigen);
        //System.out.println("La diferencia es en vertical: "+diferencia.obtenerVertical() + " en horizontal: "+diferencia.obtenerHorizontal());
        for(Direccion dir: Direccion.values()){
            if(dir.obtenerDireccion().compararCoordenada(diferencia)) return dir;
        }
        return null;
    }
}
