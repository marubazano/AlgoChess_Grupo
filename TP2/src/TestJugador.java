import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {
    Jugador pruebaJugador = new Jugador("Juan");

    @Test
    public void JugadorSeCreaConNombre(){
        assertEquals(pruebaJugador.obtenerNombre(), "Juan");
    }
}
