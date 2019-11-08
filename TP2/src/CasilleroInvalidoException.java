public class CasilleroInvalidoException extends Exception {
    private static final String mensaje = "El casillero al que queres ir esta fuera del tablero!";

    public CasilleroInvalidoException(Exception ex){
        super(ex);
    };

    public void getMensaje(){
        System.out.println(mensaje);
    }

}
