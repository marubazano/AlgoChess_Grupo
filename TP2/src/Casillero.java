public class Casillero {

    private Unidad unidadQueOcupa;
    private boolean estaOcupado;

    public Casillero() {
        this.unidadQueOcupa = null;
        this.estaOcupado = false;
    }

    public boolean estaOcupado() {
        return (estaOcupado);
    }

    public void ocuparCasilleroPorUnidad(Unidad unidad) {
        this.unidadQueOcupa = unidad;
        this.estaOcupado = true;
    }

    public void vaciarCasillero() {
        this.unidadQueOcupa = null;
        this.estaOcupado = false;
    }
}