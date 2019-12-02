package Controlador;

import Jugador.Jugador;
import Tablero.Tablero;
import Unidades.Unidad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import vista.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ControladorPrincipal {

    private Stage stage;
    private Jugador jugador1;
    private Jugador jugador2;
    private Label labelTurno;
    private Label labelEstadoDeJuego;
    private SeleccionDeUnidades seleccionDeUnidades;
    private TableroVista tableroVista;
    private HashMap<Unidad, Label> infoUnidadesJugador1;
    private HashMap<Unidad, Label> infoUnidadesJugador2;
    private VBox contenedorInfoJugador1;
    private VBox contenedorInfoJugador2;

    public ControladorPrincipal(Stage stage){
        this.stage = stage;
    }

    public StackPane principal(){
        StackPane stackPane = new StackPane();
        stackPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        stackPane.setMinWidth(1024);
        stackPane.setMinHeight(720);
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
        comenzar.setOnAction(actionEvent -> {
            stage.setScene(CreacionDeUsuarios());
            /*stage.setFullScreen(true);*/});
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
            stage.setScene(MenuSeleccionDeUnidades(nombreJugador1.getText(), nombreJugador2.getText()));
            //stage.setFullScreen(true);
        });
        panelNombreJugadores.getChildren().addAll(nombreJugador1, nombreJugador2, jugar);
        contenedorPrincipal.getChildren().add(panelNombreJugadores);
        canvas.getChildren().add(contenedorPrincipal);
        stackPane.getChildren().add(canvas);
        return new Scene(stackPane);
    }

    public Scene MenuSeleccionDeUnidades(String nombreJugador1, String nombreJugador2) {
        Tablero tablero = new Tablero();
        this.jugador1 = new Jugador(nombreJugador1, tablero, 1);
        this.jugador2 = new Jugador(nombreJugador2, tablero, 2);

        BotonSalir botonSalir = new BotonSalir();
        this.labelTurno = new Label();
        cambiarLabelTurno(jugador1);
        labelTurno.setStyle("-fx-text-fill:WHITE;");
        this.labelEstadoDeJuego = new Label();
        cambiarLabelEstadoDeJuego("Seleccione una unidad.");
        labelEstadoDeJuego.setStyle("-fx-text-fill:WHITE;");

        HBox contenedorSuperior = new HBox(10);
        contenedorSuperior.setAlignment(Pos.CENTER_LEFT);
        contenedorSuperior.getChildren().addAll(botonSalir, labelTurno, labelEstadoDeJuego);

        Label puntajeJugador1 = new Label("Puntaje " + jugador1.obtenerNombre() + ": " + jugador1.obtenerPuntos());
        puntajeJugador1.setStyle("-fx-text-fill:#fc9808;");
        Label puntajeJugador2 = new Label("Puntaje " + jugador2.obtenerNombre() + ": " + jugador2.obtenerPuntos());
        puntajeJugador2.setStyle("-fx-text-fill:#6ba3e4;");
        ControladorFlujoJuego controladorFlujoJuego = new ControladorFlujoJuego(jugador1, jugador2, tablero, this);
        this.seleccionDeUnidades = new SeleccionDeUnidades(jugador1, jugador2, this, puntajeJugador1, puntajeJugador2, controladorFlujoJuego);
        seleccionDeUnidades.deshabilitarBotonesUnidadDeJugador(jugador2);

        VBox contenedorUnidadesPosibles1 = new VBox(20);
        contenedorUnidadesPosibles1.setAlignment(Pos.CENTER);
        contenedorUnidadesPosibles1.getChildren().add(puntajeJugador1);
        for (BotonUnidad boton : seleccionDeUnidades.unidadesPosiblesJugador1()) {
            contenedorUnidadesPosibles1.getChildren().add(boton);
        }

        this.tableroVista = new TableroVista(tablero, jugador1, jugador2, controladorFlujoJuego);

        VBox contenedorUnidadesPosibles2 = new VBox(20);
        contenedorUnidadesPosibles2.setAlignment(Pos.CENTER);
        contenedorUnidadesPosibles2.getChildren().add(puntajeJugador2);
        for (BotonUnidad boton : seleccionDeUnidades.unidadesPosiblesJugador2()) {
            contenedorUnidadesPosibles2.getChildren().add(boton);
        }

        HBox contenedorPrincipal = new HBox(30);
        contenedorPrincipal.setMinHeight(700);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.getChildren().addAll(contenedorUnidadesPosibles1, tableroVista, contenedorUnidadesPosibles2);

        VBox canvas = new VBox();
        canvas.getChildren().addAll(contenedorSuperior, contenedorPrincipal);

        StackPane stackPane = principal();
        stackPane.getChildren().add(canvas);

        return new Scene(stackPane);
    }

    public void PantallaDeJuego() {
        BotonSalir botonSalir = new BotonSalir();
        jugador1.asignarTurno(true);
        jugador2.asignarTurno(false);
        cambiarLabelTurno(jugador1);
        cambiarLabelEstadoDeJuego("Comienza el juego!");

        HBox contenedorSuperior = new HBox(10);
        contenedorSuperior.setAlignment(Pos.CENTER_LEFT);
        contenedorSuperior.getChildren().addAll(botonSalir, labelTurno, labelEstadoDeJuego);

        this.infoUnidadesJugador1 = new HashMap<>();
        Label nombreJugador1 = new Label(jugador1.obtenerNombre());
        nombreJugador1.setStyle("-fx-text-fill:#fc9808;");
        ArrayList<Unidad> unidadesJugador1 = jugador1.obtenerListaUnidades();
        for (Unidad unidad : unidadesJugador1) {
            Label labelUnidad = new Label();
            labelUnidad.setText(unidad.getClass().getSimpleName() + " - (" + unidad.obtenerCoordenada().obtenerHorizontal() + ", " + unidad.obtenerCoordenada().obtenerVertical() + ") - " + unidad.obtenerVida());
            labelUnidad.setStyle("-fx-text-fill:WHITE;");
            infoUnidadesJugador1.put(unidad, labelUnidad);
        }

        this.contenedorInfoJugador1 = new VBox(10);
        contenedorInfoJugador1.setAlignment(Pos.CENTER);
        contenedorInfoJugador1.getChildren().add(nombreJugador1);
        for (Label label : infoUnidadesJugador1.values()) {
            contenedorInfoJugador1.getChildren().add(label);
        }

        this.infoUnidadesJugador2 = new HashMap<>();
        Label nombreJugador2 = new Label(jugador2.obtenerNombre());
        nombreJugador2.setStyle("-fx-text-fill:#6ba3e4;");
        ArrayList<Unidad> unidadesJugador2 = jugador2.obtenerListaUnidades();
        for (Unidad unidad : unidadesJugador2) {
            Label labelUnidad = new Label();
            labelUnidad.setText(unidad.getClass().getSimpleName() + " - (" + unidad.obtenerCoordenada().obtenerHorizontal() + ", " + unidad.obtenerCoordenada().obtenerVertical() + ") - " + unidad.obtenerVida());
            labelUnidad.setStyle("-fx-text-fill:WHITE;");
            infoUnidadesJugador2.put(unidad, labelUnidad);
        }

        this.contenedorInfoJugador2 = new VBox(10);
        contenedorInfoJugador2.setAlignment(Pos.CENTER);
        contenedorInfoJugador2.getChildren().add(nombreJugador2);
        for (Label label : infoUnidadesJugador2.values()) {
            contenedorInfoJugador2.getChildren().add(label);
        }

        HBox contenedorPrincipal = new HBox(30);
        contenedorPrincipal.setMinHeight(700);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.getChildren().addAll(contenedorInfoJugador1, this.tableroVista, contenedorInfoJugador2);

        VBox canvas = new VBox();
        canvas.getChildren().addAll(contenedorSuperior, contenedorPrincipal);

        StackPane stackPane = principal();
        stackPane.getChildren().add(canvas);

        stage.setScene(new Scene(stackPane));
        //stage.setFullScreen(true);
    }

    public void PantallaFinal(Jugador ganador) {
        BotonSalir botonSalir = new BotonSalir();
        BotonJugarDeNuevo botonJugarDeNuevo = new BotonJugarDeNuevo();
        botonJugarDeNuevo.setOnAction(actionEvent -> {
            stage.setScene(this.MenuInicio());
            jugador1 = null;
            jugador2 = null;
            labelTurno = null;
            labelEstadoDeJuego = null;
            seleccionDeUnidades = null;
            tableroVista = null;
            infoUnidadesJugador1 = null;
            infoUnidadesJugador2 = null;
            contenedorInfoJugador1 = null;
            contenedorInfoJugador2 = null;
        });

        HBox contenedorBotones = new HBox(30);
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.getChildren().addAll(botonJugarDeNuevo, botonSalir);

        Label labelGanador = new Label();
        labelGanador.setStyle("-fx-text-fill:#2bd61a; -fx-font: 40 arial;");
        labelGanador.setText("GANADOR: " + ganador.obtenerNombre());

        VBox canvas = new VBox(30);
        canvas.setAlignment(Pos.CENTER);
        canvas.getChildren().addAll(labelGanador, contenedorBotones);

        StackPane stackPane = principal();
        stackPane.getChildren().add(canvas);

        stage.setScene(new Scene(stackPane));
    }


    public void cambiarLabelTurno(Jugador jugador) {
        this.labelTurno.setText("Turno de: " + jugador.obtenerNombre() + ".");
    }

    public void cambiarLabelEstadoDeJuego(String mensaje) {
        this.labelEstadoDeJuego.setText(mensaje);
    }

    public void habilitarBotonesUnidadDeJugador(Jugador jugador) {
        this.seleccionDeUnidades.habilitarBotonesUnidadDeJugador(jugador);
    }

    public void cambiarLabelsInfoJugador() {
        for (Unidad unidad : jugador1.obtenerListaUnidades()) {
            Label labelInfoUnidad = infoUnidadesJugador1.get(unidad);
            labelInfoUnidad.setText(unidad.getClass().getSimpleName() + " - (" + unidad.obtenerCoordenada().obtenerHorizontal() + ", " + unidad.obtenerCoordenada().obtenerVertical() + ") - " + unidad.obtenerVida());
        }
        for (Unidad unidad : jugador2.obtenerListaUnidades()) {
            Label labelInfoUnidad = infoUnidadesJugador2.get(unidad);
            labelInfoUnidad.setText(unidad.getClass().getSimpleName() + " - (" + unidad.obtenerCoordenada().obtenerHorizontal() + ", " + unidad.obtenerCoordenada().obtenerVertical() + ") - " + unidad.obtenerVida());
        }
    }

    public void borrarLabelsUnidad(Jugador jugador, ArrayList<Unidad> muertasJugador) {
        if (jugador == jugador1) {
            for (Unidad muerta : muertasJugador) {
                contenedorInfoJugador1.getChildren().remove(infoUnidadesJugador1.get(muerta));
            }
        } else {
            for (Unidad muerta : muertasJugador) {
                contenedorInfoJugador2.getChildren().remove(infoUnidadesJugador2.get(muerta));
            }
        }
    }

}