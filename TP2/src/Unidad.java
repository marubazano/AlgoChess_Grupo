import java.util.ArrayList;

public class Unidad {
    private float vida;
    private int costo;
    private ArrayList<Arma> armas;

    Unidad() {}
}

/*
 * Esta clase es abstracta, cuando hagamos los derivados tipo
 * curandero, catapulta, etc, tenemos que modificar esta.
 * Por ahora la dejamos asi para poder pasar las pruebas.
 */
