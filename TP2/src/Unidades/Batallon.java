package Unidades;

import Excepciones.AccionInvalidaException;
import Excepciones.CasilleroInvalidoException;
import Tablero.Tablero;
import Tablero.Direccion;

import java.util.*;
import java.util.ArrayList.*;

public class Batallon{
    private SoldadoDeInfanteria soldado1;
    private SoldadoDeInfanteria soldado2;
    private SoldadoDeInfanteria soldado3;
    private ArrayList<SoldadoDeInfanteria> batallon = new ArrayList<>();

    public Batallon(SoldadoDeInfanteria soldado1, SoldadoDeInfanteria soldado2,SoldadoDeInfanteria soldado3) {
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);
    }

    public void mover(Tablero tablero, Direccion direccion, Queue colaSoldados) throws CasilleroInvalidoException {
        int cantMovsMax = 5;
        while (!colaSoldados.isEmpty() && cantMovsMax > 0){
            SoldadoDeInfanteria soldado = (SoldadoDeInfanteria) colaSoldados.poll();
            try {
                Unidad contiguaEnDirec = tablero.obtenerContiguaEnDireccion(soldado, direccion);
                if (contiguaEnDirec == null) tablero.mover(soldado, direccion);
                else if (batallon.contains(contiguaEnDirec)) colaSoldados.add(soldado);
                cantMovsMax--;
            } catch (CasilleroInvalidoException e) {
                continue;
            }
        }
    }

}
