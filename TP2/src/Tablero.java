import java.util.ArrayList;

public class Tablero {
    private static final int cantidadCasilleros = 400;
    private ArrayList<Casillero> lista_casilleros;
    private ArrayList<Unidad> lista_unidades;
    private ArrayList<Casillero> caja_jugador_1;
    private ArrayList<Casillero> caja_jugador_2;
    private ArrayList<Casillero> filas;
    private ArrayList<Casillero> columas;

    public void inicializarTablero() {
        for (int i = 0; i < cantidadCasilleros; i++) {
            Casillero temp = new Casillero();
            lista_casilleros.add(temp);
        }
    }
}
