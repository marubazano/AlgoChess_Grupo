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
        for (int x = 1; x < CANT_FILAS + 1; x++) {
            for (int y = 1; y < CANT_COLUMNAS + 1; y++) {
                Coordenada coordenada = new Coordenada(x, y);
                Casillero casillero= obtenerCasillero(coordenada);
                if (casillero.estaOcupado()){return false;}
            }
        }
        return true;
    }

    public Casillero obtenerCasillero(Coordenada coordenada) {    //fijarse EXCEPCIÓN
        return this.tablero.get(coordenada);
    }

    public boolean ubicarUnidad (Unidad unidad, Coordenada coordenada){
        Casillero casillero= obtenerCasillero(coordenada);
        if (casillero.estaOcupado()){return false;}
        casillero.ocuparCasilleroPorUnidad(unidad);
        this.tablero.put(coordenada,casillero);
        return true;
    }

    public boolean moverUnidad (Unidad unidad, Coordenada coordenada){
        Casillero casillero= obtenerCasillero(coordenada);
        if(ubicarUnidad(unidad,coordenada)){
            casillero.vaciarCasillero();
            return true;
        }
        return false;
    }
}