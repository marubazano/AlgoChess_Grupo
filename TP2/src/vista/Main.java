package vista;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    Stage window;
    Scene escenaJuego;


    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        window = stage;

        window.setTitle("AlgoChess - Menú Principal");

        this.reproducirMusicaDeFondo();
        this.prepararMenuInicio();

    }

    public void prepararMenuInicio() throws FileNotFoundException {

        window.setTitle("AlgoChess");
        window.setMaxHeight(500);
        window.setMinHeight(500);
        window.setMaxWidth(900);
        window.setMinWidth(900);

        Button jugar = new Button("JUGAR");
        Button salir = new Button("Salir");

        Pane layout = new Pane ();
        layout.getChildren().add(jugar);
        layout.getChildren().add(salir);
        jugar.setLayoutX(400);
        jugar.setLayoutY(400);

        jugar.setOnAction(e -> window.setScene(escenaJuego));
        salir.setOnAction(e -> System.exit(0));

        Image titleBackground = new Image("Vista/imagenes/tft.jpg", 950, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        layout.setBackground(new Background(imagenTitulo));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public void reproducirMusicaDeFondo(){

    }

}
