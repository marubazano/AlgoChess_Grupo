package Unidades;

public class Arma {
    private int danio;

    public Arma(int danio) {
        this.danio = danio;
    }

    public int obtenerDanioDeArma() {
        return this.danio;
    }
}