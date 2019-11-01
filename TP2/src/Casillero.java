public class Casillero {

    private boolean ocupado;

    Casillero() {
        this.ocupado = false;
    }

    public void ocuparCasilleroPorUnidad(Unidad nueva) {
        if(!this.estaOcupado())
            this.ocupado = true;
        else System.out.println("El casillero esta ocupado! excepcion");
    }

    public boolean estaOcupado(){
        return ocupado;
    }

}