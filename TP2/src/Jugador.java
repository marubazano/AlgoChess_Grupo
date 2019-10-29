import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<String> unidades; //cambiar de tipo string a tipo unidad

    Jugador(String nombre) {
        this.nombre = nombre;
        this.unidades= new ArrayList<String>(); //cambiar de tipo string a tipo unidad
    }
    public void agregarUnidadAJugador(String unidad) { //cambiar de tipo string a tipo unidad
        this.unidades.add(unidad);
    }

}
