public enum Direccion {
    ABAJO(1,0),
    ARRIBA(-1,0),
    DERECHA(0, 1),
    IZQUIERDA(0,-1),
    DIAGONALSUPERIORIZQUIERDA(-1, -1),
    DIAGONALSUPERIORDERECHA(-1,1),
    DIAGONALINFERIORIZQUIERDA(1,-1),
    DIAGONALINFERIORDERECHA(1,1);

    public final int x;
    public final int y;

    Direccion(int x, int y){
        this.x = x;
        this.y = y;
    }
}
