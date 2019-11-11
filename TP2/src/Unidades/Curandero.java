package Unidades;
import Tablero.*;

public class Curandero extends Movible {
    private static final float CURACION = 15; //This is constante

    public Curandero(){
        super(75, 2);
    }

    @Override
    public void realizarAccion(Unidad unidad, Tablero tablero) {
        unidad.recibirCura(CURACION);
    }
}