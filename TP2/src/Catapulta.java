public class Catapulta extends Unidad {
    public Arma municion;

    public Catapulta() {
        super(50, 5); //Llamo al constructor de unidad con los parametros correspondientes
    }

    @Override
    public void realizarAccion(Unidad unidad) {
        /*
        bla bla bla
         */
    }

    public int getDañoDeArma() {
        return this.municion.getDaño();
    }
}
