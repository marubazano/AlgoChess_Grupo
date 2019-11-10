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
    int daño = obtenerDañoDeArma();
        ArrayList<Unidad> contiguas = unidadEnemiga.obtenerUnidadesContiguas();
        Set<Unidad> unidadesAAtacar = new HashSet<>(); //El set no permite duplicados al agregar, buenardo
        unidadesAAtacar.add(unidadEnemiga);
        unidadesAAtacar.addAll(contiguas);
        unidadesEnAreaDeAtaque(contiguas, unidadesAAtacar);
        for(Unidad actual : unidadesAAtacar){
            actual.recibirDaño(daño);
        }
    }

    public void unidadesEnAreaDeAtaque(ArrayList<Unidad> contiguas, Set<Unidad> unidadesAAtacar){
        for (Unidad actual : contiguas) {
            unidadesAAtacar.add(actual);
            if (!unidadesAAtacar.containsAll(actual.obtenerUnidadesContiguas())) {
                unidadesEnAreaDeAtaque(actual.obtenerUnidadesContiguas(), unidadesAAtacar);
            }
        }
    }

    public int obtenerDañoDeArma() {
        return this.municion.obtenerDañoDeArma();
    }
}
