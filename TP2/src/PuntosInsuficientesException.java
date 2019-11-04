public class PuntosInsuficientesException extends Exception{

    private String mensaje = "No tiene puntos suficientes para comprar la unidad";

    public String getMensaje() {
        return mensaje;
    }
}
