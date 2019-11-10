package Unidades;
import Tablero.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Catapulta extends Unidad {
    public Arma municion;


    public Catapulta() {
        super(50, 5); //Llamo al constructor de unidad con los parametros correspondientes
        this.municion = new Arma(20);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga, Tablero tablero) {
        int danio = obtenerDañoDeArma();
        Set<Unidad> atacadas = new HashSet<>();
        unidadEnemiga.recibirDaño(danio);
        atacadas.add(unidadEnemiga);
        atacarUnidadesContiguas(tablero, atacadas, unidadEnemiga);
    }

    public void atacarUnidadesContiguas (Tablero tablero, Set<Unidad> atacadas, Unidad unidadEnemiga) {
        int danio = obtenerDañoDeArma();
        for (Unidad contigua : tablero.obtenerUnidadesContiguas(unidadEnemiga)) {
            if(!atacadas.contains(contigua)) {
                contigua.recibirDaño(danio);
                atacadas.add(contigua);
                atacarUnidadesContiguas(tablero, atacadas, contigua);
            }
        }

    }

    public int obtenerDañoDeArma() {
        return this.municion.obtenerDañoDeArma();
    }
}
