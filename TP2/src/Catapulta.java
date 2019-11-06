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
    public void realizarAccion(Unidad unidadEnemiga) {
    int daño = obtenerDañoDeArma();
        ArrayList<Unidad> contiguas = unidadEnemiga.obtenerUnidadesContiguas();
        Set<Unidad> unidadesAAtacar = new HashSet<>(); //El set no permite duplicados al agregar, buenardo
        unidadesAAtacar.add(unidadEnemiga);
        for(Unidad actual : contiguas){
            unidadesAAtacar.addAll(contiguas);
            unidadesAAtacar.addAll(actual.obtenerUnidadesContiguas());
        }
        for(Unidad actual : unidadesAAtacar){
            actual.recibirDaño(daño);
        }
    }

    public int obtenerDañoDeArma() {
        return this.municion.obtenerDañoDeArma();
    }
}
