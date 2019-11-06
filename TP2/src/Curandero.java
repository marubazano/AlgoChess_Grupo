public class Curandero extends Movible {
    private static final float curacion = 15; //This is constante

    public Curandero(){
        super(75, 2);
    }

    @Override
    public void realizarAccion(Unidad unidad) {
        unidad.recibirCura(curacion);
    }
}
