package vista;

import AlgoChess.Jugador;
import Tablero.Coordenada;
import Tablero.Tablero;
import Unidades.Movible;
import Unidades.Unidad;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;


public class TableroVista extends Group {
    public static final int ancho = 10;
    public static final int alto = 10;
    Tablero tablero;
    Unidad ultimaComprada;
    StackPane principal;
    Jugador jugador1;
    Jugador jugador2;
    Unidad unidadEsperando;
    BotonTablero botonTableroEsperando;
    Label turno;
    Label labelDeEstadoDeAccionDelTurno;
    SeleccionDeUnidades seleccionDeUnidades;
    private ArrayList<Movible> batallon = new ArrayList<>();
    private boolean jugando = false;
    public GridPane tableroGui;
    private Stage stage;
    private CasilleroVista[][] casilleros;


    public TableroVista(Tablero tablero, Jugador jugador1, Jugador jugador2, Label labelPuntajeJugador1, Label labelPuntajeJugador2, Label turno, Label estadoAccion){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        this.turno = turno;
        this.labelDeEstadoDeAccionDelTurno = estadoAccion;
        tableroGui = new GridPane();
        tableroGui.setGridLinesVisible(true);
        casilleros = new CasilleroVista[ancho][alto];
        for (int i = 1; i <= alto; i++) {
            for (int j = 1; j <= ancho; j++) {
                Coordenada coordenada = new Coordenada(i, j);
                BotonTablero boton = new BotonTablero(this, coordenada,jugador1, jugador2, labelPuntajeJugador1, labelPuntajeJugador2);
                if (j >= 6) boton.setStyle("-fx-background-color: #79F1CC;"); // JUGADOR2
                if (j < 6)  boton.setStyle("-fx-background-color: #F99DB8;"); // JUGADOR1
                CasilleroVista casilleroVista = new CasilleroVista(boton);
                casilleroVista.getChildren().add(boton);
                casilleroVista.setPrefSize(60,60);
                tableroGui.add(casilleroVista, j-1, i-1);
                this.casilleros[i-1][j-1] = casilleroVista;
            }
        }
        this.agregarVista(tableroGui);
    }

    public void cambiarEstado(){
        this.jugando = true;
    }

    public boolean estaJugando(){
        return this.jugando;
    }

    public void cambiarUnidadEsperando(Unidad unidad, BotonTablero boton){
        this.unidadEsperando = unidad;
        this.botonTableroEsperando = boton;
    }

    public Unidad obtenerUnidadEsperando(){
        return this.unidadEsperando;
    }

    public BotonTablero obtenerBotonTableroEsperando(){
        return this.botonTableroEsperando;
    }

    public void agregarVista(Node vista){
        this.getChildren().add(vista);
    }

    public void agregarUltimaUnidadComprada(Unidad unidad) {
        this.ultimaComprada = unidad;

    }

    public Unidad obtenerUltimaComprada() {
        return ultimaComprada;
    }

    public Tablero obtenerTablero(){return this.tablero;}

    public void setearStage(Stage stage, StackPane principal){
        this.stage = stage;
        this.principal = principal;
    }

    public void pantallaDeJuego(String nombreJugadorInicial){
        StackPane stackPane = this.principal;
        VBox canvas = new VBox();

        HBox contenedorSuperior = new HBox(10);
        contenedorSuperior.setAlignment(Pos.CENTER_LEFT);
        BotonSalir salir = new BotonSalir();
        this.turno.setText("Es el turno del jugador: " + nombreJugadorInicial + ".");
        this.labelDeEstadoDeAccionDelTurno.setText("Compienzan los gatos."); // VER SI NO QUEDA REFERENCIA A LA PANTALLA ANTERIOR PORQUE LOS LABELS LOS USO ACÁ
        contenedorSuperior.getChildren().addAll(salir, turno, labelDeEstadoDeAccionDelTurno);

        HBox contenedorPrincipal = new HBox(20);                                      //VER ESPACIAMIENTO
        contenedorPrincipal.setMinHeight(700);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        VBox izquierda = new VBox(20);                                       //VER ESPACIAMIENTO
        izquierda.setAlignment(Pos.CENTER);
        // AGREGAR COSAS AL VBOX IZQUIERDO
        Label soldado = new Label("Soldado: ataque-> 10 vida-> 100");
        Label jinete = new Label("Jinete: ataque-> 5/15 vida-> 100");
        Label curandero = new Label("Curandero: cura-> 15 vida-> 75");
        Label catapulta = new Label("Catapulta: ataque-> 20 vida-> 50");
        soldado.setStyle("-fx-font-size:10; -fx-text-fill:WHITE;");
        jinete.setStyle("-fx-font-size:10; -fx-text-fill:WHITE;");
        curandero.setStyle("-fx-font-size:10; -fx-text-fill:WHITE;");
        catapulta.setStyle("-fx-font-size:10; -fx-text-fill:WHITE;");
        izquierda.getChildren().addAll(soldado, jinete, curandero, catapulta);

        HBox contenedorTableroVista = new HBox();
        contenedorTableroVista.getChildren().add(this);

        VBox derecha = new VBox(20);                                       //VER ESPACIAMIENTO // ACÁ VAN LAS INSTRUCCIONES
        derecha.setAlignment(Pos.CENTER);
        // AGREGAR COSAS AL VBOX DERECHO
        Label instrucciones = new Label("Instrucciones:");
        Label instruccion1 = new Label("-clickea una unidad y muevela a un casillero vacío.");
        Label instruccion2 = new Label("-clickea una unidad y ataca una unidad enemiga.");
        Label instruccion3 = new Label("-puedes curar una unidad con un curandero");
        Label instruccion4 = new Label("-crea un batallón de soldados y muevelos en conjunto");
        Label instruccion5 = new Label("-ganas cuando el enemigo se queda sin unidades.");
        instrucciones.setStyle("-fx-font-size:20; -fx-text-fill:WHITE;");
        instruccion1.setStyle("-fx-font-size:10; -fx-text-fill:WHITE;");
        instruccion2.setStyle("-fx-font-size:10; -fx-text-fill:WHITE;");
        instruccion3.setStyle("-fx-font-size:10; -fx-text-fill:WHITE;");
        instruccion4.setStyle("-fx-font-size:10; -fx-text-fill:WHITE;");
        instruccion5.setStyle("-fx-font-size:10; -fx-text-fill:WHITE;");
        derecha.getChildren().addAll(instrucciones, instruccion1, instruccion2, instruccion3, instruccion4, instruccion5);

        contenedorPrincipal.getChildren().addAll(izquierda, contenedorTableroVista, derecha);
        canvas.getChildren().addAll(contenedorSuperior, contenedorPrincipal);
        stackPane.getChildren().add(canvas);

        Alert cartel = new Alert(Alert.AlertType.INFORMATION);
        cartel.setTitle("Comienza el juego");
        cartel.setContentText("Los jugadores ya seleccionaron sus unidades! Comienza el juego!");
        cartel.initStyle(StageStyle.UNDECORATED);
        cartel.showAndWait();

        stage.setScene(new Scene(stackPane));
    }

    public void pantallaGanador(String nombreGanador){
        StackPane stackPane = this.principal;
        VBox canvas = new VBox();
        HBox contenedorSuperior = new HBox();
        BotonSalir salir = new BotonSalir();
        contenedorSuperior.getChildren().add(salir);
        Label ganador = new Label("EL GANADOR ES: " + nombreGanador);
        //stackPane.getChildren().add(ganador);
        canvas.getChildren().addAll(contenedorSuperior, ganador);
        ganador.setStyle("-fx-font-size:30; -fx-text-fill:WHITE;");
        stage.setScene(new Scene(stackPane));
    }


    public void cambiarLabelTurno(String nombreJugadorDeTurno) {
        this.turno.setText("Es el turno del jugador: " + nombreJugadorDeTurno + ".");
    }

    public void cambiarLabelDeAccionDelTurno(String mensaje) {
        this.labelDeEstadoDeAccionDelTurno.setText(mensaje);
    }

    public ArrayList<Movible> obtenerListaBatallon() {
        return batallon;
    }

    public void deshabilitarLadoTablero(int nroJugador) {
        if (nroJugador == 1) {
            for(int i = 1; i <= alto; i++) {
                for (int j = 1; j <= (ancho / 2); j++) {
                    casilleros[i-1][j-1].deshabilitarBoton();
                }
            }
        } else {
            for(int i = 1; i <= alto; i++) {
                for (int j = (ancho / 2) + 1; j <= ancho; j++) {
                    casilleros[i-1][j-1].deshabilitarBoton();
                }
            }
        }
    }

    public void habilitarLadoTablero(int nroJugador) {
        if (nroJugador == 1) {
            for(int i = 1; i <= alto; i++) {
                for (int j = 1; j <= (ancho / 2); j++) {
                    casilleros[i-1][j-1].habilitarBoton();
                }
            }
        } else {
            for(int i = 1; i <= alto; i++) {
                for (int j = (ancho / 2) + 1; j <= ancho; j++) {
                    casilleros[i-1][j-1].habilitarBoton();
                }
            }
        }
    }

    public void setearSeleccionDeUnidades(SeleccionDeUnidades seleccionDeUnidades) {
        this.seleccionDeUnidades = seleccionDeUnidades;
    }

    public void deshabilitarBotonesUnidadDeJugador(int nroJugador) {
        this.seleccionDeUnidades.deshabilitarBotonesUnidadDeJugador(nroJugador);
    }

    public void habilitarBotonesUnidadDeJugador(int nroJugador) {
        this.seleccionDeUnidades.habilitarBotonesUnidadDeJugador(nroJugador);
    }
}
