package vista;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.Random;

public class Main extends Application {

    Stage window;
    Scene escenaJuego;


    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage){
        window = stage;

        window.setTitle("AlgoChess - Menú Principal");

        this.reproducirMusicaDeFondo();
        this.prepararMenuInicio();

        StackPane layout = new StackPane();

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public void prepararMenuInicio() {

        window.setTitle("AlgoChess");
        window.setMaxHeight(500);
        window.setMinHeight(500);
        window.setMaxWidth(900);
        window.setMinWidth(900);

        Button jugar = new Button("JUGAR");
        Button salir = new Button("Salir");

        StackPane layout = new StackPane();
        layout.getChildren().add(jugar);
        layout.getChildren().add(salir);

        jugar.setOnAction(e -> window.setScene(escenaJuego));
        salir.setOnAction(e -> System.exit(0));

        /*Image titleBackground = new Image("~/IdeaProjects/AlgoChess_Grupo/TP2/src/vista/imagenes/tft.jpg", 950, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);           NO ENCUENTRA LA IMAGEN REVISAR   */


    }

    public void reproducirMusicaDeFondo(){

    }

}
