package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Ventana");

        StackPane layout = new StackPane();

        Button button = new Button();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }
}
