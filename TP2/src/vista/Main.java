package vista;


import AlgoChess.Jugador;
import Tablero.Tablero;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {

    Stage stage;
    Jugador jugador1;
    Jugador jugador2;
    Tablero tablero;
    MediaPlayer mediaPlayer;

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
        contenedorPrincipal.setMinHeight(700);

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
        TextField jugador1 = new TextField("Ingrese nombre jugador 1");
        TextField jugador2 = new TextField("Ingrese nombre jugador 2");
        jugador1.textProperty().addListener((observableValue, s, t1) ->{});
        jugador2.textProperty().addListener((observableValue, s, t1) ->{});
        jugador1.setMaxWidth(220);
        jugador2.setMaxWidth(220);
        VBox panelNombreJugadores = new VBox(40);
        panelNombreJugadores.setAlignment(Pos.CENTER);
        canvas.getChildren().add(contenedorBotonSalir);
        BotonJugar jugar = new BotonJugar(contenedorPrincipal, jugador1, jugador2);
        jugar.setOnAction(actionEvent -> {
           // stage.setScene();
        });
        panelNombreJugadores.getChildren().addAll(jugador1, jugador2, jugar);
        contenedorPrincipal.getChildren().add(panelNombreJugadores);
        canvas.getChildren().add(contenedorPrincipal);
        stackPane.getChildren().add(canvas);
        return new Scene(stackPane);
    }

   /* public void prepararMenuInicio() throws Exception{

        window.setTitle("AlgoChess");
        window.setMaxHeight(700);
        window.setMinHeight(700);
        window.setMaxWidth(1000);
        window.setMinWidth(1000);

        Button jugar = new Button("Comenzar");
        jugar.setStyle("-fx-font: 23 arial; -fx-base: #000000; -fx-border-color: #6d1fd8; -fx-text-fill: #f04ef5");
        Button salir = new Button("Salir");
        salir.setStyle("-fx-font: 23 arial; -fx-base: #000000; -fx-border-color: #ec443f; -fx-text-fill: #ec443f");


        Pane layout = new Pane ();

        Image titleBackground = new Image(getClass().getResourceAsStream("imagenes/menu.jpg"), 950, 800, false, true);
        BackgroundImage imagenTitulo = new BackgroundImage(titleBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        layout.setBackground(new Background(imagenTitulo));
        layout.getChildren().add(jugar);
        layout.getChildren().add(salir);
        jugar.setLayoutX(400);
        jugar.setLayoutY(450);

        jugar.setOnAction(e -> {
            try {
                buttonCrearUsuarios();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        salir.setOnAction(e -> System.exit(0));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public void buttonCrearUsuarios () throws Exception{
        Button ingresar = new Button("Ingresar");
        ingresar.setStyle("-fx-font: 23 arial; -fx-base: #000000; -fx-border-color: #6d1fd8; -fx-text-fill: #f04ef5");
        Button salir = new Button("Salir");
        salir.setStyle("-fx-font: 23 arial; -fx-base: #000000; -fx-border-color: #ec443f; -fx-text-fill: #ec443f");

        Pane layout = new Pane ();

        Image titleBackground = new Image(getClass().getResourceAsStream("imagenes/menu.jpg"), 950, 800, false, true);
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
            try {
                crearJugadores(nombreJugador1.getText(),nombreJugador2.getText());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        nombreJugador1.setOnAction(e ->{

        });
        salir.setOnAction(e -> System.exit(0));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public void crearJugadores(String nombre1, String nombre2)throws Exception{
        Jugador jugador1 = new Jugador(nombre1,this.tablero,1);
        Jugador jugador2 = new Jugador(nombre2,this.tablero,2);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        SeleccionUnidades seleccionUnidades = new SeleccionUnidades(this.jugador1,this.jugador2);
        seleccionUnidades.start(window);
    }

    public void reproducirMusicaDeFondo() {
        String musicFile = "/TP2/src/Sonidos/phoenix-ft-cailin-russo-and-chrissy-costanza-worlds-2019-league-of-legends.mp3";
        Media sound = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + musicFile);
        this.mediaPlayer = new MediaPlayer(sound);
        this.mediaPlayer.play();
    }
*/
}

