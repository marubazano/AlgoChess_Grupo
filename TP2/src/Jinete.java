import java.util.ArrayList;

public class Jinete extends Movible {
    private ArrayList<Arma> armas; //ver si conviene terner un arreglo de armas o un atributo para cada arma (como está abajo).
    //private Arma arcoYFlecha;
    //private Arma espada;

    public Jinete(){
        super(100, 3);
        Arma arcoYFlecha = new Arma(15); //ataca media distancia
        Arma espada = new Arma(5); //ataca cuerpo a cuerpo
        this.armas = new ArrayList<>();
        this.armas.add(arcoYFlecha);
        this.armas.add(espada);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga) {
        Coordenada coordenadaEnemiga = unidadEnemiga.obtenerCoordenada();
        /*
       El valor ataque del jinete depende de la distancia hacia su enemigo, ¿necesitariamos un metodo calcularDistancia?
        agregue en los atributos la coordenada del jinete y en los parametros que recibe la coordenada enemiga. Tenemos
        saber si esta al lado (para atacar cuerpo a cuerpo) o si no lo esta (para atacar a distancia). Trate de hacer una
        funcion en Direccion pero no funco.
        Cariños, joaco.
         */
    }

    public int obtenerDañoDeArma() {
        return this.armas.get(0).obtenerDañoDeArma();
    }
}
