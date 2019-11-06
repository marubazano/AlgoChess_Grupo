public class Catapulta extends Unidad {
    public Arma municion;

    public Catapulta() {
        super(50, 5); //Llamo al constructor de unidad con los parametros correspondientes
        this.municion = new Arma(20);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga) {
        int daño = obtenerDañoDeArma();
        unidadEnemiga.recibirDaño(daño);
    }

    public int obtenerDañoDeArma() {
        return this.municion.obtenerDañoDeArma();
    }
}
