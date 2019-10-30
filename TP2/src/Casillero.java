public class Casillero {

    private boolean ocupado;
    private boolean unidad;

    Casillero() {
        this.unidad = false;
        this.ocupado = false;
    }
    public void ocuparCasilleroPorUnidad() {
        this.ocupado = true;
        this.unidad = true; //Poner unidad, cambiar el tipo de boolean a Unidad. Modificar la prueba
    }

    public boolean estaOcupado(){
        return ocupado;
    }

}