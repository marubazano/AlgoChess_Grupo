package Unidades;

import Excepciones.AccionInvalidaException;
import Tablero.*;
import java.util.ArrayList;

public class SoldadoDeInfanteria extends Movible {

    private Arma punios; //Pelea con los puños?

    public SoldadoDeInfanteria() {
        super(100,1);
        this.punios = new Arma(10);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga, Tablero tablero, ArrayList<Unidad> unidades) throws AccionInvalidaException {
        if (!unidades.contains(unidadEnemiga)) {
            int danio = obtenerDanioDeArma();
            unidadEnemiga.recibirDanio(danio);
        } else {
            throw new AccionInvalidaException();
        }
    }

    public int obtenerDanioDeArma() {
        return this.punios.obtenerDanioDeArma();
    }
}