import java.util.ArrayList;

public class Catapulta extends Unidad {
    public Arma municion;
    ArrayList<Unidad> unidadesContiguasAtacadas;

    public Catapulta() {
        super(50, 5); //Llamo al constructor de unidad con los parametros correspondientes
        this.municion = new Arma(20);
        this.unidadesContiguasAtacadas = new ArrayList<Unidad>();
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga) {
        int daño = obtenerDañoDeArma();
        unidadEnemiga.recibirDaño(daño);
        this.unidadesContiguasAtacadas.add(unidadEnemiga);
        ArrayList<Unidad> unidadesContiguas=unidadEnemiga.obtenerUnidadesContiguas();
        for (int i=0; i<unidadEnemiga.obtenerUnidadesContiguas().size();i++){
            if (!unidadesContiguasAtacadas.contains(unidadesContiguas.get(i))) {
                realizarAccion(unidadesContiguas.get(i));
                break;
            }
        }
        this.unidadesContiguasAtacadas.clear();
    }

    public int obtenerDañoDeArma() {
        return this.municion.obtenerDañoDeArma();
    }
}
