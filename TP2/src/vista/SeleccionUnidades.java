package vista;

import AlgoChess.Jugador;
import Excepciones.PuntosInsuficientesException;
import Unidades.Catapulta;
import Unidades.Curandero;
import Unidades.Jinete;
import Unidades.SoldadoDeInfanteria;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SeleccionUnidades extends Application {

    private Jugador jugador1;
    private Jugador jugador2;
    Stage window;

    public SeleccionUnidades(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.window = stage;
        seleccionarUnidadesPorJugador(jugador1);
        seleccionarUnidadesPorJugador(jugador2);
    }


    public void seleccionarUnidadesPorJugador (Jugador jugador) {
       /* window.setTitle("Seleccionar Unidades");
        window.setMaxHeight(700);
        window.setMinHeight(700);
        window.setMaxWidth(1000);
        window.setMinWidth(1000);
        Pane layout = new Pane ();

        TableroVista vistaTablero = new TableroVista();


        Image imagenSoldado = new Image("Vista/imagenes/gato_soldado_precio.png", 200, 200, false, true);
        ImageView imageViewSoldado = new ImageView(imagenSoldado);
        Button soldado = new Button("Soldado",imageViewSoldado);
        soldado.setMinSize(200,200);
        soldado.setMaxSize(200,200);
        soldado.setPrefSize(200,200);

        Image imagenJinete = new Image("Vista/imagenes/gato_jinete_precio.png", 200, 200, false, true);
        ImageView imageViewJinete = new ImageView(imagenJinete);
        Button jinete = new Button("jinete",imageViewJinete);
        jinete.setMinSize(200,200);
        jinete.setMaxSize(200,200);
        jinete.setPrefSize(200,200);

        Image imagenCatapulta = new Image("Vista/imagenes/gato_catapulta_precio.png", 200, 200, false, true);
        ImageView imageViewCatapulta = new ImageView(imagenCatapulta);
        Button catapulta = new Button("catapulta",imageViewCatapulta);
        catapulta.setMinSize(200,200);
        catapulta.setMaxSize(200,200);
        catapulta.setPrefSize(200,200);

        Image imagenCurandero = new Image("Vista/imagenes/gato_curandero_precio.png", 200, 200, false, true);
        ImageView imageViewCurandero = new ImageView(imagenCurandero);
        Button curandero = new Button("catapulta",imageViewCurandero);
        curandero.setMinSize(200,200);
        curandero.setMaxSize(200,200);
        curandero.setPrefSize(200,200);

        Button salir = new Button("Salir");
        salir.setStyle("-fx-font: 23 arial; -fx-base: #000000; -fx-border-color: #ec443f; -fx-text-fill: #ec443f");

        Image titleBackground = new Image("Vista/imagenes/menu.jpg", 950, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));
        layout.getChildren().add(soldado);
        soldado.setLayoutX(50);
        soldado.setLayoutY(450);
        layout.getChildren().add(jinete);
        jinete.setLayoutX(250);
        jinete.setLayoutY(450);
        layout.getChildren().add(catapulta);
        catapulta.setLayoutX(450);
        catapulta.setLayoutY(450);
        layout.getChildren().add(curandero);
        curandero.setLayoutX(650);
        curandero.setLayoutY(450);
        layout.getChildren().add(salir);

        layout.getChildren().add(vistaTablero.getTablero());
        vistaTablero.getTablero().setLayoutX(100);
        vistaTablero.getTablero().setLayoutX(100);

        soldado.setOnAction(e -> {
            SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
            try {
                jugador.comprar(soldado1);
            } catch (PuntosInsuficientesException ex) {
                ex.printStackTrace();
                return;
            }
        });
        jinete.setOnAction(e -> {
            Jinete jinete1 = new Jinete();
            try {
                jugador.comprar(jinete1);
            } catch (PuntosInsuficientesException ex) {
                ex.printStackTrace();
                return;
            }
        });
        catapulta.setOnAction(e -> {
            Catapulta catapulta1 = new Catapulta();
            try {
                jugador.comprar(catapulta1);
            } catch (PuntosInsuficientesException ex) {
                ex.printStackTrace();
                return;
            }
        });
        curandero.setOnAction(e -> {
            Curandero curandero1 = new Curandero();
            try {
                jugador.comprar(curandero1);
            } catch (PuntosInsuficientesException ex) {
                ex.printStackTrace();
                return;
            }
        });


        salir.setOnAction(e -> System.exit(0));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();*/
    }

}
