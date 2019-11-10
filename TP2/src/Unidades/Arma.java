package Unidades;

public class Arma {
    private int daño;

    public Arma(int daño) {
        this.daño = daño;
    }

    public int obtenerDañoDeArma() {
        return this.daño;
    }
}