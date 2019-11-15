package Unidades;

import Excepciones.CasilleroInvalidoException;
import Tablero.Tablero;
import Tablero.Direccion;
import java.util.*;

public class Batallon {
    private ArrayList<SoldadoDeInfanteria> batallon = new ArrayList<>();

    public Batallon(SoldadoDeInfanteria soldado1, SoldadoDeInfanteria soldado2, SoldadoDeInfanteria soldado3) {
        batallon.add(soldado1);
        batallon.add(soldado2);
        batallon.add(soldado3);
    }

    public void mover(Tablero tablero, Direccion direccion, SoldadoDeInfanteria soldado1, SoldadoDeInfanteria soldado2, SoldadoDeInfanteria soldado3) {
        Queue<SoldadoDeInfanteria> colaSoldados = new LinkedList<>();
        colaSoldados.add(soldado1);
        colaSoldados.add(soldado2);
        colaSoldados.add(soldado3);
        int cantMovsMax = 5;
        while (!colaSoldados.isEmpty() && cantMovsMax > 0) {
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
