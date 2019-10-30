public class Casillero {

    private boolean ocupado;
    private Unidad unidad;

    Casillero() {
        this.unidad = null;
        this.ocupado = false;
    }

    public void ocuparCasilleroPorUnidad(Unidad nueva) {
        this.ocupado = true;
        this.unidad = nueva;
    }

    public boolean estaOcupado(){
        return ocupado;
    }

}