public class Curandero extends Movible {
    private static final float curacion = 15; //This is constante

    public Curandero(){
        super(75, 2);
    }

    public void curarUnidadAliada(Unidad unidad){
        unidad.recibirCura(curacion);
    }

    @Override
    public void realizarAccion(Unidad unidad) {
        curarUnidadAliada(unidad);
    }

    @Override
    public void mover() {
        /*
        bla bla bla
         */
    }
}
