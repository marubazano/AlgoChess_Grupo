package vista;

import Controlador.Observador;
import Unidades.Unidad;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class UnidadVista implements Observador {
    private static final int escalaUnidad = 1;
    private TableroVista tableroGui;
    ImageView imagenUnidad;

    private Unidad unidad;
    private int posHorizontalAnterior;
    private int posVerticalAnterior;

    public UnidadVista(TableroVista tableroGui, Unidad unidad){
        this.tableroGui = tableroGui;
        this.unidad = unidad;
        posHorizontalAnterior = unidad.obtenerCoordenada().obtenerHorizontal();
        posVerticalAnterior = unidad.obtenerCoordenada().obtenerVertical();
        imagenUnidad = new ImageView();
        imagenUnidad.setScaleX(escalaUnidad);
        imagenUnidad.setScaleY(escalaUnidad);
        imagenUnidad.setFitHeight(20*2); //CantidadCasilleros * escala de la vista (no borrar)
        imagenUnidad.setFitWidth(20*2);
        imagenUnidad.setImage(new Image(getClass().getResourceAsStream("imagenes/gato_curandero.jpg")));

        tableroGui.agregarVistaAlMapa(imagenUnidad, unidad.obtenerCoordenada().obtenerHorizontal()-1, unidad.obtenerCoordenada().obtenerVertical()-1);
        dibujar();
    }

    private void dibujar() {
        imagenUnidad.setTranslateX(0);
        imagenUnidad.setTranslateY(0);
        //tableroGui.updateVista(imagenUnidad);
    }

    @Override
    public void change(){
        int horActual = unidad.obtenerCoordenada().obtenerHorizontal();
        int vertActual = unidad.obtenerCoordenada().obtenerVertical();
        if(posHorizontalAnterior > horActual ){
            this.imagenUnidad.setScaleX(- Math.abs(imagenUnidad.getScaleX()));
        }
        else if(posHorizontalAnterior < horActual)
            this.imagenUnidad.setScaleX(Math.abs(imagenUnidad.getScaleX()));
        this.posHorizontalAnterior = unidad.obtenerCoordenada().obtenerHorizontal();
        this.posVerticalAnterior = unidad.obtenerCoordenada().obtenerVertical();
        tableroGui.agregarVistaAlMapa(this.imagenUnidad, horActual-1, vertActual-1);
    }
}
