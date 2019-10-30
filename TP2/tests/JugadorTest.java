import org.junit.*;

public class JugadorTest {
    private Jugador pruebaJugador = new Jugador("Juan");

    @Test
    public void JugadorSeCreaConNombre(){
        Assert.assertEquals(pruebaJugador.obtenerNombre(), "Juan");
    }
}