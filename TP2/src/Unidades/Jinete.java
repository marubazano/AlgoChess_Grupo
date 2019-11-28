package Unidades;

import Excepciones.AccionInvalidaException;
import Tablero.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Jinete extends Movible {

    private HashMap<Distancia, Arma> armas;

    public Jinete() {
        super(100, 3);
        armas = new HashMap<>();
        Arma arcoYFlecha = new Arma(15); //ataca a media distancia con arco y flecha
        Arma espada = new Arma(5); //ataca cuerpo a cuerpo con espada
        armas.put(Distancia.CERCANA, espada);
        armas.put(Distancia.MEDIANA, arcoYFlecha);
    }

    //Ataque del jinete:
    // 1) Hay Soldado aliado cerca O no hay enemigo cerca: Ataca con arcoYFlecha SOLO a distancia media.
    // 2) No hay aliados cerca Y hay enemigos cerca: Ataca con espada SOLO a distancia corta.
    // Si el ataque indicado no es ninguno de los dos casos anteriores, el jinete NO ATACA y el jugador pierde el turno.

    @Override
    public void realizarAccion(Unidad unidadEnemiga, Tablero tablero, ArrayList<Unidad> unidadesAliadas) throws AccionInvalidaException {
        Coordenada coordenadaEnemiga = unidadEnemiga.obtenerCoordenada();
        Coordenada coordenadaJinete = this.obtenerCoordenada();
        Distancia distancia = coordenadaJinete.calcularDistacia(coordenadaEnemiga);
        ArrayList<Unidad> unidadesTablero = tablero.obtenerUnidades();
        ArrayList<Unidad> enemigas = obtenerUnidadesEnemigas(unidadesTablero, unidadesAliadas);
        if ((haySoldadoAliadoCerca(unidadesAliadas) || !hayEnemigosCerca(enemigas)) && (distancia == Distancia.MEDIANA)) {
            unidadEnemiga.recibirDanio(armaSegunDistancia(distancia), tablero);
        }
        else if ((hayEnemigosCerca(enemigas) && !hayAliadoCerca(unidadesAliadas)) && distancia == Distancia.CERCANA) {
            unidadEnemiga.recibirDanio(armaSegunDistancia(distancia), tablero );
        }
        else {
            throw new AccionInvalidaException();
        }
    }

    public int armaSegunDistancia(Distancia distancia) {
        int danioArma;
        try {
            danioArma = armas.get(distancia).obtenerDanioDeArma();
        }
        catch (NullPointerException e) {
            return 0;
        }
        return danioArma;
    }

    public boolean hayAliadoCerca(ArrayList<Unidad> unidadesAliadas) {
        boolean hayAliado = false;
        for (Unidad actual : unidadesAliadas) {
            if (actual != this) { //No quiero encontrar la distancia a self
                Distancia distancia = actual.obtenerCoordenada().calcularDistacia(this.obtenerCoordenada());
                if (distancia == Distancia.CERCANA) {
                    hayAliado = true;
                }
            }
        }
        return hayAliado;
    }

    public boolean haySoldadoAliadoCerca(ArrayList<Unidad> unidadesAliadas) {
        boolean haySoldado = false;
        for (Unidad actual : unidadesAliadas) {
            Distancia distancia = actual.obtenerCoordenada().calcularDistacia(this.obtenerCoordenada());
            if (actual instanceof SoldadoDeInfanteria && distancia == Distancia.CERCANA) {
                haySoldado = true;
            }
        }
        return haySoldado;
    }

    public boolean hayEnemigosCerca(ArrayList<Unidad> unidadesEnemigas) {
        boolean hayEnemigoCerca = false;
        for (Unidad enemiga : unidadesEnemigas) {
            Distancia distancia = enemiga.obtenerCoordenada().calcularDistacia(this.obtenerCoordenada());
            if (distancia == Distancia.CERCANA)
                hayEnemigoCerca = true;
        }
        return hayEnemigoCerca;
    }

    public ArrayList<Unidad> obtenerUnidadesEnemigas(ArrayList<Unidad> unidadesTablero, ArrayList<Unidad> unidadesAliadas) {
        ArrayList<Unidad> enemigas = new ArrayList<>();
        for (Unidad actual : unidadesTablero) {
            if (!unidadesAliadas.contains(actual) && actual != this) { //No nos queremos agregar en las unidades enemigas!!!
                enemigas.add(actual);
            }
        }
        return enemigas;
    }
}
