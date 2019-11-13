package Unidades;
import Tablero.*;

import Unidades.Movible;
import Unidades.Unidad;

import java.util.ArrayList;

public class SoldadoDeInfanteria extends Movible {

    private Arma puños; //Pelea con los puños?

    public SoldadoDeInfanteria(){
        super(100,1);
        this.puños = new Arma(10);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga, Tablero tablero, ArrayList<Unidad> unidades) {
        int daño = obtenerDañoDeArma();
        unidadEnemiga.recibirDaño(daño);
    }

    public int obtenerDañoDeArma() {
        return this.puños.obtenerDañoDeArma();
    }
}
