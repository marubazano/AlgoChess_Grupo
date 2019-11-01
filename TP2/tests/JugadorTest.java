import org.junit.*;

public class JugadorTest {
    private Jugador pruebaJugador = new Jugador("Juan");

    @Test
    public void JugadorSeCreaConNombre(){
        Assert.assertEquals(pruebaJugador.obtenerNombre(), "Juan");
    }

    @Test
    public void seAgregaUnidadAlJugador(){
        Unidad prueba = new Catapulta();
        pruebaJugador.agregarUnidadAJugador(prueba);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 1);
    }

    @Test
    public void seAgregaUnidadesAlJugador(){
        Unidad prueba_1 = new Catapulta();
        Unidad prueba_2 = new Curandero();
        Unidad prueba_3 = new Jinete();
        Unidad prueba_4 = new SoldadoDeInfanteria();
        pruebaJugador.agregarUnidadAJugador(prueba_1);
        pruebaJugador.agregarUnidadAJugador(prueba_2);
        pruebaJugador.agregarUnidadAJugador(prueba_3);
        pruebaJugador.agregarUnidadAJugador(prueba_4);
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 4);
    }

    @Test
    public void jugadorNoTieneUnidades(){
        Assert.assertEquals(pruebaJugador.obtenerCantidadUnidades(), 0);
    }
}