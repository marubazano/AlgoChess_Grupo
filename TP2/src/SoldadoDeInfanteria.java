public class SoldadoDeInfanteria extends Movible {

    private Arma puños; //Pelea con los puños?
    private int daño=10;

    public SoldadoDeInfanteria(){
        super(100,1);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga) {
        unidadEnemiga.recibirDaño(daño);
    }

    public int getDañoDeArma() {
        return this.puños.getDaño();
    }


}
