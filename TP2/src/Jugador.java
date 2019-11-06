import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Unidad> unidades;
    private Tablero tablero;
    private int puntos;
    private int nroJugador; // Valdra 1 o 2, segun el numero del jugador
    private String estado;

    public Jugador(String nombre, Tablero tablero, int nroJugador) {
        this.nombre = nombre;
        this.unidades = new ArrayList<>(); //Se declara así para poner cualquier objeto hijo
        this.tablero = tablero;
        this.puntos = 20;
        this.nroJugador = nroJugador;
        this.estado="JUGANDO";
    }

    /*
    public void atacarUnidadEnemiga(Unidad unidad_aliada, Unidad unidad_enemiga, Jugador enemigo) {
        unidad_enemiga.recibirDaño(unidad_aliada.obtenerDañoDeArma());
        if (unidad_enemiga.obtenerVida() <= 0) {
            enemigo.eliminarUnidadDelJugador(unidad_enemiga);
        }
    }*/ //Esta es una accion de la misma unidad

    /*public void curarUnidadAliada(Curandero curandero, Unidad unidad_aliada) {
        curandero.curarUnidadAliada(unidad_aliada);
    }*/ //Idem anterior

    public void agregarUnidadAJugador(Unidad unidad) {
        this.unidades.add(unidad);
    }

    public void eliminarUnidadDelJugador(Unidad unidad) {
        this.unidades.remove(unidad);
        if (unidades.size() == 0) this.estado="PERDEDOR";
    }

    public int obtenerCantidadUnidades() {
        return this.unidades.size();
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerPuntos() {
        return this.puntos;
    }

    //Métodos para comprar

    public boolean tieneSuficientesPuntos(Unidad unidad) {
        if (unidad.obtenerCosto() <= this.puntos) {
            return true;
        }
        return false;
    }

    public void comprar(Unidad unidad) throws PuntosInsuficientesException {
        if (tieneSuficientesPuntos(unidad)) {
            unidades.add(unidad);
            this.puntos -= unidad.obtenerCosto();
        }
        else {
            throw new PuntosInsuficientesException();
        }
    }

    public void tratarException(Unidad unidad) {
        try {
            this.comprar(unidad);
        } catch (PuntosInsuficientesException exception) {
            System.out.println(exception.getMensaje());
        }
    }

    public void comprarUnidad(Unidad unidad) {
        tratarException(unidad);
    }

    public boolean ubicarUnidad(Unidad unidad, Coordenada coordenada) {
        try {
            if (!ubicarUnidadEnLadoDelTableroCorrespondiente(coordenada)) return false;
            this.unidades.add(unidad);
            tablero.ubicarUnidad(unidad, coordenada);
        }
        catch (CasilleroOcupadoException e) {
            e.getMensaje();
        }
        return true;
    }

    public void mover(Movible unidadMovible, Direccion direccion) {
        tablero.mover(unidadMovible, direccion);
    }

    public boolean ubicarUnidadEnLadoDelTableroCorrespondiente(Coordenada coordenada) {
        if (this.nroJugador == 1) {
            if (coordenada.obtenerVertical() <= 10) return true;
            return false;
        }
        if (coordenada.obtenerVertical() > 10) return true;
        return false;
    }

    public String obtenerEstado() {
        return this.estado;
    }
}

