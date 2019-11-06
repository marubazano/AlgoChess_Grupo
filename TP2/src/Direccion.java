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


 /*  public boolean EstanAlLado(Coordenada unidad1, Coordenada unidad2){
       if (unidad1+ABAJO==unidad2 || unidad1+ARRIBA==unidad2 || unidad1+DERECHA==unidad2 ||unidad1+IZQUIERDA==unidad2 ||unidad1+DIAGONALSUPERIORIZQUIERDA==unidad2 ||unidad1+DIAGONALSUPERIORDERECHA==unidad2 ||unidad1+DIAGONALINFERIORIZQUIERDA==unidad2 ||unidad1+DIAGONALINFERIORDERECHA==unidad2 ||)
        {return true;}
        return false;
    } El peor if que veran en sus vidas, pero no se me ocurre otra forma. No funciona porque no puedo sumar un
    elemento Coordenada con un elemento Direccion*/
}
