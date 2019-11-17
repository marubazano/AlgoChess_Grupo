package vista;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        Application.launch(args);
    }

    public void start(Stage stage){
        /*stage.setTitle("Mi primera ventana");
        Button button = new Button("Holis");
        Scene scene = new Scene(button, 200, 200);
        stage.setScene(scene);
        stage.show();*/

        StackPane layout = new StackPane();
        Scene scene = new Scene(layout);
        Button button = new Button("Hola");
        layout.getChildren().add(button);
        stage.setTitle("ventana");
        stage.setScene(scene);

        stage.show();
    }
}
