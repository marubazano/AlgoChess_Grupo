import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Unidad> unidades;

    Jugador(String nombre) {
        this.nombre = nombre;
        this.unidades = new ArrayList<>(); //Se declara asi para poner cualquier objeto hijo
    }

    public void agregarUnidadAJugador(Unidad unidad) {
        this.unidades.add(unidad);
    }

    public int obtenerCantidadUnidades(){
        return this.unidades.size();
    }

    public String obtenerNombre(){
        return nombre;
    }

    public void ubicarUnidad( Unidad unidad, Casillero casillero) {
        unidad.ubicar(casillero);
    }

}
