package Tablero;


public enum Distancia {
    CERCANA,
    MEDIANA,
    LEJANA;

    Distancia(){};

    public static Distancia obtenerDistancia(int x){
        if(x <= 2) return CERCANA;
        else if(x >= 3 && x <= 5) return MEDIANA;
        return LEJANA;
    }
}
