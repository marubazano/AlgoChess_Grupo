import java.util.HashMap;

public class Tablero {
    private static final int CANT_FILAS = 20;
    private static final int CANT_COLUMNAS = 20;
    protected HashMap<Coordenada, Casillero> tablero;

    public Tablero() {
        this.tablero = new HashMap<Coordenada, Casillero>();
        for (int x = 1; x < CANT_FILAS + 1; x++) {
            for (int y = 1; y < CANT_COLUMNAS + 1; y++) {
                Coordenada coordenada = new Coordenada(x, y);
                Casillero casillero = new Casillero();
                this.tablero.put(coordenada, casillero);
            }
        }
    }

    public boolean tableroEstaVacio(){
        for(Casillero actual : tablero.values()) {
            if (actual.estaOcupado()) return false;
        }
        return true;
    }

    public Casillero obtenerCasillero(Coordenada coordenada) {
        //fijarse EXCEPCIÓN
        for(Coordenada actual : tablero.keySet()){
            if(actual.compararCoordenada(coordenada))
                return tablero.get(actual);
        }
        return null;
        //Si no esta el casillero, las coordenadas ingresadas estan mal, y hay que mandar exception
    }

    public void ubicarUnidad (Unidad unidad, Coordenada coordenada) throws CasilleroOcupadoException {
        Casillero casillero = obtenerCasillero(coordenada);
        if (casillero.estaOcupado()){
            throw new CasilleroOcupadoException();
        }
        casillero.ocuparCasilleroPorUnidad(unidad);
        unidad.ubicarEnCoordenada(coordenada);
    }

    public void mover(Movible unidadMovible, Direccion direccion) {
        //calcular la nueva Coordenada
        Coordenada coordenadaActual = unidadMovible.obtenerCoordenada();
        Casillero casilleroActual= obtenerCasillero(coordenadaActual);
        Coordenada nuevaCoordenada = coordenadaActual.desplazar(direccion);
        try {
            ubicarUnidad(unidadMovible, nuevaCoordenada);
            casilleroActual.vaciarCasillero();
            unidadMovible.mover(nuevaCoordenada);
        }
        catch(CasilleroOcupadoException e){
            e.getMensaje();
        }
    }

   /* public boolean moverUnidad (Unidad unidad, Coordenada coordenada){
        Casillero casillero = obtenerCasillero(coordenada);
        if(ubicarUnidad(unidad,coordenada)){
            casillero.vaciarCasillero();
            return true;
        }
        return false;
    }*/ // Este metodo no va aca viejo
}