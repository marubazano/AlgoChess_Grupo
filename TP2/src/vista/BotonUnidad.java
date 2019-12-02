package vista;

import Excepciones.PuntosInsuficientesException;
import Jugador.Jugador;
import Unidades.Unidad;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class BotonUnidad extends Button{

    Image imagen;
    Unidad unidad;

    public BotonUnidad(String imagenRuta, String stringUnidad, Jugador jugadorDeTurno, Jugador jugadorSiguiente, SeleccionDeUnidades seleccionDeUnidades){
        super();
        this.unidad = Unidad.factoryUnidad(stringUnidad);
        this.setPrefSize(100,100);
        imagen = new Image(getClass().getResourceAsStream(imagenRuta), 100, 100, false, false);
        ImageView imageView = new ImageView(imagen);
        this.setGraphic(imageView);
        this.setAlignment(Pos.CENTER);
        this.setOnAction(MouseEvent -> {
            try {
                Unidad unidadAComprar = Unidad.factoryUnidad(stringUnidad);
                jugadorDeTurno.comprar(unidadAComprar);
                System.out.println("Compró la unidad");
                seleccionDeUnidades.cambiarUltimaUnidadComprada(unidadAComprar);
                seleccionDeUnidades.cambiarLabelEstadoDeJuego("Ubique la unidad " + unidadAComprar.getClass().getSimpleName());
                seleccionDeUnidades.cambiarLabelPuntajeJugador(jugadorDeTurno);
                seleccionDeUnidades.deshabilitarBotonesUnidadDeJugador(jugadorDeTurno);
                seleccionDeUnidades.deshabilitarBotonesUnidadDeJugador(jugadorSiguiente);

            } catch (PuntosInsuficientesException e) {
                // LA IDEA ES QUE NUNCA LLEGUE ACÁ PORQUE SE BLOQUEAN LOS BOTONES
                e.getMensaje();
            }
        });
    }

    public Unidad obtenerUnidad() {
        return this.unidad;
    }
}