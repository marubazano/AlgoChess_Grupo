package Unidades;
import Tablero.*;

import Unidades.Movible;
import Unidades.Unidad;

public class SoldadoDeInfanteria extends Movible {

    private Arma puños; //Pelea con los puños?

    public SoldadoDeInfanteria(){
        super(100,1);
        this.puños = new Arma(10);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga, Tablero tablero) {
        int daño = obtenerDañoDeArma();
        unidadEnemiga.recibirDaño(daño);
    }

    public int obtenerDañoDeArma() {
        return this.puños.obtenerDañoDeArma();
    }
}
