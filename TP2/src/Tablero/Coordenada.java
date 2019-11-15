package Tablero;
import static java.lang.Math.max;
import static java.lang.Math.abs;

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

    public Coordenada restarCoordenada(Coordenada otraCoordenada) {
        int horizontal = this.x - otraCoordenada.obtenerHorizontal();
        int vertical = this.y - otraCoordenada.obtenerVertical();
        return new Coordenada(horizontal, vertical);
    }

    public Distancia calcularDistacia(Coordenada otraCoordenada) {
        //Distancia de tablero o chebyshev
        int distanciaNumerica = distanciaNumerica(otraCoordenada);
        return Distancia.obtenerDistancia(distanciaNumerica);

    }

    public int distanciaNumerica(Coordenada otraCoordenada) {
        Coordenada resta = restarCoordenada(otraCoordenada);
        int distanciaNumerica = max(abs(resta.obtenerHorizontal()), abs(resta.obtenerVertical()));
        return distanciaNumerica;
    }


    @Override
    public boolean equals(Object obj) {
        return (((Coordenada)obj).x == this.x) && (((Coordenada)obj).y == this.y);
    }

    @Override
    public int hashCode() {
        return this.x + 10000 * this.y;
    }
}
