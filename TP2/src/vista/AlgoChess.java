package vista;

/*
    Esta clase se agrega porque JavaFx 11 tira un error si main hereda directamente de application
    Dejo el link de donde saque la solucion para mas info:
    https://stackoverflow.com/questions/52653836/maven-shade-javafx-runtime-components-are-missing
 */

public class AlgoChess {
    public static void main(String[] args){
        Main.main(args);
    }
}
