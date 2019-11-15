package Excepciones;

public class AccionInvalidaException extends Exception {
    private static final String mensaje = "La acción es inválida";

    public AccionInvalidaException(){
        super();
    };

    public void getMensaje(){
        System.out.println(mensaje);
    }
}
