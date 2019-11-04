import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Unidad> unidades;
    private int puntos;

    Jugador(String nombre) {
        this.nombre = nombre;
        this.unidades = new ArrayList<>(); //Se declara asi para poner cualquier objeto hijo
        this.puntos = 20;
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

    public boolean tieneSuficientesPuntos(Unidad unidad) {
        if (unidad.getCosto() <= this.puntos) {
            return true;
        }
        return false;
    }

    public void comprarUnidad(Unidad unidad) {
            try {
                if (tieneSuficientesPuntos(unidad)) {
                    unidades.add(unidad);
                    this.puntos -= unidad.getCosto();
                }
                else {
                    throw new PuntosInsuficientesExcepcion();
                }
            } catch (PuntosInsuficientesExcepcion exception) {
                System.out.println(exception.getMensaje());
            }
        }
    }

}
