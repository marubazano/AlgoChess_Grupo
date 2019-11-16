package Unidades;

import Excepciones.*;
import Tablero.Tablero;
import Tablero.Direccion;
import java.util.*;

// El batallón es genérico

public class Batallon {
    private ArrayList<Movible> batallon = new ArrayList<>();

    public Batallon(Movible movible1, Movible movible2, Movible movible3) throws BatallonInvalidoException {
        if (esBatallon(movible1, movible2, movible3) && sonSoldados(movible1, movible2, movible3)) {
            batallon.add(movible1);
            batallon.add(movible2);
            batallon.add(movible3);
        }
        else {
            throw new BatallonInvalidoException();
        }
    }

    public void mover(Tablero tablero, Direccion direccion) {
        Queue<Movible> colaMovibles = new LinkedList<>();
        for (Movible movible : batallon) {
            colaMovibles.add(movible);
        }
        //colaMovibles.addAll(batallon);
        int cantMovsMax = 5;
        while (!colaMovibles.isEmpty() && cantMovsMax > 0) {
            Movible movible = colaMovibles.poll();
            try {
                Unidad contiguaEnDirec = tablero.obtenerContiguaEnDireccion(movible, direccion);
                if (contiguaEnDirec == null) tablero.mover(movible, direccion);
                else if (batallon.contains(contiguaEnDirec)) colaMovibles.add(movible);
                cantMovsMax--;
            } catch (CasilleroInvalidoException e) {
                continue;
            }
        }
    }

    public boolean esBatallon(Movible movible1, Movible movible2, Movible movible3) {
        int distancia12 = movible1.obtenerCoordenada().distanciaNumerica(movible2.obtenerCoordenada());
        int distancia23 = movible2.obtenerCoordenada().distanciaNumerica(movible3.obtenerCoordenada());
        int distancia13 = movible1.obtenerCoordenada().distanciaNumerica(movible3.obtenerCoordenada());
        int sumaDistancias = distancia12 + distancia13 + distancia23;
        if (sumaDistancias == 3 || sumaDistancias == 4) {
            return true;
        }
        return false;
    }

    public boolean sonSoldados(Movible movible1, Movible movible2, Movible movible3) {
        if ((movible1 instanceof SoldadoDeInfanteria) && (movible2 instanceof SoldadoDeInfanteria) && (movible3 instanceof SoldadoDeInfanteria)) {
            return true;
        }
        return false;
    }
}
