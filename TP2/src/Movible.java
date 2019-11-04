import java.util.ArrayList;
//Va protected en el constructor? El constructor tiene que recibir por parámetro vida, costo y armas y después pasarlas por super?
public abstract class Movible extends Unidad {
    protected Movible(float vida, int costo){
        super(vida,costo);
    }

    public void mover(Coordenada coordenada){
        ubicarEnCoordenada(coordenada);
    };
}
