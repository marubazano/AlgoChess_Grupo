public class PuntosInsuficientesException extends Exception{

    private int puntosError;
    private String mensaje = "No tiene puntos suficientes para comprar la unidad";

    public PuntosInsuficientesException(int puntosError){
        super();
        this.puntosError = puntosError;
    }

    public String getMensaje() {
        return mensaje;
    }
}
