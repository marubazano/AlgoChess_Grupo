import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Unidad> unidades;

    Jugador(String nombre) {
        this.nombre = nombre;
        this.unidades= new ArrayList<Unidad>();
    }
    public void agregarUnidadAJugador(Unidad unidad) {
        this.unidades.add(unidad);
    }
    public String obtenerNombre(){
        return nombre;
    }

}
