public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada sumar(Direccion direccion){
        int nuevox = this.x + direccion.x;
        int nuevoy = this.y + direccion.y;
        Coordenada nuevaCoordenada = new Coordenada(nuevox, nuevoy);
        return nuevaCoordenada;
    }

    public int obtenerHorizontal(){
        return x;
    }

    public int obtenerVertical(){
        return y;
    }

    public boolean compararCoordenada(Coordenada coordenada){
        return (this.x == coordenada.obtenerHorizontal() && this.y == coordenada.obtenerVertical());
    }
}
