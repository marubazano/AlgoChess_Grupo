package Controlador;

import java.util.ArrayList;


public abstract class Observable {
    private ArrayList<Observador> observadores;

    public Observable(){
        observadores = new ArrayList<Observador>();
    }

    public void agregarObservador(Observador observador){
        observadores.add(observador);
    }

    public void notificarObservadores(){
        observadores.stream().forEach(observador -> observador.change());
    }
}
