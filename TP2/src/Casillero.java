public class Casillero {

    private boolean ocupado;

    Casillero() {
        this.ocupado = false;
    }

    public void ocuparCasilleroPorUnidad(Unidad nueva) {
        this.ocupado = true;
    }

    public boolean estaOcupado(){
        return ocupado;
    }

}