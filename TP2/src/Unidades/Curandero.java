package Unidades;

import Excepciones.AccionInvalidaException;
import Tablero.*;
import java.util.ArrayList;

public class Curandero extends Movible {
    private static final float CURACION = 15;

    public Curandero(){
        super(75, 2);
    }

    @Override
    public void realizarAccion(Unidad unidad, Tablero tablero, ArrayList<Unidad> unidades) throws AccionInvalidaException {
        if(unidades.contains(unidad)) // Cura a la unidad sii pertenece a la lista de unidades del jugador
            unidad.recibirCura(CURACION);
        else {
            throw new AccionInvalidaException();
        }
    }
}
