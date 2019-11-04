public class SoldadoDeInfanteria extends Movible {

    private Arma puños; //Pelea con los puños?

    public SoldadoDeInfanteria(){
        super(100,1);
    }

    @Override
    public void realizarAccion(Unidad unidad) {
        /*
        bla bla bla
         */
    }

    public int getDañoDeArma() {
        return this.puños.getDaño();
    }


}
