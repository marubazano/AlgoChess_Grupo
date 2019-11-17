package vista;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage){
        stage.setTitle("Ventana");

        StackPane layout = new StackPane();

        Button button = new Button();
        layout.getChildren().add(button);

        Label label = new Label();
        label.setText("toma marciooo");
        layout.getChildren().add(label);

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }
}
