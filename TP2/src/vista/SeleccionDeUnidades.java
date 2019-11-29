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
    TableroVista tableroVista;

    public SeleccionDeUnidades(Jugador jugador1, Jugador jugador2, TableroVista tableroVista) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        jugador1.asignarTurno(true);
        jugador2.asignarTurno(false);
        this.tableroVista = tableroVista;
        this.perroSoldado = new BotonUnidad("imagenes/perro_soldado_precio.png", Unidad.factoryUnidad("soldado"), jugador1, jugador2, tableroVista);
        this.perroJinete = new BotonUnidad("imagenes/perro_jinete_precio.png", Unidad.factoryUnidad("jinete"), jugador1, jugador2, tableroVista);
        this.perroCurandero = new BotonUnidad("imagenes/perro_curandero_precio.png", Unidad.factoryUnidad("curandero"), jugador1, jugador2, tableroVista);
        this.perroCatapulta = new BotonUnidad("imagenes/perro_catapulta_precio.png", Unidad.factoryUnidad("catapulta"), jugador1, jugador2, tableroVista);
        this.gatoSoldado = new BotonUnidad("imagenes/gato_soldado_precio.png", Unidad.factoryUnidad("soldado"), jugador2, jugador1, tableroVista);
        this.gatoJinete = new BotonUnidad("imagenes/gato_jinete_precio.png",Unidad.factoryUnidad("jinete"), jugador2, jugador1, tableroVista);
        this.gatoCurandero = new BotonUnidad("imagenes/gato_curandero_precio.png", Unidad.factoryUnidad("curandero"), jugador2, jugador1, tableroVista);
        this.gatoCatapulta = new BotonUnidad("imagenes/gato_catapulta_precio.png", Unidad.factoryUnidad("catapulta"), jugador2, jugador1, tableroVista);
    }

    public ArrayList<BotonUnidad> unidadesPosiblesJugador1() { //VER SI ESTOY INSTANCIANDO UNIDAD O EN ALGÚN LUGAR TIENE QUE APARECER new();
        ArrayList<BotonUnidad> listaBotones1 = new ArrayList<>();
        listaBotones1.add(perroSoldado);
        listaBotones1.add(perroCurandero);
        listaBotones1.add(perroJinete);
        listaBotones1.add(perroCatapulta);
        return listaBotones1;
    }

    public ArrayList<BotonUnidad> unidadesPosiblesJugador2() {
        ArrayList<BotonUnidad> listaBotones2 = new ArrayList<>();
        listaBotones2.add(gatoSoldado);
        listaBotones2.add(gatoCurandero);
        listaBotones2.add(gatoJinete);
        listaBotones2.add(gatoCatapulta);
        return listaBotones2;
    }


    /*public void turnoJugador(Jugador jugador) {  //se llama para cada jugador en el handle de botonJugar

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
    }*/

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

    /*public void estadoBotones(Jugador jugador){
        if (jugador.obtenerPuntos() < 5 ) {
           if(jugador == this.jugador1) perroCatapulta.setDisable(true);
           else gatoCatapulta.setDisable(true);
        }
        if (jugador.obtenerPuntos() < 3 ) {
            if(jugador == this.jugador1) perroJinete.setDisable(true);
            else gatoJinete.setDisable(true);
        }
        if (jugador.obtenerPuntos() < 2 ) {
            if(jugador == this.jugador1) perroCurandero.setDisable(true);
           else gatoCurandero.setDisable(true);
        }
        if (jugador.obtenerPuntos() < 1 ) {
            if(jugador == this.jugador1) perroSoldado.setDisable(true);
            else gatoSoldado.setDisable(true);
        }
    }*/

    public void deshabilitarBotonesUnidadDeJugador(int nroJugador) {
        if (nroJugador == 1) {
            for (BotonUnidad boton : unidadesPosiblesJugador1()){
                boton.setDisable(true);
            }
        } else {
            for (BotonUnidad boton : unidadesPosiblesJugador2()){
                boton.setDisable(true);
            }
        }
    }

    public void habilitarBotonesUnidadDeJugador(int nroJugador) {
        if (nroJugador == 1) {
            int puntosJugador1 = jugador1.obtenerPuntos();
            for (BotonUnidad boton : unidadesPosiblesJugador1()){
                if (boton.obtenerUnidad().obtenerCosto() <= puntosJugador1) {
                    boton.setDisable(false);
                } else {
                    boton.setDisable(true);
                }
            }
        } else {
            int puntosJugador2 = jugador2.obtenerPuntos();
            for (BotonUnidad boton : unidadesPosiblesJugador2()){
                if (boton.obtenerUnidad().obtenerCosto() <= puntosJugador2) {
                    boton.setDisable(false);
                } else {
                    boton.setDisable(true);
                }
            }
        }
    }

}
