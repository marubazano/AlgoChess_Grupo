package vista;

import AlgoChess.Jugador;
import Unidades.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
    BotonPasar pasar = new BotonPasar();

    public SeleccionDeUnidades(){
        BotonUnidad gatoSoldado = new BotonUnidad("imagenes/gato_soldado_precio.png", Unidad.factoryUnidad("soldado"), jugador1);
        BotonUnidad gatoJinete = new BotonUnidad("imagenes/gato_jinete_precio.png", Unidad.factoryUnidad("jinete"), jugador1);
        BotonUnidad gatoCurandero = new BotonUnidad("imagenes/gato_curandero_precio.png", Unidad.factoryUnidad("curandero"), jugador1);
        BotonUnidad gatoCatapulta = new BotonUnidad("imagenes/gato_catapulta_precio.png", Unidad.factoryUnidad("catapulta"), jugador1);
        BotonUnidad perroSoldado = new BotonUnidad("imagenes/perro_soldado_precio.png", Unidad.factoryUnidad("soldado"), jugador2);
        BotonUnidad perroJinete = new BotonUnidad("imagenes/perro_jinete_precio.png",Unidad.factoryUnidad("jinete"), jugador2);
        BotonUnidad perroCurandero = new BotonUnidad("imagenes/perro_curandero_precio.png", Unidad.factoryUnidad("curandero"), jugador2);
        BotonUnidad perroCatapulta = new BotonUnidad("imagenes/perro_catapulta_precio.png", Unidad.factoryUnidad("catapulta"), jugador2);

    }

    public void start(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void turnoJugador(Jugador jugador) {  //se llama para cada jugador en el handle de botonComenzar

        if (jugador == this.jugador1) {
            desbloquearUnidadesJugador1();
            bloquearUnidadesJugador2();
        } else {
            desbloquearUnidadesJugador2();
            bloquearUnidadesJugador1();
        }

        while (jugador.obtenerPuntos() > 0) {

            if(pasar.isPressed()) {
                break;
            }

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
