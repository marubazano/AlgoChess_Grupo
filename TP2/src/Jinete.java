import java.util.ArrayList;

public class Jinete extends Movible {
    private ArrayList<Arma> armas; //Ataca cuerpo a cuerpo y a distancia
    private int dañoCuerpoACuerpo = 5;
    private int dañoCuerpoADistancia = 15;
    private Coordenada coordenada= obtenerCoordenada();

    public Jinete(){
        super(100, 3);
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

    public int getDañoDeArma() {
        return this.armas.get(0).getDaño();
    }

}
