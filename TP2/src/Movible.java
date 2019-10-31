import java.util.ArrayList;
//Va protected en el constructor? El constructor tiene que recibir por parámetro vida, costo y armas y después pasarlas por super?
public class Movible extends Unidad {
    protected Movible(float vida, int costo, ArrayList<Arma> armas){
        super(vida,costo,armas);
    }
}
