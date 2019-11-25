package vista;

import Unidades.Unidad;;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;


public class UnidadVista extends Pane{
    private static final int escalaUnidad = 1;
    private TableroVista tableroGui;
    ImageView imagenUnidad;

    private Unidad unidad;
    private int posHorizontalAnterior;
    private int posVerticalAnterior;

    public UnidadVista(TableroVista tableroGui, Unidad unidad){
        this.tableroGui = tableroGui;
        this.unidad = unidad;
        imagenUnidad = new ImageView();
        imagenUnidad.setScaleX(escalaUnidad);
        imagenUnidad.setScaleY(escalaUnidad);
        imagenUnidad.setFitHeight(20); //CantidadCasilleros * escala de la vista (no borrar)
        imagenUnidad.setFitWidth(20);
    }

    private void dibujar() {
        imagenUnidad.setTranslateX(0);
        imagenUnidad.setTranslateY(0);
        //tableroGui.updateVista(imagenUnidad);
    }

    /*@Override
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
        tableroGui.agregarVistaAlMapa();
    }*/
}
