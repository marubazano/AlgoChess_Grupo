public class AlgoChess {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;

    public AlgoChess() {
        this.tablero = new Tablero();
        this.jugador1 = null;
        this.jugador2 = null;
    }

    /*public void iniciarPartida(String nombreJugador1, String nombreJugador2) {
        //ver si acá hay que separar en dos funciones (iniciarPartidaJug1 e iniciarPartidaJug2) para
        //que haya dos fases iniciales, una para cada jugador. Así en cada una de esas funciones
        //instanciar al this.jugadori que corresponde y que ubique sus fichas. El tema es que eso
        //repite código.

        this.jugador1 = new Jugador(nombreJugador1, this.tablero);
        this.jugador2 = new Jugador(nombreJugador2, this.tablero);
    }*/


}
