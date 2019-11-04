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

 /*  public boolean EstanAlLado(Coordenada unidad1, Coordenada unidad2){
       if (unidad1+ABAJO==unidad2 || unidad1+ARRIBA==unidad2 || unidad1+DERECHA==unidad2 ||unidad1+IZQUIERDA==unidad2 ||unidad1+DIAGONALSUPERIORIZQUIERDA==unidad2 ||unidad1+DIAGONALSUPERIORDERECHA==unidad2 ||unidad1+DIAGONALINFERIORIZQUIERDA==unidad2 ||unidad1+DIAGONALINFERIORDERECHA==unidad2 ||)
        {return true;}
        return false;
    } El peor if que veran en sus vidas, pero no se me ocurre otra forma. No funciona porque no puedo sumar un
    elemento Coordenada con un elemento Direccion*/
}
