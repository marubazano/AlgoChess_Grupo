public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada desplazar(Direccion direccion) {
        Coordenada dir = direccion.obtenerDireccion();
        int horizontal = this.x + dir.obtenerHorizontal();
        int vertical = this.y + dir.obtenerVertical();
        Coordenada nueva = new Coordenada(horizontal, vertical);
        return nueva;
    }

    public int obtenerHorizontal(){
        return x;
    }

    public int obtenerVertical(){
        return y;
    }

    public boolean compararCoordenada(Coordenada coordenada) {
        return (this.x == coordenada.obtenerHorizontal() && this.y == coordenada.obtenerVertical());
    }

    public Coordenada calcularDistacia (Coordenada otraCoordenada){
        int x1 = this.x;
        int y1 = this.y;
        int x2 = otraCoordenada.obtenerHorizontal();
        int y2 = otraCoordenada.obtenerVertical();
        int distEnX = x1-x2;
        int distEnY = y1-y2;
        Coordenada distancia = new Coordenada(distEnX,distEnY);
        return distancia;
    }

    @Override
    public boolean equals(Object obj) {
        return (((Coordenada)obj).x==this.x) && (((Coordenada)obj).y==this.y);
    }

    @Override
    public int hashCode() {
        return this.x + 10000 * this.y;
    }
}
