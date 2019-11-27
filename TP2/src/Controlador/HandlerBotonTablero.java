package Controlador;

import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import Tablero.Coordenada;
import Tablero.Tablero;
import Unidades.Unidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.CasilleroVista;
import vista.TableroVista;

public class HandlerBotonTablero implements EventHandler<MouseEvent> {

    private CasilleroVista casilleroVista;
    private Coordenada coordenada;
    private TableroVista tableroVista;
    private Tablero tablero;


    public HandlerBotonTablero(TableroVista tableroVista, CasilleroVista casilleroVista, Coordenada coordenada){
        super();
        this.tableroVista = tableroVista;
        this.casilleroVista = casilleroVista;
        this.coordenada = coordenada;
        this.tablero = tableroVista.obtenerTablero();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Unidad unidad = tableroVista.obtenerUltimaComprada();
        try{
            tablero.ubicarUnidad(unidad, coordenada);
            casilleroVista.update();
            System.out.println(coordenada.obtenerVertical() + " " + coordenada.obtenerHorizontal());

        } catch (CasilleroInvalidoException e) {
            e.getMensaje();
        } catch (CasilleroOcupadoException e) {
            e.getMensaje();
        }
    }
}
