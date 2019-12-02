package Unidades;
import Excepciones.AccionInvalidaException;
import Tablero.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Catapulta extends Unidad {
    public Arma municion;

    public Catapulta() {
        super(50, 5);
        this.municion = new Arma(20);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga, Tablero tablero, ArrayList<Unidad> unidades) throws AccionInvalidaException {
        if (!unidades.contains(unidadEnemiga)) {
            int danio = obtenerDanioDeArma();
            Set<Unidad> atacadas = new HashSet<>();
            unidadEnemiga.recibirDanio(danio);
            atacadas.add(unidadEnemiga);
            atacarUnidadesContiguas(tablero, atacadas, unidadEnemiga);
        } else {
            throw new AccionInvalidaException();
        }
    }

    public void atacarUnidadesContiguas(Tablero tablero, Set<Unidad> atacadas, Unidad unidadEnemiga) {
        int danio = obtenerDanioDeArma();
        for (Unidad contigua : tablero.obtenerUnidadesContiguas(unidadEnemiga)) {
            if(!atacadas.contains(contigua)) {
                contigua.recibirDanio(danio);
                atacadas.add(contigua);
                atacarUnidadesContiguas(tablero, atacadas, contigua);
            }
        }
    }

    public int obtenerDanioDeArma() {
        return this.municion.obtenerDanioDeArma();
    }
}