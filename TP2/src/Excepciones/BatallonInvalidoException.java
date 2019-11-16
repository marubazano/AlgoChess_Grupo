package Excepciones;

public class BatallonInvalidoException extends Exception {
    private static final String mensaje = "El batallón es inválido";

    public BatallonInvalidoException(){
        super();
    };
}