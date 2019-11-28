package vista;

import AlgoChess.Jugador;
import Tablero.Casillero;
import Tablero.Coordenada;
import Tablero.Tablero;
import Unidades.Unidad;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class TableroVista extends Group {
    public static final double casilleroSize = 2;
    public static final int ancho = 20;
    public static final int alto = 20;
    Tablero tablero;
    Unidad ultimaComprada;
    StackPane principal;
    Jugador jugador1;
    Jugador jugador2;
    Unidad unidadEsperando;
    BotonTablero botonTableroEsperando;
    Label turno;
    Label labelDeAccion;

    private boolean jugando = false;

    public GridPane tableroGui;
    private Stage stage;

    private CasilleroVista[][] casilleros;

    public TableroVista(Tablero tablero, Jugador jugador1, Jugador jugador2, Label labelPuntajeJugador1, Label labelPuntajeJugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        tableroGui = new GridPane();
        tableroGui.setGridLinesVisible(true);
        casilleros = new CasilleroVista[ancho][alto];
        for(int i = 1; i <= alto; i++) {
            for(int j = 1; j <= ancho; j++) {
                Coordenada coordenada = new Coordenada(i, j);
                Casillero casillero = tablero.obtenerCasillero(coordenada);
                //casilleroVista.setStyle("-fx-background-color: white; -fx-border-color: black;");
                BotonTablero boton = new BotonTablero(this, coordenada,jugador1, jugador2, labelPuntajeJugador1, labelPuntajeJugador2);
                if (j >= 11) boton.setStyle("-fx-background-color: #79F1CC;");
                if (j < 11)  boton.setStyle("-fx-background-color: #F99DB8;");
                CasilleroVista casilleroVista = new CasilleroVista(casillero, jugador1, jugador2, boton);
                casilleroVista.getChildren().add(boton);
                casilleroVista.setPrefSize(33,33);
                tableroGui.add(casilleroVista, i, j);
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

    public void agregarVistaAlMapa (){
        for (int i=1; i<=alto; i++ ){
            for ( int j=1; j<= ancho; j++){
                CasilleroVista casilleroVista = this.casilleros[i-1][j-1];
                casilleroVista.update();
            }
        }
    }

    public void agregarVista(Node vista){
        this.getChildren().add(vista);
    }

    public void updateVista(Node vista){
        this.getChildren().remove(vista);
        this.getChildren().add(vista);
    }

    public GridPane getGridPane() {
        return this.tableroGui;
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

    public void pantallaDeJuego(int jugadorInicial){
        StackPane stackPane = this.principal;
        VBox canvas = new VBox();

        HBox contenedorSuperior = new HBox();
        BotonSalir salir = new BotonSalir();
        HBox contenedorEstadosDeJuego = new HBox();
        contenedorEstadosDeJuego.setAlignment(Pos.CENTER);
        this.turno = new Label("Es el turno del jugador: " + jugadorInicial);
        turno.setStyle("-fx-font-size:20; -fx-text-fill:WHITE;");
        this.labelDeAccion = new Label("Compienzan los gatos.");
        contenedorEstadosDeJuego.getChildren().add(turno);
        contenedorSuperior.getChildren().addAll(salir, contenedorEstadosDeJuego);

        HBox contenedorPrincipal = new HBox(20);                                      //VER ESPACIAMIENTO
        contenedorPrincipal.setMinHeight(700);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        VBox izquierda = new VBox(20);                                       //VER ESPACIAMIENTO
        izquierda.setAlignment(Pos.CENTER);
        // AGREGAR COSAS AL VBOX IZQUIERDO
        Label soldado = new Label("Soldado: ataque-> vida-> ");
        Label jinete = new Label("Jinete: ataque-> vida-> ");
        Label curandero = new Label("Curandero: ataque-> vida-> ");
        Label catapulta = new Label("Catapulta: ataque-> vida-> ");
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
        stage.setScene(new Scene(stackPane));
    }

    public void cambiarLabelTurno(int jugadorDeTurno) {
        this.turno.setText("Es el turno del jugador: " + jugadorDeTurno);
    }
}
