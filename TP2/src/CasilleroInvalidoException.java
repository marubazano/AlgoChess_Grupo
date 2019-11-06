public class CasilleroInvalidoException extends Exception {
    private static final String mensaje = "El casillero al que queres ir esta fuera del tablero!";

    public CasilleroInvalidoException(){};

    public void getMensaje(){
        System.out.println(mensaje);
    }

}
