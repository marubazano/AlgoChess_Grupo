package vista;

import AlgoChess.Jugador;
import Unidades.Unidad;

import java.util.ArrayList;

public class SeleccionDeUnidades {
    Jugador jugador1;
    Jugador jugador2;

    BotonUnidad gatoSoldado;
    BotonUnidad gatoJinete;
    BotonUnidad gatoCurandero;
    BotonUnidad gatoCatapulta;
    BotonUnidad perroSoldado;
    BotonUnidad perroJinete;
    BotonUnidad perroCurandero;
    BotonUnidad perroCatapulta;

    public SeleccionDeUnidades(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        jugador1.asignarTurno(true);
        jugador2.asignarTurno(false);
        this.gatoSoldado = new BotonUnidad("imagenes/gato_soldado_precio.png", Unidad.factoryUnidad("soldado"), jugador1, jugador2);
        this.gatoJinete = new BotonUnidad("imagenes/gato_jinete_precio.png", Unidad.factoryUnidad("jinete"), jugador1, jugador2);
        this.gatoCurandero = new BotonUnidad("imagenes/gato_curandero_precio.png", Unidad.factoryUnidad("curandero"), jugador1, jugador2);
        this.gatoCatapulta = new BotonUnidad("imagenes/gato_catapulta_precio.png", Unidad.factoryUnidad("catapulta"), jugador1, jugador2);
        this.perroSoldado = new BotonUnidad("imagenes/perro_soldado_precio.png", Unidad.factoryUnidad("soldado"), jugador2, jugador1);
        this.perroJinete = new BotonUnidad("imagenes/perro_jinete_precio.png",Unidad.factoryUnidad("jinete"), jugador2, jugador1);
        this.perroCurandero = new BotonUnidad("imagenes/perro_curandero_precio.png", Unidad.factoryUnidad("curandero"), jugador2, jugador1);
        this.perroCatapulta = new BotonUnidad("imagenes/perro_catapulta_precio.png", Unidad.factoryUnidad("catapulta"), jugador2, jugador1);
    }

    public ArrayList<BotonUnidad> unidadesPosiblesJugador1() { //VER SI ESTOY INSTANCIANDO UNIDAD O EN ALGÚN LUGAR TIENE QUE APARECER new();
        ArrayList<BotonUnidad> listaBotones1 = new ArrayList<>();
        listaBotones1.add(gatoSoldado);
        listaBotones1.add(gatoJinete);
        listaBotones1.add(gatoCurandero);
        listaBotones1.add(gatoCatapulta);
        return listaBotones1;
    }

    public ArrayList<BotonUnidad> unidadesPosiblesJugador2() {
        ArrayList<BotonUnidad> listaBotones2 = new ArrayList<>();
        listaBotones2.add(perroSoldado);
        listaBotones2.add(perroJinete);
        listaBotones2.add(perroCurandero);
        listaBotones2.add(perroCatapulta);
        return listaBotones2;
    }


    public void turnoJugador(Jugador jugador) {  //se llama para cada jugador en el handle de botonJugar

        if (jugador == this.jugador1) {
            desbloquearUnidadesJugador1();
            bloquearUnidadesJugador2();
        } else {
            desbloquearUnidadesJugador2();
            bloquearUnidadesJugador1();
        }

        while (jugador.obtenerPuntos() > 0) {

            if (jugador.obtenerPuntos() < 5 ) {
                perroCatapulta.setDisable(true);
                gatoCatapulta.setDisable(true);
            }
            if (jugador.obtenerPuntos() < 3 ) {
                perroJinete.setDisable(true);
                gatoJinete.setDisable(true);
            }
            if (jugador.obtenerPuntos() < 2 ) {
                perroCurandero.setDisable(true);
                gatoCurandero.setDisable(true);
            }

            if (gatoSoldado.isPressed() || gatoJinete.isPressed() || gatoCurandero.isPressed() || gatoCatapulta.isPressed() || perroSoldado.isPressed() || perroJinete.isPressed() || perroCurandero.isPressed() || perroCatapulta.isPressed()) {
                continue;
            }  //feo feo dudoso
        }
    }

    public void bloquearUnidadesJugador2(){
        perroSoldado.setDisable(true);
        perroJinete.setDisable(true);
        perroCurandero.setDisable(true);
        perroCatapulta.setDisable(true);
    }

    public void desbloquearUnidadesJugador2(){
        perroSoldado.setDisable(false);
        perroJinete.setDisable(false);
        perroCurandero.setDisable(false);
        perroCatapulta.setDisable(false);
    }

    public void bloquearUnidadesJugador1(){
        gatoSoldado.setDisable(true);
        gatoJinete.setDisable(true);
        gatoCurandero.setDisable(true);
        gatoCatapulta.setDisable(true);
    }

    public void desbloquearUnidadesJugador1(){
        gatoSoldado.setDisable(false);
        gatoJinete.setDisable(false);
        gatoCurandero.setDisable(false);
        gatoCatapulta.setDisable(false);
    }
}
