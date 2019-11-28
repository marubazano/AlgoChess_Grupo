package vista;


import AlgoChess.Jugador;
import Tablero.Tablero;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
    Stage stage;
    Jugador jugador1;
    Jugador jugador2;
    Tablero tablero;
    MediaPlayer mediaPlayer;
    //TableroVista tableroVista;                            SE CREA EN MenuSeleccionDeUnidades

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Scene scene = MenuInicio();
        stage.setTitle("AlgoChess");
        stage.setScene(scene);
        stage.setMinWidth(950);
        stage.setMinHeight(800);
        reproducirMusicaDeFondo();
        stage.show();
    }

    public StackPane principal(){
        StackPane stackPane = new StackPane();
        Image titleBackground = new Image(getClass().getResourceAsStream("imagenes/menu.jpg"), 950, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        stackPane.setBackground(new Background(imagenTitulo));
        stackPane.setMinWidth(950);
        stackPane.setMinHeight(800);
        return stackPane;
    }

    public Scene MenuInicio(){
        StackPane stackPane = principal();
        VBox canvas = new VBox();
        HBox contenedorBotonSalir = new HBox();
        BotonSalir salir = new BotonSalir();
        contenedorBotonSalir.getChildren().add(salir);
        HBox contenedorPrincipal = new HBox();
        contenedorPrincipal.setMinHeight(900);

        BotonComenzar comenzar = new BotonComenzar(contenedorPrincipal);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.getChildren().add(comenzar);
        comenzar.setOnAction(actionEvent -> {stage.setScene(CreacionDeUsuarios());});
        canvas.getChildren().add(contenedorBotonSalir);
        canvas.getChildren().add(contenedorPrincipal);


        stackPane.getChildren().add(canvas);
        return new Scene(stackPane);
    }

    public Scene CreacionDeUsuarios(){
        StackPane stackPane = principal();
        VBox canvas = new VBox();
        HBox contenedorBotonSalir = new HBox();
        BotonSalir salir = new BotonSalir();
        contenedorBotonSalir.getChildren().add(salir);
        HBox contenedorPrincipal = new HBox();
        contenedorPrincipal.setMinHeight(700);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        TextField nombreJugador1 = new TextField("Ingrese nombre jugador 1");
        TextField nombreJugador2 = new TextField("Ingrese nombre jugador 2");
        nombreJugador1.textProperty().addListener((observableValue, s, t1) ->{});
        nombreJugador2.textProperty().addListener((observableValue, s, t1) ->{});
        nombreJugador1.setMaxWidth(220);
        nombreJugador2.setMaxWidth(220);
        VBox panelNombreJugadores = new VBox(40);
        panelNombreJugadores.setAlignment(Pos.CENTER);
        canvas.getChildren().add(contenedorBotonSalir);
        BotonJugar jugar = new BotonJugar(contenedorPrincipal, nombreJugador1, nombreJugador2);
        jugar.setOnAction(actionEvent -> {
            Tablero tablero = new Tablero();
            stage.setScene(MenuSeleccionDeUnidades(tablero, new Jugador(nombreJugador1.getText(), tablero, 1), new Jugador(nombreJugador2.getText(), tablero, 2)));
        });
        panelNombreJugadores.getChildren().addAll(nombreJugador1, nombreJugador2, jugar);
        contenedorPrincipal.getChildren().add(panelNombreJugadores);
        canvas.getChildren().add(contenedorPrincipal);
        stackPane.getChildren().add(canvas);
        return new Scene(stackPane);
    }

    public Scene MenuSeleccionDeUnidades(Tablero tablero, Jugador jugador1, Jugador jugador2) {
        StackPane stackPane = principal();
        VBox canvas = new VBox();
        HBox contenedorBotonSalir = new HBox();
        BotonSalir salir = new BotonSalir();
        contenedorBotonSalir.getChildren().add(salir);

        Label puntajeJugador1 = new Label("Puntaje jugador 1: " + jugador1.obtenerPuntos());
        puntajeJugador1.setStyle("-fx-text-fill:WHITE;");
        Label puntajeJugador2 = new Label("Puntaje jugador 2: " + jugador2.obtenerPuntos());
        puntajeJugador2.setStyle("-fx-text-fill:WHITE;");

        HBox contenedorPrincipal = new HBox(20);                                      //VER ESPACIAMIENTO
        contenedorPrincipal.setMinHeight(700);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        TableroVista tableroVista = new TableroVista(tablero, jugador1, jugador2, puntajeJugador1, puntajeJugador2);
        tableroVista.setearStage(this.stage, principal());

        SeleccionDeUnidades seleccion = new SeleccionDeUnidades(jugador1, jugador2, tableroVista);

        VBox contenedorUnidades1 = new VBox(20);                                       //VER ESPACIAMIENTO
        contenedorUnidades1.setAlignment(Pos.CENTER);
        contenedorUnidades1.getChildren().add(puntajeJugador1);
        for (BotonUnidad boton1 : seleccion.unidadesPosiblesJugador1()) {
            contenedorUnidades1.getChildren().add(boton1);
        }

        VBox contenedorUnidades2 = new VBox(20);                                       //VER ESPACIAMIENTO
        contenedorUnidades2.setAlignment(Pos.CENTER);
        contenedorUnidades2.getChildren().add(puntajeJugador2);
        for (BotonUnidad boton2 : seleccion.unidadesPosiblesJugador2()) {
            contenedorUnidades2.getChildren().add(boton2);
        }

        HBox contenedorTableroVista = new HBox();
        contenedorTableroVista.getChildren().add(tableroVista);
        /*HBox contenedorBotonPasar = new HBox();
        BotonPasar pasar = new BotonPasar();
        contenedorBotonPasar.getChildren().add(pasar);*/

        contenedorPrincipal.getChildren().addAll(contenedorUnidades1, contenedorTableroVista, contenedorUnidades2);
        canvas.getChildren().addAll(contenedorBotonSalir, contenedorPrincipal);
        stackPane.getChildren().add(canvas);
        //pasar.setOnMouseClicked(mouseEvent -> {});
        // esto seria para pasar a la ubicacion de unidades si no lo hacemos en esta seccion
        return new Scene(stackPane);
    }

    /*public Scene MenuUbicacionUnidades(TableroVista tableroVista, Jugador jugador1, Jugador jugador2){
        StackPane stackPane = principal();
        VBox canvas = new VBox();
        HBox contenedorBotonSalir = new HBox();
        BotonSalir salir = new BotonSalir();
        contenedorBotonSalir.getChildren().add(salir);

        HBox contenedorTableroVista = new HBox();
        contenedorTableroVista.getChildren().add(tableroVista);

        HBox contenedorPrincipal = new HBox(20);                                      //VER ESPACIAMIENTO
        contenedorPrincipal.setMinHeight(700);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        VBox contenedorUnidades = new VBox();
        VBox unidadesJugador1 = new VBox();
        VBox unidadesJugador2 = new VBox();
        for(Unidad unidad : jugador1.obtenerListaUnidades()){
            UnidadVista vista = new UnidadVista(tableroVista, unidad);
            unidadesJugador1.getChildren().add(vista);
        }
        for(Unidad unidad : jugador2.obtenerListaUnidades()){
            UnidadVista vista = new UnidadVista(tableroVista, unidad);
            unidadesJugador2.getChildren().add(vista);
        }
        contenedorUnidades.getChildren().addAll(unidadesJugador1, unidadesJugador2);

        canvas.getChildren().add(contenedorUnidades);
        stackPane.getChildren().add(canvas);

        return new Scene(stackPane);
    }*/



    public void reproducirMusicaDeFondo() {
        String musicFile = "/TP2/src/Sonidos/phoenix-ft-cailin-russo-and-chrissy-costanza-worlds-2019-league-of-legends.mp3";
        Media sound = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + musicFile);
        this.mediaPlayer = new MediaPlayer(sound);
        this.mediaPlayer.play();
    }
}

