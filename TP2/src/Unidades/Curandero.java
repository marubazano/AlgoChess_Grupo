package Unidades;
import Tablero.*;

import java.util.ArrayList;

public class Curandero extends Movible {
    private static final float CURACION = 15; //This is constante

    public Curandero(){
        super(75, 2);
    }

    @Override
    public void realizarAccion(Unidad unidad, Tablero tablero, ArrayList<Unidad> unidades) {
        unidad.recibirCura(CURACION);
    }
}
