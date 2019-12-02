package vista;


import Controlador.ControladorPrincipal;
import Jugador.Jugador;
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

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage) {
        this.stage = stage;
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(this.stage);
        stage.setTitle("AlgoChess");
        stage.setMinWidth(1024);
        stage.setMinHeight(720);
        stage.setScene(controladorPrincipal.MenuInicio());
        stage.show();
    }



    /*public void reproducirMusicaDeFondo() {
        String musicFile = "/TP2/src/Sonidos/phoenix-ft-cailin-russo-and-chrissy-costanza-worlds-2019-league-of-legends.mp3";
        Media sound = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + musicFile);
        this.mediaPlayer = new MediaPlayer(sound);
        this.mediaPlayer.play();
    }*/
}

