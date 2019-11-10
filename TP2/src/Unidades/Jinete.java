package Unidades;
import Tablero.*;

import java.util.ArrayList;

public class Jinete extends Movible {
    private ArrayList<Arma> armas; //ver si conviene terner un arreglo de armas o un atributo para cada arma (como está abajo).
    //private Unidades.Arma arcoYFlecha;
    //private Unidades.Arma espada;

    public Jinete(){
        super(100, 3);
        Arma arcoYFlecha = new Arma(15); //ataca media distancia
        Arma espada = new Arma(5); //ataca cuerpo a cuerpo
        this.armas = new ArrayList<>();
        this.armas.add(arcoYFlecha);
        this.armas.add(espada);
    }

    @Override
    public void realizarAccion(Unidad unidadEnemiga, Tablero tablero) {
        Coordenada coordenadaEnemiga = unidadEnemiga.obtenerCoordenada();
        Coordenada coordenadaJinete = this.obtenerCoordenada();
        Coordenada distancia = coordenadaJinete.calcularDistacia(coordenadaEnemiga);
        int distEnX = obtenerDistanciaPositivaX(distancia);
        int distEnY = obtenerDistanciaPositivaY(distancia);
        if (distEnX<=2 && distEnY<=2)
            unidadEnemiga.recibirDaño(obtenerDañoDeArma("Espada"));//distancia corta, ataque con espada
        if((distEnX>2 && distEnX<=5) && (distEnY>2 && distEnY<=5))
            unidadEnemiga.recibirDaño(obtenerDañoDeArma("ArcoYFlecha"));// distancia media, ataque con arco y flecha
        if (distEnX>6 && distEnY>6)
            return; //distancia lejana jinete no realiza daño al enemigo

    }

    public int obtenerDistanciaPositivaX(Coordenada coordenada){
        int distX = coordenada.obtenerHorizontal();
        if (distX<0) distX=distX*(-1);
        return distX;
    }

    public int obtenerDistanciaPositivaY(Coordenada coordenada){
        int distY = coordenada.obtenerVertical();
        if (distY<0) distY=distY*(-1);
        return distY;
    }



    public int obtenerDañoDeArma(String arma) {
        int n;
        if (arma=="Espada") n=1;
        else n=0;
        return this.armas.get(n).obtenerDañoDeArma();
    }
}
