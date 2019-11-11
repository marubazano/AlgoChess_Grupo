package Unidades;
import Tablero.*;
import java.util.HashMap;

public class Jinete extends Movible {

    private HashMap<Distancia, Arma> armas;

    public Jinete(){
        super(100, 3);
        armas = new HashMap<>();
        Arma arcoYFlecha = new Arma(15); //ataca media distancia
        Arma espada = new Arma(5); //ataca cuerpo a cuerpo
        armas.put(Distancia.CERCANA, espada);
        armas.put(Distancia.MEDIANA, arcoYFlecha);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga, Tablero tablero) {
        Coordenada coordenadaEnemiga = unidadEnemiga.obtenerCoordenada();
        Coordenada coordenadaJinete = this.obtenerCoordenada();
        Distancia distancia = coordenadaJinete.calcularDistacia(coordenadaEnemiga);
        unidadEnemiga.recibirDaño(armaSegunDistancia(distancia));
    }

    public int armaSegunDistancia(Distancia distancia){
        int danioArma;
        try {
            danioArma = armas.get(distancia).obtenerDañoDeArma();
        } catch(NullPointerException e){
            return 0;
        }
        return danioArma;
    }
}
