import org.junit.*;

public class JugadorTest {
    private Jugador pruebaJugador = new Jugador("Juan");

    @Test
    public void JugadorSeCreaConNombre(){
        Assert.assertEquals(pruebaJugador.obtenerNombre(), "Juan");
    }

    @Test
    public void seAgregaUnidadAlJugador(){
        Unidad prueba = new Unidad(0,0,null);
        pruebaJugador.agregarUnidadAJugador(prueba);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 1);
    }

    @Test
    public void seAgregaUnidadesAlJugador(){
        Unidad prueba_1 = new Unidad(0,0,null);
        Unidad prueba_2 = new Unidad(0,0,null);
        Unidad prueba_3 = new Unidad(0,0,null);
        pruebaJugador.agregarUnidadAJugador(prueba_1);
        pruebaJugador.agregarUnidadAJugador(prueba_2);
        pruebaJugador.agregarUnidadAJugador(prueba_3);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 3);
    }

    @Test
    public void jugadorNoTieneUnidades(){
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 0);
    }
}