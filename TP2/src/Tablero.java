import java.util.HashMap;

public class Tablero {
    private static final int CANT_FILAS = 20;
    private static final int CANT_COLUMNAS = 20;
    protected HashMap<Coordenada, Casillero> casilleros;

    public Tablero() {
        this.casilleros = new HashMap<Coordenada, Casillero>();
        for (int x = 1; x < CANT_FILAS + 1; x++) {
            for (int y = 1; y < CANT_COLUMNAS + 1; y++) {
                Coordenada coordenada = new Coordenada(x, y);
                this.casilleros.put(coordenada, null);
            }
        }
    }
}