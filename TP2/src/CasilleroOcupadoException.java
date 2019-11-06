public class CasilleroOcupadoException extends Exception {
    private String mensaje = "El casillero esta ocupado! Proba en otro";

    public CasilleroOcupadoException() {

    }

    public void getMensaje(){
        System.out.println(mensaje);
    }
}
