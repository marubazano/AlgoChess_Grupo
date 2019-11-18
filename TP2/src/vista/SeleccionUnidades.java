package vista;

import AlgoChess.Jugador;
import Excepciones.PuntosInsuficientesException;
import Unidades.Catapulta;
import Unidades.Curandero;
import Unidades.Jinete;
import Unidades.SoldadoDeInfanteria;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SeleccionUnidades {

    private Jugador jugador1;
    private Jugador jugador2;
    Stage window;

    public SeleccionUnidades(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void main () throws Excepciones.PuntosInsuficientesException{
        seleccionarUnidadesPorJugador(jugador1);
        seleccionarUnidadesPorJugador(jugador2);
    }

    public void seleccionarUnidadesPorJugador (Jugador jugador) throws Excepciones.PuntosInsuficientesException {
        window.setTitle("AlgoChess");
        window.setMaxHeight(700);
        window.setMinHeight(700);
        window.setMaxWidth(1000);
        window.setMinWidth(1000);

        Button soldado = new Button("Comenzar");
        Button jinete = new Button("Comenzar");
        Button catapulta = new Button("Comenzar");
        Button curandero = new Button("Comenzar");
        Button salir = new Button("Salir");
        salir.setStyle("-fx-font: 23 arial; -fx-base: #000000; -fx-border-color: #ec443f; -fx-text-fill: #ec443f");


        Pane layout = new Pane ();

        Image titleBackground = new Image("Vista/imagenes/menu.jpg", 950, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));
        layout.getChildren().add(soldado);
        soldado.setLayoutX(0);
        soldado.setLayoutY(450);
        layout.getChildren().add(jinete);
        jinete.setLayoutX(200);
        jinete.setLayoutY(450);
        layout.getChildren().add(catapulta);
        catapulta.setLayoutX(400);
        catapulta.setLayoutY(450);
        layout.getChildren().add(curandero);
        soldado.setLayoutX(600);
        soldado.setLayoutY(450);
        layout.getChildren().add(salir);

        soldado.setOnAction(e -> {
            SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
            try {
                jugador.comprar(soldado1);
            } catch (PuntosInsuficientesException ex) {
                ex.printStackTrace();
            }
        });
        jinete.setOnAction(e -> {
            Jinete jinete1 = new Jinete();
            try {
                jugador.comprar(jinete1);
            } catch (PuntosInsuficientesException ex) {
                ex.printStackTrace();
            }
        });
        catapulta.setOnAction(e -> {
            Catapulta catapulta1 = new Catapulta();
            try {
                jugador.comprar(catapulta1);
            } catch (PuntosInsuficientesException ex) {
                ex.printStackTrace();
            }
        });
        curandero.setOnAction(e -> {
            Curandero curandero1 = new Curandero();
            try {
                jugador.comprar(curandero1);
            } catch (PuntosInsuficientesException ex) {
                ex.printStackTrace();
            }
        });


        salir.setOnAction(e -> System.exit(0));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }


}
