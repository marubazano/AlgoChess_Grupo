package Unidades;
import Tablero.*;

import Unidades.Movible;
import Unidades.Unidad;

import java.util.ArrayList;

public class SoldadoDeInfanteria extends Movible {

    private Arma punios; //Pelea con los puños?

    public SoldadoDeInfanteria() {
        super(100,1);
        this.punios = new Arma(10);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga, Tablero tablero, ArrayList<Unidad> unidades) {
        int danio = obtenerDanioDeArma();
        unidadEnemiga.recibirDanio(danio);
    }

    public int obtenerDanioDeArma() {
        return this.punios.obtenerDanioDeArma();
    }
}
