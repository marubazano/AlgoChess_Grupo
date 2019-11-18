package vista;


import AlgoChess.Jugador;
import Tablero.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    Stage window;
    Scene escenaJuego;
    Jugador jugador1;
    Jugador jugador2;
    Tablero tablero;
    MediaPlayer mediaPlayer;


    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        window = stage;

        window.setTitle("AlgoChess - Menú Principal");

        Tablero tablero = new Tablero();
        this.tablero = tablero;

        this.reproducirMusicaDeFondo();
        this.prepararMenuInicio();


    }

    public void prepararMenuInicio() {

        window.setTitle("AlgoChess");
        window.setMaxHeight(500);
        window.setMinHeight(500);
        window.setMaxWidth(900);
        window.setMinWidth(900);

        Button jugar = new Button("Comenzar");
        Button salir = new Button("Salir");

        Pane layout = new Pane ();

        Image titleBackground = new Image("Vista/imagenes/tft.jpg", 950, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));
        layout.getChildren().add(jugar);
        layout.getChildren().add(salir);
        jugar.setLayoutX(400);
        jugar.setLayoutY(400);

        jugar.setOnAction(e -> buttonCrearUsuarios() );
        salir.setOnAction(e -> System.exit(0));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public void buttonCrearUsuarios (){
        window.setTitle("AlgoChess");
        window.setMaxHeight(500);
        window.setMinHeight(500);
        window.setMaxWidth(900);
        window.setMinWidth(900);

        Button ingresar = new Button("Ingresar");
        Button salir = new Button("Salir");

        Pane layout = new Pane ();

        Image titleBackground = new Image("Vista/imagenes/tft.jpg", 950, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        TextField nombreJugador1 = new TextField("Jugador 1: Ingrese su nombre");
        TextField nombreJugador2 = new TextField("Jugador 2: Ingrese su nombre");

        layout.setBackground(new Background(imagenTitulo));
        layout.getChildren().add(nombreJugador1);
        layout.getChildren().add(nombreJugador2);
        layout.getChildren().add(ingresar);
        layout.getChildren().add(salir);
        nombreJugador1.setLayoutX(400);
        nombreJugador1.setLayoutY(200);
        nombreJugador2.setLayoutX(400);
        nombreJugador2.setLayoutY(250);
        ingresar.setLayoutX(450);
        ingresar.setLayoutY(350);

        ingresar.setOnAction(e -> {
            crearJugadores(nombreJugador1.getText(),nombreJugador2.getText());
        });
        nombreJugador1.setOnAction(e ->{

        });
        salir.setOnAction(e -> System.exit(0));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public void crearJugadores(String nombre1, String nombre2){
        Jugador jugador1 = new Jugador(nombre1,this.tablero,1);
        Jugador jugador2 = new Jugador(nombre2,this.tablero,2);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void reproducirMusicaDeFondo(){
      /*  String musicFile = "src/Sonidos/Minecraft Background Music.mp3"; Poner archivo que correponda
        Media sound = new Media(new File(musicFile).toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
        this.mediaPlayer.play();*/
    }

}
