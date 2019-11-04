public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
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
