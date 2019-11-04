public class Catapulta extends Unidad {
    public Arma municion;
    public int daño=20;

    public Catapulta() {
        super(50, 5); //Llamo al constructor de unidad con los parametros correspondientes
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga) {
        unidadEnemiga.recibirDaño(daño);
    }

    public int getDañoDeArma() {
        return this.municion.getDaño();
    }
}
