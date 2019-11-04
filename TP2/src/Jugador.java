import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Unidad> unidades;
    private Tablero tablero;
    private int puntos;
    private int nroJugador; // Valdra 1 o 2, segun el numero del jugador

    public Jugador(String nombre, Tablero tablero, int nroJugador) {
        this.nombre = nombre;
        this.unidades = new ArrayList<>(); //Se declara así para poner cualquier objeto hijo
        this.tablero = tablero;
        this.puntos = 20;
        this.nroJugador = nroJugador;
    }

    public void atacarUnidadEnemiga(Unidad unidad_aliada, Unidad unidad_enemiga, Jugador enemigo) {
        unidad_enemiga.recibirDaño(unidad_aliada.getDañoDeArma());
        if (unidad_enemiga.getVida() <= 0) {
            enemigo.eliminarUnidadDelJugador(unidad_enemiga);
        }
    }

    public void curarUnidadAliada(Curandero curandero, Unidad unidad_aliada) {
        curandero.curarUnidadAliada(unidad_aliada);
    }

    public void agregarUnidadAJugador(Unidad unidad) {
        this.unidades.add(unidad);
    }

    public void eliminarUnidadDelJugador(Unidad unidad) {
        this.unidades.remove(unidad);
    }

    public int obtenerCantidadUnidades(){
        return this.unidades.size();
    }

    public String obtenerNombre(){
        return nombre;
    }

    public int obtenerPuntos() {
        return this.puntos;
    }

    public void ubicarUnidad(Unidad unidad, Coordenada coordenada) {
        Casillero casilleroAUbicar = this.tablero.obtenerCasillero(coordenada);
        unidad.ubicar(casilleroAUbicar); //ESTO LANZA LA EXCEPCIÓN, SINO QUE LA LANCE ubicarUnidad
    }


    //Métodos para comprar

    public boolean tieneSuficientesPuntos(Unidad unidad) {
        if (unidad.getCosto() <= this.puntos) {
            return true;
        }
        return false;
    }

    public void comprar(Unidad unidad) throws PuntosInsuficientesException{
        if (tieneSuficientesPuntos(unidad)) {
            unidades.add(unidad);
            this.puntos -= unidad.getCosto();
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

    public boolean ubicarUnidad(Tablero tablero, Unidad unidad, Coordenada coordenada){
        try{
            if (!ubicarUnidadEnLadoDelTableroCorrespondiente(coordenada)) return false;
            tablero.ubicarUnidad(unidad, coordenada);
        }
        catch(CasilleroOcupadoException e){
            e.getMensaje();
        }
        return true;
    }

    public void mover(Unidad unidad, Direccion direccion) {
        tablero.mover(unidad, direccion);
    }

    public boolean ubicarUnidadEnLadoDelTableroCorrespondiente(Coordenada coordenada){
        if (this.nroJugador==1){
            if (coordenada.obtenerVertical()<=10) return true;
            return false;
        }
        if (coordenada.obtenerVertical()>10) return true;
        return false;
    }
}

